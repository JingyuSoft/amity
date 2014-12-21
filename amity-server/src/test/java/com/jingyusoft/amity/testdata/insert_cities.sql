insert into city(id, country_id, city_name, latitude, longitude, subdivision_1_code, subdivision_1_name, subdivision_2_code, subdivision_2_name, metro_code, time_zone)
select distinct a.geoname_id, b.id, a.city_name, c.latitude, c.longitude, a.subdivision_1_iso_code, subdivision_1_name, subdivision_2_iso_code, subdivision_2_name, metro_code, time_zone
from geolite2_city_locations_en a, country b, geolite2_city_coordinates c
where a.country_iso_code = b.country_code
  and a.geoname_id = c.geoname_id
  and a.city_name is not null
  and length(a.city_name) > 0;
