include "Authentication.thrift"
include "RefData.thrift"
namespace java com.jingyusoft.amity.thrift.generated

struct ItineraryDto {
	1: optional i64 id,
	2: required i64 userId,
	3: required i32 departureCityId,
	4: required string departureDate,
	5: required i32 arrivalCityId,
	6: optional string arrivalDate,
	7: optional RefData.CityDto departureCity,
	8: optional RefData.CityDto arrivalCity,
}

struct GetItineraryRequest {
	1: required i64 itineraryId
}

struct GetItineraryResponse {
	1: required i32 errorCode,
	2: optional ItineraryDto itinerary
}

struct ListItinerariesRequest {
	1: required i64 amityUserId
}

struct ListItinerariesResponse {
	1: required i32 errorCode,
	2: optional list<ItineraryDto> itineraries
}

struct CreateItineraryRequest {
	1: ItineraryDto itinerary
}

struct CreateItineraryResponse {
	1: required i32 errorCode,
	2: required i64 itineraryId
}

struct UpdateItineraryRequest {
	1: required ItineraryDto itinerary
}

struct UpdateItineraryResponse {
	1: required i32 errorCode
}

struct DeleteItineraryRequest {
	1: required i64 itineraryId
}

struct DeleteItineraryResponse {
	1: required i32 errorCode
}

struct SearchItinerariesRequest {
	1: optional i32 departureCityId,
	2: optional double departureLatitude,
	3: optional double departureLongitude,
	4: optional i32 arrivalCityId,
	5: optional double arrivalLatitude,
	6: optional double arrivalLongitude,
	7: optional double departureSearchRadius,
	8: optional double arrivalSearchRadius
}

struct SearchItinerariesResponse {
	1: required i32 errorCode,
	2: optional list<ItineraryDto> itineraries
}

service ItineraryThriftService {
	GetItineraryResponse getItinerary(1: GetItineraryRequest request, 2: Authentication.SessionCredentials credentials)
	ListItinerariesResponse listItineraries(1: ListItinerariesRequest request, 2: Authentication.SessionCredentials credentials)
    CreateItineraryResponse createItinerary(1: CreateItineraryRequest request, 2: Authentication.SessionCredentials credentials)
    UpdateItineraryResponse updateItinerary(1: UpdateItineraryRequest request, 2: Authentication.SessionCredentials credentials)
    DeleteItineraryResponse deleteItinerary(1: DeleteItineraryRequest request, 2: Authentication.SessionCredentials credentials)
    
    SearchItinerariesResponse searchItineraries(1: SearchItinerariesRequest request, 2: Authentication.SessionCredentials credentials)
}
