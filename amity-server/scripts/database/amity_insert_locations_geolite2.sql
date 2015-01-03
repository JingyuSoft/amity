----------------------------
-- STEP 1: Insert Countries
----------------------------
insert into country (id, continent_code, continent_name, country_code, country_name)
select geoname_id, continent_code, continent_name, country_iso_code, country_name FROM amity_dev_univer.geolite2_country_locations_en;

----------------------------
-- STEP 2: Insert Cities
----------------------------
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

-- Insert city table joining geolite2 raw table and coordinates table
insert into city(id, country_id, city_name, latitude, longitude, subdivision_1_code, subdivision_1_name, subdivision_2_code, subdivision_2_name, metro_code, time_zone)
select distinct a.geoname_id, b.id, a.city_name, c.latitude, c.longitude, a.subdivision_1_iso_code, subdivision_1_name, subdivision_2_iso_code, subdivision_2_name, metro_code, time_zone
from geolite2_city_locations_en a, country b, geolite2_city_coordinates c
where a.country_iso_code = b.country_code
  and a.geoname_id = c.geoname_id
  and a.city_name is not null
  and length(a.city_name) > 0;


----------------------------
-- STEP 3: Update Cities
----------------------------
drop table if exists city_ids;

-- Update city display name for cities in the same country that have the same name but belong to different subdivision  
create temporary table city_ids as 
select distinct a.id
from city a, city b
where a.city_name = b.city_name
  and a.country_id = b.country_id
  and a.id <> b.id
  and a.subdivision_1_name <> b.subdivision_1_name;

update city set display_name = concat(city_name, ", ", subdivision_1_name)
where id in ( select id from city_ids );

drop table city_ids;

----------------------------
-- STEP 4: Delete Duplicated Cities
----------------------------
drop table if exists duplicated_city;
drop table if exists min_id_city;

-- Calculate average latitude / longitude for cities with same name, subdivision and country
create temporary table if not exists duplicated_city
as
select city_name, subdivision_1_name, country_id, truncate(avg(latitude), 4) as avg_latitude, truncate(avg(longitude), 4) as avg_longitude
from city
group by city_name, subdivision_1_name, country_id
having count(*) > 1;

-- Update latitude / longitude for duplicated cities using average latitude / longitude
update city a inner join duplicated_city b on a.city_name = b.city_name and a.subdivision_1_name = b.subdivision_1_name and a.country_id = b.country_id
set latitude = b.avg_latitude, longitude = b.avg_longitude;

-- Get min city ID for duplicated cities
create temporary table if not exists min_id_city
select city_name, subdivision_1_name, country_id, min(id) as min_id
from city
group by city_name, subdivision_1_name, country_id
having count(*) > 1;

-- Delete duplicated cities only keeping the min ID ones
delete a from city a inner join min_id_city b on a.city_name = b.city_name and a.subdivision_1_name = b.subdivision_1_name and a.country_id = b.country_id
where a.id <> b.min_id;

drop table duplicated_city;
drop table min_id_city;
