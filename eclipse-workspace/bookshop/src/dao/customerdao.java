/**
 * class to create new id for customer in customer table , verify exisiting customer details
 */

package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.admin;
import model.customer;
import utility.ConnectionManager;
public class customerdao {
	
	//add new customer into  customer table
	public int signup(customer user)throws Exception
	{
		String insert_admin= "INSERT INTO customer(customername,cemailid,cphonenum, cpassword)VALUES(?,?,?,?)";
		int result=0;
		try
		{
			Connection connection = null;
			try {
				connection = ConnectionManager.getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Step 2:Create a statement using connection object
			PreparedStatement preparedstatement= connection.prepareStatement(insert_admin);
			preparedstatement.setString(1,user.getCustomerName());
			preparedstatement.setString(2,user.getCustomerEmail());
			preparedstatement.setString(3,user.getcustomerphoneNumber());
	        preparedstatement.setString(4,user.getPassword());
		
		
			// Step 3: Execute the query or update query
			result = preparedstatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
	
	//verify existing customer from table customer when he tries to login
	public boolean loginUser(customer user) throws Exception{
		boolean status = false;
		try{
			Connection connection = null;
			try {
				connection = ConnectionManager.getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
				// Step 2:Create a statement using connection object
		PreparedStatement preparedStatement = connection.prepareStatement("select * from customer where cemailid = ? and cpassword = ? ");
		preparedStatement.setString(1, user.getCustomerEmail());
	   preparedStatement.setString(2, user.getPassword());

		
			ResultSet result = preparedStatement.executeQuery();
			status = result.next();

		} catch (SQLException e) {
			// process sql exception
			System.out.println(e);
		}
		return status;
	}
}

