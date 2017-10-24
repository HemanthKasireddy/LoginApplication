package com.bridgeit.webApplication.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;



/**
 * Servlet implementation class UserLogOut
 */
public class UserLogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger=Logger.getLogger(UserLogOut.class);

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");	
		HttpSession session=request.getSession(false);
		if(session!=null) {
			session.invalidate();
			logger.info("session is invalidated");
		}
		logger.info("redirecting to Login.jsp");

		response.sendRedirect("LogIn.jsp");
	}
}
