import java.util.Arrays;

public class PlayList
{
	/** Song[] array list instance variable*/
	private Song[] list;
	
	/** default constructor used to set the instance variables to default values*/
	public PlayList()
	{
		// I would recommend setting the length to 1
		list = new Song[1];
    list[0] = new Song();
		// Then make sure you add 1 song to the list in index 0
		
	}
	
	/** initialization constructor used to set the instance variables
		* @param x the length of the playlist */
	public PlayList(int x)
	{
		// this should set the length of the playlist
		list = new Song[x];
	}
	
	/** modifier method to set the instance variable list
		* @param x the length of the playlist*/
	public void setList(int x)
	{
		// this should set the length of the playlist
		list = new Song[x];
	}
	
	/** accessor method to get the entire playlist
		* @return return the entire playslist as a Song[] array*/
	public Song[] getList()
	{
		return list;
  }
	
	/** method to add a song to the playlist
		* @param x the position in the playlist to add the song
		* @param s the song to add to the playlist*/
	public void addSong(int x, Song s)
	{
		/* you need to check to make sure the array is big enough to add the song
		   if it is not big enough you will need to create a large enough array
			   and then transfer the songs to the new array before assigning the new
			   array back to the list array*/
    if (list.length < x + 1)
    {
     Song[] newlist = new Song[list.length + 1];
      
     for (int i = 0; i < newlist.length-1; i++) {
        newlist[i] = list[i];
      }
    newlist[list.length] = s;
    list = newlist; 
    }
    else if (list[x]!=null) {
      Song[] templist = new Song[list.length+1];
      for (int j = 0; j <= x; j++) {
        templist[j] = list[j];
      }
      templist[x] = s;
      for (int i = 1; i > list.length; i++) {
        templist[x+i] = list[x-1+i];
      }
      list = templist;
    }
    else { list [x] = s; }
  }
	
	/** method to get a song from the playlist
		* @param x the position in the playlist to get the song from
		* @return return the song in the position specified*/
	public Song getSong(int x)
	{
		return list[x];
	}
	
	/** method to get the number of songs in the playlist
		* @return return the number of songs in the playlist*/
	public int numSongs()
	{
    int counter = 0;
		for (int i = 0; i < list.length; i++) {
      if (list[i] != null) { counter++; }
    }
    return counter;
	}
	
	/** method to get the total length of the playlist specified in seconds
		* @return return the length of the playlist in seconds*/
	public int totalLength()
	{
    int secLength = 0;
    for (int i = 0; i < list.length; i++) {
      if (list[i] != null) {
        secLength += list[i].getLength();
      }
    }
    return secLength;
		/* before accessing the length of an individual song you should ensure that the 
				song reference is not null*/
		
	}
	
	/** method to remove any songs from the specified artist
		* @param ar the artist of the songs to remove from the playlist*/
	public void removeArtist(String ar)
	{
    int songsRemoved = 0;
    for (int i = 0; i < list.length; i++) {
      if (list[i] != null && list[i].getArtist() == ar) {
        list[i] = null;
        songsRemoved++;
      }
    }
    Song[] betterList = new Song[list.length - songsRemoved];
    int betterListIndex = 0;
    for (int i = 0; i < list.length; i++) {
      if (list[i] != null) {
        betterList[betterListIndex] = list[i];
        betterListIndex++;
      }
    }
    list = betterList;
		/* to remove the songs with the specified artist you will first need to count the
				occurances of that artist. 
				Then you will need to create a new smaller array
				Then you can copy the songs to the new array excluding the ones from the artist*/
		
	}
	
	/** method to remove any songs longer than the length specified
		* @param length length of songs to removed given in seconds*/
	public void removeLength(int length)
	{
    int songsRemoved = 0;
    for (int i = 0; i < list.length; i++) {
      if (list[i] != null && list[i].getLength() > length) {
        list[i] = null;
        songsRemoved++;
      }
    }
    Song[] betterList = new Song[list.length - songsRemoved];
    int betterListIndex = 0;
    for (int i = 0; i < list.length; i++) {
      if (list[i] != null) {
        betterList[betterListIndex] = list[i];
        betterListIndex++;
      }
    }
    list = betterList;
		// same as method above with creating a smaller array
	}
	
	/** method to shuffle the order of the playlist - use the card shuffling example from the arrays presentation to help*/
	public void shuffle()
	{
    int n = list.length;
    for(int i = 0; i < n; i++) {
      int exchange = i+(int)(Math.random()*(n-i));
      Song temp = new Song();
      temp = list[i];
      list[i] = list[exchange];
      list[exchange] = temp;
    }

		// use the card shuffling example from the arrays presentation to help you with this
		
	}
	
	/** equals method to determine if two playlists are equal
	 * The base class for all classes instantiated into objects in Java is "Object"
		* @param obj the object to be compared
		* @return return true or false if the playlists are equal*/
	public boolean equals(Object obj)
	{
		PlayList pl = (PlayList)obj;
		if(!Arrays.equals(list, pl.getList()))
			return false;
		return true;
	}
	
	/** toString() method to get the instance variables
		* @return return a String containing the instance variablees*/
	public String toString()
	{
		return Arrays.toString(list);
	}
}