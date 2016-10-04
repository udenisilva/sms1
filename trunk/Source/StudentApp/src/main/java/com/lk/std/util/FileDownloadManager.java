package com.lk.std.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

import javax.servlet.http.HttpServletResponse;

public class FileDownloadManager {

  public void downloadFile(String fileName, HttpServletResponse response) throws IOException {
    // reads input file from an absolute path
    try {
      String filePath =
          CommonUtil.getValueFromFile("olsims_application", "nbro.olsims.file.upload.location.url") + "/" + fileName;
      File downloadFile = new File(filePath);
      FileInputStream inStream = new FileInputStream(downloadFile);

      // gets MIME type of the file
      String mimeType = Files.probeContentType(downloadFile.toPath());
      if (mimeType == null) {
        // set to binary type if MIME mapping not found
        mimeType = "application/octet-stream";
      }
      System.out.println("MIME type: " + mimeType);

      // modifies response
      response.setContentType(mimeType);
      response.setHeader("Content-Disposition", "inline; filename=" + downloadFile.getName());
      response.setContentLength((int) downloadFile.length());

      // forces download
      // String headerKey = "Content-Disposition";
      // String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
      // response.setHeader(headerKey, headerValue);

      // obtains response's output stream
      OutputStream outStream = response.getOutputStream();

      byte[] buffer = new byte[4096];
      int bytesRead = -1;

      while ((bytesRead = inStream.read(buffer)) != -1) {
        outStream.write(buffer, 0, bytesRead);
      }

      inStream.close();
      outStream.close();
    } catch (Exception e) {

    }
  }

}
