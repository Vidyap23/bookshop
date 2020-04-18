
/**
 * used for validation of both admin and customer accounts.ie.Password, phonenumber, email should match these conditions
 */

package service;

public class signupvalidation {
	public boolean validate(String name, String email, String phonenum, String password) {
		String regex1=	"^[a-zA-Z]*$";
		String regex2="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		String regex3="^[0-9]*$";
		String regex4="((?=.*[a-z])(?=.*d)(?=.*[@#$%&])(?=.*[A-Z]).{4,16})";

		if(name.matches(regex1)&& email.matches(regex2)&& phonenum.matches(regex3)&&password.matches(regex4))
			return true;
		else
		return false;
	}
}
