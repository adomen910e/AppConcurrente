package com.groupeonepoint.enseirb.war.hello;

import java.util.ArrayList;

public class Dictionnaire {

	// variable of type String
	private static ArrayList<String> dictionnaire;
	private static Dictionnaire single_instance = null;

	// private constructor restricted to this class itself
	public Dictionnaire() {
		dictionnaire = new ArrayList<String>();
	}

	// static method to create instance of UsersDataBase class
	public static Dictionnaire getInstance() {
		if (single_instance == null) {
			single_instance = new Dictionnaire();
			dictionnaire.add("mot1");
			dictionnaire.add("mot2");
			dictionnaire.add("mot3");
			dictionnaire.add("mot4");
			dictionnaire.add("mot5");
			dictionnaire.add("mot6");
			
			dictionnaire.add("a");
			dictionnaire.add("az");
			dictionnaire.add("aze");
			dictionnaire.add("azer");
			dictionnaire.add("azert");
			dictionnaire.add("azerty");
		}

		return single_instance;
	}

	public ArrayList<String> findWords(String begin_word) {
		String lower_word = begin_word.toLowerCase();
		ArrayList<String> result = new ArrayList<String>();
		
		for(String word : dictionnaire) {
			if (word.startsWith(lower_word)) {
				result.add(word);
			}
		}
		return result;
	}

}
