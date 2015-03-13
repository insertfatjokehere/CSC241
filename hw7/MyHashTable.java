public class MyHashTable {

  private int length = 0;
  private double loadCapacity = .75; 
  private LinkedList[] bucketList;

 
  public MyHashTable(){
    bucketList = new LinkedList[4];
    for (int i = 0; i < bucketList.length; i++)
      bucketList[i] = new LinkedList();
  }

  public MyHashTable(int s){
    bucketList = new LinkedList[s];
    for (int i = 0; i < bucketList.length; i++)
      bucketList[i] = new LinkedList();
  }

  public int size(){
    return length;
  }

  public boolean isEmpty(){
    if (length == 0)
      return true;
    else 
      return false;
  }

  private int hash(String key){
    int hash = Math.abs(key.hashCode() % bucketList.length);
    return hash;
  }

  public String toString(){
    String message = "--- Printing HashTable --- \n";
    for (int i = 0; i < bucketList.length; i++){
      // print statement could be in one line
      // but this makes it easier for someone
      // to read this code in the future
      String list = bucketList[i].toString();
      message = message + "--- HashTable at index " + i + " ---\n"; 
      message = message + "Number of Elements of index are: " + bucketList[i].size() + "\n";
      message = message + list + "\n";
    } 
    return message;
  } 

  public void insert(String k, Textbook v){
    // finds the bucket to place the key-value pair into
    int index = hash(k);
    // Debug
    // System.out.println(index);
    // checks for duplicates
    if (contains(k) == false){
      bucketList[index].append(k , v);
      length++;
    } else {
        throw new MyHashTableException("Key Already Exists");
    }
    // after the pair was added, and if it went above the load capacity
    // the bucketList gets resized 
    if (length >= loadCapacity * bucketList.length)
      resize();
  }

  private void resize(){
    // creates a new array that is twice is big
    LinkedList[] newTable = new LinkedList[bucketList.length * 2];
    for (int k = 0; k < newTable.length; k++){
      newTable[k] = new LinkedList();
    }
    // interate of the whole array to transpose the nodes
    for (int i = 0; i < bucketList.length; i++){
      // if the index has at least one element
      // interate over the linked list
      if (bucketList[i].isEmpty() == false){
        Node temp = bucketList[i].getHead(); 
          for (int j = 0; j < bucketList[i].size(); j++, temp = temp.getNext()){
             // finds the new index to move the nodes to
             // the makes new nodes in the new Hashtable
             int newIndex = Math.abs(temp.getKey().hashCode() % newTable.length);
             newTable[newIndex].append(temp.getKey(), temp.getData());
          } 
      }

    } 
    // where the real magic happens
    bucketList = newTable;
  }

  
  public boolean contains(String k){
    // find index to search
    // Debug
    // System.out.println(k);
    int index = hash(k);
    // Debug
    //  System.out.println(index);
    // if there isnt anything in the index, the value doesn't exist
    if (bucketList[index].isEmpty() == false){
      // checks all nodes in the index
      Node temp = bucketList[index].getHead();
      for (int i = 0; i < bucketList[index].size(); i++, temp = temp.getNext()){
        if (temp.getKey().equals(k) == true) {
          // bingo you found the matching keys
          // you win a brand new car
          return true;
        } else if (i == bucketList[index].size() && temp.getKey().equals(k) == false){
          // you reached the last node and it didnt match
          return false;
        }
      }
    }  
        // there are no nodes in this index
        return false;
    
  }  


  public void remove(String k){
    int index = hash(k);
    if (contains(k) == true){
      bucketList[index].remove(k);
      length--;
    } else {
      // throw new exception
     throw new MyHashTableException("Key does not exist");
    }   
 
  }

  
  public Textbook get(String k){
    int index = hash(k);
    if (contains(k) == false){
       // throw new exception
     throw new MyHashTableException("Key does not exists");
    }
    Textbook book = new Textbook(bucketList[index].get(k));
    return book;
  }


/*
  // method below is for Debugging to see if the resize works properly
  public int arrayLength(){
    return bucketList.length;
  }
*/


}
