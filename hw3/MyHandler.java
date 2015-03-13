import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import java.util.Scanner;

public class MyHandler extends DefaultHandler {

    Course[] csc = new Course[100];
    int cscCounter = 0, currentPosition = 0;
    String outerTag;
    String reqTag;
    String bookTag;
    
   

    @Override
    public void startDocument() {
        System.out.println("Parsing started.");
    }
    
    public void makePrereq(String num){
    PREREQ:
    for (int i = 0; i < csc.length; i++){
      if (num.matches(csc[i].getNumber())){
       csc[currentPosition].addPrereq(csc[i]);
       break PREREQ;
      } else if (csc[i +1] == null && !csc[i].getNumber().matches(num)) {
        csc[i + 1] = new Course(num);
        cscCounter++;
       break PREREQ;
     }
    }
    }
  
  public void makeBook(String name){
    Textbook tempBook = new Textbook(name);
    // Debug
    //  System.out.println("Book : " + tempBook.toString());
    csc[currentPosition].addTextbook(tempBook);
    }
    
   
    @Override
    public void endDocument() {
    Scanner sc = new Scanner(System.in);   
    String input;    


        System.out.println("Parsing ended.");
        System.out.print("Now Enter the course you want to look up [Type 'q' to quit]: ");
        input = sc.next();
        while(!input.equalsIgnoreCase("q")){
        ASKUSER:
        for (int i =0; i < csc.length; i++){
           // System.out.println("Course output : " + csc[i].getNumber());
           if (input.matches(csc[i].getNumber())){
               System.out.println(csc[i].toString());
               //csc[i].toString();
              break ASKUSER;
           } else if (csc[i+1] == null && !csc[i].getNumber().matches(input)){
               System.out.println("Sorry Nothing");
               break ASKUSER;
           } else {
               System.out.println("Searching attemp " + i + "....");
           
           }
               
        }
        
        System.out.println("That's all we can find");
        System.out.print("Now Enter the course you want to look up [Type 'q' to quit]: ");
        input = sc.next();
        
      }

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("xml")) {
            System.out.println("The file is being parsed, please wait...");
        } else if (qName.equals("course")) {
            outerTag = attributes.getValue("number");
           OUTER:
           for (int i =0; i < csc.length; i++){
            if (csc[0] == null){
             csc[cscCounter++] = new Course(outerTag);
             break OUTER;
            } else if (csc[i +1] == null && !csc[i].getNumber().matches(outerTag)){
             csc[i + 1] = new Course(outerTag);
             cscCounter++;
             currentPosition = i+1;
             break OUTER;
            } else if (csc[i].getNumber().matches(outerTag)) {
               currentPosition = i;
               break OUTER;

             }

            } 
            
            //debug
            //System.out.println("Course : " + csc[cscCounter -1].getNumber());
            
           

        } else if (qName.equals("prereq")) {
            reqTag = attributes.getValue("number");

            makePrereq(reqTag);
  
       } else if (qName.equals("textbook")) {
            bookTag = attributes.getValue("name");
            
           makeBook(bookTag);
                      
        }
    }
}
