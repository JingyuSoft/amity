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
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2014-12-21")
public class SearchCitiesRequest implements org.apache.thrift.TBase<SearchCitiesRequest, SearchCitiesRequest._Fields>, java.io.Serializable, Cloneable, Comparable<SearchCitiesRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("SearchCitiesRequest");

  private static final org.apache.thrift.protocol.TField SEARCH_TEXT_FIELD_DESC = new org.apache.thrift.protocol.TField("searchText", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField MAX_COUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("maxCount", org.apache.thrift.protocol.TType.I32, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new SearchCitiesRequestStandardSchemeFactory());
    schemes.put(TupleScheme.class, new SearchCitiesRequestTupleSchemeFactory());
  }

  public String searchText; // required
  public int maxCount; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SEARCH_TEXT((short)1, "searchText"),
    MAX_COUNT((short)2, "maxCount");

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
        case 1: // SEARCH_TEXT
          return SEARCH_TEXT;
        case 2: // MAX_COUNT
          return MAX_COUNT;
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
  private static final int __MAXCOUNT_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.MAX_COUNT};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SEARCH_TEXT, new org.apache.thrift.meta_data.FieldMetaData("searchText", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.MAX_COUNT, new org.apache.thrift.meta_data.FieldMetaData("maxCount", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(SearchCitiesRequest.class, metaDataMap);
  }

  public SearchCitiesRequest() {
  }

  public SearchCitiesRequest(
    String searchText)
  {
    this();
    this.searchText = searchText;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public SearchCitiesRequest(SearchCitiesRequest other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetSearchText()) {
      this.searchText = other.searchText;
    }
    this.maxCount = other.maxCount;
  }

  public SearchCitiesRequest deepCopy() {
    return new SearchCitiesRequest(this);
  }

  @Override
  public void clear() {
    this.searchText = null;
    setMaxCountIsSet(false);
    this.maxCount = 0;
  }

  public String getSearchText() {
    return this.searchText;
  }

  public SearchCitiesRequest setSearchText(String searchText) {
    this.searchText = searchText;
    return this;
  }

  public void unsetSearchText() {
    this.searchText = null;
  }

  /** Returns true if field searchText is set (has been assigned a value) and false otherwise */
  public boolean isSetSearchText() {
    return this.searchText != null;
  }

  public void setSearchTextIsSet(boolean value) {
    if (!value) {
      this.searchText = null;
    }
  }

  public int getMaxCount() {
    return this.maxCount;
  }

  public SearchCitiesRequest setMaxCount(int maxCount) {
    this.maxCount = maxCount;
    setMaxCountIsSet(true);
    return this;
  }

  public void unsetMaxCount() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __MAXCOUNT_ISSET_ID);
  }

  /** Returns true if field maxCount is set (has been assigned a value) and false otherwise */
  public boolean isSetMaxCount() {
    return EncodingUtils.testBit(__isset_bitfield, __MAXCOUNT_ISSET_ID);
  }

  public void setMaxCountIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __MAXCOUNT_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SEARCH_TEXT:
      if (value == null) {
        unsetSearchText();
      } else {
        setSearchText((String)value);
      }
      break;

    case MAX_COUNT:
      if (value == null) {
        unsetMaxCount();
      } else {
        setMaxCount((Integer)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SEARCH_TEXT:
      return getSearchText();

    case MAX_COUNT:
      return Integer.valueOf(getMaxCount());

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SEARCH_TEXT:
      return isSetSearchText();
    case MAX_COUNT:
      return isSetMaxCount();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof SearchCitiesRequest)
      return this.equals((SearchCitiesRequest)that);
    return false;
  }

  public boolean equals(SearchCitiesRequest that) {
    if (that == null)
      return false;

    boolean this_present_searchText = true && this.isSetSearchText();
    boolean that_present_searchText = true && that.isSetSearchText();
    if (this_present_searchText || that_present_searchText) {
      if (!(this_present_searchText && that_present_searchText))
        return false;
      if (!this.searchText.equals(that.searchText))
        return false;
    }

    boolean this_present_maxCount = true && this.isSetMaxCount();
    boolean that_present_maxCount = true && that.isSetMaxCount();
    if (this_present_maxCount || that_present_maxCount) {
      if (!(this_present_maxCount && that_present_maxCount))
        return false;
      if (this.maxCount != that.maxCount)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_searchText = true && (isSetSearchText());
    list.add(present_searchText);
    if (present_searchText)
      list.add(searchText);

    boolean present_maxCount = true && (isSetMaxCount());
    list.add(present_maxCount);
    if (present_maxCount)
      list.add(maxCount);

    return list.hashCode();
  }

  @Override
  public int compareTo(SearchCitiesRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetSearchText()).compareTo(other.isSetSearchText());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSearchText()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.searchText, other.searchText);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetMaxCount()).compareTo(other.isSetMaxCount());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMaxCount()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.maxCount, other.maxCount);
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
    StringBuilder sb = new StringBuilder("SearchCitiesRequest(");
    boolean first = true;

    sb.append("searchText:");
    if (this.searchText == null) {
      sb.append("null");
    } else {
      sb.append(this.searchText);
    }
    first = false;
    if (isSetMaxCount()) {
      if (!first) sb.append(", ");
      sb.append("maxCount:");
      sb.append(this.maxCount);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (searchText == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'searchText' was not present! Struct: " + toString());
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class SearchCitiesRequestStandardSchemeFactory implements SchemeFactory {
    public SearchCitiesRequestStandardScheme getScheme() {
      return new SearchCitiesRequestStandardScheme();
    }
  }

  private static class SearchCitiesRequestStandardScheme extends StandardScheme<SearchCitiesRequest> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, SearchCitiesRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SEARCH_TEXT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.searchText = iprot.readString();
              struct.setSearchTextIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // MAX_COUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.maxCount = iprot.readI32();
              struct.setMaxCountIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, SearchCitiesRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.searchText != null) {
        oprot.writeFieldBegin(SEARCH_TEXT_FIELD_DESC);
        oprot.writeString(struct.searchText);
        oprot.writeFieldEnd();
      }
      if (struct.isSetMaxCount()) {
        oprot.writeFieldBegin(MAX_COUNT_FIELD_DESC);
        oprot.writeI32(struct.maxCount);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class SearchCitiesRequestTupleSchemeFactory implements SchemeFactory {
    public SearchCitiesRequestTupleScheme getScheme() {
      return new SearchCitiesRequestTupleScheme();
    }
  }

  private static class SearchCitiesRequestTupleScheme extends TupleScheme<SearchCitiesRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, SearchCitiesRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.searchText);
      BitSet optionals = new BitSet();
      if (struct.isSetMaxCount()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetMaxCount()) {
        oprot.writeI32(struct.maxCount);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, SearchCitiesRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.searchText = iprot.readString();
      struct.setSearchTextIsSet(true);
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.maxCount = iprot.readI32();
        struct.setMaxCountIsSet(true);
      }
    }
  }

}

