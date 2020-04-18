/**
 * interface for orders class
 */
package dao;
import model.*;

public interface ordersdaointerface {
int addorders(orders neworder);
void customercart(String title,eachorder neworder);
void displayorder(String email);
}
