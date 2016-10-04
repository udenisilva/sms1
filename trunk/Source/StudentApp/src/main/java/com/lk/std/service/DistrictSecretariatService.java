/**
 * 
 */
package com.lk.std.service;

import java.util.List;

import com.lk.std.model.DistrictSecretariat;

/**
 * @author dhiripitiy001
 *
 */
public interface DistrictSecretariatService {
	
	public List<DistrictSecretariat> getDistrictSecretariatByDistrict(long districtId);
	
	public DistrictSecretariat findDistrictSecretariat(long districtSecId);
}
