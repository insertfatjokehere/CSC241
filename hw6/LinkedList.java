public class LinkedList {

    private Node head;
    private Node tail;
    private int size = 0;

    public LinkedList(Textbook t) {
        this.append(t);
    }

    public LinkedList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        if (head == null && tail == null) {
            return true;
        } else {
            return false;
        }
    }

    public int length() {
        return size;
    }

    public int contains(Textbook t) {

        if (isEmpty() == true) {
            // if the list is empty, there is no point of searching
            // Debug
            // System.out.println("Linked List is empty");
            return -1;
        } else {
            Node temp = head;
            for (int counter = 0; counter < size; temp = temp.getNext()) {
                if (t.compareTo(temp.getData()) == 0) {
                    return counter;
                }
                counter++;

            }

        }
        // after searching the list, there are no matching textbooks
        return -1;
    }

    public Textbook get(int index) {
        // only used if the the user is searching with an index that doesn't exit
        if (index < 0 || index >= size || isEmpty() == true) {
            throw new LLOutOfBoundsException(index + " is out of bounds");
        } else {
            Node temp = head;
            for (int counter = 0; counter < index; temp = temp.getNext()) {
                counter++;
            }
            Textbook t = temp.getData();
            return t;
        }

    }

    private void append(Textbook t) {
        Node end = new Node(t);
        if (tail != null) {
            tail.setNext(end);
            end.setPrev(tail);
            tail = end;
        } else {
            head = tail = new Node(t);
        }
        size++;
    }

    private void prepend(Textbook t) {
        Node front = new Node(t);
        front.setNext(head);
        head.setPrev(front);
        head = front;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void insert(Textbook t) {
        Node book = new Node(t);
        if (isEmpty() == true || tail.getData().compareTo(t) < 0) {
        // the list is either empty or the tail is alphabetcally lower
            this.append(t);
        } else if(head.getData().compareTo(t) == 0 || tail.getData().compareTo(t) == 0){
        // if the head or tail already have a textbook of the same name 
          throw new LLObjectAlreadyExist(t.toString() + " already exists");
        } else if (head.getData().compareTo(t) > 0) {
        // if the head is alphabetcally higher than the textbook
            this.prepend(t);
        } else {
            Node temp = head;
            // checks the index and the elemnt ahead to if the textbook fit between them alphabetcally
            // then the textbook is insert between and the next nodes are changed to redirect
            for (int counter = 0; counter < length() - 1; temp = temp.getNext(), counter++) {
                if(temp.getData().compareTo(t) == 0 || temp.getNext().getData().compareTo(t) == 0){
                     throw new LLObjectAlreadyExist(t.toString() + " already exists");
                }
                if (temp.getData().compareTo(t) < 0 && temp.getNext().getData().compareTo(t) > 0) {
                    book.setNext(temp.getNext());
                    temp.getNext().setPrev(book);
                    temp.setNext(book);
                    book.setPrev(temp);
                    size++;
                    return;
                }
            }
        }
    }
    
    
    @Override
    public String toString(){
        String message = "Name: " + getClass().getSimpleName() + " Size: " + length() + " Books: " + "\n" + printBooks();
        return message;
    }
    
    private String printBooks(){
      // Method use to print all the textbooks for the toString() method
      Node temp = head;
      String bookList = "";
      for (int counter = 0; counter < length(); counter++, temp = temp.getNext())
        bookList += temp.getData() + "\n";       
       return bookList;     
    }

   public void remove(Textbook t){
     Node temp = head;
     if (isEmpty() == true) { 
       // If the List is empty, dont bother searching
       throw new LLObjectDoesNotExist(t.toString() + " is not in the linked list");
     } else if (head == tail && t.compareTo(temp.getData()) == 0) {
      // if there is only one element in the list, and matches
        head = tail = null;
        size--;
        return;
     } else if (length() == 2){
         if (head.getData().compareTo(t) == 0) {
          // if there is two elements and the head is the textbook to remove
           head = tail;
           size--;
           return;
         } else if (tail.getData().compareTo(t) == 0) {
          // if there are two elements and the tail is the texbook to remove
             tail = head;
             size--;
             return;
         } else {
            // both head and tail are not the textbook to remove and the size is 2
            throw new LLObjectDoesNotExist(t.toString() + " is not in the linked list");
         }

       } else if (head.getData().compareTo(t) == 0) {
             // if the first element is the textbook to remove and the size of the list is 3+
             head = temp.getNext();
             head.setPrev(null);
             size--;
       } else if (tail.getData().compareTo(t) == 0) {
             // if the last element is the textbook to remove, and the size of the list is 3+
             tail = tail.getPrev();
             tail.setNext(null);
             size--;
       } else {
          // Head and tail are not the textbooks to remove, so this for loop apples to the general case
          // that the textbook to remove is within the list
          for (int counter = 0; counter <= length() - 1; counter++, temp = temp.getNext()){
             if (temp.getData().compareTo(t) == 0){
                temp.getPrev().setNext(temp.getNext());
                temp.getNext().setPrev(temp.getPrev());
                size--;
                return;
             } else if (counter == length() - 1 ){
                 throw new LLObjectDoesNotExist(t.toString() + " is not in the linked list");
             }
        }
     }
   }
      

   public void join(LinkedList other){
     int lengthA = length();
     int lengthB = other.length();
     int counterA = 0;
     int counterB = 0;
     Node tempA = head;
     Node tempB = other.head;
     // Check which head goes first in the new list
       if (head != null || other.head != null){
          if (head.getData().compareTo(other.head.getData()) < 0){
             tempA = tempA.getNext();
             tempB = tempB.getNext();
             tempB.getPrev().setNext(tempA);
             tempB.getPrev().setPrev(tempA.getPrev());
             tempA.getPrev().setNext(tempB.getPrev());
             tempA.setPrev(tempB.getPrev());
             size++;
             counterA++;
             counterB++;
          } else if (head.getData().compareTo(other.head.getData()) > 0){
             tempB = tempB.getNext();
             prepend(other.head.getData());
             counterB++;
          } else if (head.getData().compareTo(other.head.getData()) == 0){
             tempB = tempB.getNext();
             counterB++;
          }
       } else {
         throw new LLObjectDoesNotExist("Head(s) appears null");
       }
       // After figuring which is the head, now all the vaules in between the lowest and highest textbook
       // will be joined and sorted 
       // Debug
       // System.out.println("Head : " + head.getData()); 
       // System.out.println("Length : " + length());
       while (counterA <= lengthA - 1 && counterB <= lengthB - 1){
          // Debug
          //  System.out.println("TempA is " + tempA.getData() + " counter: " + counterA);
          //  System.out.println("TempB is " + tempB.getData() + " counter: " + counterB);
         if (tempA.getData().compareTo(tempB.getData()) == 0){
            // Debug
            // System.out.println("TempA and TempB matches, skip to the next NodeB");
           // Skips Nodes that match
           tempB = tempB.getNext();
           counterB++;
         } else if (tempA.getData().compareTo(tempB.getData()) < 0){
             // finds a word that will meet the next condition to place before it
             // i.e. bannana goes before beta, but beta goes before cherry
             // Debug
             //  System.out.println("tempA is lower than tempb, so incrementing A till b is lower than A");
             tempA = tempA.getNext();
             counterA++;
         } else if (tempA.getData().compareTo(tempB.getData()) > 0){
             // places any word that happens before tempA
             // Debug
             // System.out.println("TempB is lower than tempA, tempB is going before tempA");
             tempB = tempB.getNext();
             tempB.getPrev().setPrev(tempA.getPrev());
             tempA.getPrev().setNext(tempB.getPrev());
             tempA.setPrev(tempB.getPrev());
             tempB.getPrev().setNext(tempA);
             counterB++;
             size++;
         }
       }


         if (tempA == tail || tempB.getNext().getData() != null){     
         Textbook[] tempShelf = new Textbook[lengthB - counterB];
           for(int i = 0; i < tempShelf.length; i++, tempB = tempB.getNext())
              tempShelf[i] = tempB.getData();
           for(int k = 0; k < tempShelf.length; k++)
              append(tempShelf[k]); 
         // if the LL A is at the tail && the LL B has more elements
         // this for loop adds all the additional elements at the end
         //int tempCounter = counterB;
//           for (Node temp = tempB; temp != null; temp = temp.getNext()){
       } 

       // Now that LL B has been added to LL A
       // the LL B has to be cleared
       other.tail = other.head = null;
       other.size = 0;
       // Debug 
       // System.out.println("LL B had been nullified and size = 0");


   }

}
