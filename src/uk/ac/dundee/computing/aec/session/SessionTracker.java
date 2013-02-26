package uk.ac.dundee.computing.aec.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uk.ac.dundee.computing.aec.store.SessionData;

@WebServlet("/SessionTracker")
public class SessionTracker extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SessionTracker() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		//get the current session object create one if needed
		HttpSession session = request.getSession();
		
		//increment the hit counter for this page. The value is saved in this clients session under the name "tracker.count".
		Integer count = (Integer)session.getAttribute("tracker.count");
		if(count == null) count = new Integer(1);
		else
			count = new Integer(count.intValue()+1);
		session.setAttribute("tracker.count", count);
		out.println("<!doctype html>");
		out.println("<HTML><HEAD><TITLE>SessionTracker</TITLE>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/mystyle.css\">");
		out.println("</HEAD>");
		out.println("</div id=\"session\"");
		out.println("<BODY><H1>Session Tracking Demo</H1>");
		out.println("<p>A session tracking servlet. Code from Java Servlet Programming 2nd Edition, O'Reilly, 2001</p>");
		//display the hit count for this page
		out.println("You've visited this page " + count + ((count.intValue() ==1) ? " time." : " times."));

		out.println("<p>");
		
		out.println("<H2>Here is your session data:</H2>");
		Enumeration enumerator = session.getAttributeNames();
		while (enumerator.hasMoreElements())
		{
			String name = (String) enumerator.nextElement();
			out.println(name + ": " + session.getAttribute(name) + "<BR>");
		}

		out.println("</div>");
		out.println("</BODY></HTML>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
