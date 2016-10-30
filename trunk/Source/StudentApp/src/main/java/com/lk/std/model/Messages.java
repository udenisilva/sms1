package com.lk.std.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.lk.std.constant.OLSIMSEnumConstant.MessagesCatagory;

@Entity(name = "messages")
@Table(name = "messages")
public class Messages implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "messages_id", nullable = false)
	private long id;
	
	@Column(name = "messages", nullable = false)
	private String message;
	
	@Column(name = "catagory", nullable = false)
	private MessagesCatagory catagory;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "grade_id", nullable = true)
	private Grade grade;

	@Version
	@Column(name = "version_id")
	private int versionId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MessagesCatagory getCatagory() {
		return catagory;
	}

	public void setCatagory(MessagesCatagory catagory) {
		this.catagory = catagory;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	
}
