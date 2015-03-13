public class Addition extends Expression {

  public Addition(double first, double second){
    a = first;
    b = second;
    firstHalf = firstHalf + a;
    secondHalf = secondHalf + b;
    eval();
  }

  @Override
  public double eval(){
    answer = a + b;
    // Debug
   return answer;
  }

}
