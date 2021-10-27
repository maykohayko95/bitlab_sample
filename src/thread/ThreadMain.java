package thread;

public class ThreadMain {
    public static void main(String[] args) {
        Operation op1 = new Operation("Add Client to Bank",3);
        Operation op2 = new Operation("Delete Client",2);
        Operation op3 = new Operation("Make a Deposit",2);
        Operation op4 = new Operation("Open Deposit",1);
        Operation op5 = new Operation("Open Credit",3);
        Operation op6 = new Operation("Withdraw Money",5);
        Operation op7 = new Operation("Clear History",4);
        Operation op8 = new Operation("Restore History",7);
        Operation op9 = new Operation("List All Clients",6);
        Operation op10= new Operation("Save New Client",1);
        op1.start();
        op2.start();
        op3.start();
        op4.start();
        op5.start();
        op6.start();
        op7.start();
        op8.start();
        op9.start();
        op10.start();
    }
}
