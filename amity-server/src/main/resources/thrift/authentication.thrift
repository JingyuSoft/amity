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
    3: optional AmityToken authToke
}

service AuthenticationThriftService {
    LoginFacebookAccountResponse loginFacebookAccount(1: LoginFacebookAccountRequest request)
}
