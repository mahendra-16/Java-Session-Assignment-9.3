package com.listner.tutorial;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.listner.tutorial.*;

/**
 * Application Lifecycle Listener implementation class SampleListner
 *
 */
public class SampleListner implements ServletContextListener, HttpSessionListener {

    /**
     * Default constructor. 
     */
    public SampleListner() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent hse)  { 
         // TODO Auto-generated method stub
		log("CREATE", hse);
		System.out.println("\nsessionCreated");

    }

    
    public void sessionDestroyed(HttpSessionEvent hse)  { 
         // TODO Auto-generated method stub

		javax.servlet.http.HttpSession session = hse.getSession();
		long start = session.getCreationTime();
		long end = session.getLastAccessedTime();
		String _counter = (String) session.getAttribute("counter");
		log("DESTROY, Session Duration:" + (end - start) + "(ms) Counter:"
				+ _counter, hse);
		System.out.println("\nsessionDestroyed");

    
    }

	
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("\ncontextDestroyed");
		
    }

	
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("\ncontextInitialized");
    	
    	
    }
    
	protected void log(String msg, HttpSessionEvent hse) {
		String _ID = hse.getSession().getId();
		log("SessionID:" + _ID + " 	" + msg);
	}

	protected void log(String msg) {
		System.out.println("[" + getClass().getName() + "] " + msg);
	}

    
	
}
