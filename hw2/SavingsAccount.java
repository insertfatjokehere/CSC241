class SavingsAccount extends Account {

  private double rate;

  public SavingsAccount(double accountValue, double percentage) {
  super(accountValue);
  rate = percentage;
  }

  public void applyInterest(){
    double interest;
    double balance;
    balance = getBalance();
    interest = balance * rate;
    credit(interest);
  }
  


}