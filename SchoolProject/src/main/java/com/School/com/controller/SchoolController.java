package com.School.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.School.com.model.SchoolData;
import com.School.com.service.SchoolService;

@RestController
@RequestMapping("/school")
public class SchoolController {
	@Autowired
	private SchoolService service;

	@RequestMapping(value="/send", method = { RequestMethod.POST } , produces="application/json")
	public SchoolData saveSchooldetails(@RequestBody SchoolData school) {
		return service.savedata(school);
	}
	
	@DeleteMapping("/delete")
	public boolean deleteEntity() {
		return service.deleteEntity();
	}

}
