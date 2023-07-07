package com.phoenix.pma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StaffServices {
	
	
//	//field injection
//	@Qualifier("staffRepositoryimpl1")
//	@Autowired
//	iStaffRepository staRepo;
	
	
//	// Construcor injection
//	iStaffRepository staRepo;
//// first leeter of name of the qualifier class should be in small
//	public StaffServices(@Qualifier("staffRepositoryimpl1")iStaffRepository staRepo) {
//		super();
//		this.staRepo = staRepo;
//	}
	
	
	//setter injection
	iStaffRepository staRepo;
	@Qualifier("staffRepositoryimpl1")
	@Autowired
	public void setStaRepo(iStaffRepository staRepo) {
		this.staRepo = staRepo;
	}

}
