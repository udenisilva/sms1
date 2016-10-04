package com.lk.std.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity(name = "utilityLineTypes")
@Table(name = "utility_line_types")
public class UtilityLineTypes implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "utility_type_id", nullable = false)
  private long utilityTypeId;

  @Column(name = "utility_type", nullable = false)
  private String utilityType;

  @Version
  @Column(name = "version_id")
  private int versionId;

  public UtilityLineTypes() {
    super();

  }

  public UtilityLineTypes(long utilityTypeId, String utilityType) {
    super();
    this.utilityTypeId = utilityTypeId;
    this.utilityType = utilityType;

  }

  public Map<String, Object> toBasicMap() {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("utility_type_id", utilityTypeId);
    map.put("utility_type", utilityType);
    map.put("version_id", versionId);
    return map;
  }

  public long getUtilityTypeId() {
    return utilityTypeId;
  }

  public void setUtilityTypeId(long utilityTypeId) {
    this.utilityTypeId = utilityTypeId;
  }

  public String getUtilityType() {
    return utilityType;
  }

  public void setUtilityType(String utilityType) {
    this.utilityType = utilityType;
  }

  public int getVersionId() {
    return versionId;
  }

  public void setVersionId(int versionId) {
    this.versionId = versionId;
  }



}
