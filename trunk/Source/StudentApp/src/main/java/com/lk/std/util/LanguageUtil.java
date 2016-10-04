/**
 * 
 */
package com.lk.std.util;

import com.lk.std.constant.GeneralEnumConstants.LanguageType;

/**
 * @author dhiripitiy001
 *
 */
public final class LanguageUtil {

  public static LanguageType getLanguageType(String lang) {
    if (lang == "en") {
      return LanguageType.en;
    } else if (lang == "si") {
      return LanguageType.si;
    } else if (lang == "ta") {
      return LanguageType.ta;
    }
    return null;
  }

  public static String getLanguageType(LanguageType lang) {
    if (lang == LanguageType.en) {
      return "en";
    } else if (lang == LanguageType.si) {
      return "si";
    } else if (lang == LanguageType.ta) {
      return "ta";
    }
    return null;
  }

}
