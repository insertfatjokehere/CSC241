public class Course {
  private String number;
  private Course[] prereqs = new Course[5];
  private int pCounter = 0;
  private Textbook[] books = new Textbook[5];
  private int tCounter = 0;


  public Course(String n) {
    number = n;
  }

  public String getNumber() {
    return number;
  }

  
  
  public void addPrereq(Course prereq) {
    prereqs[pCounter++] = prereq;
    //System.out.println("Req course for : " + getNumber() + " is "+ prereqs[pCounter -1].getNumber());
  }

  public void addTextbook(Textbook book) {
    books[tCounter++] = book;
    //  System.out.println("Books for course: " + getNumber() + " is " + books[tCounter -1].toString());
  }

  public String toString() {
    String retVal = "Course: " + number + (tCounter == 0 ? ", No books." : ", textbooks: ");
    for (int i = 0; i < tCounter; i++)
      retVal += books[i].toString() + " ";
    retVal += "\n" + (pCounter == 0 ? "No prerequisites.\n" : "Prerequisites:\n");
    for (int i = 0; i < pCounter; i++)
      retVal += prereqs[i].toString();
    return retVal + "End of course " + number + ".\n";
  }
}


