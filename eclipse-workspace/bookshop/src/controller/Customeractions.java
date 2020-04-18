package controller;
import java.util.Random;
import java.lang.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

import dao.searchbooks;
import java.time.LocalDate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.*;
import dao.*;
public class Customeractions {
public void customeractions() throws SQLException, Exception {
	Scanner sc= new Scanner(System.in);
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter your action");
	System.out.println("1.Check if your favourite book is there");
	System.out.println("2.View all books in the store");
	System.out.println("3.Order books");
	System.out.println("4.View old orders");
	int checkResponse= sc.nextInt();
	if(checkResponse==1) {
		  System.out.println("*------------------------------------------------------------------------*");
		System.out.println("How do you want to search for books?");
		System.out.println("1.ISBN");
		System.out.println("2.Genre");
		System.out.println("3.Title");
		System.out.println("4. Author");
		int bookResponse= sc.nextInt();
		searchbooks search= new searchbooks();
		switch(bookResponse) {
		 
		case 1: System.out.println("enter isbn");
		String isbnNumber= br.readLine();
		search.searchbyisbn(isbnNumber);
		break;
		case 2:
			System.out.println("Enter genre");
			String genre= br.readLine();
			search.searchbygenre(genre);
			break;
			
		case 3:
		System.out.println("Enter title");
		String title= br.readLine();
		search.searchbytitle(title);
		break;
		case 4:
			System.out.println("Enter Author firstname");
			String authorfirstname= br.readLine();
			search.searchbyauthor(authorfirstname);
		
		
		}
		System.out.println("Do you want to go back to home and add books to cart?");
		String response= br.readLine();
		if(response.equals("yes"))
			customeractions();
		
		
		}
	
	if(checkResponse==2)
	{
		searchbooks displayBooks= new searchbooks();
		displayBooks.displayallBooks();
		System.out.println("Do you want to go back to home and add books to cart?");
		String response= br.readLine();
		if(response.equals("yes"))
			customeractions();
		
		
	}
		if (checkResponse==3)
		{
			int ShippingCost;
			Random rand= new Random();
			System.out.println("Enter email id again");
			String email= br.readLine();
            int orderNumber= rand.nextInt(1000);
			System.out.println("Enter shipping street of address");
			String street= br.readLine();
			System.out.println("Enter shipping state of address");
			String state= br.readLine();
			int shippingCost=0;
			if( state.equals("Karnataka"))
				ShippingCost= 50;
			else
				ShippingCost=75;
			
			System.out.println("Enter shipping country");
			String country=br.readLine();
			  System.out.println("*------------------------------------------------------------------------*");
			orders newOrder= new orders();
			newOrder.setOrders_emailid(email);
			orders newOrders= new orders();
			newOrders.setOrdernum(orderNumber);
			newOrders.setOrders_emailid(email);
			newOrders.setShipcost(ShippingCost);
			newOrders.setShipcountry(country);
			newOrders.setShipstreet(street);
		newOrders.setShipstate(state);
			orderdao shippingDetails= new orderdao();
			shippingDetails.shippingDetails(newOrders);
			System.out.println("*------------------------------------------------------------------------*");
		
			System.out.println("How many books do you want to order?");
		int numofBooks= sc.nextInt();
		for( int i=0;i<numofBooks;i++) {
			System.out.println("Enter book by its title");
			int itemnumber= rand.nextInt(50);
			String title= br.readLine();
			orderdao addCart =new orderdao();
			eachorder newitem= new eachorder();
			newitem.setItemnumber(itemnumber);
			newitem.setOrdernumber(orderNumber);
		newitem.setQuantity(numofBooks);
		addCart.customercart(title,newitem);
		  System.out.println("*------------------------------------------------------------------------*");
		  System.out.println("Do you want to go back home?");
			String response= br.readLine();
			if(response.equals("yes"))
				customeractions();
			
			
			
		}
		}
			if(checkResponse==4) {
				orderdao oldorders= new orderdao();
				System.out.println("Enter email id again");
				String email1= br.readLine();
				oldorders.displayorders(email1);
				
				
			}
				
		
		
			
		
	}
	
	
	
	
	
	
	
	
	
	
}


