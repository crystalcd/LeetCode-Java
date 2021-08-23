package _98_juc;

import java.io.IOException;

public class ThisScape {
    int num = 8;

    ThisScape() {
        new Thread(()-> System.out.println(this.num)).start();
    }

    public static void main(String[] args) throws IOException {
        new ThisScape();
        System.in.read();
    }
}
