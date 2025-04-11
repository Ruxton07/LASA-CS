class Main {
  public static void main (String[] args) {
    StudentId person = new StudentId();
    System.out.println(person);
    
    //sets ada
    person.setStudentFirstName("Ada");
    person.setStudentLastName("Lovelace");
    person.setStudentId(223344);
    System.out.println(person);

    //creates buzz
    StudentId toyman = new StudentId("Buzz", "Lightyear", 123456);
    System.out.println(toyman);

    //returns individual buzz info
    System.out.println(toyman.getStudentFirstName() + " " + toyman.getStudentLastName());
    System.out.println("ID = " + toyman.getStudentId());
    System.out.println("Password = " + toyman.getPassword());
    
  }
}