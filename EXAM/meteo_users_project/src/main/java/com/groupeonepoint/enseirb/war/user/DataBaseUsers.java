package com.groupeonepoint.enseirb.war.user;

import java.util.ArrayList;

public class DataBaseUsers {

	// variable of type String
	private static ArrayList<User> users;
	private static DataBaseUsers single_instance = null;

	// private constructor restricted to this class itself
	public DataBaseUsers() {
		users = new ArrayList<User>();
	}

	// static method to create instance of UsersDataBase class
	public static DataBaseUsers getInstance() {
		if (single_instance == null) {
			single_instance = new DataBaseUsers();
			users.add(new User("Amelie", "Domenger"));
			users.add(new User("Agathe", "Domenger"));
		}

		return single_instance;
	}

	public void addUser(String name, String surname) {
		if (!containUser(name, surname)) {
			users.add(new User(name, surname));
		}
	}

	private boolean containUser(String name, String surname) {
		for (User user : users) {
			if (user.name.equals(name) && user.surname.equals(surname)) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

//	// variable of type String
//	private static JSONObject bddJSON;
//	private static JSONArray tab_user;
//
//	// private constructor restricted to this class itself
//	public DataBaseUsers() throws IOException, org.json.simple.parser.ParseException {
//
//		JSONParser jsonParser = new JSONParser();
//
//		try (FileReader reader = new FileReader("bdd.json"))
//        {
//            //Read JSON file
//            Object obj = jsonParser.parse(reader);
//  
//            bddJSON = (JSONObject) obj;
//            System.out.println(bddJSON);
//              
//  
//        } catch (FileNotFoundException e) 
//        {
//            e.printStackTrace();
//        } catch (IOException e) 
//        {
//            e.printStackTrace();
//        }
//
//	}
//
//	public void addUser(String name, String surname) throws IOException {
//		JSONObject user_add = new JSONObject();
//		user_add.put("name", name);
//		user_add.put("surname", surname);
//
//		if (tab_user == null) {
//			tab_user = new JSONArray();
//		}
//		tab_user.put(user_add);
//
//		try (FileWriter file = new FileWriter("bdd.json")) {
//			file.write(bddJSON.toString());
//			System.out.println("Successfully Copied JSON Object to File...");
//			System.out.println("\nJSON Object: " + bddJSON);
//		}
//	}
//
//	/*
//	 * private boolean containUser(String name, String surname) { for (int i = 0; i
//	 * < tab_user.length(); i++) { JSONObject tmp = tab_user.getJSONObject(i);
//	 * 
//	 * if (tmp.get("name").equals(name) && tmp.get("surname").equals(surname)) {
//	 * return true; } }
//	 * 
//	 * return false; }
//	 */
//
//	public String getHtml() {
//		String toReturn = "";
//		toReturn += "<table>" + "<tr>" + "<td>Prénom</td>" + "<td>Nom</td>" + "</tr>";
//
//		if (tab_user == null) {
//			toReturn += "</table>";
//			return toReturn;
//		}
//
//		for (int i = 0; i < tab_user.length(); i++) {
//			JSONObject tmp = tab_user.getJSONObject(i);
//			toReturn += "<tr>" + "<td>" + tmp.get("name") + "</td>" + "<td>" + tmp.get("surname") + "</td>" + "</tr>";
//		}
//
//		toReturn += "</table>";
//
//		return toReturn;
//	}

}
