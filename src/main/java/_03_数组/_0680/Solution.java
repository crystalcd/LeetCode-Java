package _03_数组._0680;

public class Solution {
    /**
     * 错误解法
     * @param s
     * @return
     */
    public static boolean validPalindrome(String s) {
        int l=0,r=s.length()-1;
        int count=0;
        while(l<=r){
            System.out.println(s.charAt(l)+"-"+s.charAt(r)+" count="+count);
            // 一样
            if(s.charAt(l)==s.charAt(r)) {
                ++l;
                --r;
            }// 不一样 判断删除一个是否可以
            else {
                // 先判断是否可以删除
                if(count==0) { // 可以
                    // 左侧
                    // 这个解法的问题在于 删左侧和删右侧都满足 但是对于后序的子串只有一种情况满足。
                    if(s.charAt(l+1)==s.charAt(r)) {
                        ++l;
                        ++count;
                        // 右侧
                    }else if(s.charAt(l)==s.charAt(r-1)) {
                        --r;
                        ++count;
                    }else {
                        return false;
                    }
                }else { // 不可以
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * 两个指针 一个l指向头 一个r指向尾，每次比对这俩然后++l,++r;一旦遇到不一样的 验证子串[l+1,r]和[l,r-1]，只要有一个是回文就可以
     * @param s
     * @return
     */
    public static boolean validPalindrome1(String s) {
        int l=0,r=s.length()-1;
        while (l<r) {
            if(s.charAt(l)!=s.charAt(r)) {
                return isValid(s,l+1,r)||isValid(s, l,r-1);
            }
            ++l;
            --r;
        }
        return true;
    }

    public static boolean isValid(String s,int l,int r) {
        while(l<r) {
            if(s.charAt(l)!=s.charAt(r)) {
                return false;
            }
            ++l;
            --r;
        }
        return true;
    }
}
