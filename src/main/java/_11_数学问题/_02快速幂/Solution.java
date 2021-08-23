package _11_数学问题._02快速幂;

public class Solution {

    /**
     * 快速幂
     *       (a^n-1) * a (n为奇数)
     * a^n = (a^n/2)*(a^n/2) (n为偶数)
     *       1  n为0
     *
     * @param a
     * @param n
     * @return
     */
    int mod = (int)1e7+7;
    public long qpow(long a, long n) {
        if(n==0) {
            return 1;
        }
        else if(n%2==0) {
            long temp  = qpow(a, n/2);
            return temp*temp%mod;
        }
        else {
            return qpow(a,n-1)*a%mod;
        }
     }
}
