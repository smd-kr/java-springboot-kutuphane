package com.kutuphane.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
public class KutuphaneConfig {
	
	
	@Bean
	public List<Books> Books(){
		List<Books> Bookss=new ArrayList<>();
		Bookss.add(new Books("Serenad", "Zülfü Livaneli", "481","Uygun"));
		Bookss.add(new Books("Yalnızız", "Peyami Sefa", "430","Uygun"));
		Bookss.add(new Books("İnce", "Yaşar Kemal", "268","Uygun"));
		Bookss.add(new Books("Kürd", "Sabahattin Ali", "160","Uygun"));
		Bookss.add(new Books("Çalı", "Çalı Kuşu", "409","Uygun"));
		Bookss.add(new Books("Ölü Canlar", "Gogol", "331","Uygun"));
		return Bookss; 

		
	}
}
