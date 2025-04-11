public class DownloadInfo {

  private String title;
  private int timesDownloaded;
  /** Creates a new instance with the given unique title and sets the 
   * number of times downloaded to 1. 
   * @param title the unique title of the downloaded song
   */

  public DownloadInfo(String title) {
    this.title = title;
    timesDownloaded = 1;
  }
  public DownloadInfo(String t, int d) {
    title = t;
    timesDownloaded = d;
  }
  /* TODO1a-2 in DownloadInfo write a constructor with a string parameter and an integer parameter that initializes both private instance variables */

  /** @return the title */
  public String getTitle() {
    return title;
  }

  public int getTimesDownloaded() {
    return timesDownloaded;
  }

  /** Increment the number times downloaded by 1 */
  public void incrementTimesDownloaded() {
    timesDownloaded++;
  }

  public String toString() {
    return "" + title + "," + timesDownloaded;
  }

  // There may be instance variables, constructors, and methods that are not shown. 
}
