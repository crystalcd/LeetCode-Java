package _98juc;

public class ThreadD extends Thread{

    private Task mTask;

    public ThreadD(Task tk) {
        mTask = tk;
    }


    @Override
    public void run() {
        Task.printD();
    }
}
