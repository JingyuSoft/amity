/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */

#import <Foundation/Foundation.h>

#import "TProtocol.h"
#import "TApplicationException.h"
#import "TProtocolException.h"
#import "TProtocolUtil.h"
#import "TProcessor.h"
#import "TObjective-C.h"
#import "TBase.h"


@interface AmityToken : NSObject <TBase, NSCoding> {
  NSString * __value;

  BOOL __value_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, retain, getter=value, setter=setValue:) NSString * value;
#endif

- (id) init;
- (id) initWithValue: (NSString *) value;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (NSString *) value;
- (void) setValue: (NSString *) value;
#endif
- (BOOL) valueIsSet;

@end

@interface SessionCredentials : NSObject <TBase, NSCoding> {
  int64_t __amityUserId;
  AmityToken * __sessionToken;

  BOOL __amityUserId_isset;
  BOOL __sessionToken_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=amityUserId, setter=setAmityUserId:) int64_t amityUserId;
@property (nonatomic, retain, getter=sessionToken, setter=setSessionToken:) AmityToken * sessionToken;
#endif

- (id) init;
- (id) initWithAmityUserId: (int64_t) amityUserId sessionToken: (AmityToken *) sessionToken;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (int64_t) amityUserId;
- (void) setAmityUserId: (int64_t) amityUserId;
#endif
- (BOOL) amityUserIdIsSet;

#if !__has_feature(objc_arc)
- (AmityToken *) sessionToken;
- (void) setSessionToken: (AmityToken *) sessionToken;
#endif
- (BOOL) sessionTokenIsSet;

@end

@interface LoginFacebookAccountRequest : NSObject <TBase, NSCoding> {
  NSString * __facebookToken;

  BOOL __facebookToken_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, retain, getter=facebookToken, setter=setFacebookToken:) NSString * facebookToken;
#endif

- (id) init;
- (id) initWithFacebookToken: (NSString *) facebookToken;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (NSString *) facebookToken;
- (void) setFacebookToken: (NSString *) facebookToken;
#endif
- (BOOL) facebookTokenIsSet;

@end

@interface LoginFacebookAccountResponse : NSObject <TBase, NSCoding> {
  int32_t __errorCode;
  int64_t __amityUserId;
  AmityToken * __authToken;
  AmityToken * __sessionToken;

  BOOL __errorCode_isset;
  BOOL __amityUserId_isset;
  BOOL __authToken_isset;
  BOOL __sessionToken_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=errorCode, setter=setErrorCode:) int32_t errorCode;
@property (nonatomic, getter=amityUserId, setter=setAmityUserId:) int64_t amityUserId;
@property (nonatomic, retain, getter=authToken, setter=setAuthToken:) AmityToken * authToken;
@property (nonatomic, retain, getter=sessionToken, setter=setSessionToken:) AmityToken * sessionToken;
#endif

- (id) init;
- (id) initWithErrorCode: (int32_t) errorCode amityUserId: (int64_t) amityUserId authToken: (AmityToken *) authToken sessionToken: (AmityToken *) sessionToken;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (int32_t) errorCode;
- (void) setErrorCode: (int32_t) errorCode;
#endif
- (BOOL) errorCodeIsSet;

#if !__has_feature(objc_arc)
- (int64_t) amityUserId;
- (void) setAmityUserId: (int64_t) amityUserId;
#endif
- (BOOL) amityUserIdIsSet;

#if !__has_feature(objc_arc)
- (AmityToken *) authToken;
- (void) setAuthToken: (AmityToken *) authToken;
#endif
- (BOOL) authTokenIsSet;

#if !__has_feature(objc_arc)
- (AmityToken *) sessionToken;
- (void) setSessionToken: (AmityToken *) sessionToken;
#endif
- (BOOL) sessionTokenIsSet;

@end

@interface LoginAmityAccountRequest : NSObject <TBase, NSCoding> {
  int64_t __amityUserId;
  AmityToken * __authToken;

  BOOL __amityUserId_isset;
  BOOL __authToken_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=amityUserId, setter=setAmityUserId:) int64_t amityUserId;
@property (nonatomic, retain, getter=authToken, setter=setAuthToken:) AmityToken * authToken;
#endif

- (id) init;
- (id) initWithAmityUserId: (int64_t) amityUserId authToken: (AmityToken *) authToken;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (int64_t) amityUserId;
- (void) setAmityUserId: (int64_t) amityUserId;
#endif
- (BOOL) amityUserIdIsSet;

#if !__has_feature(objc_arc)
- (AmityToken *) authToken;
- (void) setAuthToken: (AmityToken *) authToken;
#endif
- (BOOL) authTokenIsSet;

@end

@interface LoginAmityAccountResponse : NSObject <TBase, NSCoding> {
  int32_t __errorCode;
  AmityToken * __sessionToken;

  BOOL __errorCode_isset;
  BOOL __sessionToken_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=errorCode, setter=setErrorCode:) int32_t errorCode;
@property (nonatomic, retain, getter=sessionToken, setter=setSessionToken:) AmityToken * sessionToken;
#endif

- (id) init;
- (id) initWithErrorCode: (int32_t) errorCode sessionToken: (AmityToken *) sessionToken;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (int32_t) errorCode;
- (void) setErrorCode: (int32_t) errorCode;
#endif
- (BOOL) errorCodeIsSet;

#if !__has_feature(objc_arc)
- (AmityToken *) sessionToken;
- (void) setSessionToken: (AmityToken *) sessionToken;
#endif
- (BOOL) sessionTokenIsSet;

@end

@protocol AuthenticationThriftService <NSObject>
- (LoginFacebookAccountResponse *) loginFacebookAccount: (LoginFacebookAccountRequest *) request;  // throws TException
- (LoginAmityAccountResponse *) loginAmityAccount: (LoginAmityAccountRequest *) request;  // throws TException
@end

@interface AuthenticationThriftServiceClient : NSObject <AuthenticationThriftService> {
  id <TProtocol> inProtocol;
  id <TProtocol> outProtocol;
}
- (id) initWithProtocol: (id <TProtocol>) protocol;
- (id) initWithInProtocol: (id <TProtocol>) inProtocol outProtocol: (id <TProtocol>) outProtocol;
@end

@interface AuthenticationThriftServiceProcessor : NSObject <TProcessor> {
  id <AuthenticationThriftService> mService;
  NSDictionary * mMethodMap;
}
- (id) initWithAuthenticationThriftService: (id <AuthenticationThriftService>) service;
- (id<AuthenticationThriftService>) service;
@end

@interface authenticationConstants : NSObject {
}
@end
