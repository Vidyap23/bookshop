/**
 * class for unique customer operations, adding shipping details for every order,adding books to cart and viewing all recent orders.
 */

package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import model.eachorder;
import model.orders;
import utility.ConnectionManager;

public class orderdao {
	
	//add shipping details for every order
public int shippingDetails(orders neworder){
	int result=0;
	String insert_shippingDetails= "INSERT INTO orders(ordernum,orders_emailid,orderdate,shipstreet,shipstate,shipcountry,shipcost)VALUES(?,?,?,?,?,?,?)";
	try{
		Connection connection = null;
		try {
			connection = ConnectionManager.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}LocalDate orderDate =LocalDate.now();
		// Step 2:Create a statement using connection object
					PreparedStatement preparedstatement= connection.prepareStatement(insert_shippingDetails);
					preparedstatement.setLong(1,neworder.getOrdernum());
					preparedstatement.setString(2,neworder.getOrders_emailid());
					preparedstatement.setDate(3,Date.valueOf(orderDate));
			        preparedstatement.setString(4,neworder.getShipstreet());
			        preparedstatement.setString(5,neworder.getShipstate());
			        preparedstatement.setString(6,neworder.getShipcountry());
			        preparedstatement.setLong(7,neworder.getShipcost());
			        
				
				
					// Step 3: Execute the query or update query
					result = preparedstatement.executeUpdate();
				} catch (SQLException e) {
					System.out.println(e);
				}
	System.out.println("Shipping details added");
				return result;
}
	

//add everyproduct to cart using orderitems table
	public void customercart(String title,eachorder neworder) throws SQLException, Exception {

		Connection connection= null;
		connection= ConnectionManager.getConnection();
		String select_book= "select books.isbn,books.sellingprice,books.inventory from books where books.title='"+title+"'";
		PreparedStatement preparedstatement = connection.prepareStatement(select_book);
		ResultSet rs= preparedstatement.executeQuery();
		String isbn=null;
		int price=0;
		int inventory=0;
		while(rs.next()) {
			
			 isbn = rs.getString(1);

			 price= rs.getInt(2);
			 inventory= rs.getInt(3);
}
		
		String insert_order="INSERT INTO orderitems(itemnumber,orderitems_isbn,orderitems_ordernum,quantity,paideach,totalprice)VALUES(?,?,?,?,?,?)";
		PreparedStatement preparedstatement1 = connection.prepareStatement(insert_order);
		int quantity= neworder.getQuantity();
		int ordernumber= neworder.getOrdernumber();
		String insert_shippingcost="select orders.shipcost from orders where orders.ordernum='"+ordernumber+"'";
		PreparedStatement preparedstatement2 = connection.prepareStatement(insert_shippingcost);
		ResultSet rs1= preparedstatement2.executeQuery();
		int shippingcost=0;
		while(rs1.next()) {
			 shippingcost= rs1.getInt(1);
		}
		
		int totalprice= quantity*price +shippingcost;
		inventory= inventory-quantity;
		preparedstatement1.setLong(1,neworder.getItemnumber());
		preparedstatement1.setString(2,isbn);
		preparedstatement1.setLong(3, neworder.getOrdernumber());
		preparedstatement1.setLong(4, quantity);
		preparedstatement1.setLong(5, price);
		preparedstatement1.setLong(6, totalprice);
		
		int result = preparedstatement1.executeUpdate();
		System.out.println("Order successfully placed!");
		String updateinventory= "update books set inventory=" +inventory+"where isbn='"+isbn+"'";
		PreparedStatement preparedstatement3 = connection.prepareStatement(updateinventory);
	 int check=preparedstatement3.executeUpdate();
	 if(check==1)
		System.out.println("Inventory updated");
}

	
	//displayall recent orders
	public void displayorders(String email) throws SQLException, Exception {
		Connection connection= null;
		connection= ConnectionManager.getConnection();
		String display_orders="select  orderitems.orderitems_isbn, orderitems.order_num, orderitems.quantity,orderitems.totalprice from orderitems inner join orders where orders.order_emailid='"+email+"'";
		PreparedStatement preparedstatement4 = connection.prepareStatement(display_orders);
		ResultSet rs= preparedstatement4.executeQuery();
		String isbn=null;
		int ordernum = 0;
		int quantity = 0;
		int totalprice = 0;
		while(rs.next()) {
			
			  isbn = rs.getString(1);

			  ordernum= rs.getInt(2);
			  quantity= rs.getInt(3);
			 totalprice=rs.getInt(4);
			 
}
		String get_title= "select title from books where isbn='"+isbn+"'";
		PreparedStatement preparedstatement5 = connection.prepareStatement(get_title);
		ResultSet rs2= preparedstatement5.executeQuery();
		String title= rs2.getString(1);
		System.out.println("ISBN" +  "     " + "TITLE" + "      "+"ORDERNUM" +"     "+"QUANTITY"+ "      "+"TOTALPRICE");
		System.out.println(isbn  + "    "+ title +"     "+ ordernum + "    " + quantity +"      " + totalprice);
	}
}
