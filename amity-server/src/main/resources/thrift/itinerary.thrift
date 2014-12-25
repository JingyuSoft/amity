include "authentication.thrift"
namespace java com.jingyusoft.amity.thrift.generated

struct ItineraryDto {
	1: optional i64 id,
	2: required i64 userId,
	3: required i32 departureCityId,
	4: required string departureDate,
	5: required i32 arrivalCityId,
	6: optional string arrivalDate
}

struct CreateItineraryRequest {
	1: ItineraryDto itinerary
}

struct CreateItineraryResponse {
	1: required i32 errorCode,
	2: required i64 itineraryId
}

service ItineraryThriftService {
    CreateItineraryResponse createItinerary(1: CreateItineraryRequest request, 2: authentication.SessionCredentials credentials)
}
