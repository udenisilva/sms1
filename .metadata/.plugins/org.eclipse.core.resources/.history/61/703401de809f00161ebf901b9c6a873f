package com.lk.std.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.lk.std.constant.OLSIMSEnumConstant.ActiveStatus;
import com.lk.std.constant.OLSIMSEnumConstant.Gender;
import com.lk.std.constant.OLSIMSEnumConstant.House;
import com.lk.std.constant.OLSIMSEnumConstant.Title;

@Entity(name = "staff")
@Table(name = "staff")
public class Staff implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "staf_id", nullable = false)
	private long id;
	
	@Column(name = "staff_title", nullable = false)
	private Title title;
	
	@Column(name = "staff_name", nullable = false)
	private String name;
	
	@Column(name = "staff_address", nullable = false)
	private String address;
	
	@OneToOne
	@JoinColumn(name="staff_branch",nullable = false) 
	private Branch branch;
	
	@OneToOne
	@JoinColumn(name="staff_designation",nullable = false) 
	private Designation designation;
	
	@Column(name = "staff_nic", nullable = false)
	private String nic;
	
	@Column(name = "staff_tel", nullable = false)
	private int tel;
	
	@Column(name = "staff_mobile", nullable = false)
	private int mobile;
	
	@Column(name = "staff_gender", nullable = false)
	private Gender gender;
	
	@Column(name = "staff_bday", nullable = false)
	private Date bday;
	
	@Column(name = "staff_email", nullable = false)
	private String email;
	
	@Column(name = "staff_qulifications", nullable = false)
	private String qulifications;
	
	@Column(name = "staff_experience", nullable = false)
	private String experience;
	
	@Column(name = "staff_house", nullable = false)
	private House house;
	
	@Column(name = "staff_jdate", nullable = false)
	private Date jdate;
	
	@Column(name = "staff_ldate", nullable = true)
	private Date ldate;
	
	@Column(name = "staff_status", nullable = false)
	private ActiveStatus status;
	
	@Column(name = "staff_remarks", nullable = true)
	private String remarks;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "staff_subject", joinColumns = @JoinColumn(name = "staff_id"), inverseJoinColumns = @JoinColumn(name = "subject_id"))
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Subject> subjects;
	
	@Version
	@Column(name = "version_id")
	private int versionId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getBday() {
		return bday;
	}

	public void setBday(Date bday) {
		this.bday = bday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQulifications() {
		return qulifications;
	}

	public void setQulifications(String qulifications) {
		this.qulifications = qulifications;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public Date getJdate() {
		return jdate;
	}

	public void setJdate(Date jdate) {
		this.jdate = jdate;
	}

	public Date getLdate() {
		return ldate;
	}

	public void setLdate(Date ldate) {
		this.ldate = ldate;
	}

	public ActiveStatus getStatus() {
		return status;
	}

	public void setStatus(ActiveStatus status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", title=" + title + ", name=" + name + ", address=" + address + ", branch=" + branch
				+ ", designation=" + designation + ", nic=" + nic + ", tel=" + tel + ", mobile=" + mobile + ", gender="
				+ gender + ", bday=" + bday + ", email=" + email + ", qulifications=" + qulifications + ", experience="
				+ experience + ", house=" + house + ", jdate=" + jdate + ", ldate=" + ldate + ", status=" + status
				+ ", remarks=" + remarks + ", subjects=" + subjects + ", versionId=" + versionId + "]";
	}

	
	
	
	
}
