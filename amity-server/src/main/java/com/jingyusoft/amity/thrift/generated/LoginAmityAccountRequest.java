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
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2014-12-25")
public class LoginAmityAccountRequest implements org.apache.thrift.TBase<LoginAmityAccountRequest, LoginAmityAccountRequest._Fields>, java.io.Serializable, Cloneable, Comparable<LoginAmityAccountRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("LoginAmityAccountRequest");

  private static final org.apache.thrift.protocol.TField EMAIL_ADDRESS_FIELD_DESC = new org.apache.thrift.protocol.TField("emailAddress", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField PLAIN_PASSWORD_FIELD_DESC = new org.apache.thrift.protocol.TField("plainPassword", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new LoginAmityAccountRequestStandardSchemeFactory());
    schemes.put(TupleScheme.class, new LoginAmityAccountRequestTupleSchemeFactory());
  }

  public String emailAddress; // required
  public String plainPassword; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    EMAIL_ADDRESS((short)1, "emailAddress"),
    PLAIN_PASSWORD((short)2, "plainPassword");

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
        case 1: // EMAIL_ADDRESS
          return EMAIL_ADDRESS;
        case 2: // PLAIN_PASSWORD
          return PLAIN_PASSWORD;
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
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.EMAIL_ADDRESS, new org.apache.thrift.meta_data.FieldMetaData("emailAddress", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PLAIN_PASSWORD, new org.apache.thrift.meta_data.FieldMetaData("plainPassword", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(LoginAmityAccountRequest.class, metaDataMap);
  }

  public LoginAmityAccountRequest() {
  }

  public LoginAmityAccountRequest(
    String emailAddress,
    String plainPassword)
  {
    this();
    this.emailAddress = emailAddress;
    this.plainPassword = plainPassword;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public LoginAmityAccountRequest(LoginAmityAccountRequest other) {
    if (other.isSetEmailAddress()) {
      this.emailAddress = other.emailAddress;
    }
    if (other.isSetPlainPassword()) {
      this.plainPassword = other.plainPassword;
    }
  }

  public LoginAmityAccountRequest deepCopy() {
    return new LoginAmityAccountRequest(this);
  }

  @Override
  public void clear() {
    this.emailAddress = null;
    this.plainPassword = null;
  }

  public String getEmailAddress() {
    return this.emailAddress;
  }

  public LoginAmityAccountRequest setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
    return this;
  }

  public void unsetEmailAddress() {
    this.emailAddress = null;
  }

  /** Returns true if field emailAddress is set (has been assigned a value) and false otherwise */
  public boolean isSetEmailAddress() {
    return this.emailAddress != null;
  }

  public void setEmailAddressIsSet(boolean value) {
    if (!value) {
      this.emailAddress = null;
    }
  }

  public String getPlainPassword() {
    return this.plainPassword;
  }

  public LoginAmityAccountRequest setPlainPassword(String plainPassword) {
    this.plainPassword = plainPassword;
    return this;
  }

  public void unsetPlainPassword() {
    this.plainPassword = null;
  }

  /** Returns true if field plainPassword is set (has been assigned a value) and false otherwise */
  public boolean isSetPlainPassword() {
    return this.plainPassword != null;
  }

  public void setPlainPasswordIsSet(boolean value) {
    if (!value) {
      this.plainPassword = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case EMAIL_ADDRESS:
      if (value == null) {
        unsetEmailAddress();
      } else {
        setEmailAddress((String)value);
      }
      break;

    case PLAIN_PASSWORD:
      if (value == null) {
        unsetPlainPassword();
      } else {
        setPlainPassword((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case EMAIL_ADDRESS:
      return getEmailAddress();

    case PLAIN_PASSWORD:
      return getPlainPassword();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case EMAIL_ADDRESS:
      return isSetEmailAddress();
    case PLAIN_PASSWORD:
      return isSetPlainPassword();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof LoginAmityAccountRequest)
      return this.equals((LoginAmityAccountRequest)that);
    return false;
  }

  public boolean equals(LoginAmityAccountRequest that) {
    if (that == null)
      return false;

    boolean this_present_emailAddress = true && this.isSetEmailAddress();
    boolean that_present_emailAddress = true && that.isSetEmailAddress();
    if (this_present_emailAddress || that_present_emailAddress) {
      if (!(this_present_emailAddress && that_present_emailAddress))
        return false;
      if (!this.emailAddress.equals(that.emailAddress))
        return false;
    }

    boolean this_present_plainPassword = true && this.isSetPlainPassword();
    boolean that_present_plainPassword = true && that.isSetPlainPassword();
    if (this_present_plainPassword || that_present_plainPassword) {
      if (!(this_present_plainPassword && that_present_plainPassword))
        return false;
      if (!this.plainPassword.equals(that.plainPassword))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_emailAddress = true && (isSetEmailAddress());
    list.add(present_emailAddress);
    if (present_emailAddress)
      list.add(emailAddress);

    boolean present_plainPassword = true && (isSetPlainPassword());
    list.add(present_plainPassword);
    if (present_plainPassword)
      list.add(plainPassword);

    return list.hashCode();
  }

  @Override
  public int compareTo(LoginAmityAccountRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetEmailAddress()).compareTo(other.isSetEmailAddress());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEmailAddress()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.emailAddress, other.emailAddress);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPlainPassword()).compareTo(other.isSetPlainPassword());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPlainPassword()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.plainPassword, other.plainPassword);
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
    StringBuilder sb = new StringBuilder("LoginAmityAccountRequest(");
    boolean first = true;

    sb.append("emailAddress:");
    if (this.emailAddress == null) {
      sb.append("null");
    } else {
      sb.append(this.emailAddress);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("plainPassword:");
    if (this.plainPassword == null) {
      sb.append("null");
    } else {
      sb.append(this.plainPassword);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (emailAddress == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'emailAddress' was not present! Struct: " + toString());
    }
    if (plainPassword == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'plainPassword' was not present! Struct: " + toString());
    }
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class LoginAmityAccountRequestStandardSchemeFactory implements SchemeFactory {
    public LoginAmityAccountRequestStandardScheme getScheme() {
      return new LoginAmityAccountRequestStandardScheme();
    }
  }

  private static class LoginAmityAccountRequestStandardScheme extends StandardScheme<LoginAmityAccountRequest> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, LoginAmityAccountRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // EMAIL_ADDRESS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.emailAddress = iprot.readString();
              struct.setEmailAddressIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PLAIN_PASSWORD
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.plainPassword = iprot.readString();
              struct.setPlainPasswordIsSet(true);
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
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, LoginAmityAccountRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.emailAddress != null) {
        oprot.writeFieldBegin(EMAIL_ADDRESS_FIELD_DESC);
        oprot.writeString(struct.emailAddress);
        oprot.writeFieldEnd();
      }
      if (struct.plainPassword != null) {
        oprot.writeFieldBegin(PLAIN_PASSWORD_FIELD_DESC);
        oprot.writeString(struct.plainPassword);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class LoginAmityAccountRequestTupleSchemeFactory implements SchemeFactory {
    public LoginAmityAccountRequestTupleScheme getScheme() {
      return new LoginAmityAccountRequestTupleScheme();
    }
  }

  private static class LoginAmityAccountRequestTupleScheme extends TupleScheme<LoginAmityAccountRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, LoginAmityAccountRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.emailAddress);
      oprot.writeString(struct.plainPassword);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, LoginAmityAccountRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.emailAddress = iprot.readString();
      struct.setEmailAddressIsSet(true);
      struct.plainPassword = iprot.readString();
      struct.setPlainPasswordIsSet(true);
    }
  }

}

