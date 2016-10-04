/**
 * 
 */
package com.lk.std.service;

import java.util.List;

import com.lk.std.model.LocalAuthority;

/**
 * @author dhiripitiy001
 *
 */
public interface LocalAuthorityService {

	public List<LocalAuthority> findLocalAuthorityByDistrict(long districtId);
	
	public LocalAuthority findLocalAuthority(long localAuthorityId);
}
