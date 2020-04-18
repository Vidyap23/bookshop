/**
 * Stores details of authors
 * @param authorid stores id of author
 * @param isbn is the isbn of the book 
 * @param authorfirstname, lastname store the name of author
 */

package model;

public class author {

String authorid;
String isbn;
String authorfirstname;
public author(String authorid, String isbn, String authorfirstname, String authorlastname) {
	super();
	this.authorid = authorid;
	this.isbn = isbn;
	this.authorfirstname = authorfirstname;
	this.authorlastname = authorlastname;
}
public author() {
	// TODO Auto-generated constructor stub
}
public String getAuthorid() {
	return authorid;
}
public void setAuthorid(String authorid) {
	this.authorid = authorid;
}
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
public String getAuthorfirstname() {
	return authorfirstname;
}
public void setAuthorfirstname(String authorfirstname) {
	this.authorfirstname = authorfirstname;
}
public String getAuthorlastname() {
	return authorlastname;
}
public void setAuthorlastname(String authorlastname) {
	this.authorlastname = authorlastname;
}
String authorlastname;
}
