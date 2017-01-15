package com.lk.std.constant;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class OLSIMSEnumConstant {

  public enum UtilityLineType {
    ELECTRICITY(1), WATER(2);

    private int code;

    private UtilityLineType(int code) {
      this.code = code;
    }

    public int getCode() {
      return code;
    }

    private static final Map<Integer, UtilityLineType> LOOKUP = new HashMap<Integer, UtilityLineType>();

    static {
      for (UtilityLineType utilityLineType : EnumSet.allOf(UtilityLineType.class)) {
        LOOKUP.put(utilityLineType.getCode(), utilityLineType);
      }
    }

    public static UtilityLineType fromCode(int code) {
      return LOOKUP.get(code);
    }
  }

  public enum Gender {
	   NONE(0), MALE(1), FEMALE(2);

	    private int code;

	    private Gender(int code) {
	      this.code = code;
	    }

	    public int getCode() {
	      return code;
	    }

	    private static final Map<Integer, Gender> LOOKUP = new HashMap<Integer, Gender>();

	    static {
	      for (Gender gender : EnumSet.allOf(Gender.class)) {
	        LOOKUP.put(gender.getCode(), gender);
	      }
	    }

	    public static Gender fromCode(int code) {
	      return LOOKUP.get(code);
	    }
	  }
  
  public enum MessagesCatagory {
	   NONE(0), MALE(1), FEMALE(2);

	    private int code;

	    private MessagesCatagory(int code) {
	      this.code = code;
	    }

	    public int getCode() {
	      return code;
	    }

	    private static final Map<Integer, MessagesCatagory> LOOKUP = new HashMap<Integer, MessagesCatagory>();

	    static {
	      for (MessagesCatagory messagesCatagory : EnumSet.allOf(MessagesCatagory.class)) {
	        LOOKUP.put(messagesCatagory.getCode(), messagesCatagory);
	      }
	    }

	    public static MessagesCatagory fromCode(int code) {
	      return LOOKUP.get(code);
	    }
	  }
  
  public enum Title {
	   NONE(0), Mr(1), Ms(2);

	    private int code;

	    private Title(int code) {
	      this.code = code;
	    }

	    public int getCode() {
	      return code;
	    }

	    private static final Map<Integer, Title> LOOKUP = new HashMap<Integer, Title>();

	    static {
	      for (Title title : EnumSet.allOf(Title.class)) {
	        LOOKUP.put(title.getCode(), title);
	      }
	    }

	    public static Title fromCode(int code) {
	      return LOOKUP.get(code);
	    }
	  }
  
  public enum House {
	   NONE(0), A(1), B(2);

	    private int code;

	    private House(int code) {
	      this.code = code;
	    }

	    public int getCode() {
	      return code;
	    }

	    private static final Map<Integer, House> LOOKUP = new HashMap<Integer, House>();

	    static {
	      for (House house : EnumSet.allOf(House.class)) {
	        LOOKUP.put(house.getCode(), house);
	      }
	    }

	    public static House fromCode(int code) {
	      return LOOKUP.get(code);
	    }
	  }
 
  public enum ActiveStatus {
	   NONE(0), ACTIVE(1),INACTIVE(2), TERMINATED(3);

	    private int code;

	    private ActiveStatus(int code) {
	      this.code = code;
	    }

	    public int getCode() {
	      return code;
	    }

	    private static final Map<Integer, ActiveStatus> LOOKUP = new HashMap<Integer, ActiveStatus>();

	    static {
	      for (ActiveStatus status : EnumSet.allOf(ActiveStatus.class)) {
	        LOOKUP.put(status.getCode(), status);
	      }
	    }

	    public static ActiveStatus fromCode(int code) {
	      return LOOKUP.get(code);
	    }
	  }

  public enum AttendanceStatus {
	   Non(0), Present(1),Absent(2);

	    private int code;

	    private AttendanceStatus(int code) {
	      this.code = code;
	    }

	    public int getCode() {
	      return code;
	    }

	    private static final Map<Integer, AttendanceStatus> LOOKUP = new HashMap<Integer, AttendanceStatus>();

	    static {
	      for (AttendanceStatus status : EnumSet.allOf(AttendanceStatus.class)) {
	        LOOKUP.put(status.getCode(), status);
	      }
	    }

	    public static AttendanceStatus fromCode(int code) {
	      return LOOKUP.get(code);
	    }
	  }

  
  public enum PaymentStatus {
    NONE(0), FULL_PAYMENT(1), NOT_PAID(2), TREASUARY_GRANT(3), INSTALLMENTS(4), LOCAL_AUTHORITY(5);

    private int code;

    private PaymentStatus(int code) {
      this.code = code;
    }

    public int getCode() {
      return code;
    }

    private static final Map<Integer, PaymentStatus> LOOKUP = new HashMap<Integer, PaymentStatus>();

    static {
      for (PaymentStatus paymentStatus : EnumSet.allOf(PaymentStatus.class)) {
        LOOKUP.put(paymentStatus.getCode(), paymentStatus);
      }
    }

    public static PaymentStatus fromCode(int code) {
      return LOOKUP.get(code);
    }
  }


  public enum PaymentType {
    NONE(0), FULL_PAYMENT(1), NOT_PAID(2), TREASUARY_GRANT(3), INSTALLMENTS(4), LOCAL_AUTHORITY(5);

    private int code;

    private PaymentType(int code) {
      this.code = code;
    }

    public int getCode() {
      return code;
    }

    private static final Map<Integer, PaymentStatus> LOOKUP = new HashMap<Integer, PaymentStatus>();

    static {
      for (PaymentStatus paymentType : EnumSet.allOf(PaymentStatus.class)) {
        LOOKUP.put(paymentType.getCode(), paymentType);
      }
    }

    public static PaymentStatus fromCode(int code) {
      return LOOKUP.get(code);
    }
  }

  public enum UseOfLandType {
    PURCHASE_SALE_OF_LAND, SUBLOTTING_AMALGAMATION_OF_LOTS, ISSUE_OF_LONGTERM_OF_SHORTTERM_LAND_PERMITS_OR_DEEDS, LAND_INVESTIGATION_PRIOR_TO_CONTSTRUCTION_OF_BUILDING, LAND_INVESTIGATION_FOR_THE_PURPOSE_BANK_LOAN,

    CONSTRUCTION_AND_PERPAIR_ROADS, STARTING_A_METAL_QUARRY, RENEWAL_OF_A_QUARRY_PERMIT, GEM_MINING, CONSTRUCTION_OF_PYLONS, MINI_TYPE_HYDRO_POWER_PROJECTS, IRRIGATION_PROJECTS, WATER_SUPPLY_AND_DRAINAGE_SYSTEM, SAND_MINING, GRAPHITE_MINING, EXCAVATION_OR_DUMPING_OF_SOILS, MEDIUM_AND_LARGE_SCALE_CULTIVATION,

    RESIDENTIAL, INSTITUTIONAL, COMMERCIAL, INDUSTRIAL;
  }

  /* @formatter:off */
  public enum Action {
    LAD_APPLICATION_CREATED, LAD_APPLICATION_UPDATED, OFFICEUSE_FORM_FILLED, OFFICE_USE_REPORT_PRINTED, LAP_APPLICATION_CREATED, LAP_APPLICATION_UPDATED, COSTESTIMATION_CREATED, COSTESTIMATION_UPDATED, COSTESTIMATION_PRINTED, USER_CREATED, USER_UPDATED, LI_APPLICATION_CREATED, LI_APPLICATION_UPDATED, PAYMENT_CREATED, PAYMENT_UPDATED, C_OF_C_CREATED, C_OF_C_UPDATED, APPEAL_CREATED, APPEAL_UPDATED, CLEARANCE_ISSUE_CREATED, CLEARANCE_ISSUE_UPDATED, INVESTIGATION_CREATED, INVESTIGATION_UPDATED, RENEWAL_CREATED, RENEWAL_UPDATED, RENEWAL_PRINTED, MODIFICATION_CREATED, MODIFICATION_UPDATED, CLERANCE_ISSUE_REPORT_PRINTED, CUSTOM_REPORT_GENERATED;
  }

}
