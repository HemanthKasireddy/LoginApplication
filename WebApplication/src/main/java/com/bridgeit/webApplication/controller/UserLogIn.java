package com.bridgeit.webApplication.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.bridgeit.webApplication.DAO.UserDataBaseConnection;


/**
 * Servlet implementation class UserLogIn
 */
public class UserLogIn extends HttpServlet {
	static Logger logger=Logger.getLogger(UserLogIn.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDataBaseConnection userDataBaseConnection=new UserDataBaseConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		logger.info("test");
		String email=request.getParameter("email id");
		String password=request.getParameter("password");
		String emailValidation="^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$";
		if(email.matches(emailValidation)) {
			userDataBaseConnection.getDbConnection();
			logger.info("Db connection created");
		} else {
			 RequestDispatcher rd = request.getRequestDispatcher("/LogIn.jsp");
			 request.setAttribute("error","enter valid email address ");
			 logger.error("validation fails");
			 rd.include(request, response);
		}
		try {
			preparedStatement=userDataBaseConnection.getUserDetails(email,password);
			resultSet=preparedStatement.executeQuery();
			 
			 
				 if(!resultSet.next()) {
		   
						 RequestDispatcher rd = request.getRequestDispatcher("/LogIn.jsp");
						 request.setAttribute("error","email or password is invalid");
						 logger.error("password or email is incorrect");
						 rd.forward(request, response);
						} else {
						HttpSession session=request.getSession(true);
						session.setAttribute("user",email);
						logger.info("your sesssion will be expire in 10 minutes");
						session.setMaxInactiveInterval(60*10);
						//Get the encoded URL string
						
						String encodedURL = response.encodeRedirectURL("Home.jsp");
						response.sendRedirect(encodedURL);
						response.sendRedirect("Home.jsp");
						logger.debug("User is exist");
						logger.debug("session is created ");
					} 
					
			 
		} catch(SQLException ex) {
			
			logger.error("error is",ex);
		}
	}


}
