package com.groupeonepoint.enseirb.war.hello;

public class Utilisateur {
	private String user;
    private String motDePasse;
    
    Utilisateur(String user_name, String user_motDePasse) {
    	user = user_name;
    	motDePasse = user_motDePasse;
	}

    public void setUser(String user) {
	this.user = user;
    }
    public String getUser() {
	return user;
    }

    public void setMotDePasse(String motDePasse) {
	this.motDePasse = motDePasse;
    }
    public String getMotDePasse() {
	return motDePasse;
    }

}
