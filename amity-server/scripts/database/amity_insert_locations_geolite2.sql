insert into country (id, continent_code, continent_name, country_code, country_name)
select geoname_id, continent_code, continent_name, country_iso_code, country_name FROM amity_dev_univer.geolite2_country_locations_en;

-- Create a table to hold the coordinates of each city
create table geolite2_city_coordinates
(
	geoname_id int primary key,
	min_latitude double not null,
	min_longitude double not null,
	max_latitude double not null,
	max_longitude double not null,
	latitude double null,
	longitude double null
);

-- Calculate each city's min / max latitude / longitude
insert into geolite2_city_coordinates
select geoname_id, min(latitude), min(longitude), max(latitude), max(longitude)
from geolite2_city_blocks
where geoname_id > 0
group by geoname_id;

update geolite2_city_coordinates
set latitude = (min_latitude + max_latitude) / 2,
	longitude = (min_longitude + max_longitude) / 2;

insert into city(id, country_id, city_name, latitude, longitude, subdivision_1_code, subdivision_1_name, subdivision_2_code, subdivision_2_name, metro_code, time_zone)
select distinct a.geoname_id, b.id, a.city_name, c.latitude, c.longitude, a.subdivision_1_iso_code, subdivision_1_name, subdivision_2_iso_code, subdivision_2_name, metro_code, time_zone
from geolite2_city_locations_en a, country b, geolite2_city_coordinates c
where a.country_iso_code = b.country_code
  and a.geoname_id = c.geoname_id
  and a.city_name is not null
  and length(a.city_name) > 0;


-- Update city display name for cities in the same country that have the same name but belong to different subdivision
drop table if exists city_ids;
  
create temporary table city_ids as 
select a.id
from city a, city b
where a.city_name = b.city_name
  and a.country_id = b.country_id
  and a.id <> b.id
  and a.subdivision_1_name <> b.subdivision_1_name;

update city set display_name = concat(city_name, ", ", subdivision_1_name)
where id in ( select id from city_ids );

drop table city_ids;
