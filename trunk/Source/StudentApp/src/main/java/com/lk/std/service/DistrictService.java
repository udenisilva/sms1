/**
 * 
 */
package com.lk.std.service;

import java.util.List;

import com.lk.std.model.District;

/**
 * @author dhiripitiy001
 *
 */


public interface DistrictService {
	public List<District> findAllDestrict();
	public District findDistrict(long districtId);
}
