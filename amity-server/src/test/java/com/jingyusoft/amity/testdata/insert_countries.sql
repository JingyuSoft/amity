insert into country (id, continent_code, continent_name, country_code, country_name)
select geoname_id, continent_code, continent_name, country_iso_code, country_name
from amity_dev_univer.geolite2_country_locations_en
where country_iso_code = 'CN';