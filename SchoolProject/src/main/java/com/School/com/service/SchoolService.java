package com.School.com.service;

import com.School.com.model.SchoolData;
import com.School.com.vo.ResponseTerms;

public interface SchoolService {
	

	public SchoolData savedata(SchoolData school);

	public ResponseTerms getDetails(int schoolid);
	public boolean deleteEntity();
	

}
