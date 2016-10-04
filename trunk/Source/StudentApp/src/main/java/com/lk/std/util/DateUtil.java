package com.lk.std.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtil {

  public static Date getDate(String date) {
    try {
      SimpleDateFormat format = new SimpleDateFormat();
      format = new SimpleDateFormat("dd/MM/yyyy");
      return format.parse(date);
    } catch (ParseException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static Date getNowDate() {
    Date curDate = new Date();
    return curDate;
  }

}
