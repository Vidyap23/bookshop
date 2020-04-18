/**
 * has shipping details and order date of each order
 * @param orders_emailid is the email id of a customer
 * @param ordernum is the uniquely generated random code
 
 */
package model;

import java.sql.Date;
import java.time.LocalDate;

public class orders {
String orders_emailid;
int ordernum;
LocalDate orderdate;
String shipstreet;
String shipcountry;
String shipstate;
public orders(String orders_emailid, int ordernum, LocalDate orderdate, String shipstreet, String shipcountry,
		String shipstate, int shipcost) {
	super();
	this.orders_emailid = orders_emailid;
	this.ordernum = ordernum;
	this.orderdate = orderdate;
	this.shipstreet = shipstreet;
	this.shipcountry = shipcountry;
	this.shipstate = shipstate;
	this.shipcost = shipcost;
}
public orders() {
	// TODO Auto-generated constructor stub
}
public String getShipstate() {
	return shipstate;
}
public void setShipstate(String shipstate) {
	this.shipstate = shipstate;
}
public String getOrders_emailid() {
	return orders_emailid;
}
public void setOrders_emailid(String orders_emailid) {
	this.orders_emailid = orders_emailid;
}
public int getOrdernum() {
	return ordernum;
}
public void setOrdernum(int ordernum) {
	this.ordernum = ordernum;
}

public LocalDate getOrderdate() {
	return orderdate;
}
public void setOrderdate(LocalDate orderdate) {
	this.orderdate = orderdate;
}

public String getShipstreet() {
	return shipstreet;
}
public void setShipstreet(String shipstreet) {
	this.shipstreet = shipstreet;
}
public String getShipcountry() {
	return shipcountry;
}
public void setShipcountry(String shipcountry) {
	this.shipcountry = shipcountry;
}
public int getShipcost() {
	return shipcost;
}
public void setShipcost(int shipcost) {
	this.shipcost = shipcost;
}
	int shipcost;
}
