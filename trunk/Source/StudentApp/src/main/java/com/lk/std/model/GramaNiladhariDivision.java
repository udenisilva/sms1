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


@Entity(name = "gramaNiladhariDivision")
@Table(name = "gramaNiladhariDivision")
public class GramaNiladhariDivision implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "gn_div_id", nullable = false)
  private long gnDivId;

  @Column(name = "gn_div_desc", nullable = false)
  private String gnDivDesc;
  
  @Column(name = "gn_div_desc_si", nullable = false)
  private String gnDivDesc_si;

  @Column(name = "gn_div_code")
  private String gnDivCode;

  @Column(name = "gn_div_no", nullable = false)
  private String gnDivNo;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "district_sec_id")
  private DistrictSecretariat districtSecId;

  @Version
  @Column(name = "version_id")
  private int versionId;

  public GramaNiladhariDivision() {
    super();
  }

  public GramaNiladhariDivision(long gn_div_id, String gnDivDesc, String gn_div_no) {
    super();
    this.gnDivId = gn_div_id;
    this.gnDivDesc = gnDivDesc;
    this.gnDivNo = gn_div_no;
  }

  public Map<String, Object> toBasicMap() {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("gnDivId", gnDivId);
    map.put("gnDivDesc", gnDivDesc);
    map.put("gnDivNo", gnDivNo);
    map.put("gnDivCode", gnDivCode);
    map.put("districtSecId", districtSecId);
    map.put("versionId", versionId);
    return map;
  }


  public long getGnDivId() {
    return gnDivId;
  }

  public void setGnDivId(long gnDivId) {
    this.gnDivId = gnDivId;
  }

  public String getGnDivDesc() {
    return gnDivDesc;
  }

  public void setGnDivDesc(String gnDivDesc) {
    this.gnDivDesc = gnDivDesc;
  }

  public String getGnDivNo() {
    return gnDivNo;
  }

  public void setGnDivNo(String gnDivNo) {
    this.gnDivNo = gnDivNo;
  }

  public int getVersionId() {
    return versionId;
  }

  public void setVersionId(int versionId) {
    this.versionId = versionId;
  }


  public DistrictSecretariat getDistrictSecId() {
    return districtSecId;
  }

  public void setDistrictSecId(DistrictSecretariat districtSecId) {
    this.districtSecId = districtSecId;
  }

  public String getGnDivCode() {
    return gnDivCode;
  }

  public void setGnDivCode(String gnDivCode) {
    this.gnDivCode = gnDivCode;
  }

public String getGnDivDesc_si() {
	return gnDivDesc_si;
}

public void setGnDivDesc_si(String gnDivDesc_si) {
	this.gnDivDesc_si = gnDivDesc_si;
}
  
  
}
