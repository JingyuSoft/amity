namespace java com.jingyusoft.amity.thrift.generated

struct LocationDto {
	1: required i32 id,
	2: required string code,
	3: required string name,
	4: required double latitude,
	5: required double longitude
}

struct CityDto {
	1: required i32 id,
	2: required string code,
	3: required string name,
	4: required double latitude,
	5: required double longitude
}

struct RegionDto {
	1: required i32 id,
	2: required string code,
	3: required string name,
	4: required double latitude,
	5: required double longitude
}

struct CountryDto {
	1: required i32 id,
	2: required string code,
	3: required string name,
	4: required double latitude,
	5: required double longitude
}
