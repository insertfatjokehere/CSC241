class Multiplication extends Expression {

   public Multiplication(double first, double second){
     a = first;
     b = second;
     firstHalf = firstHalf + a;
     secondHalf = secondHalf + b;
     
   }

   @Override
   public double eval(){
     answer = a * b;
     return answer;
   }

   @Override
   public String toString(){
    equation = "(" + firstHalf + " * " + secondHalf + ")"; 
    // Debug
    //System.out.println(equation);
    return equation;
   }
}
