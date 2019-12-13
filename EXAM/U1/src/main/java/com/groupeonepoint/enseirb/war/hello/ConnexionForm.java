package com.groupeonepoint.enseirb.war.hello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


public class ConnexionForm {
	private static ArrayList<Utilisateur> users;
	private static ConnexionForm single_instance = null;
	
	private static final String CHAMP_EMAIL  = "user";
    private static final String CHAMP_PASS   = "motdepasse";

    private String              resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();

 // private constructor restricted to this class itself
 	public ConnexionForm() {
 		users = new ArrayList<Utilisateur>();
 	}

 	// static method to create instance of UsersDataBase class
 	public static ConnexionForm getInstance() {
 		if (single_instance == null) {
 			single_instance = new ConnexionForm();
 			users.add(new Utilisateur("jdoe", "jdoe"));
 			users.add(new Utilisateur("amelie", "toto"));
 			users.add(new Utilisateur("tom", "titi"));
 			users.add(new Utilisateur("agathe", "toto"));
 		}

 		return single_instance;
 	}
    
    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Utilisateur connecterUtilisateur( HttpServletRequest request ) {
        /* Récupération des champs du formulaire */
        String email = getValeurChamp( request, CHAMP_EMAIL );
        String motDePasse = getValeurChamp( request, CHAMP_PASS );


        Utilisateur utilisateur = null;
        /* Validation du champ email. */
        try {
            utilisateur = validation( email, motDePasse );
            if (utilisateur == null) {
            	 setErreur( CHAMP_EMAIL, "Non valide" );
            	 setErreur( CHAMP_PASS, "Non valide" );
            	
            }
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
            setErreur( CHAMP_PASS, e.getMessage() );
        }

        /* Initialisation du résultat global de la validation. */
        if ( erreurs.isEmpty() ) {
            resultat = "Succès de la connexion.";
        } else {
            resultat = "Échec de la connexion.";
        }

        return utilisateur;
    }

    private Utilisateur validation( String username, String password ) throws Exception {
        if ( username != null &&  password!= null) {
        	for (Utilisateur user : users) {
    			if (user.getUser().equals(username) && user.getMotDePasse().equals(password)) {
    				return user;
    			}
    		}
            throw new Exception( "Connection non valide" );
        }
       
        return null;
    }


    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }

    public ArrayList<Utilisateur> getUsers() {
		return users;
	}
}
