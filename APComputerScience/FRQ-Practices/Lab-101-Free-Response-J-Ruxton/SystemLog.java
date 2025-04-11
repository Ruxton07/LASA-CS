import java.util.List;
import java.util.ArrayList;

public class SystemLog
{
  private List<LogMessage> messageList;

  public SystemLog(String[] messages)
  {
    messageList = new ArrayList<LogMessage>();
    for (String s : messages)
      messageList.add(new LogMessage(s));
  }

  /* Part (c) */

  public List<LogMessage> removeMessages(String keyword)
  {
    List<LogMessage> removed = new ArrayList<LogMessage>();
    for (int i = 0; i < messageList.size(); i++) {
      if (messageList.get(i).containsWord(keyword)) {
        removed.add(messageList.get(i));
        messageList.remove(i);
        i--;
      }
    }
    return removed;
  }

  public String toString()
  {
    String s = "";
    for (LogMessage msg : messageList)
      s += msg + "\n";
    return s;
  }

}
