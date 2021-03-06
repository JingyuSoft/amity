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

struct AmityUserDto {
	1: required i64 amityUserId,
	2: required string userType,
	3: optional string username,
	4: optional string firstName,
	5: optional string lastName,
	6: required string emailAddress,
	7: optional string gender,
	8: optional string userAlias,
	9: optional binary avatar
}

struct LoginFacebookAccountResponse {
	1: required i32 errorCode,
    2: optional i64 amityUserId,
    3: optional AmityToken authToken,
    4: optional AmityToken sessionToken,
    5: optional AmityUserDto amityUser
}

struct LoginAmityAccountRequest {
    1: required string emailAddress,
    2: required string plainPassword
}

struct LoginAmityAccountResponse {
	1: required i32 errorCode,
    2: optional AmityToken sessionToken,
    3: optional AmityUserDto amityUser
}

struct AuthenticateAmityAccountRequest {
    1: required i64 amityUserId,
    2: required AmityToken authToken
}

struct AuthenticateAmityAccountResponse {
	1: required i32 errorCode,
    2: optional AmityToken sessionToken,
    3: optional AmityUserDto amityUser
}

struct UpdateAmityAccountRequest {
    1: required i64 amityUserId,
    2: optional string username,
    3: required string firstName,
    4: required string lastName,
    5: optional string gender,
    6: required string userAlias,
    7: optional binary avatar
}

struct UpdateAmityAccountResponse {
    1: required i32 errorCode
}

service AuthenticationThriftService {
    LoginFacebookAccountResponse loginFacebookAccount(1: LoginFacebookAccountRequest request)
    LoginAmityAccountResponse loginAmityAccount(1: LoginAmityAccountRequest request)
    AuthenticateAmityAccountResponse authenticateAmityAccount(1: AuthenticateAmityAccountRequest request)
    UpdateAmityAccountResponse updateAmityAccount(1: UpdateAmityAccountRequest request, 2: SessionCredentials credentials)
}
