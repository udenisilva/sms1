package com.lk.std.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.artofsolving.jodconverter.OfficeDocumentConverter;
import org.artofsolving.jodconverter.cli.Convert;
import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.OfficeManager;


public class CreateDoxToPdf {

  private static final String PROP_FILE_NAME = "application";

  public static String createDocument(String fileName, String fileType) {
    OfficeManager officeManager = null;
    try {
      System.out.println("---- Convert started ----");
      officeManager = new DefaultOfficeManagerConfiguration()
          .setOfficeHome(new File(CommonUtil.getValueFromFile(PROP_FILE_NAME, "libreOffice.location")))
          .buildOfficeManager();
      officeManager.start();

      // 2) Create JODConverter converter
      OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);

      // 3) Create PDF
      if (fileType.equals("DOCX")) {
        // ConvertToPDF(fileName, fileName);
        createPDF(converter, fileName);
      } else if (fileType.equals("ODT")) {
        createPDFFromOdt(converter, fileName);
      } else if (fileType.equals("HTML")) {
        createHTML(converter, fileName);
      }
      System.out.println("---- Convert end ----");
      return "SUCCESS";
    } catch (Exception e) {
      e.printStackTrace();
      return "ERROR";
    } finally {
      // 4) Stop LibreOffice in headless mode.
      if (officeManager != null) {
        officeManager.stop();
      }
    }
    // return null;
  }

  private static void createPDF(OfficeDocumentConverter converter, String fileName) {
    try {
      System.out.println("---- Converting 1----");
      final String filePath = CommonUtil.getValueFromFile(PROP_FILE_NAME, "file.export.url");
      System.out.println(filePath + fileName + ".docx");
      converter.convert(new File(filePath + fileName + ".docx"), new File(filePath + fileName + ".PDF"));
    } catch (Throwable e) {
      e.printStackTrace();
    }
  }

  private static void createHTML(OfficeDocumentConverter converter, String fileName) {
    try {
      System.out.println("---- Converting 1----");
      final String filePath = CommonUtil.getValueFromFile(PROP_FILE_NAME, "file.export.url");
      System.out.println(filePath + fileName + ".docx");
      converter.convert(new File(filePath + fileName + ".docx"), new File(filePath + fileName + ".pdf"));
    } catch (Throwable e) {
      e.printStackTrace();
    }
  }

  private static void createPDFFromOdt(OfficeDocumentConverter converter, String fileName) {
    try {
      System.out.println("---- Converting 2 ----");
      final String filePath = CommonUtil.getValueFromFile(PROP_FILE_NAME, "file.export.url");
      converter.convert(new File(filePath + fileName + ".odt"), new File(filePath + fileName + ".pdf"));
    } catch (Throwable e) {
      e.printStackTrace();
    }
  }

  public static void ConvertToPDF(String docPath, String pdfPath) {
    try {
      final String filePath = CommonUtil.getValueFromFile(PROP_FILE_NAME, "file.export.url");
      docPath = filePath + docPath + ".docx";
      pdfPath = filePath + pdfPath + ".pdf";
      InputStream doc = new FileInputStream(new File(docPath));
      XWPFDocument document = new XWPFDocument(doc);
      PdfOptions options = PdfOptions.create();
      OutputStream out = new FileOutputStream(new File(pdfPath));
      PdfConverter.getInstance().convert(document, out, options);
    } catch (FileNotFoundException ex) {
      Logger.getLogger(Convert.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(Convert.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

}
