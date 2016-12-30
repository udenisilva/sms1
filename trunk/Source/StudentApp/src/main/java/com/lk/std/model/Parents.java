package com.lk.std.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity(name = "parents")
@Table(name = "parents")
public class Parents implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "parent_id", nullable = false)
	private long id;

	@Column(name = "parent_fname", nullable = false)
	private String fname;
	
	@Column(name = "parent_foccupation", nullable = true)
	private String foccupation;
	
	@Column(name = "parent_fnationaity", nullable = false)
	private String fnationaity;
	
	@Column(name = "parent_fnic", nullable = false)
	private String fnic;
	
	@Column(name = "parent_fcompany", nullable = true)
	private String fcompany;
	
	@Column(name = "parent_fphone", nullable = false)
	private int fphone;
	
	@Column(name = "parent_fmobile", nullable = false)
	private int fmobile;
	
	@Column(name = "parent_faddress", nullable = false)
	private String faddress;
	
	@Column(name = "parent_femail", nullable = false)
	private String femail;
	
	@Column(name = "parent_mname", nullable = false)
	private String mname;
	
	@Column(name = "parent_moccupation", nullable = true)
	private String moccupation;
	
	@Column(name = "parent_mnationaity", nullable = false)
	private String mnationaity;
	
	@Column(name = "parent_mnic", nullable = false)
	private String mnic;
	
	@Column(name = "parent_mcompany", nullable = true)
	private String mcompany;
	
	@Column(name = "parent_mphone", nullable = false)
	private int mphone;
	
	@Column(name = "parent_mmobile", nullable = false)
	private int mmobile;
	
	@Column(name = "parent_maddress", nullable = false)
	private String maddress;
	
	@Column(name = "parent_memail", nullable = false)
	private String memail;
	
	@OneToMany(mappedBy="parents") 
	private List<Student> student;
	
	
	@Version
	@Column(name = "version_id")
	private int versionId;

	public Parents() {
		super();		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFoccupation() {
		return foccupation;
	}

	public void setFoccupation(String foccupation) {
		this.foccupation = foccupation;
	}

	public String getFnationaity() {
		return fnationaity;
	}

	public void setFnationaity(String fnationaity) {
		this.fnationaity = fnationaity;
	}

	public String getFnic() {
		return fnic;
	}

	public void setFnic(String fnic) {
		this.fnic = fnic;
	}

	public String getFcompany() {
		return fcompany;
	}

	public void setFcompany(String fcompany) {
		this.fcompany = fcompany;
	}

	public int getFphone() {
		return fphone;
	}

	public void setFphone(int fphone) {
		this.fphone = fphone;
	}

	public int getFmobile() {
		return fmobile;
	}

	public void setFmobile(int fmobile) {
		this.fmobile = fmobile;
	}

	public String getFaddress() {
		return faddress;
	}

	public void setFaddress(String faddress) {
		this.faddress = faddress;
	}

	public String getFemail() {
		return femail;
	}

	public void setFemail(String femail) {
		this.femail = femail;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMoccupation() {
		return moccupation;
	}

	public void setMoccupation(String moccupation) {
		this.moccupation = moccupation;
	}

	public String getMnationaity() {
		return mnationaity;
	}

	public void setMnationaity(String mnationaity) {
		this.mnationaity = mnationaity;
	}

	public String getMnic() {
		return mnic;
	}

	public void setMnic(String mnic) {
		this.mnic = mnic;
	}

	public String getMcompany() {
		return mcompany;
	}

	public void setMcompany(String mcompany) {
		this.mcompany = mcompany;
	}

	public int getMphone() {
		return mphone;
	}

	public void setMphone(int mphone) {
		this.mphone = mphone;
	}

	public int getMmobile() {
		return mmobile;
	}

	public void setMmobile(int mmobile) {
		this.mmobile = mmobile;
	}

	public String getMaddress() {
		return maddress;
	}

	public void setMaddress(String maddress) {
		this.maddress = maddress;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	@Override
	public String toString() {
		return "Parents [id=" + id + ", fname=" + fname + ", foccupation=" + foccupation + ", fnationaity="
				+ fnationaity + ", fnic=" + fnic + ", fcompany=" + fcompany + ", fphone=" + fphone + ", fmobile="
				+ fmobile + ", faddress=" + faddress + ", femail=" + femail + ", mname=" + mname + ", moccupation="
				+ moccupation + ", mnationaity=" + mnationaity + ", mnic=" + mnic + ", mcompany=" + mcompany
				+ ", mphone=" + mphone + ", mmobile=" + mmobile + ", maddress=" + maddress + ", memail=" + memail
				+ ", versionId=" + versionId + "]";
	}
	
	

}
