package com.lk.std.service;

import java.util.Calendar;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.std.constant.GeneralEnumConstants.ApplicationType;
import com.lk.std.dao.SequenceNumberRepository;

import com.lk.std.model.District;
import com.lk.std.model.LocalAuthority;
import com.lk.std.model.SequenceNumber;

@Service
@Transactional
public class SequenceNumberServiceImpl implements SequenceNumberService {

	@Autowired
	SequenceNumberRepository sequenceNumberRepository;

	@Autowired
	DistrictService districtService;

	@Autowired
	LocalAuthorityService authorityService;

	private static final String prefix = "NBRO/LLRMD/";
	private static final String middlefix = "/31/";
	private static final String slash = "/";
	private static final String renewal = "/REN/";
	private static final String modification = "/MOD/";

	@Override
	public String getGeneratedSequenceNumber(ApplicationType applicationType, long districtId, long localAuthorityId) {

		// String sequenceNo = getNextSequenceNumber(applicationType.getCode());

		District district = districtService.findDistrict(districtId);
		String sequenceNo = getNextSequenceNumber(district);
		LocalAuthority authority = authorityService.findLocalAuthority(localAuthorityId);
		int year = Calendar.getInstance().get(Calendar.YEAR);

		if (applicationType.getCode() == 1) {
			// LAD
			return prefix + district.getDistrictCode() + slash + authority.getLocalAuthorityCode() + slash
					+ ApplicationType.LAD.toString() + slash + year + middlefix + sequenceNo;

		} else if (applicationType.getCode() == 2) {
			// LAB
			return prefix + district.getDistrictCode() + slash + authority.getLocalAuthorityCode() + slash
					+ ApplicationType.LAB.toString() + slash + year + middlefix + sequenceNo;
		} else if (applicationType.getCode() == 3) {
			// LAP
			return prefix + district.getDistrictCode() + slash + authority.getLocalAuthorityCode() + slash
					+ ApplicationType.LAP.toString() + slash + year + middlefix + sequenceNo;
		} else if (applicationType.getCode() == 4) {
			// LI
			return prefix + district.getDistrictCode() + slash + authority.getLocalAuthorityCode() + slash
					+ ApplicationType.LI.toString() + slash + year + middlefix + sequenceNo;
		}
		return null;
	}

	private String getNextSequenceNumber(District id) {
		// SequenceNumber sequenceNumber = sequenceNumberRepository.findOne(id);
		SequenceNumber sequenceNumber = sequenceNumberRepository.findByDistrict(id);
		// int paddedLength = sequenceNumber.getNumberLength();
		// String formattedNumber = String.format("%0"+paddedLength+"d",
		// sequenceNumber.getCurrentSequenceNumber());

		// String sequenceNo = sequenceNumber.getPrefixValue()+formattedNumber;

		String sequenceNo = String.valueOf(sequenceNumber.getCurrentSequenceNumber());

		sequenceNumber.setCurrentSequenceNumber(sequenceNumber.getCurrentSequenceNumber() + 1);
		sequenceNumberRepository.save(sequenceNumber);

		return sequenceNo;
	}

	@Override
	public String generateRenewalSequenceNumber(String generatedSequenceNumber) {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		return generatedSequenceNumber + renewal + year;
	}

	@Override
	public String generateModificationSequenceNumber(String generatedSequenceNumber) {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		return generatedSequenceNumber + modification + year;
	}

}