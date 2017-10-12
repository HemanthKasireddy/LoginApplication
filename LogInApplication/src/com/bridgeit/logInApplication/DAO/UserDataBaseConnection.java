package com.bridgeit.logInApplication.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.bridgeit.logInApplication.controller.UserRegistration;

public class UserDataBaseConnection {
	static Logger logger=Logger.getLogger(UserDataBaseConnection.class);

	Connection connection=null;

	public Connection getDbConnection() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/LogInApplication", "root", "root");
		

		} catch (ClassNotFoundException | SQLException e) {
			logger.error("connection is not created");
		}

	return connection;
	}

	public PreparedStatement getInsertQuery() throws SQLException {
		PreparedStatement preparedStatement=null;
		preparedStatement=connection.prepareStatement("Insert into User values(?,?,?,?)");
		logger.info("querry is executed");

		return preparedStatement;
	}

	public PreparedStatement getUserDetails(String email, String password) throws SQLException {
		PreparedStatement preparedStatement=null;
		preparedStatement=connection.prepareStatement("select *from User where user_email_id=? and user_password= ? ");
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, password);
		logger.info("querry is executed");

		return preparedStatement;
	}
}
