import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command;
        double balance;
        double interest;
        double feeRate;
        System.out.print("Enter the initial balance for the savings account: ");
        balance = sc.nextDouble();
        System.out.print("Enter the interest rate for the savings account: ");
        interest = sc.nextDouble();
        SavingsAccount sav = new SavingsAccount(balance, interest);
        System.out.print("Enter the initial balance for the checking account: ");
        balance = sc.nextDouble();
        System.out.print("Enter the withdrawal fee for the checking account: ");
        feeRate = sc.nextDouble();
        CheckingAccount chk = new CheckingAccount(balance, feeRate);
        System.out.print("Type in a command for futher actions; type 'q' to quit, or 'man' to read the commands: ");
        command = sc.next();
        while (!command.equals("q")) {

            if (command.equals("man")) {
                Main.manpage();

            } else if (command.equals("sd")) {
                System.out.println("Now enter the value you want to debit");
                sav.debit(sc.nextDouble());

            } else if (command.equals("sb")) {
                System.out.println("The balance for the savings account is : " + sav.getBalance());


            } else if (command.equals("si")) {
                sav.applyInterest();

            } else if (command.equals("sc")) {
                System.out.println("Now enter the value you want to debit");
                sav.credit(sc.nextDouble());

            } else if (command.equals("cb")) {
                System.out.println("The balance for the checking account is : " + chk.getBalance());

            } else if (command.equals("cd")) {
                System.out.println("Now enter the value you want to debit");
                
                chk.debit(sc.nextDouble());

            } else if (command.equals("cc")) {
                System.out.println("Now enter the value you want to credit");
                chk.credit(sc.nextDouble());
                
            } else {
                System.out.println("[You typed a incorrect command; type 'man' if you're not sure]");
            
            }

            System.out.println("[Now enter the next command]");
            command = sc.next();
        }
    }

    public static void manpage() {
        System.out.println("[Type the command first, then press the enter key]");
        System.out.println("[sd: debits money from the savings account]");
        System.out.println("[sb: retrieves the balance of the savings account]");
        System.out.println("[sc: credits money into the savings account]");
        System.out.println("[si: applies interest to the savings account]");
        System.out.println("[cd: debits money from the checking account]");
        System.out.println("[cb: retrieves the balance of the checking account]");
        System.out.println("[cc: credits money into the checking account]");
      
    }
}