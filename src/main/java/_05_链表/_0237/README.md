# [237. Delete Node in a Linked List](https://leetcode.com/problems/delete-node-in-a-linked-list/)

## 题目

Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Given linked list -- head = [4,5,1,9], which looks like following:

![](https://assets.leetcode.com/uploads/2018/12/28/237_example.png)

Example 1
```c
Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
```

Example 2
```c
Input: head = [4,5,1,9], node = 1
Output: [4,5,9]
Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
```

## 题目大意

写一个函数来删除一个单链表中的节点(除了尾部)，只给该节点访问权。

## 解题思路

可以将给定节点的下一个节点的值赋给给定节点，然后让给定节点的next为下下个节点。