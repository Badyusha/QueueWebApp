package com.QueueWebApp.bll.services;


public class SignInService {
	//static methods
	public static final int NoSuchUser = 0;
	public static final int BadRequestError = -1;
	public static int SuccessfulAuthorization(String login, String password){
		String encryptedPassword = password;

//		try (Statement statement = Database.connection.createStatement();
//			 ResultSet resultSet = statement.executeQuery("SELECT count(*) AS UsersCount " +
//					 "FROM UsersTable " +
//					 "WHERE (UsersTable.Login = '" + login + "' " +
//					 "AND UsersTable.Password = '" + encryptedPassword + "');")) {
//
//			if (resultSet.next()) {
//				return resultSet.getInt("UsersCount");
//			}
//			return NoSuchUser;
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("SQL Error!");
//			return BadRequestError;
		return 0;
		}

}
