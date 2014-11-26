namespace java com.jingyusoft.amity.thrift.generated

struct HelperItineraryDto {
	1: optional i64 id,
	2: required i64 userId,
	3: required i32 fromLocationid,
	4: required string latestPickupDate,
	5: required i32 toLocationId,
	6: required string latestDeliveryDate
}

struct CreateHelperItineraryRequest {
	1: HelperItineraryDto itinerary
}

struct CreateHelperItineraryResponse {
	1: i32 itineraryId
}

service ItineraryThriftService {
    CreateHelperItineraryResponse createItinerary(1: CreateHelperItineraryRequest request)
}
