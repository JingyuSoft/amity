include "authentication.thrift"
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

struct GetCountriesResponse {
	1: required i32 errorCode,
	2: optional list<CountryDto> countries
}

struct GetRegionsResponse {
	1: required i32 errorCode,
	2: optional list<RegionDto> regions
}

struct GetCitiesResponse {
	1: required i32 errorCode,
	2: optional list<CityDto> cities
}

struct GetRegionsAndCitiesByCountryRequest {
	1: required i32 countryId
}

struct GetRegionsAndCitiesByCountryResponse {
	1: required i32 errorCode,
	2: optional list<RegionDto> regions,
	3: optional list<CityDto> cities
}

struct GetCitiesByRegionRequest {
	1: required i32 regionId
}

struct GetCitiesByRegionResponse {
	1: required i32 errorCode,
	2: optional list<CityDto> cities
}

service RefDataThriftService {
	GetCountriesResponse getCountries(1: authentication.SessionCredentials credentials)
	GetRegionsResponse getRegions(1: authentication.SessionCredentials credentials)
	GetCitiesResponse getCities(1: authentication.SessionCredentials credentials)
	
	GetRegionsAndCitiesByCountryResponse getRegionsAndCitiesByCountry(1: GetRegionsAndCitiesByCountryRequest request, 2: authentication.SessionCredentials credentials)
	GetCitiesByRegionResponse getCitiesByRegion(1: GetCitiesByRegionRequest request, 2: authentication.SessionCredentials credentials)
}
