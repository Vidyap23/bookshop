package mainapp;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registerdao {
 public void adduser(registerpojo rpojo) throws ClassNotFoundException, SQLException {
	 String firstname=rpojo.getFirstname();
	 String lastname=rpojo.getLastname();
	 String username=rpojo.getUsername();
	 String password=rpojo.getPassword();
	 String email= rpojo.getEmail();
	 connectionmanager cn= new connectionmanager();
	 String sql= "insert into userdetails(firstname,lastname,username,password,email)VALUES(?,?,?,?,?)";
	 //create statement object
	 PreparedStatement st= cn.getConnection().prepareStatement(sql);
	 st.setString(1,firstname); //similar to getters
	 st.setString(2, lastname);
	 st.setString(3, username);
	 st.setString(4, password);
	 st.setString(5, email);
	 st.executeUpdate(); //execute statement
	 cn.getConnection().close();
 }
}
