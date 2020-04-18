/**
 * Stores all admin related details.
 * @param username is the username of admin for this application
 * @param email is the email of admin
 * @param phonenum, password are the respective
 */


package model;

public class admin {
String username;
String email;
String password;
String phonenum;
public String getPhonenum() {
	return phonenum;
}
public admin(String username, String email, String password, String phonenum) {
	super();
	this.username = username;
	this.email = email;
	this.password = password;
	this.phonenum = phonenum;
}
public admin() {
	// TODO Auto-generated constructor stub
}
public void setPhonenum(String phonenum) {
	this.phonenum = phonenum;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
