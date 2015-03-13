import java.io.*;
import java.util.*;
public class Main {

   public static void main(String[] args) throws Exception {
      Scanner file = new Scanner(new File("books.txt"));
      Scanner sc = new Scanner(System.in);
      Textbook searchQuery;
      Textbook[] library = new Textbook[30];
      int omega, lIndex, hIndex;
      hIndex = library.length - 1;
      lIndex = 0;
      Sort superSort = new Sort();

      // Loop to add book names from the text file "books" to array
      for (int i = 0; i < library.length; i++){
         
        library[i] = new Textbook(file.nextLine());
         // Debug for showing the books from the .txt file
         // System.out.println("Unsorted Book list " + i + ": " + library[i].toString());


      }

      superSort.quickSort(library, lIndex, hIndex);
      
      // Debug loop to print all contents of library
      for (int  i = 0; i < library.length; i++){
         System.out.println("Sorted Book list " + i + ": " + library[i].toString());
	 if (i == library.length -1)
           System.out.println("All the titles are shown to list the possible searches");
      }
      
      
      System.out.print("Insert the title of the book you're searching for: ");
      searchQuery = new Textbook(sc.nextLine());

      omega = superSort.binarySearch(library, searchQuery, lIndex, library.length);

      if (omega == -1){
         System.out.println("Book not found");
      } else {
          System.out.println("Found book at index : " + omega);
      }

   }
}
