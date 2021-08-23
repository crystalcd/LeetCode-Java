package _98_juc;

public class ThreadA extends Thread{
    private Task task;

    public ThreadA(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        this.task.printA();
    }
}
