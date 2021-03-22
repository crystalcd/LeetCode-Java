# 数组

## 删除元素
使用两个指针，一个指针用来记录位置，另一个用来遍历。

## 二分法


```java
class Array {
    
    public int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l+(r-l)/2; // 避免整型溢出 不使用(l+r)/2
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}

```