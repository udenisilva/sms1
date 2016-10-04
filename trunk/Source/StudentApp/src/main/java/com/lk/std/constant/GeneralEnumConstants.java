package com.lk.std.constant;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class GeneralEnumConstants {

	public enum ReportType {
		APPLICATION_ACKNOWLEDGMENT, OTHER;
	}

	public enum AffectLevel {
		HIGH(1), MODERATE(2), LOW(3);

		private int code;

		private AffectLevel(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}

		private static final Map<Integer, AffectLevel> LOOKUP = new HashMap<Integer, AffectLevel>();

		static {
			for (AffectLevel affectedLevel : EnumSet.allOf(AffectLevel.class)) {
				LOOKUP.put(affectedLevel.getCode(), affectedLevel);
			}
		}

		public static AffectLevel fromCode(int code) {
			return LOOKUP.get(code);
		}
	}

	public enum YesNoStatus {
		YES(1), NO(0);

		private int code;

		private YesNoStatus(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}

		private static final Map<Integer, YesNoStatus> LOOKUP = new HashMap<Integer, YesNoStatus>();

		static {
			for (YesNoStatus yesNoStatus : EnumSet.allOf(YesNoStatus.class)) {
				LOOKUP.put(yesNoStatus.getCode(), yesNoStatus);
			}
		}

		public static YesNoStatus fromCode(int code) {
			return LOOKUP.get(code);
		}
	}

	public enum AttachmentType {
		NONE(0), ACCESS_ROOT(1), OTHER_INFOR(2), MODIFICATION(3), OTHER(4), INVSKETCH(5), INCIDENT_SKETCH(
				6), CROSS_SKETCH(7), PHOTOGRAPHS(8), LOCATION_MAP(9), CHART_GRAPH(10);

		private int code;

		private AttachmentType(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}

		private static final Map<Integer, AttachmentType> LOOKUP = new HashMap<Integer, AttachmentType>();

		static {
			for (AttachmentType attachmentType : EnumSet.allOf(AttachmentType.class)) {
				LOOKUP.put(attachmentType.getCode(), attachmentType);
			}
		}

		public static AttachmentType fromCode(int code) {
			return LOOKUP.get(code);
		}
	}

	public enum UserRoleType {
		NONE(0), ROLE_USER(1), ROLE_ADMIN(2), ROLE_GUEST(3), ROLE_DIVISION_HEAD(4);

		private int code;

		private UserRoleType(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}

		private static final Map<Integer, UserRoleType> LOOKUP = new HashMap<Integer, UserRoleType>();

		static {
			for (UserRoleType roleType : EnumSet.allOf(UserRoleType.class)) {
				LOOKUP.put(roleType.getCode(), roleType);
			}
		}

		public static UserRoleType fromCode(int code) {
			return LOOKUP.get(code);
		}
	}

	public enum ApplicationReviewStatus {

		APP_DATA_FILLED("application.review.status.application.data.filled"), APP_DATA_VERIFIED(
				"application.review.status.application.data.verified"), ATTACH_UPLOADED(
						"application.review.status.attachments.uploaded"), COST_ESTI_DATA_FILLED(
								"application.review.status.cost.estimation.data.filled"), COST_ESTI_DATA_VERIFIED(
										"application.review.status.cost.estimation.data.verified"), PAYMENT_DATA_FILLED(
												"application.review.status.payment.data.filled"), PAYMENT_DATA_VERIFIED(
														"application.review.status.payment.data.verified"), INVESTI_DATA_FILLED(
																"application.review.status.investigation.data.filled"), INVESTI_DATA_VERIFIED(
																		"application.review.status.investigation.data.verified"), RENEWAL_DATA_FILLED(
																				"application.review.status.renewal.data.filled"), RENEWAL_DATA_VERIFIED(
																						"application.review.status.renewal.data.verified"), MODI_DATA_FILLED(
																								"application.review.status.modification.data.filled"), MODI_DATA_VERIFIED(
																										"application.review.status.modification.data.verified"), APPEAL_DATA_FILLED(
																												"application.review.status.appeal.data.filled"), APPEAL_DATA_VERIFIED(
																														"application.review.status.appeal.data.verified"), CLEAR_ISSUE_DATA_FILLED(
																																"application.review.status.clearance.issue.data.filled"), CLEAR_ISSUE_VERIFIED(
																																		"application.review.status.clearance.verified"), OTHER(
																																				"application.review.status.other");

		private String displayName;

		private ApplicationReviewStatus(String name) {
			this.displayName = name;
		}

		public String getDisplayName() {
			return displayName;
		}

		private static final Map<String, ApplicationReviewStatus> LOOKUP = new LinkedHashMap<String, ApplicationReviewStatus>();
		private static final Map<String, ApplicationReviewStatus> CODE_LOOKUP = new LinkedHashMap<String, ApplicationReviewStatus>();

		static {
			for (ApplicationReviewStatus applicationReviewStatus : EnumSet.allOf(ApplicationReviewStatus.class)) {
				LOOKUP.put(applicationReviewStatus.getDisplayName(), applicationReviewStatus);
				CODE_LOOKUP.put(applicationReviewStatus.toString(), applicationReviewStatus);
			}
		}

		public static ApplicationReviewStatus fromCode(String code) {
			return CODE_LOOKUP.get(code);
		}

		public static ApplicationReviewStatus fromDisplayName(String displayName) {
			return LOOKUP.get(displayName);
		}

		public static Map<String, ApplicationReviewStatus> getApplicationReviewStatusMap() {
			return LOOKUP;
		}

	}

	public enum ApplicationType {
		NONE(0), LAD(1), LAB(2), LAP(3), LI(4);

		private int code;

		private ApplicationType(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}

		private static final Map<Integer, ApplicationType> LOOKUP = new HashMap<Integer, ApplicationType>();

		static {
			for (ApplicationType applicationType : EnumSet.allOf(ApplicationType.class)) {
				LOOKUP.put(applicationType.getCode(), applicationType);
			}
		}

		public static ApplicationType fromCode(int code) {
			return LOOKUP.get(code);
		}
	}

	public enum LanguageType {
		NONE(0), en(1), si(2), ta(3);

		private int code;

		private LanguageType(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}

		private static final Map<Integer, LanguageType> LOOKUP = new HashMap<Integer, LanguageType>();

		static {
			for (LanguageType languageType : EnumSet.allOf(LanguageType.class)) {
				LOOKUP.put(languageType.getCode(), languageType);
			}
		}

		public static LanguageType fromCode(int code) {
			return LOOKUP.get(code);
		}
	}

	public enum DistrictType {
		AMPARA(1), ANURADHAPURA(2), AVISSAWELLA(3), BADULLA(4), BANDARAWELA(5), BATTICALOA(6), CHILAW(7), COLOMBO(
				8), GALLE(9), GAMPAHA(10), HAMBANTHOTA(11), HATTON(12), JAFFNA(13), KALMUNAI(14), KALUTHARA(15), KANDY(
						16), KEGALLE(17), KURUNEGALA(18), MANNAR(19), MATARA(20), NAWALAPITIYA(21), NEGOMBO(
								22), NUWARAELIYA(23), PANADURA(24), TRINCOMALEE(25), VAVUNIYA(26), MONERAGALA(
										27), KILINOCHCHI(28), PUTTALAM(29), MULLATIVU(30);

		private int code;

		private DistrictType(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}

		private static final Map<Integer, ApplicationType> LOOKUP = new HashMap<Integer, ApplicationType>();

		static {
			for (ApplicationType applicationType : EnumSet.allOf(ApplicationType.class)) {
				LOOKUP.put(applicationType.getCode(), applicationType);
			}
		}

		public static ApplicationType fromCode(int code) {
			return LOOKUP.get(code);
		}
	}

}
