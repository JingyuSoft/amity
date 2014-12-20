SELECT ci.id, ci.city_name, co.country_name from city ci
INNER JOIN country co on ci.country_id = co.id