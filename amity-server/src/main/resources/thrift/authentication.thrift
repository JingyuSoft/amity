namespace java com.jingyusoft.amity.thrift.generated

struct AmityToken {
    1: required string value
}

struct LoginFacebookAccountRequest {
    1: required i64 facebookId,
    2: required string emailAddress,
    3: required string facebookToken
}

struct LoginFacebookAccountResponse {
    1: required i64 facebookId,
    2: required AmityToken authToken,
    3: required AmityToken sessionToken
}

service AuthenticationThriftService {
    LoginFacebookAccountResponse loginFacebookAccount(1: LoginFacebookAccountRequest request)
}
