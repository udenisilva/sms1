/**
 * 
 */
package com.lk.std.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;


@Entity(name = "localAuthority")
@Table(name = "localAuthority")
public class LocalAuthority implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "local_authority_id", nullable = false)
  private long localAuthorityId;

  @Column(name = "local_authority_desc", nullable = false)
  private String localAuthorityDesc;

  @Column(name = "local_authority_desc_si", nullable = false)
  private String localAuthorityDesc_si;
  
  @Column(name = "local_authority_code", nullable = false)
  private String localAuthorityCode;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "district_id")
  private District district;

  @Version
  @Column(name = "version_id")
  private int versionId;

  public LocalAuthority() {
    super();
  }

  public LocalAuthority(long local_auth_id, String local_auth_desc) {
    super();
    this.localAuthorityId = local_auth_id;
    this.localAuthorityDesc = local_auth_desc;
  }

  public Map<String, Object> toBasicMap() {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("localAuthorityId", localAuthorityId);
    map.put("localAuthorityDesc", localAuthorityDesc);
    map.put("localAuthorityCode", localAuthorityCode);
    map.put("district", district);
    map.put("versionId", versionId);
    return map;
  }

  public long getLocalAuthorityId() {
    return localAuthorityId;
  }

  public void setLocalAuthorityId(Long localAuthorityId) {
    this.localAuthorityId = localAuthorityId;
  }

  public String getLocalAuthorityDesc() {
    return localAuthorityDesc;
  }

  public void setLocalAuthorityDesc(String localAuthorityDesc) {
    this.localAuthorityDesc = localAuthorityDesc;
  }

  public District getDistrict() {
    return district;
  }

  public void setDistrict(District district) {
    this.district = district;
  }

  public int getVersionId() {
    return versionId;
  }

  public void setVersionId(int versionId) {
    this.versionId = versionId;
  }

  public String getLocalAuthorityCode() {
    return localAuthorityCode;
  }

  public void setLocalAuthorityCode(String localAuthorityCode) {
    this.localAuthorityCode = localAuthorityCode;
  }

  public void setLocalAuthorityId(long localAuthorityId) {
    this.localAuthorityId = localAuthorityId;
  }

public String getLocalAuthorityDesc_si() {
	return localAuthorityDesc_si;
}

public void setLocalAuthorityDesc_si(String localAuthorityDesc_si) {
	this.localAuthorityDesc_si = localAuthorityDesc_si;
}
  
  

}