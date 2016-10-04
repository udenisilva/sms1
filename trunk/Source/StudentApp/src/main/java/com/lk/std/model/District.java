/**
 * 
 */
package com.lk.std.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * @author dhiripitiy001
 *
 */
@Entity(name = "district")
@Table(name = "district")
public class District implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "district_id", nullable = false)
  private long districtId;

  @Column(name = "district", nullable = false)
  private String district;
  
  @Column(name = "district_si", nullable = false)
  private String district_si;

  @Column(name = "district_code", nullable = false)
  private String districtCode;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "district")
  private List<DistrictSecretariat> districtSecretariat;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "district")
  private List<LocalAuthority> localAuthority;

 

  @OneToOne(mappedBy = "district")
  private SequenceNumber sequenceNumber;
  
  @Version
  @Column(name = "version_id")
  private int versionId;

  public District() {
    super();
  }

  public District(long districtId, String district) {
    super();
    this.districtId = districtId;
    this.district = district;
  }

  public Map<String, Object> toBasicMap() {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("district_id", districtId);
    map.put("district", district);
    map.put("district_code", districtCode);
    map.put("versionId", versionId);
    return map;
  }

  public long getDistrictId() {
    return districtId;
  }

  public void setDistrictId(long districtId) {
    this.districtId = districtId;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public int getVersionId() {
    return versionId;
  }

  public void setVersionId(int versionId) {
    this.versionId = versionId;
  }

  public List<DistrictSecretariat> getDistrictSecretariat() {
    return districtSecretariat;
  }

  public void setDistrictSecretariat(List<DistrictSecretariat> districtSecretariat) {
    this.districtSecretariat = districtSecretariat;
  }

  public List<LocalAuthority> getLocalAuthority() {
    return localAuthority;
  }

  public void setLocalAuthority(List<LocalAuthority> localAuthority) {
    this.localAuthority = localAuthority;
  }

  public String getDistrictCode() {
    return districtCode;
  }

  public void setDistrictCode(String districtCode) {
    this.districtCode = districtCode;
  }

public String getDistrict_si() {
	return district_si;
}

public void setDistrict_si(String district_si) {
	this.district_si = district_si;
}


}
