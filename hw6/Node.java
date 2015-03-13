public class Node {
  private Textbook data;
  private Node next;
  private Node previous;

  public Node(Textbook d) {
    data = d;
  }

  public Textbook getData() { return data; }
  
  public void setNext(Node n) {
    next = n;
  }
  
  public void setPrev(Node p) {
    previous = p;
  } 

  public Node getPrev() { return previous; }

  public Node getNext() { return next; }
}

