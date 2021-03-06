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
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2015-1-3")
public class ListHelpRequestResponse implements org.apache.thrift.TBase<ListHelpRequestResponse, ListHelpRequestResponse._Fields>, java.io.Serializable, Cloneable, Comparable<ListHelpRequestResponse> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ListHelpRequestResponse");

  private static final org.apache.thrift.protocol.TField ERROR_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("errorCode", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField HELP_REQUESTS_FIELD_DESC = new org.apache.thrift.protocol.TField("helpRequests", org.apache.thrift.protocol.TType.LIST, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new ListHelpRequestResponseStandardSchemeFactory());
    schemes.put(TupleScheme.class, new ListHelpRequestResponseTupleSchemeFactory());
  }

  public int errorCode; // required
  public List<HelpRequestDto> helpRequests; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ERROR_CODE((short)1, "errorCode"),
    HELP_REQUESTS((short)2, "helpRequests");

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
        case 2: // HELP_REQUESTS
          return HELP_REQUESTS;
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
  private static final _Fields optionals[] = {_Fields.HELP_REQUESTS};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ERROR_CODE, new org.apache.thrift.meta_data.FieldMetaData("errorCode", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.HELP_REQUESTS, new org.apache.thrift.meta_data.FieldMetaData("helpRequests", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, HelpRequestDto.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ListHelpRequestResponse.class, metaDataMap);
  }

  public ListHelpRequestResponse() {
  }

  public ListHelpRequestResponse(
    int errorCode)
  {
    this();
    this.errorCode = errorCode;
    setErrorCodeIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ListHelpRequestResponse(ListHelpRequestResponse other) {
    __isset_bitfield = other.__isset_bitfield;
    this.errorCode = other.errorCode;
    if (other.isSetHelpRequests()) {
      List<HelpRequestDto> __this__helpRequests = new ArrayList<HelpRequestDto>(other.helpRequests.size());
      for (HelpRequestDto other_element : other.helpRequests) {
        __this__helpRequests.add(new HelpRequestDto(other_element));
      }
      this.helpRequests = __this__helpRequests;
    }
  }

  public ListHelpRequestResponse deepCopy() {
    return new ListHelpRequestResponse(this);
  }

  @Override
  public void clear() {
    setErrorCodeIsSet(false);
    this.errorCode = 0;
    this.helpRequests = null;
  }

  public int getErrorCode() {
    return this.errorCode;
  }

  public ListHelpRequestResponse setErrorCode(int errorCode) {
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

  public int getHelpRequestsSize() {
    return (this.helpRequests == null) ? 0 : this.helpRequests.size();
  }

  public java.util.Iterator<HelpRequestDto> getHelpRequestsIterator() {
    return (this.helpRequests == null) ? null : this.helpRequests.iterator();
  }

  public void addToHelpRequests(HelpRequestDto elem) {
    if (this.helpRequests == null) {
      this.helpRequests = new ArrayList<HelpRequestDto>();
    }
    this.helpRequests.add(elem);
  }

  public List<HelpRequestDto> getHelpRequests() {
    return this.helpRequests;
  }

  public ListHelpRequestResponse setHelpRequests(List<HelpRequestDto> helpRequests) {
    this.helpRequests = helpRequests;
    return this;
  }

  public void unsetHelpRequests() {
    this.helpRequests = null;
  }

  /** Returns true if field helpRequests is set (has been assigned a value) and false otherwise */
  public boolean isSetHelpRequests() {
    return this.helpRequests != null;
  }

  public void setHelpRequestsIsSet(boolean value) {
    if (!value) {
      this.helpRequests = null;
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

    case HELP_REQUESTS:
      if (value == null) {
        unsetHelpRequests();
      } else {
        setHelpRequests((List<HelpRequestDto>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ERROR_CODE:
      return Integer.valueOf(getErrorCode());

    case HELP_REQUESTS:
      return getHelpRequests();

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
    case HELP_REQUESTS:
      return isSetHelpRequests();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ListHelpRequestResponse)
      return this.equals((ListHelpRequestResponse)that);
    return false;
  }

  public boolean equals(ListHelpRequestResponse that) {
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

    boolean this_present_helpRequests = true && this.isSetHelpRequests();
    boolean that_present_helpRequests = true && that.isSetHelpRequests();
    if (this_present_helpRequests || that_present_helpRequests) {
      if (!(this_present_helpRequests && that_present_helpRequests))
        return false;
      if (!this.helpRequests.equals(that.helpRequests))
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

    boolean present_helpRequests = true && (isSetHelpRequests());
    list.add(present_helpRequests);
    if (present_helpRequests)
      list.add(helpRequests);

    return list.hashCode();
  }

  @Override
  public int compareTo(ListHelpRequestResponse other) {
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
    lastComparison = Boolean.valueOf(isSetHelpRequests()).compareTo(other.isSetHelpRequests());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHelpRequests()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.helpRequests, other.helpRequests);
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
    StringBuilder sb = new StringBuilder("ListHelpRequestResponse(");
    boolean first = true;

    sb.append("errorCode:");
    sb.append(this.errorCode);
    first = false;
    if (isSetHelpRequests()) {
      if (!first) sb.append(", ");
      sb.append("helpRequests:");
      if (this.helpRequests == null) {
        sb.append("null");
      } else {
        sb.append(this.helpRequests);
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

  private static class ListHelpRequestResponseStandardSchemeFactory implements SchemeFactory {
    public ListHelpRequestResponseStandardScheme getScheme() {
      return new ListHelpRequestResponseStandardScheme();
    }
  }

  private static class ListHelpRequestResponseStandardScheme extends StandardScheme<ListHelpRequestResponse> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ListHelpRequestResponse struct) throws org.apache.thrift.TException {
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
          case 2: // HELP_REQUESTS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.helpRequests = new ArrayList<HelpRequestDto>(_list0.size);
                HelpRequestDto _elem1;
                for (int _i2 = 0; _i2 < _list0.size; ++_i2)
                {
                  _elem1 = new HelpRequestDto();
                  _elem1.read(iprot);
                  struct.helpRequests.add(_elem1);
                }
                iprot.readListEnd();
              }
              struct.setHelpRequestsIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, ListHelpRequestResponse struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ERROR_CODE_FIELD_DESC);
      oprot.writeI32(struct.errorCode);
      oprot.writeFieldEnd();
      if (struct.helpRequests != null) {
        if (struct.isSetHelpRequests()) {
          oprot.writeFieldBegin(HELP_REQUESTS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.helpRequests.size()));
            for (HelpRequestDto _iter3 : struct.helpRequests)
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

  private static class ListHelpRequestResponseTupleSchemeFactory implements SchemeFactory {
    public ListHelpRequestResponseTupleScheme getScheme() {
      return new ListHelpRequestResponseTupleScheme();
    }
  }

  private static class ListHelpRequestResponseTupleScheme extends TupleScheme<ListHelpRequestResponse> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ListHelpRequestResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.errorCode);
      BitSet optionals = new BitSet();
      if (struct.isSetHelpRequests()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetHelpRequests()) {
        {
          oprot.writeI32(struct.helpRequests.size());
          for (HelpRequestDto _iter4 : struct.helpRequests)
          {
            _iter4.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ListHelpRequestResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.errorCode = iprot.readI32();
      struct.setErrorCodeIsSet(true);
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list5 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.helpRequests = new ArrayList<HelpRequestDto>(_list5.size);
          HelpRequestDto _elem6;
          for (int _i7 = 0; _i7 < _list5.size; ++_i7)
          {
            _elem6 = new HelpRequestDto();
            _elem6.read(iprot);
            struct.helpRequests.add(_elem6);
          }
        }
        struct.setHelpRequestsIsSet(true);
      }
    }
  }

}

