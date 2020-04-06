package mainapp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class logindao {
	public boolean validate(loginpojo lpojo) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String username= lpojo.getUsername();
		String password= lpojo.getPassword();
		connectionmanager con = new connectionmanager();
		Statement st= con.getConnection().createStatement();
		ResultSet rs= st.executeQuery("SELECT * from userdetails");
		while(rs.next())
		{
			if(username.contentEquals(rs.getString("USERNAME"))&& password.equals("PASSWORD"))
{
					con.getConnection().close();
					return true;
			}
			else
			{
				con.getConnection().close();
				return false;
			}
		}
		return false;
	}
}
