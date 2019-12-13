package com.groupeonepoint.enseirb.war.meteo;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Déclaration de la servlet auprès du conteneur de servlet
@WebServlet(name = "ServletMeteo", urlPatterns = "/meteo")
public class ServletMeteo extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Inject @ModelGfs private MeteoProvider meteoProvider;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	// Méthode appelée par le conteneur lorsqu'une requète Http GET est reçue
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// On récupère un paramètre depuis la requète
		String ville = req.getParameter("localisation");
		Double temp = null;
		Boolean is_running = false;
		
		if (ville != null) {
			temp = meteoProvider.getTemperature(ville);
			
			is_running = true;
		}

		req.setAttribute("meteo", temp);
		req.setAttribute("ville", ville);
		req.setAttribute("is_running", is_running);
		req.getRequestDispatcher("WEB-INF/meteo.jsp").forward(req, resp);

	}

}
