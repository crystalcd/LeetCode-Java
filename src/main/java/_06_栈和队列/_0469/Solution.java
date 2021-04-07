package _06_栈和队列._0469;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 496. 下一个更大元素 I
 */
public class Solution {
    /**
     * 先求出nums2对应位置的下一个更大元素，再将num2的每个元素跟索引建立映射，再根据映射求出nums1的下一个更大元素
     *
     *  把数组的元素想象成并列站立的人，元素大小想象成人的身高。这些人面对你站成一列，
     *  如何求元素「2」的 Next Greater Number 呢？很简单，如果能够看到元素「2」，
     *  那么他后面可见的第一个人就是「2」的 Next Greater Number，
     *  因为比「2」小的元素身高不够，都被「2」挡住了，第一个露出来的就是答案。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
        int[] res = new int[nums2.length];
        Map<Integer,Integer> value2Index = new HashMap<>();
        // 倒着往栈里面放
        for(int i=nums2.length-1;i>=0;i--) {
            value2Index.put(nums2[i],i);
            // 判定个子高矮
            while (!s.isEmpty()&&s.peek()<=nums2[i]) {
                // 矮个起开，反正也被挡着了。。。
                s.pop();
            }
            // nums[i] 身后的 next great number
            res[i] = s.isEmpty()?-1:s.peek();
            s.push(nums2[i]);
        }
        int[] rs = new int[nums1.length];
        for(int i=0;i<nums1.length;i++) {
            rs[i] = nums2[value2Index.get(nums1[i])];
        }
        return rs;
    }
}
