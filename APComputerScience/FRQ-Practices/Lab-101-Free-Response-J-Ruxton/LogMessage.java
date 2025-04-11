public class LogMessage
{
  private String machineId;
  private String description;


  public LogMessage(String message)
  {
    /* to be implemented in part (a) */
    String[] parts = message.split(":");
    machineId = parts[0];
    description = parts[1];
  }

  /* Part (b) */

  public boolean containsWord(String keyword)
  {
      /* to be implemented in part (b) */
    String[] parts = new String[(description.split(" ").length + 1)];
    for (int x = 0; x < parts.length-1; x++) {
      parts[x] = (description.split(" ")[x]);
    }
    parts[parts.length-1] = machineId;
    for (int i = 0; i < parts.length; i++) {
      if (parts[i].equals(keyword)) {
        return true;
      }
    }
    return false;
  }



  public String getMachineId()
  { return machineId; }

  public String getDescription()
  { return description; }

  public String toString()
  {
    return getMachineId() + ":" + getDescription();
  }
}
