
#### 文本匹配
O(n+m)的算法：滚动hash、KMP


###### 滚动hash
重点是两个hash函数：
```
int base = 基数;
long hash1 = 0, hash2 = 0;
hash1 = hash1 * base + a[i];
hash2 = hash2 + a[i]*base^[0~n];


a[i]就是第i个字符；
base^[0~n] : base的次方，从0开始；
```
基数的选择？
base是基数，元素集合中，不重复的个数。

###### 注意
长整型 long的存储范围，可能不断累加而超出边界；
业界的做法是，对结果取模。
参考 https://leetcode.com/problems/shortest-palindrome/discuss/60153/8-line-O(n)-method-using-Rabin-Karp-rolling-hash



#### KMP 

计算next[]
本质就是找出搜索串P 相等的前后缀。“寻找前缀和后缀相等”


https://www.bilibili.com/video/BV1jJ411E7Lm?p=1
next数组
next[i]代表 0~i-1位，前缀和后缀相等的最大长度。

