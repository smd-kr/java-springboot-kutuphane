package com.kutuphane.user;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
	int id;
	String FirstName;
	String LastName;
	String Passaword;
	ArrayList<String> books_received;
	int situation;
}
