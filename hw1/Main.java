import java.util.*;

public class Main {

    public static void main(String[] args) {
        int numberOfRows;
        int inputNumber;
        //Shape rowOfStars = new Shape();
        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter the number of rows: ");

        inputNumber = sc.nextInt();
        Shape rowOfStars = new Shape(inputNumber);
        numberOfRows = inputNumber;
        for (int i = 0; i < numberOfRows; i++) {
            System.out.print("Please enter the number of stars for row " + (i + 1) + ": ");
            inputNumber = sc.nextInt();
            
            rowOfStars.draw(inputNumber);

        }
    }
}
