insert into country (id, code, name, latitude, longitude)
select id, iso, local_name, geo_lat, geo_lng from meta_location
where type = 'CO';

insert into region (id, code, name, latitude, longitude)
select id, iso, local_name, geo_lat, geo_lng from meta_location
where type = 'RE';

insert into city (id, code, name, latitude, longitude)
select id, iso, local_name, geo_lat, geo_lng from meta_location
where type = 'CI';

update city inner join meta_location l1 on city.id = l1.id
inner join meta_location l2 on l1.in_location = l2.id and l2.type = 'RE'
set city.region_id = l1.in_location;

update city inner join meta_location l1 on city.id = l1.id
inner join meta_location l2 on l1.in_location = l2.id and l2.type = 'CO'
set city.country_id = l1.in_location;

update region inner join meta_location on region.id = meta_location.id and meta_location.in_location is not null
set region.country_id = meta_location.in_location;
