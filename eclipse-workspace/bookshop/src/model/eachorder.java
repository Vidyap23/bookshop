/**
 * every order detail is stored in this class
 * @param itemnumber is a randomly generated number
 * @param isbn is the unique book code
 * @param ordernumber is a randomly generated number for ordercode
 * @price is the price for each piece
 * @param totalprice is quantity*price
 */


package model;

public class eachorder {
int itemnumber;
String isbn;
int ordernumber;
int quantity;
int price;
int totalprice;
public eachorder(int itemnumber, String isbn, int ordernumber, int quantity, int price, int totalprice) {
	super();
	this.itemnumber = itemnumber;
	this.isbn = isbn;
	this.ordernumber = ordernumber;
	this.quantity = quantity;
	this.price = price;
	this.totalprice = totalprice;
}
public eachorder() {
	// TODO Auto-generated constructor stub
}
public int getTotalprice() {
	return totalprice;
}
public void setTotalprice(int totalprice) {
	this.totalprice = totalprice;
}
public int getItemnumber() {
	return itemnumber;
}
public void setItemnumber(int itemnumber) {
	this.itemnumber = itemnumber;
}
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
public int getOrdernumber() {
	return ordernumber;
}
public int setOrdernumber(int ordernumber)
{
	return this.ordernumber=ordernumber;
}

public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
}
