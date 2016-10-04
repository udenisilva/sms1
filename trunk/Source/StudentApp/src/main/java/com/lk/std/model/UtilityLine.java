package com.lk.std.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;



@Entity(name = "utilityLine")
@Table(name = "utility_line")
public class UtilityLine implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  // @Column(name = "utility_type_id")
  private int id;

  // @Enumerated
  // private UtilityLineType utilityLineType;

  private double affectedLength;
 
  @ManyToOne(cascade = CascadeType.DETACH)
  @JoinColumn(name = "utility_type_id", nullable = true)
  private UtilityLineTypes utilityLineTypes;

  private Date createdDateTime;

  private long createdUser;;

  @Version
  private int versionId;



  public UtilityLine() {
    super();
    // TODO Auto-generated constructor stub
  }



  public UtilityLine(int id, double affectedLength, Date createdDateTime, long createdUser) {
    super();
    this.id = id;
    this.affectedLength = affectedLength;
    this.createdDateTime = createdDateTime;
    this.createdUser = createdUser;
  }

  public Map<String, Object> toBasicMap() {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("utility_type_id", id);
    map.put("affectedLength", affectedLength);
    map.put("createdDateTime", createdDateTime);
    map.put("createdUser", createdUser);
    map.put("versionId", versionId);
    return map;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }



  public double getAffectedLength() {
    return affectedLength;
  }

  public void setAffectedLength(double affectedLength) {
    this.affectedLength = affectedLength;
  }



  public UtilityLineTypes getUtilityLineTypes() {
    return utilityLineTypes;
  }



  public void setUtilityLineTypes(UtilityLineTypes utilityLineTypes) {
    this.utilityLineTypes = utilityLineTypes;
  }



  public Date getCreatedDateTime() {
    return createdDateTime;
  }

  public void setCreatedDateTime(Date createdDateTime) {
    this.createdDateTime = createdDateTime;
  }

  



  public long getCreatedUser() {
	return createdUser;
}



public void setCreatedUser(long createdUser) {
	this.createdUser = createdUser;
}



public int getVersionId() {
    return versionId;
  }

  public void setVersionId(int versionId) {
    this.versionId = versionId;
  }

 



}
