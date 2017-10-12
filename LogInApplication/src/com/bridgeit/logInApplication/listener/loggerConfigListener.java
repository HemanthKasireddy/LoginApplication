package com.bridgeit.logInApplication.listener;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.PropertyConfigurator;

/**
 * Application Lifecycle Listener implementation class loggerConfigListener
 *
 */
@WebListener
public class loggerConfigListener implements ServletContextListener, ServletRequestListener {

    /**
     * Default constructor. 
     */
    public loggerConfigListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext context = sce.getServletContext();
    	String prefix =  context.getRealPath("/");     
    	  String file = "WEB-INF"+System.getProperty("file.separator")+"classes"+System.getProperty("file.separator")+"log4j.properties";
    	           
    	     if(file != null) {
    	       PropertyConfigurator.configure(prefix+file);
    	       System.out.println("Log4J Logging started for application: " + prefix+file);
    	     }
    	     else
    	     {
    	      System.out.println("Log4J Is not configured for application Application: " + prefix+file);
    	     } 
    }
	
}
