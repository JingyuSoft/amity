include "Authentication.thrift"
include "RefData.thrift"
namespace java com.jingyusoft.amity.thrift.generated

struct HelpRequestDto {
	1: optional i64 id,
	2: required i64 userId,
	3: required i32 fromCityId,
	4: required string fromDate,
	5: required i32 toCityId,
	6: optional string toDate,
	7: optional RefData.CityDto fromCity,
	8: optional RefData.CityDto toCity,
}

struct GetHelpRequestRequest {
	1: required i64 helpRequestId
}

struct GetHelpRequestResponse {
	1: required i32 errorCode,
	2: optional HelpRequestDto helpRequest
}

struct ListHelpRequestRequest {
	1: required i64 amityUserId
}

struct ListHelpRequestResponse {
	1: required i32 errorCode,
	2: optional list<HelpRequestDto> helpRequests
}

struct CreateHelpRequestRequest {
	1: HelpRequestDto helpRequest
}

struct CreateHelpRequestResponse {
	1: required i32 errorCode,
	2: required i64 helpRequestId
}

struct UpdateHelpRequestRequest {
	1: required HelpRequestDto helpRequest
}

struct UpdateHelpRequestResponse {
	1: required i32 errorCode
}

struct DeleteHelpRequestRequest {
	1: required i64 helpRequestId
}

struct DeleteHelpRequestResponse {
	1: required i32 errorCode
}

service HelpRequestThriftService {
	GetHelpRequestResponse getHelpRequest(1: GetHelpRequestRequest request, 2: Authentication.SessionCredentials credentials)
	ListHelpRequestResponse listHelpRequests(1: ListHelpRequestRequest request, 2: Authentication.SessionCredentials credentials)
    CreateHelpRequestResponse createHelpRequest(1: CreateHelpRequestRequest request, 2: Authentication.SessionCredentials credentials)
    UpdateHelpRequestResponse updateHelpRequest(1: UpdateHelpRequestRequest request, 2: Authentication.SessionCredentials credentials)
    DeleteHelpRequestResponse deleteHelpRequest(1: DeleteHelpRequestRequest request, 2: Authentication.SessionCredentials credentials)
}
