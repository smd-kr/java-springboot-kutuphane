package com.kutuphane.services;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.kutuphane.admin.Admin;
import com.kutuphane.config.Books;
import com.kutuphane.respository.Respository;
import com.kutuphane.user.User;
@Service
public class Services {
	
	@Autowired
	private Respository respository;
	
	public List<Books> gettAllBooks(){
		return respository.getAllBooks();
	}
	
	public List<User> gettAllUser(){
		return respository.getAllUser();
	}
	public List<User> getonlineUser(){
		return respository.getonlineUser();
	}
	
	public boolean UserBookTake(String firstName, String lastName, String Passaword) {
		boolean kontrol=false;
		for (User user : respository.getAllUser()) {
			if (firstName.equalsIgnoreCase(user.getFirstName()) && lastName.equalsIgnoreCase(user.getLastName()) && Passaword.equals(user.getPassaword())) {
				kontrol=respository.LoginUser(user);
				respository.addonlineUser(user);
				//				kontrol=respository.configLoginUser(user);
			}
		}
		return kontrol;
		
	}
	public String buyBook(String firstName,String lastName, String namebook) {
		User kontrol=respository.configLoginUserTest(firstName, lastName);
		if ((kontrol.getSituation()==1)) 
			return respository.buyBook(namebook,kontrol);
		else
			return "Giriş yapılmadan kitap alınamaz";
		
	
}
	public String giveBook(String firstName,String lastName, String namebook) {
		User kontrol=respository.configLoginUserTest(firstName, lastName);
		if ((kontrol.getSituation()==1)) 
			return respository.giveBook(namebook,kontrol);
		else
			return "Giriş yapılmadan kitap verilmez";
		
	
}
	public List<User> onlineUser() {
		return getonlineUser();
	}
	
	public boolean controlAdmin(String firstName,String lastName, String passawoard) {
		for(Admin admin:respository.getAllAdmin()) {
			if (admin.getName().equalsIgnoreCase(firstName)&&admin.getLastname().equalsIgnoreCase(lastName)&&admin.getPassaword().equals(passawoard)) {
				admin.setLogin("1");
				return true;
			}
		}
		return false;
	}
	
	public boolean controlLoginAdmin(String durum) {
		for(Admin admin:respository.getAllAdmin()) {
			if (admin.getId().equals(durum)) {
				if (admin.getLogin().equals("1")) {
					return true;
				}
			}
			
		}
		return false;
	}
	public String delUser(String delİd) {
		int a=0;
		for(User userr:gettAllUser()) {
			a++;
			if (userr.getId()==(Integer.valueOf(delİd))) {
				respository.getAllUser().remove(a);
				return "Başarılı bir şekilde silindi";			}
		}
		return "Bulunamadı";
	}
}
