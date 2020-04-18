/**
 * start class for the application to start. 
 */

package controller;
import java.lang.*;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import model.*;
import dao.*;
import service.signupvalidation;

public class start {
public static void main(String[] args) throws Exception {
	System.out.println("*----------------Welcome to Blossoms,a book for everyone----------------*");
	System.out.println("Enter your role. Are you an admin or a customer?");
	System.out.println("1.Admin");
	System.out.println("2. Customer");
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 Scanner sc= new Scanner(System.in);
	 int response= sc.nextInt();
	 switch(response)
	 {
	 
	 //admin part
	 case 1:
	  System.out.println("*---------------------Existing user or signup?--------------------------*");
	         System.out.println("1.Signup");
	         System.out.println("2. Login");
	         System.out.println("*------------------------------------------------------------------------*");
	         int loginresponseAdmin= sc.nextInt();
	        
	         //new user
	         if(loginresponseAdmin==1) {
	        	 admin newAdmin= new admin();
	        	 System.out.println("Enter username");
	        	String username= br.readLine();
	        	newAdmin.setUsername(username);
	        	System.out.println("Enter email");
	        	String email= br.readLine();
	        	newAdmin.setEmail(email);
	        	System.out.println("Enter password which must have a capital letter,a special character");
	        	String password= br.readLine();
	        	newAdmin.setPassword(password);
	        	System.out.println("Enter phonenumber");
	        	String phonenum= br.readLine();
	        	newAdmin.setPhonenum(phonenum);
	        	signupvalidation adminValidation= new signupvalidation();
	        	//validation of email and password
	        	boolean check=adminValidation.validate(username, email, phonenum, password);
	        	  System.out.println("*------------------------------------------------------------------------*");
	        	
	        	if (check==true) {
	        	admindao newAdmindao= new admindao();
	        	newAdmindao.signup(newAdmin);
	        	System.out.println("Do you want to add,check inventory or look at previous purchases? Press 1 if yes");
	        	int inventoryResponse=sc.nextInt();
	        	if(inventoryResponse==1) {
	        	addbooks addBooks = new addbooks(); //after signing up can add books and perform operations in the addbooks class
	        	addBooks.addinventory();
	        	}
	         }
	         }
	         
	         //existinguser
	         else if(loginresponseAdmin==2)
		        {
		        	admin existingUser= new admin();
		        	System.out.println("Enter email");
		        	String emailUser= br.readLine();
		        	System.out.println("Enter password");
		        	String passwordUser= br.readLine();
		        	existingUser.setEmail(emailUser);
		        	existingUser.setPassword(passwordUser);
		        	admindao existingUserdao= new admindao();
		        	boolean checkUser=existingUserdao.loginUser(existingUser);
		        	  System.out.println("*------------------------------------------------------------------------*");
		        	if(checkUser==true) {
		        	System.out.println("Successful login");
		        	  System.out.println("*------------------------------------------------------------------------*");
		        	System.out.println("Do you want to add,check inventory or look at previous purchases?");
		        	String inventoryResponse=br.readLine();
		        if(inventoryResponse.equals("yes"))
		        {
		        	addbooks addBooks= new addbooks();
		        	addBooks.addinventory();
		        }
		        	
		        	}
		        	else
		        		System.out.println("Please check user credentials");
		        	
		        	
		        }
	         	break;
	         	
	         	
	         	//customerpart
	 case 2: System.out.println("*----------------------Existing customer or do you want to signup?-----------------------*");
     System.out.println("1.Signup");
     System.out.println("2. Login");
     System.out.println("*------------------------------------------------------------------------*");
     int loginresponseCustomer= sc.nextInt();
     
     //new customer
     if(loginresponseCustomer==1) {
    	 customer newCustomer= new customer();
    	 System.out.println("Enter username");
    	String username= br.readLine();
    	newCustomer.setCustomername(username);
    	System.out.println("Enter email");
    	String email= br.readLine();
    	newCustomer.setCustomeremail(email);
    	System.out.println("Enter password which must have a capital letter,a special character");
    	String password= br.readLine();
    	newCustomer.setPassword(password);
    	System.out.println("Enter phonenumber");
    	String phonenum= br.readLine();
    	newCustomer.setcustomerphonenumber(phonenum);
    	signupvalidation validation= new signupvalidation();
    	boolean check=validation.validate(username, email, phonenum, password);
    	  System.out.println("*------------------------------------------------------------------------*");
    	if(check==true) {
    		customerdao newcustomerDao= new customerdao();
    		newcustomerDao.signup(newCustomer);
    		System.out.println("Account created successfully");
    		  System.out.println("*------------------------------------------------------------------------*");
    		System.out.println("Do you want to browse through books or shop? ");
    		String customerResponse= br.readLine();
    		if(customerResponse.equals("yes"))
    		{
    			Customeractions customerActions = new Customeractions();
    			customerActions.customeractions();
    		}
    		
    	}
     }
    	
     //existing customer
    	if(loginresponseCustomer==2) {
    		
    		customer existingCustomer= new customer();
        	System.out.println("Enter your  email");
        	String emailUser= br.readLine();
        	System.out.println("Enter your password");
        	String passwordUser= br.readLine();
        	existingCustomer.setCustomeremail(emailUser);
        	existingCustomer.setPassword(passwordUser);
        	customerdao existingCustomerdao= new customerdao();
        	boolean checkUser=existingCustomerdao.loginUser(existingCustomer);
        	  System.out.println("*------------------------------------------------------------------------*");
        	if(checkUser==true) {
        	System.out.println("Successful login");
        	  System.out.println("*------------------------------------------------------------------------*");;
        	System.out.println("Do you want to browse through books or shop? ");
    		String customerResponse= br.readLine();
    		if(customerResponse.equals("yes"))
    		{
    			Customeractions customerActions = new Customeractions();
    			customerActions.customeractions();
    		}
        	}
        	else
        		System.out.println("Check credentials");
    	}
    
    	}
    	
	
}
}






