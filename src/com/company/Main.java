/*package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<User> users = getUsersList();
        while (true) {
            System.out.println("PRESS [1] TO ADD USERS");
            System.out.println("PRESS [2] TO LIST USERS");
            System.out.println("PRESS [3] TO DELETE USERS");
            System.out.println("PRESS [4] TO EXIT");
            String choice = in.next();
            if (choice.equals("1")) {
                System.out.println("Insert ID");
                int id = in.nextInt();

                System.out.println("Insert Login");
                String login = in.next();

                System.out.println("Insert Password");
                String password = in.next();
                users = getUsersList();
                users.add(new User(id,login,password));
                saveUsersList(users);
            }else if(choice.equals("2")){
                users = getUsersList();
                for(User u: users){
                    System.out.println(u.toString());
                }
            }else if(choice.equals("3")){
                System.out.println("Choose user to delete:");
                users = getUsersList();
                for(int i = 0; i< users.size(); i++){
                    System.out.println(i+1+" "+users.get(i).toString());
                }
                int choiceDelete = in.nextInt();
                users.remove(choiceDelete-1);
                saveUsersList(users);
            }else{
                break;
            }
        }
        }

        public static void saveUsersList(ArrayList<User> users){
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("memory.txt"));
                for (User u: users) {
                    bw.write(u.getId() + "\n");
                    bw.write(u.getLogin() + "\n");
                    bw.write(u.getPassword() + "\n");
                }
                bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static ArrayList<User> getUsersList(){
            ArrayList<User> users = new ArrayList<>();
            try {
                BufferedReader br = new BufferedReader(new FileReader("memory.txt"));
                String line;
                while((line = br.readLine()) != null) {
                    int id = Integer.parseInt(line);
                    String login = br.readLine();
                    String password = br.readLine();
                    users.add(new User(id, login, password));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return users;
        }
}

*/










