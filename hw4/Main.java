public class Main {
  
   public static void main(String[] args){
    Expression e = new Multiplication(new Addition(2.0, 3.0), -5);
    System.out.println(e.eval());
    System.out.println(e.toString());
   }

}
