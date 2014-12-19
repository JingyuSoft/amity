include "authentication.thrift"
namespace java com.jingyusoft.amity.thrift.generated

struct CityDto {
	1: required i32 id,
	2: required string name,
	3: required double latitude,
	4: required double longitude
	5: optional string regionName,
	6: required string countryName
}

struct SearchCitiesRequest {
	1: required string searchText
}

struct SearchCitiesResponse {
	1: required i32 errorCode,
	2: optional list<CityDto> cities
}

service RefDataThriftService {
	SearchCitiesResponse searchCities(1: SearchCitiesRequest request, 2: authentication.SessionCredentials credentials)
}
