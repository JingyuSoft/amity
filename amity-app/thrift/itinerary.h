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

#import "authentication.h"

@interface HelperItineraryDto : NSObject <TBase, NSCoding> {
  int64_t __id;
  int64_t __userId;
  int32_t __fromLocationid;
  NSString * __latestPickupDate;
  int32_t __toLocationId;
  NSString * __latestDeliveryDate;

  BOOL __id_isset;
  BOOL __userId_isset;
  BOOL __fromLocationid_isset;
  BOOL __latestPickupDate_isset;
  BOOL __toLocationId_isset;
  BOOL __latestDeliveryDate_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=id, setter=setId:) int64_t id;
@property (nonatomic, getter=userId, setter=setUserId:) int64_t userId;
@property (nonatomic, getter=fromLocationid, setter=setFromLocationid:) int32_t fromLocationid;
@property (nonatomic, retain, getter=latestPickupDate, setter=setLatestPickupDate:) NSString * latestPickupDate;
@property (nonatomic, getter=toLocationId, setter=setToLocationId:) int32_t toLocationId;
@property (nonatomic, retain, getter=latestDeliveryDate, setter=setLatestDeliveryDate:) NSString * latestDeliveryDate;
#endif

- (id) init;
- (id) initWithId: (int64_t) id userId: (int64_t) userId fromLocationid: (int32_t) fromLocationid latestPickupDate: (NSString *) latestPickupDate toLocationId: (int32_t) toLocationId latestDeliveryDate: (NSString *) latestDeliveryDate;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (int64_t) id;
- (void) setId: (int64_t) id;
#endif
- (BOOL) idIsSet;

#if !__has_feature(objc_arc)
- (int64_t) userId;
- (void) setUserId: (int64_t) userId;
#endif
- (BOOL) userIdIsSet;

#if !__has_feature(objc_arc)
- (int32_t) fromLocationid;
- (void) setFromLocationid: (int32_t) fromLocationid;
#endif
- (BOOL) fromLocationidIsSet;

#if !__has_feature(objc_arc)
- (NSString *) latestPickupDate;
- (void) setLatestPickupDate: (NSString *) latestPickupDate;
#endif
- (BOOL) latestPickupDateIsSet;

#if !__has_feature(objc_arc)
- (int32_t) toLocationId;
- (void) setToLocationId: (int32_t) toLocationId;
#endif
- (BOOL) toLocationIdIsSet;

#if !__has_feature(objc_arc)
- (NSString *) latestDeliveryDate;
- (void) setLatestDeliveryDate: (NSString *) latestDeliveryDate;
#endif
- (BOOL) latestDeliveryDateIsSet;

@end

@interface CreateHelperItineraryRequest : NSObject <TBase, NSCoding> {
  HelperItineraryDto * __itinerary;

  BOOL __itinerary_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, retain, getter=itinerary, setter=setItinerary:) HelperItineraryDto * itinerary;
#endif

- (id) init;
- (id) initWithItinerary: (HelperItineraryDto *) itinerary;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (HelperItineraryDto *) itinerary;
- (void) setItinerary: (HelperItineraryDto *) itinerary;
#endif
- (BOOL) itineraryIsSet;

@end

@interface CreateHelperItineraryResponse : NSObject <TBase, NSCoding> {
  int32_t __errorCode;
  int32_t __itineraryId;

  BOOL __errorCode_isset;
  BOOL __itineraryId_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=errorCode, setter=setErrorCode:) int32_t errorCode;
@property (nonatomic, getter=itineraryId, setter=setItineraryId:) int32_t itineraryId;
#endif

- (id) init;
- (id) initWithErrorCode: (int32_t) errorCode itineraryId: (int32_t) itineraryId;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (int32_t) errorCode;
- (void) setErrorCode: (int32_t) errorCode;
#endif
- (BOOL) errorCodeIsSet;

#if !__has_feature(objc_arc)
- (int32_t) itineraryId;
- (void) setItineraryId: (int32_t) itineraryId;
#endif
- (BOOL) itineraryIdIsSet;

@end

@protocol ItineraryThriftService <NSObject>
- (CreateHelperItineraryResponse *) createItinerary: (CreateHelperItineraryRequest *) request credentials: (SessionCredentials *) credentials;  // throws TException
@end

@interface ItineraryThriftServiceClient : NSObject <ItineraryThriftService> {
  id <TProtocol> inProtocol;
  id <TProtocol> outProtocol;
}
- (id) initWithProtocol: (id <TProtocol>) protocol;
- (id) initWithInProtocol: (id <TProtocol>) inProtocol outProtocol: (id <TProtocol>) outProtocol;
@end

@interface ItineraryThriftServiceProcessor : NSObject <TProcessor> {
  id <ItineraryThriftService> mService;
  NSDictionary * mMethodMap;
}
- (id) initWithItineraryThriftService: (id <ItineraryThriftService>) service;
- (id<ItineraryThriftService>) service;
@end

@interface itineraryConstants : NSObject {
}
@end
