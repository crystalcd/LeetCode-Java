# [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)


## 题目

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.

Example 1
```c
Input: s = "()"
Output: true
```

Example 2
```c
Input: s = "()[]{}"
Output: true
```
Example 3
```c
Input: s = "(]"
Output: false
```

Example 4
```c
Input: s = "([)]"
Output: false
```

Example 5
```c
Input: s = "{[]}"
Output: true
```

## 题目大意

给定一个值包含'(',')','[',']',{','}'的字符串，如果左括号和右括号
满足以下条件，就认为这个字符串是一个合法字符串。
1. 左括号必须由相同类型的括号关闭。
   
2. 左括号必须按正确顺序关闭。

## 解题思路

栈，
遍历字符串，每次遇到左括号就入栈，如果遇到右括号，如果栈中一个左括号都没有，直接返回
false，判断栈顶元素与右括号是否为相同类型，如果为相同类型就出栈，不同类型需要入栈.
字符串遍历完成后，如果栈中没有元素则为合法字符串。