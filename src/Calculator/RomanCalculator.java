package Calculator;

import java.io.Serializable;

public class RomanCalculator implements Serializable {
    String operation;

    public RomanCalculator() {
    }
    public RomanCalculator(String operation) {
        this.operation = operation;
    }

    public String getRomanOperation() {
        try {
            if (operation.equals("I+II") || operation.equals("II+I")) {
                System.out.println("=III");
            } else if (operation.equals("I+III") || operation.equals("III+I")) {
                System.out.println("=IV");
            } else if (operation.equals("I+V") || operation.equals("V+I")) {
                System.out.println("=VI");
            } else if (operation.equals("I+VI") || operation.equals("VI+I")) {
                System.out.println("=VII");
            } else if (operation.equals("I+VII") || operation.equals("VII+I")) {
                System.out.println("=VIII");
            } else if (operation.equals("I+VIII") || operation.equals("VIII+I")) {
                System.out.println("=IX");
            } else if (operation.equals("=I+IX") || operation.equals("IX+I")) {
                System.out.println("=X");
            } else if (operation.equals("I+X") || operation.equals("X+I")) {
                System.out.println("=XI");
            } else {
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }


    public void getRomanDeduction() {
        try {
            if (operation.equals("I-II") || operation.equals("II+I")) {
                System.out.println("=III");
            } else if (operation.equals("I+III") || operation.equals("III+I")) {
                System.out.println("=IV");
            } else if (operation.equals("I+V") || operation.equals("V+I")) {
                System.out.println("=VI");
            } else if (operation.equals("I+VI") || operation.equals("VI+I")) {
                System.out.println("=VII");
            } else if (operation.equals("I+VII") || operation.equals("VII+I")) {
                System.out.println("=VIII");
            } else if (operation.equals("I+VIII") || operation.equals("VIII+I")) {
                System.out.println("=IX");
            } else if (operation.equals("=I+IX") || operation.equals("IX+I")) {
                System.out.println("=X");
            } else if (operation.equals("I+X") || operation.equals("X+I")) {
                System.out.println("=XI");
            } else {
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
