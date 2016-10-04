package com.lk.std.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity(name = "sequence_number")
@Table(name = "sequence_number")
public class SequenceNumber implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private long id;

  private long currentSequenceNumber;

  private String description;
  
  @OneToOne
  private District district;

  @Version
  private int versionId;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getCurrentSequenceNumber() {
    return currentSequenceNumber;
  }

  public void setCurrentSequenceNumber(long currentSequenceNumber) {
    this.currentSequenceNumber = currentSequenceNumber;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getVersionId() {
    return versionId;
  }

  public void setVersionId(int versionId) {
    this.versionId = versionId;
  }

}
