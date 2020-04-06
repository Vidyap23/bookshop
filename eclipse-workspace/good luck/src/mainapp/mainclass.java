package mainapp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class mainclass {
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("1 - Register");
		System.out.println("2 - Login");
		System.out.println("Your Option");
		int x = Integer.parseInt(br.readLine());
		//create objects
		registerpojo rpojo= new registerpojo();
		Registerdao rdao= new Registerdao();
		loginpojo lpojo= new loginpojo();
		logindao ldao= new logindao();
		
		switch(x) {
		case 1:
			System.out.println("Enter Firstname");
			String firstname = br.readLine();
			System.out.println("Enter Lastname");
			String lastname = br.readLine();
			System.out.println("Enter Username");
			String username = br.readLine();
			System.out.println("Enter Password");
			String password = br.readLine();
			System.out.println("Enter Email");
			String email= br.readLine();
			rpojo.setFirstname(firstname);
			rpojo.setLastname(lastname);
			rpojo.setUsername(username);
			rpojo.setEmail(email);
			rpojo.setPassword(password);
			rdao.adduser(rpojo);
			break;
		case 2:
			System.out.println("enter username");
			String username1=br.readLine();
			System.out.println("enter password");
			String password1= br.readLine();
			lpojo.setUsername(username1);
			lpojo.setPassword(password1);
			if(ldao.validate(lpojo)==true)
			{
				luck l= new luck();
				l.display();
			}
			else
				System.out.println("incorrect username or password");
			
			break;
			
		
		
		
	}
}
}
