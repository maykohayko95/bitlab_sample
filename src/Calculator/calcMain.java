package Calculator;

import java.util.Scanner;

public class calcMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please, choose calculator type:");
        System.out.println("PRESS [1] TO USE ROMAN CALCULATOR\n" +
                "PRESS [2] TO USE ARABIC CALCULATOR\n" +
                "PRESS [0] TO EXIT");
        String choice = in.next();
        try {
            while(true) {
                if (choice.equals("1")) {
                    System.out.println("PLEASE, USE LATIN LETTERS ONLY");
                    System.out.println("Please, input operation you want to calculate in one line without spaces");
                    String op = in.nextLine();
                    RomanCalculator operation = new RomanCalculator(op);
                    System.out.println(operation.getRomanOperation());
                } else if (choice.equals("2")){
                    System.out.println("PLEASE, USE ARABIC DIGITS ONLY");
                    System.out.println("Please, input operation you want to calculate in one line without spaces");
                    String op = in.nextLine();
                    ArabicCalculator oper = new ArabicCalculator(op);
                    System.out.println(oper.getOperation());
                }else{
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
