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

#import "Authentication.h"
#import "RefData.h"

@interface ItineraryDto : NSObject <TBase, NSCoding> {
  int64_t __id;
  int64_t __userId;
  int32_t __departureCityId;
  NSString * __departureDate;
  int32_t __arrivalCityId;
  NSString * __arrivalDate;
  CityDto * __departureCity;
  CityDto * __arrivalCity;

  BOOL __id_isset;
  BOOL __userId_isset;
  BOOL __departureCityId_isset;
  BOOL __departureDate_isset;
  BOOL __arrivalCityId_isset;
  BOOL __arrivalDate_isset;
  BOOL __departureCity_isset;
  BOOL __arrivalCity_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=id, setter=setId:) int64_t id;
@property (nonatomic, getter=userId, setter=setUserId:) int64_t userId;
@property (nonatomic, getter=departureCityId, setter=setDepartureCityId:) int32_t departureCityId;
@property (nonatomic, retain, getter=departureDate, setter=setDepartureDate:) NSString * departureDate;
@property (nonatomic, getter=arrivalCityId, setter=setArrivalCityId:) int32_t arrivalCityId;
@property (nonatomic, retain, getter=arrivalDate, setter=setArrivalDate:) NSString * arrivalDate;
@property (nonatomic, retain, getter=departureCity, setter=setDepartureCity:) CityDto * departureCity;
@property (nonatomic, retain, getter=arrivalCity, setter=setArrivalCity:) CityDto * arrivalCity;
#endif

- (id) init;
- (id) initWithId: (int64_t) id userId: (int64_t) userId departureCityId: (int32_t) departureCityId departureDate: (NSString *) departureDate arrivalCityId: (int32_t) arrivalCityId arrivalDate: (NSString *) arrivalDate departureCity: (CityDto *) departureCity arrivalCity: (CityDto *) arrivalCity;

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
- (int32_t) departureCityId;
- (void) setDepartureCityId: (int32_t) departureCityId;
#endif
- (BOOL) departureCityIdIsSet;

#if !__has_feature(objc_arc)
- (NSString *) departureDate;
- (void) setDepartureDate: (NSString *) departureDate;
#endif
- (BOOL) departureDateIsSet;

#if !__has_feature(objc_arc)
- (int32_t) arrivalCityId;
- (void) setArrivalCityId: (int32_t) arrivalCityId;
#endif
- (BOOL) arrivalCityIdIsSet;

#if !__has_feature(objc_arc)
- (NSString *) arrivalDate;
- (void) setArrivalDate: (NSString *) arrivalDate;
#endif
- (BOOL) arrivalDateIsSet;

#if !__has_feature(objc_arc)
- (CityDto *) departureCity;
- (void) setDepartureCity: (CityDto *) departureCity;
#endif
- (BOOL) departureCityIsSet;

#if !__has_feature(objc_arc)
- (CityDto *) arrivalCity;
- (void) setArrivalCity: (CityDto *) arrivalCity;
#endif
- (BOOL) arrivalCityIsSet;

@end

@interface GetItineraryRequest : NSObject <TBase, NSCoding> {
  int64_t __itineraryId;

  BOOL __itineraryId_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=itineraryId, setter=setItineraryId:) int64_t itineraryId;
#endif

- (id) init;
- (id) initWithItineraryId: (int64_t) itineraryId;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (int64_t) itineraryId;
- (void) setItineraryId: (int64_t) itineraryId;
#endif
- (BOOL) itineraryIdIsSet;

@end

@interface GetItineraryResponse : NSObject <TBase, NSCoding> {
  int32_t __errorCode;
  ItineraryDto * __itinerary;

  BOOL __errorCode_isset;
  BOOL __itinerary_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=errorCode, setter=setErrorCode:) int32_t errorCode;
@property (nonatomic, retain, getter=itinerary, setter=setItinerary:) ItineraryDto * itinerary;
#endif

- (id) init;
- (id) initWithErrorCode: (int32_t) errorCode itinerary: (ItineraryDto *) itinerary;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (int32_t) errorCode;
- (void) setErrorCode: (int32_t) errorCode;
#endif
- (BOOL) errorCodeIsSet;

#if !__has_feature(objc_arc)
- (ItineraryDto *) itinerary;
- (void) setItinerary: (ItineraryDto *) itinerary;
#endif
- (BOOL) itineraryIsSet;

@end

@interface ListItineraryRequest : NSObject <TBase, NSCoding> {
  int64_t __amityUserId;

  BOOL __amityUserId_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=amityUserId, setter=setAmityUserId:) int64_t amityUserId;
#endif

- (id) init;
- (id) initWithAmityUserId: (int64_t) amityUserId;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (int64_t) amityUserId;
- (void) setAmityUserId: (int64_t) amityUserId;
#endif
- (BOOL) amityUserIdIsSet;

@end

@interface ListItineraryResponse : NSObject <TBase, NSCoding> {
  int32_t __errorCode;
  NSMutableArray * __itineraries;

  BOOL __errorCode_isset;
  BOOL __itineraries_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=errorCode, setter=setErrorCode:) int32_t errorCode;
@property (nonatomic, retain, getter=itineraries, setter=setItineraries:) NSMutableArray * itineraries;
#endif

- (id) init;
- (id) initWithErrorCode: (int32_t) errorCode itineraries: (NSMutableArray *) itineraries;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (int32_t) errorCode;
- (void) setErrorCode: (int32_t) errorCode;
#endif
- (BOOL) errorCodeIsSet;

#if !__has_feature(objc_arc)
- (NSMutableArray *) itineraries;
- (void) setItineraries: (NSMutableArray *) itineraries;
#endif
- (BOOL) itinerariesIsSet;

@end

@interface CreateItineraryRequest : NSObject <TBase, NSCoding> {
  ItineraryDto * __itinerary;

  BOOL __itinerary_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, retain, getter=itinerary, setter=setItinerary:) ItineraryDto * itinerary;
#endif

- (id) init;
- (id) initWithItinerary: (ItineraryDto *) itinerary;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (ItineraryDto *) itinerary;
- (void) setItinerary: (ItineraryDto *) itinerary;
#endif
- (BOOL) itineraryIsSet;

@end

@interface CreateItineraryResponse : NSObject <TBase, NSCoding> {
  int32_t __errorCode;
  int64_t __itineraryId;

  BOOL __errorCode_isset;
  BOOL __itineraryId_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=errorCode, setter=setErrorCode:) int32_t errorCode;
@property (nonatomic, getter=itineraryId, setter=setItineraryId:) int64_t itineraryId;
#endif

- (id) init;
- (id) initWithErrorCode: (int32_t) errorCode itineraryId: (int64_t) itineraryId;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (int32_t) errorCode;
- (void) setErrorCode: (int32_t) errorCode;
#endif
- (BOOL) errorCodeIsSet;

#if !__has_feature(objc_arc)
- (int64_t) itineraryId;
- (void) setItineraryId: (int64_t) itineraryId;
#endif
- (BOOL) itineraryIdIsSet;

@end

@interface UpdateItineraryRequest : NSObject <TBase, NSCoding> {
  ItineraryDto * __itinerary;

  BOOL __itinerary_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, retain, getter=itinerary, setter=setItinerary:) ItineraryDto * itinerary;
#endif

- (id) init;
- (id) initWithItinerary: (ItineraryDto *) itinerary;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (ItineraryDto *) itinerary;
- (void) setItinerary: (ItineraryDto *) itinerary;
#endif
- (BOOL) itineraryIsSet;

@end

@interface UpdateItineraryResponse : NSObject <TBase, NSCoding> {
  int32_t __errorCode;

  BOOL __errorCode_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=errorCode, setter=setErrorCode:) int32_t errorCode;
#endif

- (id) init;
- (id) initWithErrorCode: (int32_t) errorCode;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (int32_t) errorCode;
- (void) setErrorCode: (int32_t) errorCode;
#endif
- (BOOL) errorCodeIsSet;

@end

@interface DeleteItineraryRequest : NSObject <TBase, NSCoding> {
  int64_t __itineraryId;

  BOOL __itineraryId_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=itineraryId, setter=setItineraryId:) int64_t itineraryId;
#endif

- (id) init;
- (id) initWithItineraryId: (int64_t) itineraryId;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (int64_t) itineraryId;
- (void) setItineraryId: (int64_t) itineraryId;
#endif
- (BOOL) itineraryIdIsSet;

@end

@interface DeleteItineraryResponse : NSObject <TBase, NSCoding> {
  int32_t __errorCode;

  BOOL __errorCode_isset;
}

#if TARGET_OS_IPHONE || (MAC_OS_X_VERSION_MAX_ALLOWED >= MAC_OS_X_VERSION_10_5)
@property (nonatomic, getter=errorCode, setter=setErrorCode:) int32_t errorCode;
#endif

- (id) init;
- (id) initWithErrorCode: (int32_t) errorCode;

- (void) read: (id <TProtocol>) inProtocol;
- (void) write: (id <TProtocol>) outProtocol;

- (void) validate;

#if !__has_feature(objc_arc)
- (int32_t) errorCode;
- (void) setErrorCode: (int32_t) errorCode;
#endif
- (BOOL) errorCodeIsSet;

@end

@protocol ItineraryThriftService <NSObject>
- (GetItineraryResponse *) getItinerary: (GetItineraryRequest *) request credentials: (SessionCredentials *) credentials;  // throws TException
- (ListItineraryResponse *) listItineries: (ListItineraryRequest *) request credentials: (SessionCredentials *) credentials;  // throws TException
- (CreateItineraryResponse *) createItinerary: (CreateItineraryRequest *) request credentials: (SessionCredentials *) credentials;  // throws TException
- (UpdateItineraryResponse *) updateItinerary: (UpdateItineraryRequest *) request credentials: (SessionCredentials *) credentials;  // throws TException
- (DeleteItineraryResponse *) deleteItinerary: (DeleteItineraryRequest *) request credentials: (SessionCredentials *) credentials;  // throws TException
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

@interface ItineraryConstants : NSObject {
}
@end
