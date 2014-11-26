namespace java com.jingyusoft.amity.thrift.generated

struct AmityToken {
    1: required string value
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

service AuthenticationThriftService {
    LoginFacebookAccountResponse loginFacebookAccount(1: LoginFacebookAccountRequest request)
}
