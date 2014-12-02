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
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2014-12-2")
public class LoginFacebookAccountResponse implements org.apache.thrift.TBase<LoginFacebookAccountResponse, LoginFacebookAccountResponse._Fields>, java.io.Serializable, Cloneable, Comparable<LoginFacebookAccountResponse> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("LoginFacebookAccountResponse");

  private static final org.apache.thrift.protocol.TField ERROR_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("errorCode", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField AMITY_USER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("amityUserId", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField AUTH_TOKE_FIELD_DESC = new org.apache.thrift.protocol.TField("authToke", org.apache.thrift.protocol.TType.STRUCT, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new LoginFacebookAccountResponseStandardSchemeFactory());
    schemes.put(TupleScheme.class, new LoginFacebookAccountResponseTupleSchemeFactory());
  }

  public int errorCode; // required
  public long amityUserId; // optional
  public AmityToken authToke; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ERROR_CODE((short)1, "errorCode"),
    AMITY_USER_ID((short)2, "amityUserId"),
    AUTH_TOKE((short)3, "authToke");

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
        case 2: // AMITY_USER_ID
          return AMITY_USER_ID;
        case 3: // AUTH_TOKE
          return AUTH_TOKE;
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
  private static final int __AMITYUSERID_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.AMITY_USER_ID,_Fields.AUTH_TOKE};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ERROR_CODE, new org.apache.thrift.meta_data.FieldMetaData("errorCode", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.AMITY_USER_ID, new org.apache.thrift.meta_data.FieldMetaData("amityUserId", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.AUTH_TOKE, new org.apache.thrift.meta_data.FieldMetaData("authToke", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, AmityToken.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(LoginFacebookAccountResponse.class, metaDataMap);
  }

  public LoginFacebookAccountResponse() {
  }

  public LoginFacebookAccountResponse(
    int errorCode)
  {
    this();
    this.errorCode = errorCode;
    setErrorCodeIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public LoginFacebookAccountResponse(LoginFacebookAccountResponse other) {
    __isset_bitfield = other.__isset_bitfield;
    this.errorCode = other.errorCode;
    this.amityUserId = other.amityUserId;
    if (other.isSetAuthToke()) {
      this.authToke = new AmityToken(other.authToke);
    }
  }

  public LoginFacebookAccountResponse deepCopy() {
    return new LoginFacebookAccountResponse(this);
  }

  @Override
  public void clear() {
    setErrorCodeIsSet(false);
    this.errorCode = 0;
    setAmityUserIdIsSet(false);
    this.amityUserId = 0;
    this.authToke = null;
  }

  public int getErrorCode() {
    return this.errorCode;
  }

  public LoginFacebookAccountResponse setErrorCode(int errorCode) {
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

  public long getAmityUserId() {
    return this.amityUserId;
  }

  public LoginFacebookAccountResponse setAmityUserId(long amityUserId) {
    this.amityUserId = amityUserId;
    setAmityUserIdIsSet(true);
    return this;
  }

  public void unsetAmityUserId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __AMITYUSERID_ISSET_ID);
  }

  /** Returns true if field amityUserId is set (has been assigned a value) and false otherwise */
  public boolean isSetAmityUserId() {
    return EncodingUtils.testBit(__isset_bitfield, __AMITYUSERID_ISSET_ID);
  }

  public void setAmityUserIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __AMITYUSERID_ISSET_ID, value);
  }

  public AmityToken getAuthToke() {
    return this.authToke;
  }

  public LoginFacebookAccountResponse setAuthToke(AmityToken authToke) {
    this.authToke = authToke;
    return this;
  }

  public void unsetAuthToke() {
    this.authToke = null;
  }

  /** Returns true if field authToke is set (has been assigned a value) and false otherwise */
  public boolean isSetAuthToke() {
    return this.authToke != null;
  }

  public void setAuthTokeIsSet(boolean value) {
    if (!value) {
      this.authToke = null;
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

    case AMITY_USER_ID:
      if (value == null) {
        unsetAmityUserId();
      } else {
        setAmityUserId((Long)value);
      }
      break;

    case AUTH_TOKE:
      if (value == null) {
        unsetAuthToke();
      } else {
        setAuthToke((AmityToken)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ERROR_CODE:
      return Integer.valueOf(getErrorCode());

    case AMITY_USER_ID:
      return Long.valueOf(getAmityUserId());

    case AUTH_TOKE:
      return getAuthToke();

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
    case AMITY_USER_ID:
      return isSetAmityUserId();
    case AUTH_TOKE:
      return isSetAuthToke();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof LoginFacebookAccountResponse)
      return this.equals((LoginFacebookAccountResponse)that);
    return false;
  }

  public boolean equals(LoginFacebookAccountResponse that) {
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

    boolean this_present_amityUserId = true && this.isSetAmityUserId();
    boolean that_present_amityUserId = true && that.isSetAmityUserId();
    if (this_present_amityUserId || that_present_amityUserId) {
      if (!(this_present_amityUserId && that_present_amityUserId))
        return false;
      if (this.amityUserId != that.amityUserId)
        return false;
    }

    boolean this_present_authToke = true && this.isSetAuthToke();
    boolean that_present_authToke = true && that.isSetAuthToke();
    if (this_present_authToke || that_present_authToke) {
      if (!(this_present_authToke && that_present_authToke))
        return false;
      if (!this.authToke.equals(that.authToke))
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

    boolean present_amityUserId = true && (isSetAmityUserId());
    list.add(present_amityUserId);
    if (present_amityUserId)
      list.add(amityUserId);

    boolean present_authToke = true && (isSetAuthToke());
    list.add(present_authToke);
    if (present_authToke)
      list.add(authToke);

    return list.hashCode();
  }

  @Override
  public int compareTo(LoginFacebookAccountResponse other) {
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
    lastComparison = Boolean.valueOf(isSetAmityUserId()).compareTo(other.isSetAmityUserId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAmityUserId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.amityUserId, other.amityUserId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAuthToke()).compareTo(other.isSetAuthToke());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAuthToke()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.authToke, other.authToke);
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
    StringBuilder sb = new StringBuilder("LoginFacebookAccountResponse(");
    boolean first = true;

    sb.append("errorCode:");
    sb.append(this.errorCode);
    first = false;
    if (isSetAmityUserId()) {
      if (!first) sb.append(", ");
      sb.append("amityUserId:");
      sb.append(this.amityUserId);
      first = false;
    }
    if (isSetAuthToke()) {
      if (!first) sb.append(", ");
      sb.append("authToke:");
      if (this.authToke == null) {
        sb.append("null");
      } else {
        sb.append(this.authToke);
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
    if (authToke != null) {
      authToke.validate();
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

  private static class LoginFacebookAccountResponseStandardSchemeFactory implements SchemeFactory {
    public LoginFacebookAccountResponseStandardScheme getScheme() {
      return new LoginFacebookAccountResponseStandardScheme();
    }
  }

  private static class LoginFacebookAccountResponseStandardScheme extends StandardScheme<LoginFacebookAccountResponse> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, LoginFacebookAccountResponse struct) throws org.apache.thrift.TException {
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
          case 2: // AMITY_USER_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.amityUserId = iprot.readI64();
              struct.setAmityUserIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // AUTH_TOKE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.authToke = new AmityToken();
              struct.authToke.read(iprot);
              struct.setAuthTokeIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, LoginFacebookAccountResponse struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(ERROR_CODE_FIELD_DESC);
      oprot.writeI32(struct.errorCode);
      oprot.writeFieldEnd();
      if (struct.isSetAmityUserId()) {
        oprot.writeFieldBegin(AMITY_USER_ID_FIELD_DESC);
        oprot.writeI64(struct.amityUserId);
        oprot.writeFieldEnd();
      }
      if (struct.authToke != null) {
        if (struct.isSetAuthToke()) {
          oprot.writeFieldBegin(AUTH_TOKE_FIELD_DESC);
          struct.authToke.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class LoginFacebookAccountResponseTupleSchemeFactory implements SchemeFactory {
    public LoginFacebookAccountResponseTupleScheme getScheme() {
      return new LoginFacebookAccountResponseTupleScheme();
    }
  }

  private static class LoginFacebookAccountResponseTupleScheme extends TupleScheme<LoginFacebookAccountResponse> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, LoginFacebookAccountResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.errorCode);
      BitSet optionals = new BitSet();
      if (struct.isSetAmityUserId()) {
        optionals.set(0);
      }
      if (struct.isSetAuthToke()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetAmityUserId()) {
        oprot.writeI64(struct.amityUserId);
      }
      if (struct.isSetAuthToke()) {
        struct.authToke.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, LoginFacebookAccountResponse struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.errorCode = iprot.readI32();
      struct.setErrorCodeIsSet(true);
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.amityUserId = iprot.readI64();
        struct.setAmityUserIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.authToke = new AmityToken();
        struct.authToke.read(iprot);
        struct.setAuthTokeIsSet(true);
      }
    }
  }

}

