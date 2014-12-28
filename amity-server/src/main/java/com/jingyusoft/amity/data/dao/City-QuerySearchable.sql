SELECT ci.id, ci.city_name, ifnull(ci.display_name, ci.city_name) as city_display_name, co.country_name, ci.latitude, ci.longitude
FROM city ci INNER JOIN country co ON ci.country_id = co.id