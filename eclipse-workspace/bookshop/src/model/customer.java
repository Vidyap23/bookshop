/**
 * Stores all customer related details.
 * @param username is the username of customer for this application
 * @param email is the email of customer
 * @param phonenum, password are the respective
 */


package model;

public class customer {

String customerName;
String customerEmail;
String password;
String customerphoneNumber;
public customer(String customerName, String customerEmail, String password, String customerphoneNumber) {
	super();
	this.customerName = customerName;
	this.customerEmail = customerEmail;
	this.password = password;
	this.customerphoneNumber = customerphoneNumber;
}
public customer() {
	// TODO Auto-generated constructor stub
}
public String getCustomerName() {
	return customerName;
}
public void setCustomername(String customerName) {
	this.customerName = customerName;
}
public String getCustomerEmail() {
	return customerEmail;
}
public void setCustomeremail(String customeremail) {
	this.customerEmail = customeremail;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getcustomerphoneNumber() {
	return customerphoneNumber;
}
public void setcustomerphonenumber(String phonenumber) {
	this.customerphoneNumber = phonenumber;
}

}
