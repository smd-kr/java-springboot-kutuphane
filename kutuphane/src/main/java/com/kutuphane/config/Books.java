package com.kutuphane.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
//@AllArgsConstructor
@ToString
public class Books {
	String BookName;
	String BookWriter;
	String BookPageNumber;
	String durum;
	public Books(String bookName, String bookWriter, String bookPageNumber, String durum) {
		
		BookName = bookName;
		BookWriter = bookWriter;
		BookPageNumber = bookPageNumber;
		this.durum=durum;
	}
}
