import java.util.Scanner;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.helpers.DefaultHandler;
public class Main {

   public static void main(String[] args) throws Exception {
    SAXParserFactory factory = SAXParserFactory.newInstance();
    SAXParser saxParser = factory.newSAXParser();
    Scanner sc = new Scanner(System.in);
    String input;
    File f;
    
    do {
    System.out.print("Enter the name of the xml file name including the file extension: ");
    input = sc.next();
    f = new File(input);
    if (!f.exists()){
        System.out.println("You entered a file name that doesn't exist");
    }
    } while (!f.exists());

    DefaultHandler dh = new MyHandler();

    saxParser.parse(f, dh);
    
       //System.out.println("Now enter the class you want to search");
       //input = sc.next();
       
       
       
       
   }
   
  }
