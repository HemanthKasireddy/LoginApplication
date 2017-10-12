package com.bridgeit.logInApplication.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bridgeit.logInApplication.DAO.UserDataBaseConnection;
import com.bridgeit.logInApplication.model.User;

/**
 * Servlet implementation class UserRegistration
 */
@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger=Logger.getLogger(UserRegistration.class);

    /**
     * Default constructor. 
     */
    public UserRegistration() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDataBaseConnection userDataBaseConnection=new UserDataBaseConnection();
		User user=new User();
		logger.info("taking all the values from form fields");
		user.setName(request.getParameter("User Name"));
		user.setEmailId(request.getParameter("Email Id"));
		user.setPassword(request.getParameter("Password"));
		user.setMobileNumber(Long.parseLong(request.getParameter("Mobile Number")));

		PreparedStatement preparedStatement=null;
		
		userDataBaseConnection.getDbConnection();
		logger.info("Db connection created");

		try {
			preparedStatement=userDataBaseConnection.getInsertQuery();
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmailId());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setLong(4, user.getMobileNumber());
			int counter=preparedStatement.executeUpdate();
			logger.debug("inserting user filds to data base");
			logger.debug("The" + counter+" number of rows affected:");
			logger.info("redirecting to log in page");
			response.sendRedirect("LogIn.jsp");
		} catch (SQLException ex) {
			logger.error("The Error is"+ex );
		}
		
		
	}

}
