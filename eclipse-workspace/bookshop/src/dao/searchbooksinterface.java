package dao;

public interface searchbooksinterface {

	void searchbyisbn(String isbn);
	void searchbygenre(String genre);
	void searchbytitle(String title);
	void searchbyauthor(String authorname);
	void displayallBooks();
	
}
