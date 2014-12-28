/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.jingyusoft.amity.thrift.generated;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2014-12-28")
public class ItineraryDto implements org.apache.thrift.TBase<ItineraryDto, ItineraryDto._Fields>, java.io.Serializable, Cloneable, Comparable<ItineraryDto> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ItineraryDto");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField USER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("userId", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField DEPARTURE_CITY_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("departureCityId", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField DEPARTURE_DATE_FIELD_DESC = new org.apache.thrift.protocol.TField("departureDate", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField ARRIVAL_CITY_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("arrivalCityId", org.apache.thrift.protocol.TType.I32, (short)5);
  private static final org.apache.thrift.protocol.TField ARRIVAL_DATE_FIELD_DESC = new org.apache.thrift.protocol.TField("arrivalDate", org.apache.thrift.protocol.TType.STRING, (short)6);
  private static final org.apache.thrift.protocol.TField DEPARTURE_CITY_FIELD_DESC = new org.apache.thrift.protocol.TField("departureCity", org.apache.thrift.protocol.TType.STRUCT, (short)7);
  private static final org.apache.thrift.protocol.TField ARRIVAL_CITY_FIELD_DESC = new org.apache.thrift.protocol.TField("arrivalCity", org.apache.thrift.protocol.TType.STRUCT, (short)8);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ItineraryDtoStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ItineraryDtoTupleSchemeFactory());
  }

  public long id; // optional
  public long userId; // required
  public int departureCityId; // required
  public String departureDate; // required
  public int arrivalCityId; // required
  public String arrivalDate; // optional
  public com.jingyusoft.amity.thrift.generated.CityDto departureCity; // optional
  public com.jingyusoft.amity.thrift.generated.CityDto arrivalCity; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    USER_ID((short)2, "userId"),
    DEPARTURE_CITY_ID((short)3, "departureCityId"),
    DEPARTURE_DATE((short)4, "departureDate"),
    ARRIVAL_CITY_ID((short)5, "arrivalCityId"),
    ARRIVAL_DATE((short)6, "arrivalDate"),
    DEPARTURE_CITY((short)7, "departureCity"),
    ARRIVAL_CITY((short)8, "arrivalCity");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ID
          return ID;
        case 2: // USER_ID
          return USER_ID;
        case 3: // DEPARTURE_CITY_ID
          return DEPARTURE_CITY_ID;
        case 4: // DEPARTURE_DATE
          return DEPARTURE_DATE;
        case 5: // ARRIVAL_CITY_ID
          return ARRIVAL_CITY_ID;
        case 6: // ARRIVAL_DATE
          return ARRIVAL_DATE;
        case 7: // DEPARTURE_CITY
          return DEPARTURE_CITY;
        case 8: // ARRIVAL_CITY
          return ARRIVAL_CITY;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __ID_ISSET_ID = 0;
  private static final int __USERID_ISSET_ID = 1;
  private static final int __DEPARTURECITYID_ISSET_ID = 2;
  private static final int __ARRIVALCITYID_ISSET_ID = 3;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.ID,_Fields.ARRIVAL_DATE,_Fields.DEPARTURE_CITY,_Fields.ARRIVAL_CITY};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.USER_ID, new org.apache.thrift.meta_data.FieldMetaData("userId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.DEPARTURE_CITY_ID, new org.apache.thrift.meta_data.FieldMetaData("departureCityId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.DEPARTURE_DATE, new org.apache.thrift.meta_data.FieldMetaData("departureDate", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ARRIVAL_CITY_ID, new org.apache.thrift.meta_data.FieldMetaData("arrivalCityId", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.ARRIVAL_DATE, new org.apache.thrift.meta_data.FieldMetaData("arrivalDate", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DEPARTURE_CITY, new org.apache.thrift.meta_data.FieldMetaData("departureCity", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.jingyusoft.amity.thrift.generated.CityDto.class)));
    tmpMap.put(_Fields.ARRIVAL_CITY, new org.apache.thrift.meta_data.FieldMetaData("arrivalCity", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, com.jingyusoft.amity.thrift.generated.CityDto.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ItineraryDto.class, metaDataMap);
  }

  public ItineraryDto() {
  }

  public ItineraryDto(
    long userId,
    int departureCityId,
    String departureDate,
    int arrivalCityId)
  {
    this();
    this.userId = userId;
    setUserIdIsSet(true);
    this.departureCityId = departureCityId;
    setDepartureCityIdIsSet(true);
    this.departureDate = departureDate;
    this.arrivalCityId = arrivalCityId;
    setArrivalCityIdIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ItineraryDto(ItineraryDto other) {
    __isset_bitfield = other.__isset_bitfield;
    this.id = other.id;
    this.userId = other.userId;
    this.departureCityId = other.departureCityId;
    if (other.isSetDepartureDate()) {
      this.departureDate = other.departureDate;
    }
    this.arrivalCityId = other.arrivalCityId;
    if (other.isSetArrivalDate()) {
      this.arrivalDate = other.arrivalDate;
    }
    if (other.isSetDepartureCity()) {
      this.departureCity = new com.jingyusoft.amity.thrift.generated.CityDto(other.departureCity);
    }
    if (other.isSetArrivalCity()) {
      this.arrivalCity = new com.jingyusoft.amity.thrift.generated.CityDto(other.arrivalCity);
    }
  }

  public ItineraryDto deepCopy() {
    return new ItineraryDto(this);
  }

  @Override
  public void clear() {
    setIdIsSet(false);
    this.id = 0;
    setUserIdIsSet(false);
    this.userId = 0;
    setDepartureCityIdIsSet(false);
    this.departureCityId = 0;
    this.departureDate = null;
    setArrivalCityIdIsSet(false);
    this.arrivalCityId = 0;
    this.arrivalDate = null;
    this.departureCity = null;
    this.arrivalCity = null;
  }

  public long getId() {
    return this.id;
  }

  public ItineraryDto setId(long id) {
    this.id = id;
    setIdIsSet(true);
    return this;
  }

  public void unsetId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ID_ISSET_ID);
  }

  /** Returns true if field id is set (has been assigned a value) and false otherwise */
  public boolean isSetId() {
    return EncodingUtils.testBit(__isset_bitfield, __ID_ISSET_ID);
  }

  public void setIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ID_ISSET_ID, value);
  }

  public long getUserId() {
    return this.userId;
  }

  public ItineraryDto setUserId(long userId) {
    this.userId = userId;
    setUserIdIsSet(true);
    return this;
  }

  public void unsetUserId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __USERID_ISSET_ID);
  }

  /** Returns true if field userId is set (has been assigned a value) and false otherwise */
  public boolean isSetUserId() {
    return EncodingUtils.testBit(__isset_bitfield, __USERID_ISSET_ID);
  }

  public void setUserIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __USERID_ISSET_ID, value);
  }

  public int getDepartureCityId() {
    return this.departureCityId;
  }

  public ItineraryDto setDepartureCityId(int departureCityId) {
    this.departureCityId = departureCityId;
    setDepartureCityIdIsSet(true);
    return this;
  }

  public void unsetDepartureCityId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __DEPARTURECITYID_ISSET_ID);
  }

  /** Returns true if field departureCityId is set (has been assigned a value) and false otherwise */
  public boolean isSetDepartureCityId() {
    return EncodingUtils.testBit(__isset_bitfield, __DEPARTURECITYID_ISSET_ID);
  }

  public void setDepartureCityIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __DEPARTURECITYID_ISSET_ID, value);
  }

  public String getDepartureDate() {
    return this.departureDate;
  }

  public ItineraryDto setDepartureDate(String departureDate) {
    this.departureDate = departureDate;
    return this;
  }

  public void unsetDepartureDate() {
    this.departureDate = null;
  }

  /** Returns true if field departureDate is set (has been assigned a value) and false otherwise */
  public boolean isSetDepartureDate() {
    return this.departureDate != null;
  }

  public void setDepartureDateIsSet(boolean value) {
    if (!value) {
      this.departureDate = null;
    }
  }

  public int getArrivalCityId() {
    return this.arrivalCityId;
  }

  public ItineraryDto setArrivalCityId(int arrivalCityId) {
    this.arrivalCityId = arrivalCityId;
    setArrivalCityIdIsSet(true);
    return this;
  }

  public void unsetArrivalCityId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ARRIVALCITYID_ISSET_ID);
  }

  /** Returns true if field arrivalCityId is set (has been assigned a value) and false otherwise */
  public boolean isSetArrivalCityId() {
    return EncodingUtils.testBit(__isset_bitfield, __ARRIVALCITYID_ISSET_ID);
  }

  public void setArrivalCityIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ARRIVALCITYID_ISSET_ID, value);
  }

  public String getArrivalDate() {
    return this.arrivalDate;
  }

  public ItineraryDto setArrivalDate(String arrivalDate) {
    this.arrivalDate = arrivalDate;
    return this;
  }

  public void unsetArrivalDate() {
    this.arrivalDate = null;
  }

  /** Returns true if field arrivalDate is set (has been assigned a value) and false otherwise */
  public boolean isSetArrivalDate() {
    return this.arrivalDate != null;
  }

  public void setArrivalDateIsSet(boolean value) {
    if (!value) {
      this.arrivalDate = null;
    }
  }

  public com.jingyusoft.amity.thrift.generated.CityDto getDepartureCity() {
    return this.departureCity;
  }

  public ItineraryDto setDepartureCity(com.jingyusoft.amity.thrift.generated.CityDto departureCity) {
    this.departureCity = departureCity;
    return this;
  }

  public void unsetDepartureCity() {
    this.departureCity = null;
  }

  /** Returns true if field departureCity is set (has been assigned a value) and false otherwise */
  public boolean isSetDepartureCity() {
    return this.departureCity != null;
  }

  public void setDepartureCityIsSet(boolean value) {
    if (!value) {
      this.departureCity = null;
    }
  }

  public com.jingyusoft.amity.thrift.generated.CityDto getArrivalCity() {
    return this.arrivalCity;
  }

  public ItineraryDto setArrivalCity(com.jingyusoft.amity.thrift.generated.CityDto arrivalCity) {
    this.arrivalCity = arrivalCity;
    return this;
  }

  public void unsetArrivalCity() {
    this.arrivalCity = null;
  }

  /** Returns true if field arrivalCity is set (has been assigned a value) and false otherwise */
  public boolean isSetArrivalCity() {
    return this.arrivalCity != null;
  }

  public void setArrivalCityIsSet(boolean value) {
    if (!value) {
      this.arrivalCity = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((Long)value);
      }
      break;

    case USER_ID:
      if (value == null) {
        unsetUserId();
      } else {
        setUserId((Long)value);
      }
      break;

    case DEPARTURE_CITY_ID:
      if (value == null) {
        unsetDepartureCityId();
      } else {
        setDepartureCityId((Integer)value);
      }
      break;

    case DEPARTURE_DATE:
      if (value == null) {
        unsetDepartureDate();
      } else {
        setDepartureDate((String)value);
      }
      break;

    case ARRIVAL_CITY_ID:
      if (value == null) {
        unsetArrivalCityId();
      } else {
        setArrivalCityId((Integer)value);
      }
      break;

    case ARRIVAL_DATE:
      if (value == null) {
        unsetArrivalDate();
      } else {
        setArrivalDate((String)value);
      }
      break;

    case DEPARTURE_CITY:
      if (value == null) {
        unsetDepartureCity();
      } else {
        setDepartureCity((com.jingyusoft.amity.thrift.generated.CityDto)value);
      }
      break;

    case ARRIVAL_CITY:
      if (value == null) {
        unsetArrivalCity();
      } else {
        setArrivalCity((com.jingyusoft.amity.thrift.generated.CityDto)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ID:
      return Long.valueOf(getId());

    case USER_ID:
      return Long.valueOf(getUserId());

    case DEPARTURE_CITY_ID:
      return Integer.valueOf(getDepartureCityId());

    case DEPARTURE_DATE:
      return getDepartureDate();

    case ARRIVAL_CITY_ID:
      return Integer.valueOf(getArrivalCityId());

    case ARRIVAL_DATE:
      return getArrivalDate();

    case DEPARTURE_CITY:
      return getDepartureCity();

    case ARRIVAL_CITY:
      return getArrivalCity();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ID:
      return isSetId();
    case USER_ID:
      return isSetUserId();
    case DEPARTURE_CITY_ID:
      return isSetDepartureCityId();
    case DEPARTURE_DATE:
      return isSetDepartureDate();
    case ARRIVAL_CITY_ID:
      return isSetArrivalCityId();
    case ARRIVAL_DATE:
      return isSetArrivalDate();
    case DEPARTURE_CITY:
      return isSetDepartureCity();
    case ARRIVAL_CITY:
      return isSetArrivalCity();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ItineraryDto)
      return this.equals((ItineraryDto)that);
    return false;
  }

  public boolean equals(ItineraryDto that) {
    if (that == null)
      return false;

    boolean this_present_id = true && this.isSetId();
    boolean that_present_id = true && that.isSetId();
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (this.id != that.id)
        return false;
    }

    boolean this_present_userId = true;
    boolean that_present_userId = true;
    if (this_present_userId || that_present_userId) {
      if (!(this_present_userId && that_present_userId))
        return false;
      if (this.userId != that.userId)
        return false;
    }

    boolean this_present_departureCityId = true;
    boolean that_present_departureCityId = true;
    if (this_present_departureCityId || that_present_departureCityId) {
      if (!(this_present_departureCityId && that_present_departureCityId))
        return false;
      if (this.departureCityId != that.departureCityId)
        return false;
    }

    boolean this_present_departureDate = true && this.isSetDepartureDate();
    boolean that_present_departureDate = true && that.isSetDepartureDate();
    if (this_present_departureDate || that_present_departureDate) {
      if (!(this_present_departureDate && that_present_departureDate))
        return false;
      if (!this.departureDate.equals(that.departureDate))
        return false;
    }

    boolean this_present_arrivalCityId = true;
    boolean that_present_arrivalCityId = true;
    if (this_present_arrivalCityId || that_present_arrivalCityId) {
      if (!(this_present_arrivalCityId && that_present_arrivalCityId))
        return false;
      if (this.arrivalCityId != that.arrivalCityId)
        return false;
    }

    boolean this_present_arrivalDate = true && this.isSetArrivalDate();
    boolean that_present_arrivalDate = true && that.isSetArrivalDate();
    if (this_present_arrivalDate || that_present_arrivalDate) {
      if (!(this_present_arrivalDate && that_present_arrivalDate))
        return false;
      if (!this.arrivalDate.equals(that.arrivalDate))
        return false;
    }

    boolean this_present_departureCity = true && this.isSetDepartureCity();
    boolean that_present_departureCity = true && that.isSetDepartureCity();
    if (this_present_departureCity || that_present_departureCity) {
      if (!(this_present_departureCity && that_present_departureCity))
        return false;
      if (!this.departureCity.equals(that.departureCity))
        return false;
    }

    boolean this_present_arrivalCity = true && this.isSetArrivalCity();
    boolean that_present_arrivalCity = true && that.isSetArrivalCity();
    if (this_present_arrivalCity || that_present_arrivalCity) {
      if (!(this_present_arrivalCity && that_present_arrivalCity))
        return false;
      if (!this.arrivalCity.equals(that.arrivalCity))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_id = true && (isSetId());
    list.add(present_id);
    if (present_id)
      list.add(id);

    boolean present_userId = true;
    list.add(present_userId);
    if (present_userId)
      list.add(userId);

    boolean present_departureCityId = true;
    list.add(present_departureCityId);
    if (present_departureCityId)
      list.add(departureCityId);

    boolean present_departureDate = true && (isSetDepartureDate());
    list.add(present_departureDate);
    if (present_departureDate)
      list.add(departureDate);

    boolean present_arrivalCityId = true;
    list.add(present_arrivalCityId);
    if (present_arrivalCityId)
      list.add(arrivalCityId);

    boolean present_arrivalDate = true && (isSetArrivalDate());
    list.add(present_arrivalDate);
    if (present_arrivalDate)
      list.add(arrivalDate);

    boolean present_departureCity = true && (isSetDepartureCity());
    list.add(present_departureCity);
    if (present_departureCity)
      list.add(departureCity);

    boolean present_arrivalCity = true && (isSetArrivalCity());
    list.add(present_arrivalCity);
    if (present_arrivalCity)
      list.add(arrivalCity);

    return list.hashCode();
  }

  @Override
  public int compareTo(ItineraryDto other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetId()).compareTo(other.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, other.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUserId()).compareTo(other.isSetUserId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUserId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userId, other.userId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDepartureCityId()).compareTo(other.isSetDepartureCityId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDepartureCityId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.departureCityId, other.departureCityId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDepartureDate()).compareTo(other.isSetDepartureDate());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDepartureDate()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.departureDate, other.departureDate);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetArrivalCityId()).compareTo(other.isSetArrivalCityId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetArrivalCityId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.arrivalCityId, other.arrivalCityId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetArrivalDate()).compareTo(other.isSetArrivalDate());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetArrivalDate()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.arrivalDate, other.arrivalDate);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDepartureCity()).compareTo(other.isSetDepartureCity());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDepartureCity()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.departureCity, other.departureCity);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetArrivalCity()).compareTo(other.isSetArrivalCity());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetArrivalCity()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.arrivalCity, other.arrivalCity);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("ItineraryDto(");
    boolean first = true;

    if (isSetId()) {
      sb.append("id:");
      sb.append(this.id);
      first = false;
    }
    if (!first) sb.append(", ");
    sb.append("userId:");
    sb.append(this.userId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("departureCityId:");
    sb.append(this.departureCityId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("departureDate:");
    if (this.departureDate == null) {
      sb.append("null");
    } else {
      sb.append(this.departureDate);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("arrivalCityId:");
    sb.append(this.arrivalCityId);
    first = false;
    if (isSetArrivalDate()) {
      if (!first) sb.append(", ");
      sb.append("arrivalDate:");
      if (this.arrivalDate == null) {
        sb.append("null");
      } else {
        sb.append(this.arrivalDate);
      }
      first = false;
    }
    if (isSetDepartureCity()) {
      if (!first) sb.append(", ");
      sb.append("departureCity:");
      if (this.departureCity == null) {
        sb.append("null");
      } else {
        sb.append(this.departureCity);
      }
      first = false;
    }
    if (isSetArrivalCity()) {
      if (!first) sb.append(", ");
      sb.append("arrivalCity:");
      if (this.arrivalCity == null) {
        sb.append("null");
      } else {
        sb.append(this.arrivalCity);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'userId' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'departureCityId' because it's a primitive and you chose the non-beans generator.
    if (departureDate == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'departureDate' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'arrivalCityId' because it's a primitive and you chose the non-beans generator.
    // check for sub-struct validity
    if (departureCity != null) {
      departureCity.validate();
    }
    if (arrivalCity != null) {
      arrivalCity.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ItineraryDtoStandardSchemeFactory implements SchemeFactory {
    public ItineraryDtoStandardScheme getScheme() {
      return new ItineraryDtoStandardScheme();
    }
  }

  private static class ItineraryDtoStandardScheme extends StandardScheme<ItineraryDto> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ItineraryDto struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.id = iprot.readI64();
              struct.setIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // USER_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.userId = iprot.readI64();
              struct.setUserIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // DEPARTURE_CITY_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.departureCityId = iprot.readI32();
              struct.setDepartureCityIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // DEPARTURE_DATE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.departureDate = iprot.readString();
              struct.setDepartureDateIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // ARRIVAL_CITY_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.arrivalCityId = iprot.readI32();
              struct.setArrivalCityIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // ARRIVAL_DATE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.arrivalDate = iprot.readString();
              struct.setArrivalDateIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // DEPARTURE_CITY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.departureCity = new com.jingyusoft.amity.thrift.generated.CityDto();
              struct.departureCity.read(iprot);
              struct.setDepartureCityIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 8: // ARRIVAL_CITY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.arrivalCity = new com.jingyusoft.amity.thrift.generated.CityDto();
              struct.arrivalCity.read(iprot);
              struct.setArrivalCityIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      if (!struct.isSetUserId()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'userId' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetDepartureCityId()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'departureCityId' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetArrivalCityId()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'arrivalCityId' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ItineraryDto struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetId()) {
        oprot.writeFieldBegin(ID_FIELD_DESC);
        oprot.writeI64(struct.id);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(USER_ID_FIELD_DESC);
      oprot.writeI64(struct.userId);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(DEPARTURE_CITY_ID_FIELD_DESC);
      oprot.writeI32(struct.departureCityId);
      oprot.writeFieldEnd();
      if (struct.departureDate != null) {
        oprot.writeFieldBegin(DEPARTURE_DATE_FIELD_DESC);
        oprot.writeString(struct.departureDate);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(ARRIVAL_CITY_ID_FIELD_DESC);
      oprot.writeI32(struct.arrivalCityId);
      oprot.writeFieldEnd();
      if (struct.arrivalDate != null) {
        if (struct.isSetArrivalDate()) {
          oprot.writeFieldBegin(ARRIVAL_DATE_FIELD_DESC);
          oprot.writeString(struct.arrivalDate);
          oprot.writeFieldEnd();
        }
      }
      if (struct.departureCity != null) {
        if (struct.isSetDepartureCity()) {
          oprot.writeFieldBegin(DEPARTURE_CITY_FIELD_DESC);
          struct.departureCity.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.arrivalCity != null) {
        if (struct.isSetArrivalCity()) {
          oprot.writeFieldBegin(ARRIVAL_CITY_FIELD_DESC);
          struct.arrivalCity.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ItineraryDtoTupleSchemeFactory implements SchemeFactory {
    public ItineraryDtoTupleScheme getScheme() {
      return new ItineraryDtoTupleScheme();
    }
  }

  private static class ItineraryDtoTupleScheme extends TupleScheme<ItineraryDto> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ItineraryDto struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI64(struct.userId);
      oprot.writeI32(struct.departureCityId);
      oprot.writeString(struct.departureDate);
      oprot.writeI32(struct.arrivalCityId);
      BitSet optionals = new BitSet();
      if (struct.isSetId()) {
        optionals.set(0);
      }
      if (struct.isSetArrivalDate()) {
        optionals.set(1);
      }
      if (struct.isSetDepartureCity()) {
        optionals.set(2);
      }
      if (struct.isSetArrivalCity()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetId()) {
        oprot.writeI64(struct.id);
      }
      if (struct.isSetArrivalDate()) {
        oprot.writeString(struct.arrivalDate);
      }
      if (struct.isSetDepartureCity()) {
        struct.departureCity.write(oprot);
      }
      if (struct.isSetArrivalCity()) {
        struct.arrivalCity.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ItineraryDto struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.userId = iprot.readI64();
      struct.setUserIdIsSet(true);
      struct.departureCityId = iprot.readI32();
      struct.setDepartureCityIdIsSet(true);
      struct.departureDate = iprot.readString();
      struct.setDepartureDateIsSet(true);
      struct.arrivalCityId = iprot.readI32();
      struct.setArrivalCityIdIsSet(true);
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.id = iprot.readI64();
        struct.setIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.arrivalDate = iprot.readString();
        struct.setArrivalDateIsSet(true);
      }
      if (incoming.get(2)) {
        struct.departureCity = new com.jingyusoft.amity.thrift.generated.CityDto();
        struct.departureCity.read(iprot);
        struct.setDepartureCityIsSet(true);
      }
      if (incoming.get(3)) {
        struct.arrivalCity = new com.jingyusoft.amity.thrift.generated.CityDto();
        struct.arrivalCity.read(iprot);
        struct.setArrivalCityIsSet(true);
      }
    }
  }

}

