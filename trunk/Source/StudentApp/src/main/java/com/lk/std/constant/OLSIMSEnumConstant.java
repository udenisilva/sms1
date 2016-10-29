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

  public enum PlantationCropType {
    TEA(1), RUBBER(2);

    private int code;

    private PlantationCropType(int code) {
      this.code = code;
    }

    public int getCode() {
      return code;
    }

    private static final Map<Integer, PlantationCropType> LOOKUP = new HashMap<Integer, PlantationCropType>();

    static {
      for (PlantationCropType plantationCropType : EnumSet.allOf(PlantationCropType.class)) {
        LOOKUP.put(plantationCropType.getCode(), plantationCropType);
      }
    }

    public static PlantationCropType fromCode(int code) {
      return LOOKUP.get(code);
    }
  }

  public enum RoadCanalType {
    MAJOR_ROAD(1), RAILWAY(2);

    private int code;

    private RoadCanalType(int code) {
      this.code = code;
    }

    public int getCode() {
      return code;
    }

    private static final Map<Integer, RoadCanalType> LOOKUP = new HashMap<Integer, RoadCanalType>();

    static {
      for (RoadCanalType roadCanalType : EnumSet.allOf(RoadCanalType.class)) {
        LOOKUP.put(roadCanalType.getCode(), roadCanalType);
      }
    }

    public static RoadCanalType fromCode(int code) {
      return LOOKUP.get(code);
    }
  }

  public enum BuildingStructureType {
    SCHOOL(1), HOSPITAL(2);

    private int code;

    private BuildingStructureType(int code) {
      this.code = code;
    }

    public int getCode() {
      return code;
    }

    private static final Map<Integer, BuildingStructureType> LOOKUP = new HashMap<Integer, BuildingStructureType>();

    static {
      for (BuildingStructureType buildingStructureType : EnumSet.allOf(BuildingStructureType.class)) {
        LOOKUP.put(buildingStructureType.getCode(), buildingStructureType);
      }
    }

    public static BuildingStructureType fromCode(int code) {
      return LOOKUP.get(code);
    }
  }

  public enum InvestigationStatus {
    NONE(0), RE_VISIT(1), APPROVE(2), REJECT(3), MITIGATION(4);

    private int code;

    private InvestigationStatus(int code) {
      this.code = code;
    }

    public int getCode() {
      return code;
    }

    private static final Map<Integer, InvestigationStatus> LOOKUP = new HashMap<Integer, InvestigationStatus>();

    static {
      for (InvestigationStatus investigationStatus : EnumSet.allOf(InvestigationStatus.class)) {
        LOOKUP.put(investigationStatus.getCode(), investigationStatus);
      }
    }

    public static InvestigationStatus fromCode(int code) {
      return LOOKUP.get(code);
    }
  }


  public enum HazardType {
    SLOPE_FAILURE(1), CUTTING_FAILURE(2);

    private int code;

    private HazardType(int code) {
      this.code = code;
    }

    public int getCode() {
      return code;
    }

    private static final Map<Integer, HazardType> LOOKUP = new HashMap<Integer, HazardType>();

    static {
      for (HazardType hazardType : EnumSet.allOf(HazardType.class)) {
        LOOKUP.put(hazardType.getCode(), hazardType);
      }
    }

    public static HazardType fromCode(int code) {
      return LOOKUP.get(code);
    }
  }

  public enum LandslideType {
    ROCK_FALL(1), DEBRIS_FLOW(2);

    private int code;

    private LandslideType(int code) {
      this.code = code;
    }

    public int getCode() {
      return code;
    }

    private static final Map<Integer, LandslideType> LOOKUP = new HashMap<Integer, LandslideType>();

    static {
      for (LandslideType landslideType : EnumSet.allOf(LandslideType.class)) {
        LOOKUP.put(landslideType.getCode(), landslideType);
      }
    }

    public static LandslideType fromCode(int code) {
      return LOOKUP.get(code);
    }
  }

  public enum PaymentAcknoledgeStatus {
    NONE(0), ACCEPT(1), REJECT(2), NA(3);

    private int code;

    private PaymentAcknoledgeStatus(int code) {
      this.code = code;
    }

    public int getCode() {
      return code;
    }

    private static final Map<Integer, PaymentAcknoledgeStatus> LOOKUP = new HashMap<Integer, PaymentAcknoledgeStatus>();

    static {
      for (PaymentAcknoledgeStatus paymentAcknoledgeStatus : EnumSet.allOf(PaymentAcknoledgeStatus.class)) {
        LOOKUP.put(paymentAcknoledgeStatus.getCode(), paymentAcknoledgeStatus);
      }
    }

    public static PaymentAcknoledgeStatus fromCode(int code) {
      return LOOKUP.get(code);
    }
  }

  public enum CostItemName {
    NONE(0), TRANSPORT(1), OTHER(2);

    private int code;

    private CostItemName(int code) {
      this.code = code;
    }

    public int getCode() {
      return code;
    }

    private static final Map<Integer, CostItemName> LOOKUP = new HashMap<Integer, CostItemName>();

    static {
      for (CostItemName costItemName : EnumSet.allOf(CostItemName.class)) {
        LOOKUP.put(costItemName.getCode(), costItemName);
      }
    }

    public static CostItemName fromCode(int code) {
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

  // for LI request
  public enum IncidentType {
    NONE(0), POTENTIAL_LANDSLIDE(1), OCCURED(2), OTHER(3);

    private int type;

    private IncidentType(int type) {
      this.type = type;
    }

    public int getType() {
      return type;
    }

    private static final Map<Integer, IncidentType> LOOKUP = new HashMap<Integer, IncidentType>();

    static {
      for (IncidentType typeStatus : EnumSet.allOf(IncidentType.class)) {
        LOOKUP.put(typeStatus.getType(), typeStatus);
      }
    }

    public static IncidentType fromType(int type) {
      return LOOKUP.get(type);
    }

    public static Map<Integer, IncidentType> getIncidentTypes() {
      return LOOKUP;
    }
  }


  public enum RenewalType {
    NONE(0), RENEWAL(1), MODIFICATION(2), APPEAL(3), COFC(4);

    private int type;

    private RenewalType(int type) {
      this.type = type;
    }

    public int geTtype() {
      return type;
    }

    private static final Map<Integer, RenewalType> LOOKUP = new HashMap<Integer, RenewalType>();

    static {
      for (RenewalType renewalType : EnumSet.allOf(RenewalType.class)) {
        LOOKUP.put(renewalType.geTtype(), renewalType);
      }
    }

    public static RenewalType fromType(String type) {
      return LOOKUP.get(type);
    }

  }


  public enum AppealStatus {
    NONE(0), NA(1), APPROVE(2), REJECT(3);

    private int type;

    private AppealStatus(int type) {
      this.type = type;
    }

    public int geTtype() {
      return type;
    }

    private static final Map<Integer, AppealStatus> LOOKUP = new HashMap<Integer, AppealStatus>();

    static {
      for (AppealStatus appealStatus : EnumSet.allOf(AppealStatus.class)) {
        LOOKUP.put(appealStatus.geTtype(), appealStatus);
      }
    }

    public static AppealStatus fromType(String type) {
      return LOOKUP.get(type);
    }

  }

  public enum CofCStatus {
    NONE(0), NA(1), APPROVE(2), REJECT(3);

    private int type;

    private CofCStatus(int type) {
      this.type = type;
    }

    public int geTtype() {
      return type;
    }

    private static final Map<Integer, CofCStatus> LOOKUP = new HashMap<Integer, CofCStatus>();

    static {
      for (CofCStatus cofc : EnumSet.allOf(CofCStatus.class)) {
        LOOKUP.put(cofc.geTtype(), cofc);
      }
    }

    public static CofCStatus fromType(String type) {
      return LOOKUP.get(type);
    }

  }


  public enum ClearanceStatus {
    NONE(0), APPROVE(1), REJECT(2);

    private int type;

    private ClearanceStatus(int type) {
      this.type = type;
    }

    public int geTtype() {
      return type;
    }

    private static final Map<Integer, ClearanceStatus> LOOKUP = new HashMap<Integer, ClearanceStatus>();

    static {
      for (ClearanceStatus clearanceStatus : EnumSet.allOf(ClearanceStatus.class)) {
        LOOKUP.put(clearanceStatus.geTtype(), clearanceStatus);
      }
    }

    public static ClearanceStatus fromType(String type) {
      return LOOKUP.get(type);
    }

  }


  /* @formatter:off */
  public enum Action {
    LAD_APPLICATION_CREATED, LAD_APPLICATION_UPDATED, OFFICEUSE_FORM_FILLED, OFFICE_USE_REPORT_PRINTED, LAP_APPLICATION_CREATED, LAP_APPLICATION_UPDATED, COSTESTIMATION_CREATED, COSTESTIMATION_UPDATED, COSTESTIMATION_PRINTED, USER_CREATED, USER_UPDATED, LI_APPLICATION_CREATED, LI_APPLICATION_UPDATED, PAYMENT_CREATED, PAYMENT_UPDATED, C_OF_C_CREATED, C_OF_C_UPDATED, APPEAL_CREATED, APPEAL_UPDATED, CLEARANCE_ISSUE_CREATED, CLEARANCE_ISSUE_UPDATED, INVESTIGATION_CREATED, INVESTIGATION_UPDATED, RENEWAL_CREATED, RENEWAL_UPDATED, RENEWAL_PRINTED, MODIFICATION_CREATED, MODIFICATION_UPDATED, CLERANCE_ISSUE_REPORT_PRINTED, CUSTOM_REPORT_GENERATED;
  }

}