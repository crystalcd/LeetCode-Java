package _05_链表._0237;

import data.struct.linked.ListNode;
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
        ListNode head = ListNode.array2Link(para);
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
        int[] myans = ListNode.link2array(head);
        assertArrayEquals(ans,myans);
    }
    
    static Stream<Arguments> _0237() {
        return Stream.of(
                Arguments.of(new int[]{4,5,1,9},5,new int[]{4,1,9}),
                Arguments.of(new int[]{4,5,1,9},1,new int[]{4,5,9})
        );// 添加测试案例可以拷贝上面的数据修改
    }


}