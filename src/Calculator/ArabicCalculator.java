package Calculator;

import java.io.Serializable;

public class ArabicCalculator implements Serializable {
    String operation;

    public ArabicCalculator() {

    }

    public ArabicCalculator(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        try {
            if (operation.equals("1+2") || operation.equals("2+1")) {
                System.out.println("=3");
            } else if (operation.equals("1+3") || operation.equals("3+1")) {
                System.out.println("=4");
            } else if (operation.equals("1+5") || operation.equals("5+1")) {
                System.out.println("=6");
            } else if (operation.equals("1+6") || operation.equals("6+1")) {
                System.out.println("=7");
            } else if (operation.equals("1+7") || operation.equals("7+1")) {
                System.out.println("=8");
            } else if (operation.equals("1+8") || operation.equals("8+1")) {
                System.out.println("=9");
            } else if (operation.equals("1+9") || operation.equals("9+1")) {
                System.out.println("=10");
            } else if (operation.equals("1+10") || operation.equals("10+1")) {
                System.out.println("=11");
            } else {
                System.out.println();
            }
        } catch (Exception e) {

        }
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

}
