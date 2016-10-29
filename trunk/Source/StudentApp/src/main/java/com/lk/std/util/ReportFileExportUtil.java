package com.lk.std.util;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.log4j.Logger;

import com.lk.std.constant.ApplicationConstants;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;

public class ReportFileExportUtil {


  private static final Logger LOGGER = Logger.getLogger(ReportFileExportUtil.class);
  private static ReportFileExportUtil instance = null;

  /**
   * Singleton Implementation
   * 
   */
  public static ReportFileExportUtil getInstance() {
    synchronized (ReportFileExportUtil.class) {
      if (instance == null) {
        instance = new ReportFileExportUtil();
      }
      return instance;
    }
  }


  /**
   * @param type
   * @param jp
   * @param baos
   * @param fileName without the extension
   * @return
   * @throws Exception
   */
  public String export(String type, JasperPrint jp, ByteArrayOutputStream baos, String orgFileName) throws Exception {
    LOGGER.info("type :" + type);
    System.out.println("in ");
    String fullFilePath = null;
    String fileName = orgFileName;
    final String filePath = CommonUtil.getValueFromFile("olsims_application", "nbro.olsims.file.export.url");
    if (type.equalsIgnoreCase(ApplicationConstants.FILE_TYPE_PDF)) {
      // Export to output stream
      exportPdf(jp, baos);
      // Create a new file
      // declare a custom filename
      fileName = fileName + ".pdf";
      new File(filePath).mkdirs();
      fullFilePath = filePath + fileName;
      LOGGER.info("fullFilePath - " + fullFilePath);
      File pdfFile = new File(fullFilePath);
      // write data to a file and store

      OutputStream outputStream = new FileOutputStream(pdfFile);
      baos.writeTo(outputStream);
      outputStream.close();
      baos.close();
    } else if (type.equalsIgnoreCase(ApplicationConstants.FILE_TYPE_WORD)) {
      // Export to output stream
      exportWord(jp, baos);
      // Create a new file
      // declare a custom filename
      fileName = fileName + ".docx";
      fullFilePath = filePath + fileName;
      System.out.println("fullFilePath - " + fullFilePath);
      File pdfFile = new File(fullFilePath);
      // write data to a file and store
      System.out.println("fullFilePath - " + fullFilePath);
      OutputStream outputStream = new FileOutputStream(pdfFile);
      baos.writeTo(outputStream);
      outputStream.close();
      baos.close();
    } else if (type.equalsIgnoreCase(ApplicationConstants.FILE_TYPE_HTML)) {
      // Export to output stream
      exportHTML(jp, baos);
      // Create a new file
      // declare a custom filename
      fileName = fileName + ".html";
      fullFilePath = filePath + fileName;
      System.out.println("fullFilePath - " + fullFilePath);
      File pdfFile = new File(fullFilePath);
      // write data to a file and store
      System.out.println("fullFilePath - " + fullFilePath);
      OutputStream outputStream = new FileOutputStream(pdfFile);
      baos.writeTo(outputStream);
      outputStream.close();
      baos.close();
    } else {
      // Export to output stream
      exportCSV(jp, baos);
      // Create a new file
      // declare a custom filename
      fileName = fileName + ".csv";
      fullFilePath = filePath + fileName;
      File pdfFile = new File(fullFilePath);
      // write data to a file and store
      OutputStream outputStream = new FileOutputStream(pdfFile);
      baos.writeTo(outputStream);
      outputStream.close();
      baos.close();
    }
    return orgFileName;
  }

  public void exportPdf(JasperPrint jp, ByteArrayOutputStream baos) throws JRException {
    // Create a JRXlsExporter instance
    JRPdfExporter exporter = new JRPdfExporter();
    // Here assign the parameters jp and baos to the exporter
    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
    exporter.exportReport();
  }

  public void exportHTML(JasperPrint jp, ByteArrayOutputStream baos) throws JRException {
    // Create a JRXlsExporter instance
    JRHtmlExporter exporter = new JRHtmlExporter();
    // Here assign the parameters jp and baos to the exporter
    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
    exporter.exportReport();
  }

  public void exportWord(JasperPrint jp, ByteArrayOutputStream baos) throws JRException {
    // Create a JRXlsExporter instance
    JRDocxExporter exporter = new JRDocxExporter();
    // Here assign the parameters jp and baos to the exporter
    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
    exporter.exportReport();
  }

  public void exportCSV(JasperPrint jp, ByteArrayOutputStream baos) throws JRException {
    // Create a JRXlsExporter instance
    JRCsvExporter exporter = new JRCsvExporter();
    // Here assign the parameters jp and baos to the exporter
    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
    exporter.exportReport();
  }

  public ReportFileExportUtil() {

  }
}