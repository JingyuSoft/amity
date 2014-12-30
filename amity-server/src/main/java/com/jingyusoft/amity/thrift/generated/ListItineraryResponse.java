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
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2014-12-30")
public class ListItineraryResponse implements org.apache.thrift.TBase<ListItineraryResponse, ListItineraryResponse._Fields>, java.io.Serializable, Cloneable, Comparable<ListItineraryResponse> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ListItineraryResponse");

  private static final org.apache.thrift.protocol.TField ERROR_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("errorCode", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField ITINERARIES_FIELD_DESC = new org.apache.thrift.protocol.TField("itineraries", org.apache.thrift.protocol.TType.LIST, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ListItineraryResponseStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ListItineraryResponseTupleSchemeFactory());
  }

  public int errorCode; // required
  public List<ItineraryDto> itineraries; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ERROR_CODE((short)1, "errorCode"),
    ITINERARIES((short)2, "itineraries");

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
        case 1: // ERROR_CODE
          return ERROR_CODE;
        case 2: // ITINERARIES
          return ITINERARIES;
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
  private static final int __ERRORCODE_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.ITINERARIES};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ERROR_CODE, new org.apache.thrift.meta_data.FieldMetaData("errorCode", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.ITINERARIES, new org.apache.thrift.meta_data.FieldMetaData("itineraries", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, ItineraryDto.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ListItineraryResponse.class, metaDataMap);
  }

  public ListItineraryResponse() {
  }

  public ListItineraryResponse(
    int errorCode)
  {
    this();
    this.errorCode = errorCode;
    setErrorCodeIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ListItineraryResponse(ListItineraryResponse other) {
    __isset_bitfield = other.__isset_bitfield;
    this.errorCode = other.errorCode;
    if (other.isSetItineraries()) {
      List<ItineraryDto> __this__itineraries = new ArrayList<ItineraryDto>(other.itineraries.size());
      for (ItineraryDto other_element : other.itineraries) {
        __this__itineraries.add(new ItineraryDto(other_element));
      }
      this.itineraries = __this__itineraries;
    }
  }

  public ListItineraryResponse deepCopy() {
    return new ListItineraryResponse(this);
  }

  @Override
  public void clear() {
    setErrorCodeIsSet(false);
    this.errorCode = 0;
    this.itineraries = null;
  }

  public int getErrorCode() {
    return this.errorCode;
  }

  public ListItineraryResponse setErrorCode(int errorCode) {
    this.errorCode = errorCode;
    setErrorCodeIsSet(true);
    return this;
  }

  public void unsetErrorCode() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ERRORCODE_ISSET_ID);
  }

  /** Returns true if field errorCode is set (has been assigned a value) and false otherwise */
  public boolean isSetErrorCode() {
    return EncodingUtils.testBit(__isset_bitfield, __ERRORCODE_ISSET_ID);
  }

  public void setErrorCodeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ERRORCODE_ISSET_ID, value);
  }

  public int getItinerariesSize() {
    return (this.itineraries == null) ? 0 : this.itineraries.size();
  }

  public java.util.Iterator<ItineraryDto> getItinerariesIterator() {
    return (this.itineraries == null) ? null : this.itineraries.iterator();
  }

  public void addToItineraries(ItineraryDto elem) {
    if (this.itineraries == null) {
      this.itineraries = new ArrayList<ItineraryDto>();
    }
    this.itineraries.add(elem);
  }

  public List<ItineraryDto> getItineraries() {
    return this.itineraries;
  }

  public ListItineraryResponse setItineraries(List<ItineraryDto> itineraries) {
    this.itineraries = itineraries;
    return this;
  }

  public void unsetItineraries() {
    this.itineraries = null;
  }

  /** Returns true if field itineraries is set (has been assigned a value) and false otherwise */
  public boolean isSetItineraries() {
    return this.itineraries != null;
  }

  public void setItinerariesIsSet(boolean value) {
    if (!value) {
      this.itineraries = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ERROR_CODE:
      if (value == null) {
        unsetErrorCode();
      } else {
        setErrorCode((Integer)value);
      }
      break;

    case ITINERARIES:
      if (value == null) {
        unsetItineraries();
      } else {
        setItineraries((List<ItineraryDto>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ERROR_CODE:
      return Integer.valueOf(getErrorCode());

    case ITINERARIES:
      return getItineraries();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ERROR_CODE:
      return isSetErrorCode();
    case ITINERARIES:
      return isSetItineraries();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ListItineraryResponse)
      return this.equals((ListItineraryResponse)that);
    return false;
  }

  public boolean equals(ListItineraryResponse that) {
    if (that == null)
      return false;

    boolean this_present_errorCode = true;
    boolean that_present_errorCode = true;
    if (this_present_errorCode || that_present_errorCode) {
      if (!(this_present_errorCode && that_present_errorCode))
        return false;
      if (this.errorCode != that.errorCode)
        return false;
    }

    boolean this_present_itineraries = true && this.isSetItineraries();
    boolean that_present_itineraries = true && that.isSetItineraries();
    if (this_present_itineraries || that_present_itineraries) {
      if (!(this_present_itineraries && that_present_itineraries))
        return false;
      if (!this.itineraries.equals(that.itineraries))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_errorCode = true;
    list.add(present_errorCode);
    if (present_errorCode)
      list.add(errorCode);

    boolean present_itineraries = true && (isSetItineraries());
    list.add(present_itineraries);
    if (present_itineraries)
      list.add(itineraries);

    return list.hashCode();
  }

  @Override
  public int compareTo(ListItineraryResponse other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetErrorCode()).compareTo(other.isSetErrorCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetErrorCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.errorCode, other.errorCode);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetItineraries()).compareTo(other.isSetItineraries());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetItineraries()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.itineraries, other.itineraries);
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
    StringBuilder sb = new StringBuilder("ListItineraryResponse(");
    boolean first = true;

    sb.append("errorCode:");
    sb.append(this.errorCode);
    first = false;
    if (isSetItineraries()) {
      if (!first) sb.append(", ");
      sb.append("itineraries:");
      if (this.itineraries == null) {
        sb.append("null");
      } else {
        sb.append(this.itineraries);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'errorCode' because it's a primitive and you chose the non-beans generator.
    // check for sub-struct validity
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

  private static class ListItineraryResponseStandardSchemeFactory implements SchemeFactory {
    public ListItineraryResponseStandardScheme getScheme() {
      return new ListItineraryResponseStandardScheme();
    }
  }

  private static class ListItineraryResponseStandardScheme extends StandardScheme<ListItineraryResponse> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ListItineraryResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ERROR_CODE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.errorCode = iprot.readI32();
              struct.setErrorCodeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // ITINERARIES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.itineraries = new ArrayList<ItineraryDto>(_list0.size);
                ItineraryDto _elem1;
                for (int _i2 = 0; _i2 < _list0.size; ++_i2)
                {
                  _elem1 = new ItineraryDto();
                  _elem1.read(iprot);
                  struct.itineraries.add(_elem1);
                }
                iprot.readListEnd();
              }
              struct.setItinerariesIsSet(true);
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
      if (!struct.isSetErrorCode()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ListItineraryResponse struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ERROR_CODE_FIELD_DESC);
      oprot.writeI32(struct.errorCode);
      oprot.writeFieldEnd();
      if (struct.itineraries != null) {
        if (struct.isSetItineraries()) {
          oprot.writeFieldBegin(ITINERARIES_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.itineraries.size()));
            for (ItineraryDto _iter3 : struct.itineraries)
            {
              _iter3.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ListItineraryResponseTupleSchemeFactory implements SchemeFactory {
    public ListItineraryResponseTupleScheme getScheme() {
      return new ListItineraryResponseTupleScheme();
    }
  }

  private static class ListItineraryResponseTupleScheme extends TupleScheme<ListItineraryResponse> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ListItineraryResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.errorCode);
      BitSet optionals = new BitSet();
      if (struct.isSetItineraries()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetItineraries()) {
        {
          oprot.writeI32(struct.itineraries.size());
          for (ItineraryDto _iter4 : struct.itineraries)
          {
            _iter4.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ListItineraryResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.errorCode = iprot.readI32();
      struct.setErrorCodeIsSet(true);
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list5 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.itineraries = new ArrayList<ItineraryDto>(_list5.size);
          ItineraryDto _elem6;
          for (int _i7 = 0; _i7 < _list5.size; ++_i7)
          {
            _elem6 = new ItineraryDto();
            _elem6.read(iprot);
            struct.itineraries.add(_elem6);
          }
        }
        struct.setItinerariesIsSet(true);
      }
    }
  }

}

