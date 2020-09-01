package _05_链表._0237;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("_0237")
    void deleteNode(int[] para, int val,int[] ans) {
        ListNode head = array2Link(para);
        Solution solution = new Solution(head);
        ListNode p = head;
        ListNode deleteNode = null;
        while(p!=null) {
            if(p.val== val) {
                deleteNode = p;
                break;
            }
            p = p.next;
        }
        solution.deleteNode(deleteNode);
        int[] myans = link2array(head);
        assertArrayEquals(ans,myans);
    }
    
    static Stream<Arguments> _0237() {
        return Stream.of(
                Arguments.of(new int[]{4,5,1,9},5,new int[]{4,1,9}),
                Arguments.of(new int[]{4,5,1,9},1,new int[]{4,5,9})
        );// 添加测试案例可以拷贝上面的数据修改
    }

    /**
     * 数组转换为链表 返回链表的头节点
     *
     * @param paras
     * @return
     */
    ListNode array2Link(int[] paras) {
        ListNode head = new ListNode(-1);
        ListNode node = null;
        ListNode p = head;
        for (int par : paras) {
            node = new ListNode(par);
            p.next = node;
            p = node;
        }
        return head.next;
    }

    /**
     * 链表转换为数组
     *
     * @param head
     * @return
     */
    int[] link2array(ListNode head) {
        List<Integer> rsList = new ArrayList();
        while (head != null) {
            rsList.add(head.val);
            head = head.next;
        }
        int[] rs = new int[rsList.size()];
        for (int i = 0; i < rs.length; i++) {
            rs[i] = rsList.get(i);
        }
        return rs;
    }
}