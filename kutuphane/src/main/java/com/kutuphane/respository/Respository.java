package com.kutuphane.respository;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TooManyListenersException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.kutuphane.admin.Admin;
import com.kutuphane.config.Books;
import com.kutuphane.user.ConfigUser;
import com.kutuphane.user.User;
import java.util.List;
@Repository
public class Respository {

	public ArrayList<User> OnlineUser=new ArrayList<>();
	
	@Autowired
	private List<Books> listBooks;
	
	@Autowired
	@Qualifier("configUsers")
	private List<User> listUser;
	
	@Autowired
	private List<Admin> listAdmin;
	
//    @Autowired
//    @Qualifier("ConfigLoginUseer")
//    private List<User> ConfigLoginUsers;

	public List<User> getonlineUser(){
		return OnlineUser;
	}
	public void addonlineUser(User user){
		OnlineUser.add(user);
	}
	
	
	public List<Admin> getAllAdmin(){
		return listAdmin;
	}
	
	public List<Books> getAllBooks(){
		return listBooks;
	}
	public List<User> getAllUser(){
		return listUser;
				
	}
	public Boolean LoginUser(User user) {
		user.setSituation(1);
		return true;
	}
	public User configLoginUserTest(String firstName,String lastName) {
		User zero_user=new User(0, "", "", "", null, -1);
		for(User user:listUser) {
			if (user.getFirstName().equalsIgnoreCase(firstName) && user.getLastName().equalsIgnoreCase(lastName)) {
				return user;
			}
		}
		return zero_user;
	}
	public String buyBook(String nameBook,User user) {
		for(Books books:listBooks) {
			if (books.getBookName().equalsIgnoreCase(nameBook)) {
				//return "2";
				if (books.getDurum().equalsIgnoreCase("Uygun")) {
					books.setDurum("Uygun Değil");
					user.getBooks_received().add(books.getBookName());
					return "Kitap başarılı bir şekilde alınmıştır";
				}else {
					return "Başka bit kullanıcı tarafından alınmış";
				}
			}
		}
		
		return "Belirtilien kitap bulunamadı";
	}
	public String giveBook(String nameBook,User user) {
		int a=-1;
		for(String books:user.getBooks_received()) {
			a++;
			if (books.equalsIgnoreCase(nameBook)) {
					user.getBooks_received().remove(a);
					for(Books book:listBooks) {
						if (book.getBookName().equalsIgnoreCase(nameBook)) { 
							book.setDurum("Uygun");
							}
					}
					return "Kitap başarılı bir şekilde teslim edilmiştir";
				}
		}
		return "Belirtilien kitap bulunamadı Lütfen Girdileri doğru bir şekilde girin ve Kitabın uygunluk kısmına bakıp tekrar deneyiniz";

		}
	
}
