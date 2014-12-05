namespace java com.jingyusoft.amity.thrift.generated

struct AmityToken {
    1: required string value
}

struct SessionCredentials {
    1: required i64 amityUserId,
    2: required AmityToken sessionToken
}

struct LoginFacebookAccountRequest {
    1: required string facebookToken
}

struct LoginFacebookAccountResponse {
	1: required i32 errorCode,
    2: optional i64 amityUserId,
    3: optional AmityToken authToken,
    4: optional AmityToken sessionToken
}

struct LoginAmityAccountRequest {
    1: required i64 amityUserId,
    2: required AmityToken authToken
}

struct LoginAmityAccountResponse {
	1: required i32 errorCode,
    2: optional AmityToken sessionToken
}

struct UpdateAmityAccountRequest {
    1: required i64 amityUserId,
    2: optional string username,
    3: optional string firstName,
    4: optional string lastName,
    5: optional string userAlias,
    6: optional binary avatar
}

struct UpdateAmityAccountResponse {
    1: required i32 errorCode
}

service AuthenticationThriftService {
    LoginFacebookAccountResponse loginFacebookAccount(1: LoginFacebookAccountRequest request)
    LoginAmityAccountResponse loginAmityAccount(1: LoginAmityAccountRequest request)
    UpdateAmityAccountResponse updateAmityAccount(1: UpdateAmityAccountRequest request, 2: SessionCredentials credentials)
}
