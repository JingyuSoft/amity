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

@interface LoginFacebookAccountRequest : NSObject <TBase, NSCoding> {
  int64_t __facebookId;
  NSString * __emailAddress;
  NSString * __facebookToken;

  BOOL __facebookId_isset;
  BOOL __emailAddress_isset;
  BOOL __facebookToken_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=facebookId, setter=setFacebookId:) int64_t facebookId;
@property (nonatomic, retain, getter=emailAddress, setter=setEmailAddress:) NSString * emailAddress;
@property (nonatomic, retain, getter=facebookToken, setter=setFacebookToken:) NSString * facebookToken;
#endif

- (id) init;
- (id) initWithFacebookId: (int64_t) facebookId emailAddress: (NSString *) emailAddress facebookToken: (NSString *) facebookToken;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (int64_t) facebookId;
- (void) setFacebookId: (int64_t) facebookId;
#endif
- (BOOL) facebookIdIsSet;

#if !__has_feature(objc_arc)
- (NSString *) emailAddress;
- (void) setEmailAddress: (NSString *) emailAddress;
#endif
- (BOOL) emailAddressIsSet;

#if !__has_feature(objc_arc)
- (NSString *) facebookToken;
- (void) setFacebookToken: (NSString *) facebookToken;
#endif
- (BOOL) facebookTokenIsSet;

@end

@interface LoginFacebookAccountResponse : NSObject <TBase, NSCoding> {
  int64_t __facebookId;
  AmityToken * __authToken;
  AmityToken * __sessionToken;

  BOOL __facebookId_isset;
  BOOL __authToken_isset;
  BOOL __sessionToken_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=facebookId, setter=setFacebookId:) int64_t facebookId;
@property (nonatomic, retain, getter=authToken, setter=setAuthToken:) AmityToken * authToken;
@property (nonatomic, retain, getter=sessionToken, setter=setSessionToken:) AmityToken * sessionToken;
#endif

- (id) init;
- (id) initWithFacebookId: (int64_t) facebookId authToken: (AmityToken *) authToken sessionToken: (AmityToken *) sessionToken;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (int64_t) facebookId;
- (void) setFacebookId: (int64_t) facebookId;
#endif
- (BOOL) facebookIdIsSet;

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

@protocol AuthenticationThriftService <NSObject>
- (LoginFacebookAccountResponse *) loginFacebookAccount: (LoginFacebookAccountRequest *) request;  // throws TException
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
