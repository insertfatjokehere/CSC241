class CheckingAccount extends Account {

private double fee;


    public CheckingAccount(double accountValue, double feeRate){
        super(accountValue);
        fee = feeRate;

    }
     
    public void debit(double value){
    double totalValue;
    totalValue = value + fee;
    super.debit(totalValue);
    
    }
    
    public void credit(double value){
    double totalValue;
    totalValue = value - fee;
    super.credit(totalValue);
    
    }

}