include "authentication.thrift"
namespace java com.jingyusoft.amity.thrift.generated

struct HelperItineraryDto {
	1: optional i64 id,
	2: required i64 userId,
	3: required i32 departureCityId,
	4: required string departureDate,
	5: required i32 arrivalCityId,
	6: required string arrivalDate
}

struct CreateHelperItineraryRequest {
	1: HelperItineraryDto itinerary
}

struct CreateHelperItineraryResponse {
	1: required i32 errorCode,
	2: required i64 itineraryId
}

service ItineraryThriftService {
    CreateHelperItineraryResponse createItinerary(1: CreateHelperItineraryRequest request, 2: authentication.SessionCredentials credentials)
}
