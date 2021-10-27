package thread;

public class Operation extends Thread{
    String operationName;
    int operationTime;

    public Operation(String operationName, int operationTime) {
        this.operationName = operationName;
        this.operationTime = operationTime;
    }
    public void run(){
        try{
            System.out.println("Operation "+this.operationName+": started");
            for(int i=0;i<operationTime;i++){
                System.out.println("Operation "+this.operationName+": "+(i+1)+" seconds");
                Thread.sleep(1000);
            }
            System.out.println("Operation "+this.operationName+": finished");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
