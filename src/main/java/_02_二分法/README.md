# 二分法
二分查找也常被称为二分法或者折半查找，
每次查找时通过将待查找区间分成两部分并只取一部分继续查找，
将查找的复杂度大大减少。

有时候遇到不能判断取左边还是右边时，可以采用缩小总范围的方式重新取mid；
如--r或者++l;


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