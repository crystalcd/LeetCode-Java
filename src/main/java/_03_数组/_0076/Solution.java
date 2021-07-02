package _03_数组._0076;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串 滑动窗口
 */
public class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> need=new HashMap<>(),window = new HashMap<>();
        // 初始化need字典
        for(int i=0;i<t.length();i++) {
            need.put(t.charAt(i),need.getOrDefault(t.charAt(i),0)+1);
        }
        int l=0,r=0; // 闭区间
        int valid=0;
        int start = 0; //最小字串的开始位置
        int minLen = Integer.MAX_VALUE; // 最小字串的长度
        while(r<s.length()) {
            // 移入的char
            char c = s.charAt(r);
            r++;//右侧扩大
            if(need.containsKey(c)) { // 目标里面需要这个字符
                window.put(c,window.getOrDefault(c,0)+1);
                if(window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 判断是否收缩左侧
            while(valid==need.size()) {
                if(r-l<minLen) { // 比他小 需要更新
                    start = l;
                    minLen = r-l; // 上面r已经+1了;
                }
                char d = s.charAt(l);
                l++;// 左侧缩小
                // 如果移出的字符在需要的里面需要更新窗口 还要更新合法的字符数量
                if(need.containsKey(d)) {
                    if(need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d,window.get(d)-1);
                }
            }

        }
        System.out.println(start+","+minLen);
        return minLen==Integer.MAX_VALUE?"":s.substring(start,start+minLen);
    }
}
