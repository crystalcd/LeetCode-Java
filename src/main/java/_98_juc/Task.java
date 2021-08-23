package _98_juc;

public class Task {
    /**
     * 锁实例对象
     */
    public synchronized void printA() {
        System.out.println("name= "+Thread.currentThread().getName()+" begin");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("name= "+Thread.currentThread().getName()+" end");
    }

    public synchronized void printB() {
        synchronized (this) {
            System.out.println("name= "+Thread.currentThread().getName()+" begin");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("name= "+Thread.currentThread().getName()+" end");
        }
    }

    public static synchronized void printC() {
        System.out.println("name= "+Thread.currentThread().getName()+" begin");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("name= "+Thread.currentThread().getName()+" end");
    }

    public static synchronized void printD() {
        System.out.println("name= "+Thread.currentThread().getName()+" begin");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("name= "+Thread.currentThread().getName()+" end");
    }

    public void printE() {
        synchronized (Task.class) {
            System.out.println("name= "+Thread.currentThread().getName()+" begin");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("name= "+Thread.currentThread().getName()+" end");
        }
    }
}
