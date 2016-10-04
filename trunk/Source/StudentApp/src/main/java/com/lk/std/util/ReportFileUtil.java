package com.lk.std.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;

public class ReportFileUtil {

  private static String reportDbUrl = CommonUtil.getValueFromFile("hibernate", "database.access.url");
  public static String templateLocation =
      CommonUtil.getValueFromFile("olsims_application", "nbro.olsims.jrxml.template.location.url");
  static String customReportUploadLocation =
      CommonUtil.getValueFromFile("olsims_application", "nbro.olsims.file.custom.report.upload.url");

  private static Connection connection = null;

  public static final class TemplateNames {
    public static final String templateLocations = templateLocation;

    public static final String applicationAcknoledgment1 = "OfficeUseOnly.jrxml";
    public static final String applicationAcknoledgment = "OfficeUseOnly/OfficeUseOnly.jrxml";
    public static final String applicationAcknoledgmentLad = "OfficeUseOnly/OfficeUseOnlyLad.jrxml";
    public static final String applicationAcknoledgmentLap = "OfficeUseOnly/OfficeUseOnlyLap.jrxml";
    public static final String applicationAcknoledgmentLab = "OfficeUseOnly/OfficeUseOnlyLab.jrxml";
    public static final String applicationAcknoledgmentSubReport = "OfficeUseOnly/";

    public static final String clearanceIssueCertificatePageCertify1 = "Page1.jasper";
    public static final String clearanceIssueCertificatePageCertify2 = "Page1Certify.jasper";
    public static final String clearanceIssueCertificatePage1 = "ClearanceIssueCertificate/Page2.jrxml";
    public static final String clearanceIssueCertificatePage2 = "ClearanceIssueCertificate/Page3.jrxml";
    public static final String clearanceIssueCertificatePage3 = "ClearanceIssueCertificate/LocationImagesPage.jrxml";
    public static final String clearanceIssueCertificatePage4 = "ClearanceIssueCertificate/images/Attachments.jrxml";
    public static final String clearanceIssueCertificateSubReport = "ClearanceIssueCertificate/";
    public static final String clearanceIssueCertificateImageFolder = "ClearanceIssueCertificate/images/";


    public static final String clearanceIssueReportOnePage1Certify = "ClearanceIssueReport/Page1Certifie.jrxml";
    public static final String clearanceIssueReportOnePage1 = "ClearanceIssueReport/Page1.jrxml";
    public static final String clearanceIssueReportOnePage2 = "ClearanceIssueReport/Page2.jrxml";
    public static final String clearanceIssueReportOnePage3 = "ClearanceIssueReport/LocationImagesPage.jrxml";
    public static final String clearanceIssueReportOnePage4 = "ClearanceIssueReport/images/Attachments.jrxml";
    public static final String clearanceIssueReportOnePage5 = "ClearanceIssueReport/Page3.jrxml";
    public static final String clearanceIssueReportOneSubReport = "ClearanceIssueReport/";
    public static final String clearanceIssueReportOneImageFolder = "ClearanceIssueReport/images/";

    public static final String clearanceIssueReportTwoCetifie = "recommendationsRecmmendedcertifie.jasper";
    public static final String clearanceIssueReportTwo = "recommendationsRecmmended.jasper";
    public static final String clearanceIssueReportTwoPage1 = "ClearanceIssueReportTwo/Page1.jrxml";
    // public static final String clearanceIssueReportTwoPage2 =
    // "ClearanceIssueReportTwo/crossSectionImagesPage.jrxml";
    // public static final String clearanceIssueReportTwoPage3 =
    // "ClearanceIssueReportTwo/SketchImagesPage.jrxml";
    public static final String clearanceIssueReportTwoSubReport = "ClearanceIssueReportTwo/";
    // public static final String clearanceIssueReportTwoPage4 =
    // "ClearanceIssueReportTwo/Page2.jrxml";
    public static final String clearanceIssueReportTwoPage5 = "ClearanceIssueReportTwo/Page3.jrxml";
    public static final String clearanceIssueReportTwoPage6 = "ClearanceIssueReportTwo/images/Attachments.jrxml";
    public static final String clearanceIssueReportTwoImageFolder = "ClearanceIssueReportTwo/images/";

    public static final String costEstimation = "CostEstimation/costEstimation.jrxml";
    public static final String costEstimationSubReport = "CostEstimation/";

    public static final String renewalLetterPath = "RenewalLetter";
    public static final String renewalLetter = "RenewalLetter/RenewalLetter.jrxml";

  }

  public static Connection getReportDBConnection() {
    try {
      connection = (Connection) DriverManager.getConnection(reportDbUrl);
      return connection;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static JasperReport getJasperReport(String templateName) {
    try {
      System.out.println("templateLocation + templateName " + templateLocation + templateName);
      return JasperCompileManager.compileReport(templateLocation + templateName);
    } catch (JRException e) {
      System.out.println("error " + e.toString());
      e.printStackTrace();
      return null;
    }
  }

  public static JasperReport getCustomJasperReport(String templateName) {
    try {
      return JasperCompileManager.compileReport(customReportUploadLocation + "/" + templateName);
    } catch (JRException e) {
      e.printStackTrace();
      return null;
    }
  }

}
