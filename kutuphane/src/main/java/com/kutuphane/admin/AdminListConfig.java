package com.kutuphane.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminListConfig {

	@Bean
	List<Admin> configAdmin(){
		ArrayList<Admin> adminList=new ArrayList<>();
		adminList.add(new Admin("0","S", "K", "A","0"));
		adminList.add(new Admin("1","A", "B", "AB","0"));
		adminList.add(new Admin("2","C", "D", "ABC","0"));
		return adminList;

	}
	
}
