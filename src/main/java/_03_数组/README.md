# 数组

## 双指针
- 双指针主要用于遍历数组，两个指针指向不同的元素，从而协同完成任务。也可以延伸到多个数组的多个指针。 
- 若两个指针指向同一数组，遍历方向相同且不会相交，则也称为滑动窗口(两个指针包围的区域即为当前的窗口)，经常用于区间搜索。
- 若两个指针指向同一数组，但是遍历方向相反，则可以用来进行搜索，待搜索的数组往往是排好序的。
- 快慢指针 Floyd判圈算法
- 滑动窗口 

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

## Java API
```java
Arrays.sort(intervals,(a,b)->a[1]-b[1]); // 改变原数组
Arrays.stream(intervals).sorted((a,b)->a[1]-b[1]); // 不改变原数组

```