-- insert countries
insert into country (id, code, latitude, longitude, name)
select id, iso, geo_lat, geo_lng, local_name
from meta_location
where type = 'CO'
;

-- insert regions
insert into region (id, code, latitude, longitude, name, country_id)
select id, iso, geo_lat, geo_lng, local_name, in_location
from meta_location
where type = 'RE'
;

-- insert cities where parent location is region
insert into city (id, code, latitude, longitude, name, country_id, region_id)
select a.id, a.iso, a.geo_lat, a.geo_lng, a.local_name, b.in_location, a.in_location
from meta_location a, meta_location b
where a.type = 'CI'
  and a.in_location = b.id
  and b.type = 'RE'
;

-- insert cities where parent location in country
insert into city (id, code, latitude, longitude, name, country_id, region_id)
select a.id, a.iso, a.geo_lat, a.geo_lng, a.local_name, a.in_location, null
from meta_location a, meta_location b
where a.type = 'CI'
  and a.in_location = b.id
  and b.type = 'CO'
;

delete from city where latitude is null or longitude is null
;

update city set name = replace(name, '\r', '') where name like '%\r%';
update region set name = replace(name, '\r', '') where name like '%\r%';
update country set name = replace(name, '\r', '') where name like '%\r%';
