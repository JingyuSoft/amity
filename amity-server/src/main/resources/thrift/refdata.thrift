include "authentication.thrift"
namespace java com.jingyusoft.amity.thrift.generated

struct CitySearchResultDto {
	1: required i32 id,
	2: required string displayName
}

struct SearchCitiesRequest {
	1: required string searchText
}

struct SearchCitiesResponse {
	1: required i32 errorCode,
	2: optional list<CitySearchResultDto> cities
}

service RefDataThriftService {
	SearchCitiesResponse searchCities(1: SearchCitiesRequest request, 2: authentication.SessionCredentials credentials)
}
