package com.kutuphane.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kutuphane.config.Books;
import com.kutuphane.services.Services;
import com.kutuphane.user.User;



@RestController


@RequestMapping("/rest/api")
public class RestContoroler {
	@Autowired
	private Services services;
	
	@GetMapping(path = "/getAllBooks")
	public List<Books> getAllBooks(){
		return services.gettAllBooks();
	}
	@GetMapping(path = "/getAllUser")
	public List<User> getAllUser(){
		return services.gettAllUser();
	}
//	@GetMapping(path = "/getOnlineUser")
//	public List<User> getOnlineUser(){
//		return services.getonlineUser();
//	}

	//GİRİŞ KISIMI
	@GetMapping(path ="/{firstName}/{lastName}/{Passaword}")
	public String UserBookTake(@PathVariable(name = "firstName", required = true) String firstName,
							@PathVariable(name = "lastName", required = true) String lastName,@PathVariable(name = "Passaword", required = true) String Passaword) {
		Boolean kontrol=services.UserBookTake(firstName,lastName,Passaword);
		if (kontrol==true) 
			
			return "Kullanıcı Başarılı Bir şekilde giriş yaptı";
		else {
			return "Kullanıcı Bilgileri Yanlış";
	}
}
	//kitap alam kısmı
	@GetMapping(path = "/{firstName}/{lastName}/with-params-buybook")
	public String buyBook(
			 @PathVariable(name = "firstName",required = true) String firstName
			,@PathVariable(name = "lastName", required = true) String lastName
			,@RequestParam(name = "nameBook", required = true) String nameBook){
		
		return services.buyBook(firstName, lastName, nameBook);
	}
	
	//kitap verme kısmı
	@GetMapping(path = "/{firstName}/{lastName}/with-params-givebook")
	public String giveBook(
			 @PathVariable(name = "firstName",required = true) String firstName
			,@PathVariable(name = "lastName", required = true) String lastName
			,@RequestParam(name = "nameBook", required = true) String nameBook){
		
		return services.giveBook(firstName, lastName, nameBook);
	}
	
	
	//	ADMİN KATEGORİSİ
	@GetMapping(path ="/admin/{firstName}/{lastName}/{passawoard}")
	public String loginAdmin( 
			@PathVariable(name = "firstName",required = true) String firstName
			,@PathVariable(name = "lastName", required = true) String lastName
			,@PathVariable(name = "passawoard", required = true) String passawoard) {
		if (services.controlAdmin(firstName, lastName, passawoard)) {
			return "Giriş Başarılı";
		}
			return "Başarısız giriş";
	
	}
	
	@GetMapping(path ="/onlineUser/{idAdmin}")
	public Object onlineUser( @PathVariable(name = "idAdmin",required = true) String idAdmin) {
		if (services.controlLoginAdmin(idAdmin)) {
			return services.onlineUser();
		}
		return "Yetkisiz giriş";
	}
	// ÜYE SİLME
	@DeleteMapping(path = "/deleteUser/{idDelUser}/{idAdmin}")
	public String delUser(@PathVariable(name = "idDelUser")String idDelUser,
			@PathVariable(name = "idAdmin")String idAdmin) {
		if (services.controlLoginAdmin(idAdmin)) {
			return services.delUser(idDelUser);
		}else {
			return "Yetkisiz Giriş";
		}
		
	}
	

}
