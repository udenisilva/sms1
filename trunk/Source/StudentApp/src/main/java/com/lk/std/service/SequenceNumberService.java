package com.lk.std.service;

import com.lk.std.constant.GeneralEnumConstants.ApplicationType;

public interface SequenceNumberService {

  public String getGeneratedSequenceNumber(ApplicationType applicationType, long districtId, long localAuthorityId);

  public String generateRenewalSequenceNumber(String generatedSequenceNumber);

  public String generateModificationSequenceNumber(String generatedSequenceNumber);

}
