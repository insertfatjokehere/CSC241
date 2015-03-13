public class LinkedList {

  private Node head;
  private Node tail;
  private int size = 0;

  public LinkedList(String k, Textbook v) {
    append(k,v);
  }

  public LinkedList() {
    clear();
  }

  public String toString() {
    String variable = "";
    for (Node temp = head; temp != null; temp = temp.getNext())
      variable = variable + "> " + temp.getKey() + " , " + temp.getData() + "\n";
    return variable;
  }
  

  public void clear() {
    head = tail = null;
  }

  private void rangeCheck(int index) {
    if (index < 0 || index >= size)
      throw new LLOutOfBoundsException(index + " is out of bounds");
  }


  public void remove(String k){
    // this method is only called if the key exists
    // so all methods dont have to check is
    Node prev = head;
    Node current = prev.getNext();
    // if the first element of the list is the key
    // to remove, change the head to the next element
    // doesnt matter if the next element is either null or tail
    if (head.getKey().equals(k) == true){
      head = head.getNext();
      size--;
      return;
    } 
    // if the next node doesn't equal key
    // transverse to the next Node 
    while (current.getKey().equals(k) == false){
      prev = current;
      current = current.getNext();
    }
    if (current.getKey().equals(k) == true){
      prev.setNext(current.getNext());
      // if the key to remove was the tail of the list
      // make the element before the new tail
      if (prev.getNext() == null){
        tail = prev;
      }
      size--;
      return;
    }
  }

  public void append(String k, Textbook v) {
    if (tail != null) {
      tail.setNext(new Node(k,v));
      tail = tail.getNext();
    } else
      head = tail = new Node(k,v);
    size++;
  }


  public String get(String k) {
    // method is only called when the key is in this list
    Node temp = head;
    if (temp.getKey().equals(k) == false){
      // searches the whole list until the
      for (int counter = 0; counter < size; temp = temp.getNext(), counter++){
       if (temp.getKey().equals(k) == true)
         return temp.getData().toString();
      }
    }
    // if head is key
    return temp.getData().toString();
  }

  public int size() {
    return this.size;
  }

  public boolean isEmpty(){
    if (size == 0)
     return true;
    else
     return false;
  }

  public Node getHead(){
    return head;
  }
}
