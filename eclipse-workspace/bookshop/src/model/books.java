/**
 * Stores all details of books
 * @param isbn is the unique identification number of the book
 * @param title is the name of book
 * @param purchasecost is the cost the library purchased book at
 * @edition is the edition of the book
 * @param sellingcost is the price
 * @param inventory is the number of books present of one title
 * @genre is the type of book eg. horror, history,non fiction
 */
package model;

public class books {
	
	String isbn;
	String publicationDate;
	String title;
	int purchaseCost;
	int sellingCost;
	int discount;
	int edition;
	int inventory;
	String genre;
public books(String isbn, String publicationDate, String title, int purchaseCost, int sellingCost, int discount,
			int edition, int inventory, String genre) {
		super();
		this.isbn = isbn;
		this.publicationDate = publicationDate;
		this.title = title;
		this.purchaseCost = purchaseCost;
		this.sellingCost = sellingCost;
		this.discount = discount;
		this.edition = edition;
		this.inventory = inventory;
		this.genre = genre;
	}

public books() {
	// TODO Auto-generated constructor stub
}

public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
public String getPublicationDate() {
	return publicationDate;
}
public void setPubdate(String publicationDate) {
	this.publicationDate = publicationDate;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public int getPurchasecost() {
	return purchaseCost;
}
public void setPurchasecost(int purchasecost) {
	this.purchaseCost = purchasecost;
}
public int getSellingcost() {
	return sellingCost;
}
public void setSellingcost(int sellingcost) {
	this.sellingCost = sellingcost;
}
public int getDiscount() {
	return discount;
}
public void setDiscount(int discount) {
	this.discount = discount;
}
public int getEdition() {
	return edition;
}
public void setEdition(int edition) {
	this.edition = edition;
}
public int getInventory() {
	return inventory;
}
public void setInventory(int inventory) {
	this.inventory = inventory;
}
public String getGenre() {
	return genre;
}
public void setGenre(String genre) {
	this.genre = genre;
}

}
