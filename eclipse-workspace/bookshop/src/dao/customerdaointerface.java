/**
 * interface for the customerdao class
 */
package dao;

import model.*;

public interface customerdaointerface {
	int signUp(customer user) throws Exception;
	boolean loginUser(customer user) throws Exception;
}
