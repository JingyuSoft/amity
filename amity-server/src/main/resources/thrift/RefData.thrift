include "Authentication.thrift"
namespace java com.jingyusoft.amity.thrift.generated

struct CountryDto {
	1: required i32 id,
	2: required string code
	3: required string name,
	4: required string continentCode,
	5: required string continentName,
}

struct CityDto {
	1: required i32 id,
	2: required string name,
	3: optional string displayName,
	4: required CountryDto country,
	5: required double latitude,
	6: required double longitude
}

struct CitySearchResultDto {
	1: required i32 id,
	2: required string displayName
}

struct SearchCitiesRequest {
	1: required string searchText,
	2: optional i32 maxCount
}

struct SearchCitiesResponse {
	1: required i32 errorCode,
	2: optional list<CitySearchResultDto> cities
}

struct GetCityRequest {
	1: required i32 id
}

struct GetCityResponse {
	1: required i32 errorCode,
	2: optional CityDto city
}

service RefDataThriftService {
	SearchCitiesResponse searchCities(1: SearchCitiesRequest request, 2: Authentication.SessionCredentials credentials)
	GetCityResponse getCity(1: GetCityRequest request, 2: Authentication.SessionCredentials credentials)
}
