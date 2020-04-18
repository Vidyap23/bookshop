/**
 * class to search books by isbn, title, author and genre
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.*;

import utility.ConnectionManager;

//displays all books in the books table
public class searchbooks {
	public void displayallBooks() throws Exception
	{
		List<books> list=new ArrayList<books>();
		Connection connection= null;
		connection= ConnectionManager.getConnection();
				// Step 2:Create a statement using connection object
		String displayBooks="select *from books ";
		PreparedStatement preparedstatement = connection.prepareStatement(displayBooks);
		 
	ResultSet rs= preparedstatement.executeQuery();//
		
		while(rs.next()) {
			String isbn = rs.getString(1);
			String title= rs.getString(2);
			String publicationDate= rs.getString(3);
			int sellingPrice= rs.getInt(4);
			int edition = rs.getInt(7);
			int inventory= rs.getInt(8);
			String genre= rs.getString(9);
			books searchedBooks= new books();
			searchedBooks.setIsbn(isbn);
			searchedBooks.setTitle(title);
			searchedBooks.setInventory(inventory);
			searchedBooks.setGenre(genre);
			searchedBooks.setEdition(edition);
			searchedBooks.setPubdate(publicationDate);
			searchedBooks.setSellingcost(sellingPrice);
		list.add(searchedBooks);
		 
		}
		 System.out.println("*--------------------------------------------------------------------------------------*");
System.out.println("ISBN"+"            " +"TITLE"+ "             "+"DATE"+ "        "+ "SELLINGPRICE"+ "         "+"EDITION"+ "         "+ "INVENTORY"+ "      " +"GENRE");
		if(list!= null) {
			for(books books : list) {
				System.out.println( books.getIsbn() + "        " + books.getTitle() +"          " + books.getPublicationDate()+ "            " + books.getSellingcost() + "            " + books.getInventory() + "              "+ books.getEdition()+ "              "+ books.getGenre());
				 
			}
			System.out.println("*--------------------------------------------------------------------------------------*");		
			
		}	
		
	}
	
	
	//searches books by isbn
public void searchbyisbn(String isbn) {
	try{
		Connection connection = null;
		try {
			connection = ConnectionManager.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String searchIsbn="select *from books where isbn=?";
	
			// Step 2:Create a statement using connection object
		 
	PreparedStatement preparedstatement = connection.prepareStatement(searchIsbn);
	 preparedstatement.setString(1,isbn);
	ResultSet rs= preparedstatement.executeQuery();
	
	while(rs.next()) {
		
		String title= rs.getString(2);
		String publicationDate= rs.getString(3);
		int sellingPrice= rs.getInt(4);
		int edition = rs.getInt(7);
		int inventory= rs.getInt(8);
		String genre= rs.getString(9);
		
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println("ISBN"+"            " +"TITLE"+ "             "+"DATE"+ "        "+ "SELLINGPRICE"+ "     "+"EDITION"+ "    "+ "INVENTORY"+ "    " +"GENRE");
		System.out.println( isbn + "         " + title +"        "+ publicationDate +"          " + sellingPrice + "             " + edition + "          " + inventory + "          "+ genre + "      ");
		System.out.println("--------------------------------------------------------------------------------------------");
	}
		

	} catch (SQLException e) {
		// process sql exception
		System.out.println(e);
	}
	
	
	
}

//searchesbooksbygenre
public void searchbygenre(String genre) throws SQLException, Exception {
	List<books> list=new ArrayList<books>();
		Connection connection= null;
		connection= ConnectionManager.getConnection();
				// Step 2:Create a statement using connection object
		String searchGenre="select *from books where genre=?";
		PreparedStatement preparedstatement = connection.prepareStatement(searchGenre);
		 preparedstatement.setString(1,genre);
	ResultSet rs= preparedstatement.executeQuery();//hello sir,
		
		while(rs.next()) {
			String isbn = rs.getString(1);
			String title= rs.getString(2);
			String publicationDate= rs.getString(3);
			int sellingPrice= rs.getInt(4);
			int edition = rs.getInt(7);
			int inventory= rs.getInt(8);
			books searchedBooks= new books();
			searchedBooks.setIsbn(isbn);
			searchedBooks.setTitle(title);
			searchedBooks.setInventory(inventory);
			searchedBooks.setGenre(genre);
			searchedBooks.setEdition(edition);
			searchedBooks.setPubdate(publicationDate);
			searchedBooks.setSellingcost(sellingPrice);
		list.add(searchedBooks);
		
		}

		if(list!= null) {
			 System.out.println("*-----------------------------------------------------------------------------------------------*");
			 System.out.println("ISBN"+"            " +"TITLE"+ "             "+"DATE"+ "        "+ "SELLINGPRICE"+ "         "+"EDITION"+ "         "+ "INVENTORY"+ "      " +"GENRE");
			for(books books : list) {
				
				System.out.println( books.getIsbn() + "        " + books.getTitle() +"          " + books.getPublicationDate()+ "            " + books.getSellingcost() + "            " + books.getInventory() + "              "+ books.getEdition()+ "              "+ books.getGenre());
				 
				
			}
			System.out.println("*------------------------------------------------------------------------------------------------*");		
			
		}
		
	
}

//searches books by title
public void searchbytitle(String title) throws SQLException, Exception {
	List<books> list=new ArrayList<books>();
		Connection connection= null;
		connection= ConnectionManager.getConnection();
				// Step 2:Create a statement using connection object
		String searchTitle="select *from books where title=?";
		PreparedStatement preparedstatement = connection.prepareStatement(searchTitle);
		 preparedstatement.setString(1,title);
	ResultSet rs= preparedstatement.executeQuery();//hello sir,
		
		while(rs.next()) {
			String isbn = rs.getString(1);
			String genre= rs.getString(9);
			String publicationDate= rs.getString(3);
			int sellingPrice= rs.getInt(4);
			int edition = rs.getInt(7);
			int inventory= rs.getInt(8);
			books searchedBooks= new books();
			searchedBooks.setIsbn(isbn);
			searchedBooks.setTitle(title);
			searchedBooks.setInventory(inventory);
			searchedBooks.setGenre(genre);
			searchedBooks.setEdition(edition);
			searchedBooks.setPubdate(publicationDate);
			searchedBooks.setSellingcost(sellingPrice);
		list.add(searchedBooks);
		}
		
		if(list!= null) {
			System.out.println("*--------------------------------------------------------------------------------------*");
			 System.out.println("ISBN"+"            " +"TITLE"+ "             "+"DATE"+ "        "+ "SELLINGPRICE"+ "         "+"EDITION"+ "         "+ "INVENTORY"+ "      " +"GENRE");
			for(books books : list) {
				System.out.println( books.getIsbn() + "        " + books.getTitle() +"          " + books.getPublicationDate()+ "            " + books.getSellingcost() + "            " + books.getInventory() + "              "+ books.getEdition()+ "              "+ books.getGenre());
				
			}
			 System.out.println("*--------------------------------------------------------------------------------------*");		
				
		}
}


//searches books by author

		public void searchbyauthor(String author) throws SQLException, Exception {
			
				Connection connection= null;
				connection= ConnectionManager.getConnection();
						// Step 2:Create a statement using connection object
				String searchAuthor="select books.isbn,books.title,books.inventory,books.edition,books.genre from books left join author on author.books_isbn= books.isbn  where author.firstname='"+author+"'";
				PreparedStatement preparedstatement = connection.prepareStatement(searchAuthor);
			
			ResultSet rs= preparedstatement.executeQuery();
			
				while(rs.next()) {
				
					String isbn = rs.getString(1);
	
					String title= rs.getString(2);
				int inventory= rs.getInt(3);
					int edition = rs.getInt(4);
				String genre= rs.getString(5);
					
					books searchedBooks= new books();
					searchedBooks.setTitle(title);
				searchedBooks.setGenre(genre);
				searchedBooks.setIsbn(isbn);
				searchedBooks.setEdition(edition);
				searchedBooks.setInventory(inventory);
				
				System.out.println("---------------------------------------------------------------------------------------------");
				System.out.println("ISBN"+"         " +"TITLE"+ "      "+"EDITION"+ "      "+ "INVENTORY"+ "     " +"GENRE");
				System.out.println(searchedBooks.getIsbn() + "         " +searchedBooks.getTitle()+ "          " + searchedBooks.getInventory()+"      " +searchedBooks.getEdition() + "     " +searchedBooks.getGenre());
				}
				
}
}
