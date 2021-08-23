package _98_juc;

public class ThreadC extends Thread{
    private Task mTask;

    public ThreadC(Task tk) {
        mTask = tk;
    }


    @Override
    public void run() {
        Task.printC();
    }
}
