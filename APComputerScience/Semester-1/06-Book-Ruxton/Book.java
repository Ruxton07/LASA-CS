// Declare a Book class here.
public class Book {
  private String bookName;
  private int bookISBN;
  public Book() {
    bookName = "";
    bookISBN = 0;
  }
  public Book(String name, int isbn) {
    bookName = name;
    bookISBN = isbn;
  }
  public void setBookName (String name) {
    bookName = name;
  }
  public void setBookISBN (int isbn) {
    bookISBN = isbn;
  }
  public String getBookName () {
    return bookName;
  }
  public int getBookISBN () {
    return bookISBN;
  }
  public String toString() {
    return (bookName + " " + bookISBN);
  }
}
