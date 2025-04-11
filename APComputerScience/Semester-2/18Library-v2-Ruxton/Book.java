public class Book {

	private String title;
	private String author;
	private int rating;

  public Book()
  {
    title = "";
    author = "";
    setRating(0);
  }
	public Book(String t, String a, int r)
	{
		title = t;
		author = a;
		rating = r;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String t)
	{
		title = t;
	}
	
	public String getAuthor()
	{
		return author;
	}
	
	public void setAuthor(String a)
	{
		author = a;
	}
	
	public int getRating()
	{
		return rating;
	}
	
	/**
	 * Change book's rating. We only accept rating values between 0 and 5.
	 * @param rating is the new rating value
	 */
	public void setRating(int newRating)
	{
		if (newRating > 5) {
			rating = 5;
		} else if (newRating < 0) {
			rating = 0;
		} else {
			rating = newRating;
		}
	}
	
	public String toString()
	{
		return "\"" + title + "\" by " + author + " (" + rating + ")";
	}
	
	/**
	 * Needed for compatibility with Sun/Oracle JDK's ArrayList
	 */
	public boolean equals(Object obj)
	{
      Book temp = (Book)obj;
		if (temp != null && title.equals(temp.getTitle()) && author.equals(temp.getAuthor())) {
			return true;
		}
		return false;
	}
	
	public boolean titleContains(String target)
	{
		return title.toLowerCase().indexOf(target.toLowerCase()) != -1;
	}
	
	public boolean authorContains(String target)
	{
		return author.toLowerCase().indexOf(target.toLowerCase()) != -1;
	}
}