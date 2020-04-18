/**
 * interface for the admindao class
 */

package dao;

import model.*;


public interface admindaointerface {
	int signUp(admin user) throws Exception;
	boolean loginUser(admin user) throws Exception;
	int  addbooks(books add) throws Exception;
	int addauthor(author add)throws Exception;
	
}
