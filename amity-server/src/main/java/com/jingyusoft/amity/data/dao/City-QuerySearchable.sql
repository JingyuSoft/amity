SELECT ci.id, ci.name as city_name, re.name as region_name, co.name as country_name from city ci
INNER JOIN region re on ci.region_id = re.id
INNER JOIN country co on ci.country_id = co.id
UNION
SELECT ci.id, ci.name as city_name, "" as region_name, co.name as country_name from city ci
INNER JOIN country co on ci.country_id = co.id
WHERE ci.region_id is null
LIMIT 10000;