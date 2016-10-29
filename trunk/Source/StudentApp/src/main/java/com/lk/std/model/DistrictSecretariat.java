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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * @author dhiripitiy001
 *
 */
@Entity(name = "districtSecretariat")
@Table(name = "districtSecretariat")
public class DistrictSecretariat implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "district_sec_id", nullable = false)
  private long districtSecId;

  @Column(name = "district_sec", nullable = false)
  private String districtSec;
  
  @Column(name = "district_sec_si", nullable = false)
  private String districtSec_si;


  @Column(name = "district_sec_code", nullable = false)
  private String districtSecCode;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "district_id")
  private District district;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "districtSecId")
  private List<GramaNiladhariDivision> gramaNiladhariDivision;

  @Version
  @Column(name = "version_id")
  private int versionId;

  public DistrictSecretariat() {
    super();
  }

  public DistrictSecretariat(long divSecId, String div_sec) {
    super();
    this.districtSecId = divSecId;
    this.districtSec = div_sec;
  }

  public Map<String, Object> toBasicMap() {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("district_sec_id", districtSecId);
    map.put("district_sec", districtSec);
    map.put("district_sec_code", districtSecCode);
    map.put("versionId", versionId);
    return map;
  }

  public long getDistrictSecId() {
    return districtSecId;
  }

  public void setDistrictSecId(long districtSecId) {
    this.districtSecId = districtSecId;
  }

  public String getDistrictSec() {
    return districtSec;
  }

  public void setDistrictSec(String districtSec) {
    this.districtSec = districtSec;
  }

  public int getVersionId() {
    return versionId;
  }

  public void setVersionId(int versionId) {
    this.versionId = versionId;
  }

  public District getDistrict() {
    return district;
  }

  public void setDistrict(District district) {
    this.district = district;
  }

  public List<GramaNiladhariDivision> getGramaNiladhariDivision() {
    return gramaNiladhariDivision;
  }

  public void setGramaNiladhariDivision(List<GramaNiladhariDivision> gramaNiladhariDivision) {
    this.gramaNiladhariDivision = gramaNiladhariDivision;
  }

public String getDistrictSec_si() {
	return districtSec_si;
}

public void setDistrictSec_si(String districtSec_si) {
	this.districtSec_si = districtSec_si;
}

  
}