package com.groupeonepoint.enseirb.war.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// Déclaration de la servlet auprès du conteneur de servlet
@WebServlet(name="DictionnaireContainsServlet", urlPatterns="/contains")
public class DictionnaireContainsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static Dictionnaire bdd;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		bdd = Dictionnaire.getInstance();
	}
	
	// Méthode appelée par le conteneur lorsqu'une requète Http GET est reçue
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String text = req.getParameter("inputWord");
		
		if (text !=null) {
			ArrayList<String> result = bdd.findWords(text);
			req.setAttribute("isEmpty", false);
			req.setAttribute("TabWord", result);
		}else {
			req.setAttribute("isEmpty", true);
		}	

		req.getRequestDispatcher("WEB-INF/contains.jsp").forward(req, resp);
		
	}

}
