package _06_栈和队列._0020;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (char c :chars) {
            Character value = map.get(c);
            if(value==null) {
                stack.push(c);
            }else {
                if(stack.empty()) {
                    return false;
                }
                Character peek = stack.peek();
                if(value.equals(peek)) {
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }
        }
        if(stack.empty()) {
            return true;
        }else {
            return false;
        }
    }
}
