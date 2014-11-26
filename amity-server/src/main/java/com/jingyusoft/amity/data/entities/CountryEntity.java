package com.jingyusoft.amity.data.entities;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "country", indexes = { @Index(name = "idx_country_by_code", columnList = "code", unique = true) })
public class CountryEntity extends LocationEntityBase {

}
