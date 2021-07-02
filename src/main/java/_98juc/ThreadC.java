package _98juc;

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
