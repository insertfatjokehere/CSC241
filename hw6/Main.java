public class Main {

  public static void main(String[] args){
   Textbook a = new Textbook("Apple");
   Textbook b = new Textbook("Bananna");
   Textbook c = new Textbook("Cherry");
   Textbook d = new Textbook("Chocolate");
   // All textbook variables with 2 letters are in the second LinkedList
   Textbook aa = new Textbook("Alpha");
   Textbook bb = new Textbook("Apple");
   Textbook cc = new Textbook("Omega");
   Textbook dd = new Textbook("Beta");
   Textbook ee = new Textbook("Gundam");
   Textbook ff = new Textbook("Zeta"); 
   LinkedList la = new LinkedList(d);
   LinkedList lb = new LinkedList();
   la.insert(a);
   la.insert(c);
   la.insert(b);
   System.out.println(la.toString());
   // la.remove(d);
   //  System.out.println(la.toString());
   lb.insert(bb); 
   lb.insert(aa); 
   lb.insert(ff); 
   lb.insert(ee); 
   lb.insert(dd); 
   lb.insert(cc); 
   System.out.println(lb.toString());
   la.join(lb);
   System.out.println("--- After the join method ---");
   System.out.println(la.toString());
   System.out.println(lb.toString());
  }

}

