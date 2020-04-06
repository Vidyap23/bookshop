package mainapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionmanager {
public Connection getConnection() throws ClassNotFoundException, SQLException {
	//register driver class
	Class.forName("oracle.jdbc.driver.OracleDriver");
	//create connection object
	Connection con= null;
	con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","SYSTEM","Vids2310$");
	if(con!=null)
		System.out.println("established");
	return con;
	
}
}
//sir what was the mistake
// in Class.forname driver is mssing then OracleDriver D caps sry my bad in tohakt line you miss one that's it remaining every this is ok' okay sir thank you
//always welcome
