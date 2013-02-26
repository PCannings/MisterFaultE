package uk.ac.dundee.computing.aec.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uk.ac.dundee.computing.aec.store.SessionData;

@WebServlet("/HomePageController")
public class HomePageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	    public HomePageController() {
        super();
        
    }

	public void init(ServletConfig config) throws ServletException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		SessionData sessionData = new SessionData();
		sessionData.setTestSessionData("Test String for session data stored in a bean");
		
		SessionData count = (SessionData)session.getAttribute("sessionData");
			
		session.setAttribute("sessionData", sessionData);
		
		response.sendRedirect("WelcomePage.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
