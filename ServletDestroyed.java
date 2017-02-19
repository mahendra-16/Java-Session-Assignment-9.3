package com.listner.tutorial;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.listner.tutorial.*;

/**
 * Servlet implementation class ServletDestroyed
 */
public class ServletDestroyed extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletDestroyed() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	HttpSession session = request.getSession(true);
		// Invalidate Session
		session.invalidate();

		// set content type and other response header fields first
		response.setContentType("text/html");

		// then write the data of the response
		PrintWriter out = response.getWriter();

		out.println("<HEAD><TITLE> "
					+ "Session Destroyed Successfully .. Look at TOMCAT Console to see whether the HTTPSessionEvent invoked "
					+ "</TITLE></HEAD><BODY>");
		out.println("<P>[<A HREF=\"index.jsp\">Restart</A>]");
		out.println("<h2> Session Destroyed Successfully</h2>");
		out.println("Look at the OC4J Console to see whether the HTTPSessionEvent was invoked");
		out.close();

    	
    	
    	
	}

	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
