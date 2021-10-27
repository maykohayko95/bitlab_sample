package trycatch1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainTryCatch1 {
    public static void main(String[] args) {
        User[] users = new User[5];
        int sum = 0;
        for (int i = 0; i < users.length; i++) {
            users[i] = getUserFromKeyboard();
        }
        for (int i = 0; i < users.length; i++) {
            sum += users[i].getAge();
        }
        System.out.println("Average age: " + (sum / users.length));
        System.out.println("Program finished");
    }

    private static User getUserFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        System.out.println("Input name");
        user.setName(scanner.next());
        System.out.println("Input username");
        user.setUsername(scanner.next());
        System.out.println("Input age");
        try {
            user.setAge(scanner.nextInt());
        } catch (InputMismatchException e) {
            System.out.println("Input Mismatch Exception");
            user.setAge(0);
        }
        return user;
    }
}

