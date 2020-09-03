# [19. Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)

## 题目

Given a linked list, remove the n-th node from the end of list and return its head.

Example
```c
Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
```


## 题目大意

给定一个链表，删除从后往前的第几个节点,返回头节点

## 解题思路

双指针 使用两个指针p、q，初始时p和q都指向一个虚拟头节点，遍历链表，p节点向后移动，
当p和q相差为给定n+1时，如果p指向null则删除q后一个节点，
如果不是，继续遍历，p、q节点同时向后移动一个节点