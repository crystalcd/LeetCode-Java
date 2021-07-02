package _98juc;

public class ThreadE extends Thread{

    private Task task;

    public ThreadE(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        this.task.printE();
    }
}
