public class StudentId {
  private String studentFirstName;
  private String studentLastName;
  private int studentId;

  //default constructor
  public StudentId() {
    studentFirstName = "First";
    studentLastName = "Last ";
    studentId = 111111;
  }

  //initialization constructor
  public StudentId (String f, String l, int d) {
    studentFirstName = f;
    studentLastName = l;
    studentId = d;
  }

  //getter methods
  public String getStudentFirstName() {
    return studentFirstName;
  }
  
  public String getStudentLastName() {
    return studentLastName;
  }
  
  public int getStudentId() {
    return studentId;
  }

  //setter methods
  public void setStudentFirstName(String f) {
    studentFirstName = f;
  }
  public void setStudentLastName(String l) {
    studentLastName = l;
  }
  public void setStudentId(int d) {
    studentId = d;
  }
  public String getPassword() {
    char f0 = studentLastName.charAt(0);
    char l0 = studentLastName.charAt(studentLastName.length()-1);
    return "" + f0 + studentId + l0;
  }
  public String toString() {
    return "Name = " + studentFirstName + " " + studentLastName + " \nStudent ID = " + studentId;
  }
}