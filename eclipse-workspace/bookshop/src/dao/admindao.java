/**
 * class which does all the admin operations, enters new admin details into table, checks existing user when he tries to login, adds books, views
 * previous orders
 */
package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.admin;
import model.author;
import model.books;
import model.eachorder;
import utility.ConnectionManager;
public class admindao {
	
	//enters new admin into admin table
public int signup(admin user)throws Exception
{
	String insert_admin= "INSERT INTO admin(username,emailid,phonenumber, password)VALUES(?,?,?,?)";
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
		
		PreparedStatement preparedstatement= connection.prepareStatement(insert_admin);
		preparedstatement.setString(1,user.getUsername());
		preparedstatement.setString(2,user.getEmail());
		preparedstatement.setString(3,user.getPhonenum());
        preparedstatement.setString(4,user.getPassword());
	
	
		
		result = preparedstatement.executeUpdate();

		
	} catch (SQLException e) {
		System.out.println(e);
	}
	return result;
}


//checks if existing user is actually present in admin table
public boolean loginUser(admin user) throws Exception{
	boolean status = false;
	try{
		Connection connection = null;
		try {
			connection = ConnectionManager.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	PreparedStatement preparedStatement = connection.prepareStatement("select * from admin where emailid = ? and password = ? ");
	preparedStatement.setString(1, user.getEmail());
    preparedStatement.setString(2, user.getPassword());

	
		ResultSet result = preparedStatement.executeQuery();
		status = result.next();

	} catch (SQLException e) {
		// process sql exception
		System.out.println(e);
	}
	return status;
	
	
	
}


//adds books into books table after admin has logged in.
	public int addbooks(books add) throws Exception{
		
		String insert_books= "INSERT INTO books(isbn,title,publicationDate,purchaseCost,sellingPrice,discountPerc,edition,inventory,genre)VALUES(?,?,?,?,?,?,?,?,?)";
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
			
			PreparedStatement ps= connection.prepareStatement(insert_books);
			ps.setString(1,add.getIsbn());
			ps.setString(2,add.getTitle());
			ps.setString(3,add.getPublicationDate());
	        ps.setLong(4,add.getPurchasecost());
	        ps.setLong(5,add.getSellingcost());
	        ps.setLong(6, add.getDiscount());
	        ps.setLong(7, add.getEdition());
	        ps.setLong(8, add.getInventory());
	        ps.setString(9,add.getGenre());
		
		
			
			result = ps.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return result;
	}
	
	
	//adds authors according to the added books in the author table in db
		public int  addauthor(author add)throws Exception{
			String insert_author ="INSERT INTO author(books_isbn,authorid,firstname,lastname)VALUES(?,?,?,?)";
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
				
				PreparedStatement ps= connection.prepareStatement(insert_author);
				ps.setString(1,add.getIsbn());
				ps.setString(2,add.getAuthorid());
				ps.setString(3,add.getAuthorfirstname());
		        ps.setString(4,add.getAuthorlastname());
			
			
				
				result = ps.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e);
			}
			if(result==1)
			System.out.println("book added to inventory");
			return result;
			
		}
		
		
		//displays all orders from the orderitems table
		public void vieworders() throws SQLException, Exception {
			String viewOrders="select *from orderitems ";
			List<eachorder> list=new ArrayList<eachorder>();
			Connection connection= null;
			connection= ConnectionManager.getConnection();
			PreparedStatement preparedstatement = connection.prepareStatement(viewOrders);
		ResultSet rs= preparedstatement.executeQuery();
			
			while(rs.next()) {
				int itemnumber= rs.getInt(1);
				String isbn= rs.getString(2);
				int ordernum= rs.getInt(3);
				int quantity=rs.getInt(4);
				int paideach= rs.getInt(5);
				int total= rs.getInt(6);
				eachorder view= new eachorder();
				view.setIsbn(isbn);
				view.setOrdernumber(ordernum);
				view.setQuantity(quantity);
				view.setItemnumber(itemnumber);
				view.setPrice(paideach);
				view.setTotalprice(total);
			list.add(view);
			
			}

			if(list!= null) {
				System.out.println("*---------------------------------------------------------------------------------------*");
System.out.println("ITEMNUMBER" + "     " +"ISBN" +"         " +"ORDERO" + "       " + "QUANTITY" +  "        "+ " PRICE" + "       "+ "TOTALPRICE");
	        for(eachorder view : list) {
			System.out.println( view.getItemnumber() + "            " + view.getIsbn() +"            " + view.getOrdernumber()+ "           " + view.getQuantity() + "            " + view.getPrice() + "           "+ view.getTotalprice() );
					
					
				}
				System.out.println("*----------------------------------------------------------------------------------------*");
			
		}
		
	}
}
	



	


