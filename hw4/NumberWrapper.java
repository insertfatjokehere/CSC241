public class NumberWrapper extends Expression {

  public NumberWrapper(double value){
    a = value;
  }

  @Override
  public double eval(){
    return a;
  }

  

}
