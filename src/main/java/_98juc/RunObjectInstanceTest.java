package _98juc;

public class RunObjectInstanceTest {
    public static void main(String[] args) {
        Task mTaskA = new Task();
        Task mTaskB = new Task();

        ThreadA ta1 = new ThreadA(mTaskA);
        ThreadA ta2 = new ThreadA(mTaskB);

        // ta1 和 tb1竞争一个同一个对象锁
        // ta1 和 ta2不是竞争一个锁
        ThreadB tb1 = new ThreadB(mTaskA);
        ThreadB tb2 = new ThreadB(mTaskB);


        ta1.setName("A1");
        ta2.setName("A2");

        tb1.setName("B1");
        tb2.setName("B2");

        ta1.start();
        ta2.start();
        tb1.start();
        tb2.start();

    }

}
