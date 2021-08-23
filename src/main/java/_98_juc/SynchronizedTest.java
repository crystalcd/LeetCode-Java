package _98_juc;

public class SynchronizedTest {

    /**方法
     * 实例方法
     * ACC_SYNCHRONIZED
     * 实例对象
     */
    public synchronized void printA() throws InterruptedException {
        System.out.println("A");
        this.wait();
    }

    /**方法
     * 静态方法
     * class对象
     */
    public static synchronized void printC() {
        System.out.println();
    }

    /**代码块
     * class对象
     * MONITORENTER 进入代码块
     * MONITOREXIT 离开代码块
     */
    public void printB() {
        synchronized (SynchronizedTest.class) {
            System.out.println("B");
        }
    }

    /**代码块
     * 实例对象
     */
    public void printD() {
        synchronized (this) {
            System.out.println("D");
        }
    }
}
