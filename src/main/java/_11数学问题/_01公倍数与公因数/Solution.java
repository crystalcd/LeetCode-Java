package _11数学问题._01公倍数与公因数;

public class Solution {

    /**
     * 最大公因数
     * 辗转相除法
     */
    public int gcdRec(int a,int b) {
        if (b == 0) {
            return a;
        }
        return gcdRec(b, a % b);
    }

    public int gcd(int a, int b) {
        int t =1;
        while (t!=0) {
            t = a%b;
            a=b;
            b=t;
        }
        return a;
    }


    /**
     * 最小公倍数
     */
    public int lcm(int a,int b) {
        return a*b/gcd(a,b);
    }
}

