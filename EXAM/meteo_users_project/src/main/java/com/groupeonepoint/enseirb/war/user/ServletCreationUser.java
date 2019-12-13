package com.groupeonepoint.enseirb.war.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Déclaration de la servlet auprès du conteneur de servlet
@WebServlet(name = "ServletCreateUser", urlPatterns = "/create-user")
public class ServletCreationUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Méthode appelée par le conteneur lorsqu'une requète Http GET est reçue
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/createUser.jsp").forward(req, resp);
	}
	
}
