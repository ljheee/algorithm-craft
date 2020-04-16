#### BST 二叉搜索树
###### 将后序遍历数组，转成BST；
最后一个元素是根，0~len-1小于根的节点，是左子树；
                        大于根的，是右子树；
                        
关键是如何快速查找分界点；
直接遍历：
```
 // 找出 左子树、右子树的分界
int mid = -1;
for (int i = left; i < right; i++) {
    if (postArr[i] < postArr[right]) {
        mid = i;
    }
}

if (mid == -1) {
    // 没有左子树，只有右侧
    head.right = postOrder2BST(postArr, left, right - 1);
} else if (mid == right - 1) {
    // 没有右子树，只有左侧
    head.left = postOrder2BST(postArr, left, right - 1);
} else {
    head.left = postOrder2BST(postArr, left, mid);
    head.right = postOrder2BST(postArr, mid + 1, right - 1);
}
```
mid 是在[left,right-1]找出分界；
但是存在 单边树的情况，没有左子树、或没有右子树；需要判断mid的值；

不用if逻辑结构区分，一套代码搞定；
```
int mid = left - 1;
for (int i = left; i < right; i++) {
    if (postArr[i] < postArr[right]) {
        mid = i;
    }
}

head.left = postOrder2BST(postArr, left, mid);
head.right = postOrder2BST(postArr, mid + 1, right - 1);
```
巧妙之处：mid=left-1 ，是为了兼容 不存在左侧或右侧的情况；

**二分查找：优化**
```
public int binarySearch(int[] ascOrderArr, int target) {
    int left = 0;
    int right = ascOrderArr.length - 1;
    while (left < right) {
        int mid = (left + right) / 2;
        if (ascOrderArr[mid] == target) {
            return mid;
        } else if (ascOrderArr[mid] < target) {
            left = mid + 1;
        } else if (ascOrderArr[mid] > target) {
            right = mid - 1;
        }
    }
    return -1;
}
```
二分mid优化
L+R 可能会溢出int范围，
mid = ll + (rr - ll) / 2;此方法不会；
