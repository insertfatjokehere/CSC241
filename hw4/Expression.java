abstract class Expression {
  
  double a, b, answer;
  String equation = "";
  String firstHalf = "";
  String secondHalf = "";

  public double eval(){
    System.out.println(answer +  " super");
    return answer;
  }



  public String toString(){
    return equation;

 }

}
