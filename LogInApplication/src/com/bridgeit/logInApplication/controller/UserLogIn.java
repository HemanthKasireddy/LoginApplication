package com.bridgeit.logInApplication.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.bridgeit.logInApplication.DAO.UserDataBaseConnection;

/**
 * Servlet implementation class UserLogIn
 */
@WebServlet("/UserLogIn")
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
 
		String email=request.getParameter("email id");
		String password=request.getParameter("password");
		userDataBaseConnection.getDbConnection();
		logger.info("Db connection created");
		try {
			preparedStatement=userDataBaseConnection.getUserDetails(email,password);
			resultSet=preparedStatement.executeQuery();
			 
			 
				 if(!resultSet.next()) {
		   
						 RequestDispatcher rd = request.getRequestDispatcher("/LogIn.jsp");
						 request.setAttribute("error","email or password is invalid");
						 logger.error("password or email is incorrect");
						 rd.include(request, response);
						} else {
						HttpSession session=request.getSession(true);
						session.setAttribute("user",email);
						session.setMaxInactiveInterval(60*10);
						response.sendRedirect("Home.jsp");
						logger.debug("User is exist");
						logger.debug("session is created ");
					} 
					
			 
		} catch(SQLException ex) {
			
			logger.error("error is",ex);
		}
	}

}
