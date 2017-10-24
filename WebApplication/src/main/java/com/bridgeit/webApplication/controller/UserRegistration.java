package com.bridgeit.webApplication.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bridgeit.webApplication.DAO.UserDataBaseConnection;
import com.bridgeit.webApplication.model.User;


/**
 * Servlet implementation class UserRegistration
 */
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
		
		String email=request.getParameter("Email Id");
		String password=request.getParameter("Password");
		String confirmPassword=request.getParameter("confirmPassword");
		String mobileNumber=request.getParameter("Mobile Number");
		
		user.setName(request.getParameter("User Name"));
		user.setEmailId(email);
		user.setPassword(request.getParameter("Password"));
		user.setMobileNumber(Long.parseLong(request.getParameter("Mobile Number")));

		PreparedStatement preparedStatement=null;
		
		String emailValidation="^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$";
		String mobileValidation="^((\\+)?(\\d{2}[-]))?(\\d{10}){1}?$";
		boolean isError=false;
		
		if(!email.matches(emailValidation)) {
			 request.setAttribute("error","enter valid email address ");

			isError=true;
		} else if(!confirmPassword.equals(password)) {
			 request.setAttribute("error"," password not matches");

			isError=true;
		} else if(!mobileNumber.matches(mobileValidation)) {
			 request.setAttribute("error","enter valid 10 digit mobile numbr ");

			isError=true;
		} 
		
		if(isError==true) {
			
			 RequestDispatcher rd = request.getRequestDispatcher("/UserRegistration");
			 logger.error("validation fails");
			 rd.include(request, response);		
			 
		} else {
			user.setName(request.getParameter("User Name"));
			user.setEmailId(email);
			user.setPassword(password);
			user.setMobileNumber(Long.parseLong(mobileNumber));
			userDataBaseConnection.getDbConnection();
			logger.info("Db connection created");
		}
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
