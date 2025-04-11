public class Main
{
	public static void main(String args[])
	{
		Book textBook = new Book();
		System.out.println(textBook);  //What does this line do?

    Book galaxyGuide = new Book("Hitchhikers Guide to the Galaxy",345391802);
    System.out.println(galaxyGuide);
    textBook.setBookName("Learn JAVA now!!!");
    textBook.setBookISBN(12345678);
    System.out.println(textBook);
    System.out.println("Book 0 name: "+ textBook.getBookName() + " ISBN(" + textBook.getBookISBN() + ")");
    System.out.println("Book 1 name: "+ galaxyGuide.getBookName() + " ISBN(" + galaxyGuide.getBookISBN() + ")");
    System.out.println(textBook);
    System.out.println(galaxyGuide);
	}
}