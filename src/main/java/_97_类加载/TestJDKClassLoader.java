package _97_类加载;

public class TestJDKClassLoader {
    public static void main(String[] args) {
        // 引导类是c++写的
        System.out.println(String.class.getClassLoader());
        System.out.println(TestJDKClassLoader.class.getClassLoader());
        System.out.println(String.class);
    }
}
