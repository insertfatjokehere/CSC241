abstract class Account {
private double accountBalance;

   public Account(double userBalance){
        if (userBalance >= 0.0){
        accountBalance = userBalance;
        } else {
          accountBalance = 0.0;
          System.out.println("The number you entered is invalid and the account value is 0.0");
        }

   }


   protected void credit(double value){
   accountBalance = accountBalance + value;
   }


   protected void debit(double value){

     if(value >= 0 && value <= accountBalance){
       accountBalance = accountBalance - value;
     } else {
        System.out.println("You're withdrawing too much money and the balance has been unchanged");
     }

   }

   final double getBalance(){
       return accountBalance;
   }
}
