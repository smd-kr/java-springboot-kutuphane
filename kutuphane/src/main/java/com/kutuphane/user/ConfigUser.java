package com.kutuphane.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
public class ConfigUser {
	
	//BURADA Kullanıcıları Ekedik VeriTabanına

	@Bean
	public List<User> configUsers(){
		List<User> configUsers=new ArrayList<>();
		configUsers.add(new User(0,"A", "B","12", new ArrayList<>(List.of()),0));
		configUsers.add(new User(1,"C", "D","123",new ArrayList<>(List.of()),0));
		configUsers.add(new User(2,"E", "F","1234",new ArrayList<>(List.of()),0));
		configUsers.add(new User(3,"G", "H","12345",new ArrayList<>(List.of()),0));
		configUsers.add(new User(4,"I", "İ","123456",new ArrayList<>(List.of()),0));

		return configUsers;
	}
//	@Bean
//	public List<User> ConfigLoginUseer(){
//		List<User> configUserLoginList=new ArrayList<>();
//		return configUserLoginList;
//	}
}
