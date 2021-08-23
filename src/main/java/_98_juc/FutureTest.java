package _98_juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTest {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        Future<?> submit = es.submit(() -> {

        });
    }
}
