package com.groupeonepoint.enseirb.war.user;

public class User {
	public final String name;
	public final String surname;

	User(String user_name, String user_surname) {
		name = user_name;
		surname = user_surname;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public String getName() {
		return this.name;
	}
}
