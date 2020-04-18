package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import dao.*;
import model.*;
public class addbooks{

	public void addinventory() throws Exception {
		Scanner sc= new Scanner(System.in);
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 System.out.println("*------------------------------------------------------------------------*");
		 System.out.println("1. Add books");
		 System.out.println("2. Check inventory");
		 System.out.println("3.View all books in bookshop");
		 System.out.println("4. View all orders");
		 System.out.println("*------------------------------------------------------------------------*");
		 int response= sc.nextInt();
		switch(response)
		{
		//adding books
		case 1:	System.out.println("---------------How many books do you want to add?-----------------");
		
		books addBook= new books();
		author addAuthor= new author();
		admindao addBooks= new admindao();
		int books_number= sc.nextInt();
		for(int i=0;i<books_number;i++)
		{
			System.out.println("Enter Book isbn");
			String isbn= br.readLine();
			System.out.println("enter Book title");
			String title= br.readLine();
			System.out.println("enter Publication date");
			String publicationDate= br.readLine();
			System.out.println("enter Edition");
			int edition= sc.nextInt();
			System.out.println("enter Genre");
			String genre= br.readLine() ;
			System.out.println("enter Inventory");
			int inventory= sc.nextInt();
			System.out.println("enter Purchase price");
			int purchasePrice= sc.nextInt();
			System.out.println("enter Selling price");
			int sellingPrice= sc.nextInt();
			System.out.println("enter discount");
			int discount= sc.nextInt();
			
		
			addBook.setIsbn(isbn);
			addBook.setTitle(title);
			addBook.setEdition(edition);
			addBook.setGenre(genre);
			addBook.setPubdate(publicationDate);
			addBook.setInventory(inventory);
			addBook.setPurchasecost(purchasePrice);
			addBook.setSellingcost(sellingPrice);
			addBook.setDiscount(discount);
			
			System.out.println("Enter authorid");
			String authorid= br.readLine();
			System.out.println("Enter authorfirstname");
			String authorfirstname= br.readLine();
			System.out.println("Enter authorlastname");
			String authorlastname= br.readLine();
			addAuthor.setIsbn(isbn);
			addAuthor.setAuthorid(authorid);
			addAuthor.setAuthorfirstname(authorfirstname);
			addAuthor.setAuthorlastname(authorlastname);
			
			addBooks.addbooks(addBook);//calling dao class to add books to books table
			addBooks.addauthor(addAuthor);// calling 
			addinventory();
			  System.out.println("*------------------------------------------------------------------------*");
			  System.out.println("Do you want to go back to home?");
			  String resp= br.readLine();
			  if(resp.equals("yes")) {
				  addinventory();
				  
			  }
		}
		break;
		
		//searching books
		case 2: System.out.println("---------------How do you want to search for books?-------------------");
		System.out.println("1.ISBN");
		System.out.println("2.Genre");
		System.out.println("3.Title");
		System.out.println("4. Author");
		  System.out.println("*------------------------------------------------------------------------*");
		       int searchResponse= sc.nextInt();
		       searchbooks search= new searchbooks();
		switch(searchResponse) {
		case 1: System.out.println("enter isbn");
			String isbnNumber= br.readLine();
			search.searchbyisbn(isbnNumber);
			  System.out.println("Do you want to go back to home?");
			  String resp= br.readLine();
			  if(resp.equals("yes")) {
				  addinventory();
				  
			  }
			break;
			case 2:
				System.out.println("Enter genre");
				String genre= br.readLine();
				search.searchbygenre(genre);
				  System.out.println("Do you want to go back to home?");
				  String r= br.readLine();
				  if(r.equals("yes")) {
					  addinventory();
					  
				  }
				break;
				
			case 3:
			System.out.println("Enter title");
			String title= br.readLine();
			search.searchbytitle(title);
			  System.out.println("Do you want to go back to home?");
			  String e= br.readLine();
			  if(e.equals("yes")) {
				  addinventory();
				  
			  }
			break;
			case 4:
				System.out.println("Enter Author firstname");
				String authorfirstname= br.readLine();
				search.searchbyauthor(authorfirstname);
				  System.out.println("Do you want to go back to home?");
				  String p= br.readLine();
				  if(p.equals("yes")) {
					  addinventory();
					  
				  }
				
		
		}
		
	}
		//display all books in shop
		if(response==3) {
			
			searchbooks displayBooks= new searchbooks();
			displayBooks.displayallBooks();
			
			  System.out.println("Do you want to go back to home?");
			  String resp= br.readLine();
			  if(resp.equals("yes")) {
				  addinventory();
				  
			  }
			
		}
		
		//display all orders
		if(response==4)
		{
			admindao displayOrders= new admindao();
			displayOrders.vieworders();
			
			  System.out.println("Do you want to go back to home?");
			  String resp= br.readLine();
			  if(resp.equals("yes")) {
				  addinventory();
				  
			  }
		}
	
	
}
}
