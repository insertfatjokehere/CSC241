public class Textbook implements Comparable<Textbook> {
  private String name;

  public Textbook(String n) {
    name = n;
  }

  public String toString() {
    return name;
  }

  public int compareTo(Textbook other){
    String oName = other.toString();
/*    if (this.name.matches(oName)){
      return 0;
    } else if (this.name.compareTo(oName) > 0){
      return 1;
    } else {
      return -1;
    }
*/

    return this.name.compareTo(oName);
  }
}
