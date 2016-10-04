package com.lk.std.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FileUploadManager {

  String fileUploadLocation = CommonUtil.getValueFromFile("olsims_application", "nbro.olsims.file.upload.location.url");
  String customReportUploadLocation =
      CommonUtil.getValueFromFile("olsims_application", "nbro.olsims.file.custom.report.upload.url");

  public Map<String, Object> uploadFile(CommonsMultipartFile uploadedFile, String prefix) throws Exception {

    File destinationDir = null;
    String generatedAssetName = null;

    generatePath(fileUploadLocation);
    destinationDir = new File(fileUploadLocation);
    generatedAssetName = generateUniqueName(prefix + "_");

    FileItem item = uploadedFile.getFileItem();
    String extension = item.getName().substring(item.getName().lastIndexOf("."), item.getName().length());

    File file = new File(destinationDir, (generatedAssetName + extension));

    item.write(file);

    Map<String, Object> uploadedDataMap = new HashMap<String, Object>();

    uploadedDataMap.put("fileDestination", file.getPath());
    uploadedDataMap.put("fileName", generatedAssetName + extension);

    return uploadedDataMap;

  }

  public Map<String, Object> uploadCustomReportFile(CommonsMultipartFile uploadedFile) throws Exception {

    File destinationDir = null;
    String generatedAssetName = null;

    generatePath(customReportUploadLocation);
    destinationDir = new File(customReportUploadLocation);
    generatedAssetName = generateUniqueName("CR_");

    FileItem item = uploadedFile.getFileItem();
    String extension = item.getName().substring(item.getName().lastIndexOf("."), item.getName().length());

    File file = new File(destinationDir, (generatedAssetName + extension));

    item.write(file);

    Map<String, Object> uploadedDataMap = new HashMap<String, Object>();

    uploadedDataMap.put("fileDestination", file.getPath());
    uploadedDataMap.put("fileName", generatedAssetName + extension);

    return uploadedDataMap;

  }

  public String generateUniqueName(String prefix) {
    String uniqueFolderName = prefix + System.currentTimeMillis();
    return uniqueFolderName;
  }

  public void generatePath(String filePath) {
    File destination = new File(filePath);
    if (!destination.exists()) {
      if (destination.mkdirs()) {
        System.out.println("created " + filePath);
      } else {
        System.out.println("cannot create " + filePath);
      }
    } else {
      System.out.println(filePath + "file exist");
    }
  }
}
