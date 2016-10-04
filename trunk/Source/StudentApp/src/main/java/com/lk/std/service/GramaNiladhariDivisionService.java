/**
 * 
 */
package com.lk.std.service;

import java.util.List;

import com.lk.std.model.GramaNiladhariDivision;

/**
 * @author dhiripitiy001
 *
 */
public interface GramaNiladhariDivisionService {
	
	public List<GramaNiladhariDivision> findGNDivisionNoByDistrictSecretariat(long districtSecId);
	
	public GramaNiladhariDivision findGramaNiladhariDivision(long gramaNiladhariDivisionId);

}
