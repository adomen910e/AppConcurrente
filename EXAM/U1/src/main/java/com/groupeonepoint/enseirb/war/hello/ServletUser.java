package com.groupeonepoint.enseirb.war.hello;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Déclaration de la servlet auprès du conteneur de servlet
@WebServlet(name = "ServletUser", urlPatterns = "/valid")
public class ServletUser extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static ConnexionForm bdd_users;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		bdd_users = ConnexionForm.getInstance();
	}

	// Méthode appelée par le conteneur lorsqu'une requète Http GET est reçue
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ArrayList<Utilisateur> users = bdd_users.getUsers();
		req.setAttribute("users", users);
		req.getRequestDispatcher("WEB-INF/user.jsp").forward(req, resp);


	}

}
