package com.lk.std.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lk.std.constant.OLSIMSEnumConstant.Action;

@Entity(name = "actionLogger")
@Table(name = "action_logger")
public class ActionLogger {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Enumerated(EnumType.STRING)
  private Action action;

  private String description;

  private Date occuredDateTime;

  private long appId;

  private long user;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Action getAction() {
    return action;
  }

  public void setAction(Action action) {
    this.action = action;
  }

  public Date getOccuredDateTime() {
    return occuredDateTime;
  }

  public void setOccuredDateTime(Date occuredDateTime) {
    this.occuredDateTime = occuredDateTime;
  }

  public long getAppId() {
    return appId;
  }

  public void setAppId(long appId) {
    this.appId = appId;
  }

  public long getUser() {
    return user;
  }

  public void setUser(long user) {
    this.user = user;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }



}