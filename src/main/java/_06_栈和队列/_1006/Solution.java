package _06_栈和队列._1006;

import java.util.Stack;

public class Solution {
    /**
     * 1006. 笨阶乘
     *  方法一  硬算
     *         后缀表达式
     *         遇到乘除立即算，遇到加减先入栈
     *  方法二 数学公式找规律
     *
     *  学到一个新技能  打表 依托方法一 输入大范围数据找规律
     * @param N
     * @return
     */
    public int clumsy(int N) {
        String[] ops = {"*","/","+","-"};
        Stack<Integer> s= new Stack<>();
        s.push(N);
        int count=0;
        int temp = 0;
        for(int i=N-1;i>0;i++) {
            int opsIndex = count%4;
            if(opsIndex==0) {
                temp = s.pop()*i;
                s.push(temp);
            }else if(opsIndex==1) {
                temp = s.pop()/i;
                s.push(temp);
            }else if(opsIndex==2) {
                s.push(i);
            }else if(opsIndex==3) {
                s.push(-i);
            }
            ++count;
        }
        int rs = 0;
        while(!s.isEmpty()) {
            rs+=s.pop();
        }
        return rs;
    }
}
