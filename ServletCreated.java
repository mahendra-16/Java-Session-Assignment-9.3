package com.listner.tutorial;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletCreated
 */
public class ServletCreated extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletCreated() {
        super();
        // TODO Auto-generated constructor stub
    }
	
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	HttpSession session = request.getSession();
  
    	response.setContentType("text/html");
  
    	PrintWriter pw = response.getWriter();
	
    	String note = (String)request.getAttribute("count");
    	int count = 1;
    	if(note != null){
    		count = Integer.parseInt(note);
    		count++;
    	}
    	
    	
    	session.setAttribute("count", String.valueOf(count));

		pw.println("<HEAD><TITLE> "
			+ "Session Created Successfully .. Look at TOMCAT Console to see whether the HTTPSessionEvent invoked "
			+ "</TITLE></HEAD><BODY>");
		pw.println("<P>[<a href=\"sessioncreated\">Reload</a>]&nbsp;");
		pw.println("[<a href=\"sessiondestroyed\">Destroy Session</a>]");
		pw.println("<h2>Session created Successfully</h2>");
		pw.println("Look at the TOMCAT Console to see whether the HTTPSessionEvent was invoked");
		pw.println("<h3>Session Data:</h3>");
		pw.println("New Session: " + session.isNew());
		pw.println("<br>Session ID: " + session.getId());
		pw.println("<br>Creation Time: "
			+ new Date(session.getCreationTime()));
		pw.println("<br>Last Accessed Time: "
			+ new Date(session.getLastAccessedTime()));
		pw.println("<BR>Number of Accesses: "
				+ session.getAttribute("count"));

    	
    	
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
