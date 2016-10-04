package com.lk.std.util;



import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.lk.std.model.SystemUser;

public final class Session {

  private final class Keys {

    public static final String SESSION_USER = "SESSION_USER";
    public static final String SESSION_USER_ID = "SESSION_USER_ID";
    public static final String SESSION_USER_DISPLAY_NAME = "SESSION_USER_DISPLAY_NAME";
    public static final String SESSION_REF_NO = "SESSION_REF_NO";
    public static final String SESSION_APP_ID = "SESSION_APP_ID";
    public static final String SESSION_APP_LANG = "SESSION_APP_LANG";
    public static final String SESSION_APP_CERTIFY_USER = "SESSION_APP_CERTIFY_USER";

  }

  private static HttpSession getCurrent() {
    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
    return attr.getRequest().getSession();
  }

  private static Object getAttributeFromCurrent(String key) {
    return Session.getCurrent().getAttribute(key);
  }

  private static void setAttributeToCurrent(String key, String value) {
    Session.getCurrent().setAttribute(key, value);
  }

  private static void setAttributeToCurrent(String key, Object value) {
    Session.getCurrent().setAttribute(key, value);
  }

  public static long getLoggedUserId() {
    return (long) Session.getAttributeFromCurrent(Session.Keys.SESSION_USER_ID);
  }

  public static void setLoggedUserId(long userId) {
    setAttributeToCurrent(Session.Keys.SESSION_USER_ID, String.valueOf(userId));
  }

  public static void setApplicationRefNo(String refno) {
    setAttributeToCurrent(Session.Keys.SESSION_REF_NO, refno);
  }

  public static String getApplicationRefNo() {
    return (String) getAttributeFromCurrent(Session.Keys.SESSION_REF_NO);
  }

  public static long getApplicationId() {
    return Long.parseLong((String) getAttributeFromCurrent(Session.Keys.SESSION_APP_ID));
  }

  public static void setApplicationId(long id) {
    setAttributeToCurrent(Session.Keys.SESSION_APP_ID, String.valueOf(id));
  }

  public static String getUserDisplayName() {
    return (String) getAttributeFromCurrent(Session.Keys.SESSION_USER_DISPLAY_NAME);
  }

  public static void setUserDisplayName(String displayName) {
    setAttributeToCurrent(Session.Keys.SESSION_USER_DISPLAY_NAME, displayName);
  }

  public static SystemUser getSystemUser() {
    return (SystemUser) getAttributeFromCurrent(Session.Keys.SESSION_USER);
  }

  public static void setSystemUser(SystemUser systemUser) {
    setAttributeToCurrent(Session.Keys.SESSION_USER, systemUser);
  }

  public static void setApplicationLanguage(String lang) {
    setAttributeToCurrent(Session.Keys.SESSION_APP_LANG, lang);
  }

  public static String getApplicationLanguage() {
    return (String) getAttributeFromCurrent(Session.Keys.SESSION_APP_LANG);
  }

  public static void setApplicationCertifyUser(boolean certifyStatus) {
    setAttributeToCurrent(Session.Keys.SESSION_APP_CERTIFY_USER, certifyStatus);
  }

  public static boolean getApplicationCertifyUser() {
    return (boolean) getAttributeFromCurrent(Session.Keys.SESSION_APP_CERTIFY_USER);
  }

}
