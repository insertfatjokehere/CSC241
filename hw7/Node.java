public class Node {
  private Textbook value;
  private String key;
  private Node next;

  public Node(String k, Textbook v) {
    value = v;
    key = k;
  }

  public Textbook getData() { return value; }
  
  public String getKey() { return key; }  

  public void setNext(Node n) {
    next = n;
  }

  public Node getNext() { return next; }
}
