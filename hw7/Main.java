import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String command;
    String userKey;
    String userValue;
    boolean isEmptyPrompt;
    MyHashTable table = new MyHashTable();
    System.out.println("If you need the list of commands, type man");
    System.out.print("Enter a command: ");
    command = sc.next();
    while (!command.matches("q")){
     if (command.matches("man")){
       man();
     } else if (command.matches("p")){
       System.out.println(table.toString());
     } else if (command.matches("i")){ 
       System.out.print("Enter the Key for the new Textbook: ");
       userKey = sc.next();
       System.out.print("Enter the name for the new Textbook: ");
       userValue = reader.readLine();
       if (userValue == null || userValue.equals(""))
         throw new MyHashTableException("The book you entered is blank");
       Textbook userBook = new Textbook(userValue);
       table.insert(userKey, userBook);
     } else if (command.matches("r")){
       System.out.print("Enter the key for the Textbook to be removed: ");
       userKey = sc.next();
       table.remove(userKey);
     } else if (command.matches("g")){
       System.out.print("Enter the key for the Textbook to search: ");
       userKey = sc.next();
       System.out.println(table.get(userKey));
     } else if(command.matches("c")){
       System.out.print("Enter the key to see of the Textbook is in the table : ");
       userKey = sc.next();
       System.out.println(table.contains(userKey));
     } else if (command.matches("e")){
       isEmptyPrompt = table.isEmpty();
       if (isEmptyPrompt == true)
         System.out.println("The table is empty");
       else
         System.out.println("The table is not empty");
     } else if (command.matches("s")){
         for (int i = 0; i < 75; i++)
           System.out.println();
     } else {
       System.out.println("Illegal command");
     }
     System.out.print("Enter a command: ");
     command = sc.next();
      
    } 
  }

  public static void man(){
    System.out.println("[i: insert textbook]");
    System.out.println("[s: clear screen   ]");
    System.out.println("[g: get textbook   ]");
    System.out.println("[r: remove textbook]");
    System.out.println("[c: contains book  ]");
    System.out.println("[p: print table    ]");
    System.out.println("[e: Is table empty?]");
    System.out.println("[q: quit program   ]");

  }

}
