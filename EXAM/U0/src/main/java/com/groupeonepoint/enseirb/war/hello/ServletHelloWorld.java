package com.groupeonepoint.enseirb.war.hello;

import java.util.ArrayList;
import java.util.Set;
import java.util.List;
import java.util.HashSet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Déclaration de la servlet auprès du conteneur de servlet
@WebServlet(name="HelloServlet", urlPatterns="/compteur")
public class ServletHelloWorld extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	// Méthode appelée par le conteneur lorsqu'une requète Http GET est reçue
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String text = req.getParameter("inputTexte");
		if (text !=null) {
			String result[] = text.split(".\\s*(\\s|=>|,)\\s*");
			List<String> array_L = new ArrayList();
			
			for(String word : result) {
				 array_L.add(word);
			}
			Set<String> mySet = new HashSet<String>(array_L);
			 
		    // Créer une Nouvelle ArrayList à partir de Set
		    List<String> array_L2 = new ArrayList<String>(mySet);
		    
			req.setAttribute("isEmpty", false);
			req.setAttribute("TabWord", array_L2);
			
		}else {
			req.setAttribute("isEmpty", true);
		}	

		req.getRequestDispatcher("WEB-INF/compteurText.jsp").forward(req, resp);	
	}
}
