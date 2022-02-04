
# 算法练习

总体按照 [代码随想录](https://www.programmercarl.com/) 的顺序练习

穿插补充 [labuladong的算法小抄](https://labuladong.gitee.io/) 、[左程云](https://github.com/algorithmzuo ) 老师的算法课例子和模版以及自己的思考与总结

其余引用也在对应部分给出链接，感谢前辈们的总结使后来者的路更加宽广。

如果您能在我的仓库留下一颗🌟 这是我的荣幸。

## 本仓库解析特点

目前大多数的算法解析都是动图或者是可控制翻页的ppt，但我本人在使用时感觉到些许不适应（因为不是自己主动思考程序运行过程，是被别人"带"着思考的），个人认为还是自己手动模拟实际的程序运算过程更好理解这个算法（左老师上课总会手动给出例子解析，感觉这种教学方法比较容易理解）。 

所以在做题目解析与总结时，会尽量附上例子，并实际模拟其运算过程，然后通过各种用例来完善程序。

毕竟，我只是一个菜鸟，无法像大佬一样，避过所有坑一步AC。

但，我也相信，通过不断的练习与总结，是可以达到大佬的一部分的水平的。

愿吾与诸君共勉 


## 补充

:ok_hand:  表示**已完成,并有相应的总结**;

[个人在 CSDN 上的算法学习笔记 ](https://blog.csdn.net/qq_41852212/article/details/120628784)

[左老师算法课学习建议](http://erdengk.top/archives/zuo-lao-shi-suan-fa-ke-xue-xi-jian-yi)


> **尚未完成，因为生命不息，学习不止，持续更新中...!**

## 已完成的总结
1. [总结： 你知道二分法的坑吗](http://erdengk.top/archives/er-fen-fa)
2. [滑动窗口总结 1 ](http://erdengk.top/archives/windows1)
3. [滑动窗口总结 2 ](http://erdengk.top/archives/sui-xiang-lu-3)
4. [矩阵打印总结](http://erdengk.top/archives/sui-xiang-lu-4)
5. [反转链表总结](http://erdengk.top/archives/sui-xiang-lu-5)
6. [环形链表总结](http://erdengk.top/archives/sui-xiang-lu-6)
7. [环形链表相关问题(解决下面这几个问题)](http://erdengk.top/archives/sui-xiang-lu-6-1) 
8. [总结：nSum 问题重点是去重](http://erdengk.top/archives/sui-xiang-lu-7) 
9. [前缀和数组](http://erdengk.top/archives/sui-xiang-lu-10--fan-wai)


## 数组

<details>
<summary>二分法</summary>

- [704. 二分查找](https://leetcode-cn.com/problems/binary-search/)
- [34. 在排序数组中查找元素的第一个和最后一个位置](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
- :ok_hand: [总结： 你知道二分法的坑吗](http://erdengk.top/archives/er-fen-fa)
- [仓库代码](https://github.com/erdengk/codeExercise/blob/main/src/daily/exercise/LeetCodeArray/Search.java)

</details><br>

<details>
<summary>移除元素</summary>

- [27. 移除元素](https://leetcode-cn.com/problems/remove-element/)
- [删除有序数组中的重复项（简单）](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)
- [删除排序链表中的重复元素（简单）](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/)
- [移动零（简单）](https://leetcode-cn.com/problems/move-zeroes/)
- [仓库代码](https://github.com/erdengk/codeExercise/blob/main/src/daily/exercise/LeetCodeArray/RemoveElement.java)

</details><br>

<details>
<summary>有序数组的平方</summary>

- [977. 有序数组的平方](https://leetcode-cn.com/problems/squares-of-a-sorted-array/)

</details><br>


<details>
<summary>滑动窗口</summary>



### 练习：

注：以下目录整理来自 [wiki](https://github.com/SharingSource/LogicStack-LeetCode/wiki/%E6%BB%91%E5%8A%A8%E7%AA%97%E5%8F%A3) 与官方推荐 按推荐顺序排列


#### easy：


| 题目                                                         | 题解                                                         | 推荐度 | 备注 |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------ | ---- |
| [ 594. 最长和谐子序列](https://leetcode-cn.com/problems/longest-harmonious-subsequence/) | [题解](https://leetcode-cn.com/problems/longest-harmonious-subsequence/solution/hua-dong-chuang-kou-by-erdengk-cb5v/) | 4🌟     |      |
| [643. 子数组最大平均数 I](https://leetcode-cn.com/problems/maximum-average-subarray-i/) | [题解](https://github.com/erdengk/codeExercise/blob/main/src/daily/exercise/LeetCodeArray/window/FindMaxAverage.java) | 5🌟     |      |


#### mid：


| 题目                                                         | 题解                                                         | 推荐度 | 备注 |
| :----------------------------------------------------------- | ------------------------------------------------------------ | ------ | ---- |
| [3. 无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/) | [题解](https://github.com/erdengk/codeExercise/blob/main/src/daily/exercise/LeetCodeArray/window/LengthOfLongestSubstring.java) | 5🌟     |      |
| [187. 重复的DNA序列](https://leetcode-cn.com/problems/repeated-dna-sequences/) |                                                              | 4🌟     |      |
| [1423. 可获得的最大点数](https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards/) |                                                              | 4🌟     |      |
| [424. 替换后的最长重复字符](https://leetcode-cn.com/problems/longest-repeating-character-replacement/) |                                                              | 4🌟     |      |
| [438. 找到字符串中所有字母异位词](https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/) |                                                              | 4🌟     |      |
| [567. 字符串的排列](https://leetcode-cn.com/problems/permutation-in-string/) |                                                              | 3🌟     |      |
| [1004. 最大连续1的个数 III](https://leetcode-cn.com/problems/max-consecutive-ones-iii/) |                                                              | 3🌟     |      |
| [1052. 爱生气的书店老板](https://leetcode-cn.com/problems/grumpy-bookstore-owner/) |                                                              | 3🌟     |      |
| [1208. 尽可能使字符串相等](https://leetcode-cn.com/problems/get-equal-substrings-within-budget/) |                                                              | 3🌟     |      |
| [220. 存在重复元素 III](https://leetcode-cn.com/problems/contains-duplicate-iii/) |                                                              | 3🌟     |      |
| [1438. 绝对差不超过限制的最长连续子数组](https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/) |                                                              | 3🌟     |      |
| [1838. 最高频元素的频数](https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element/) |                                                              | 3🌟     |      |
| [904. 水果成篮 （mid）](https://leetcode-cn.com/problems/fruit-into-baskets/) |                                                              |        |      |
| [76. 最小覆盖子串 （hard）](https://leetcode-cn.com/problems/minimum-window-substring/) |                                                              |        |      |
| [209. 长度最小的子数组 （mid）](https://leetcode-cn.com/problems/minimum-size-subarray-sum/) | [题解](https://github.com/erdengk/codeExercise/blob/main/src/daily/exercise/LeetCodeArray/MinSubArrayLen.java) |        |      |

#### hard：



| 题目                                                         | 题解 | 推荐度 | 备注 |
| ------------------------------------------------------------ | ---- | ------ | ---- |
| [480. 滑动窗口中位数](https://leetcode-cn.com/problems/sliding-window-median/) |      | 5🌟     |      |
| [992. K 个不同整数的子数组](https://leetcode-cn.com/problems/subarrays-with-k-different-integers/) |      | 4🌟     |      |
| [1610. 可见点的最大数目](https://leetcode-cn.com/problems/maximum-number-of-visible-points/) |      | 4🌟     |      |
| [30. 串联所有单词的子串](https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/) |      | 2🌟     |      |
| [632. 最小区间（hard）](https://leetcode-cn.com/problems/smallest-range-covering-elements-from-k-lists/) |      | ？     |      |
| [862. 和至少为 K 的最短子数组](https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k/) | |    4🌟  |



</details>

:ok_hand:  [滑动窗口总结 1 ](http://erdengk.top/archives/windows1)

:ok_hand:  [滑动窗口总结 2 ](http://erdengk.top/archives/sui-xiang-lu-3)


<details>
<summary>矩阵的各种遍历、翻转</summary>


### 螺旋矩阵II 

这部分的推荐度由我自己评估，仅供参考

| 题目                                                         |   推荐度 | 备注 |
| ------------------------------------------------------------ |  ------ | ---- |
| [59. 螺旋矩阵 II](https://leetcode-cn.com/problems/spiral-matrix-ii/) |       4🌟     |      |
| [54. 螺旋矩阵](https://leetcode-cn.com/problems/spiral-matrix/) |       5🌟     |      |
| [剑指 Offer 29. 顺时针打印矩阵](https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/) |       4🌟     |      |
| [之字形打印矩阵](https://github.com/erdengk/codeExercise/blob/main/src/daily/exercise/LeetCodeArray/ArrayPrint/PrintArrayByZ.java)                                           |       5🌟     |      |
| [48. 旋转图像](https://leetcode-cn.com/problems/rotate-image/) |       5🌟     |      |

</details>

:ok_hand:  [矩阵打印总结](http://erdengk.top/archives/sui-xiang-lu-4)



<details>
<summary>前缀和</summary>
- [303. 区域和检索 - 数组不可变](https://leetcode-cn.com/problems/range-sum-query-immutable/)
- [304. 二维区域和检索 - 矩阵不可变](https://leetcode-cn.com/problems/range-sum-query-2d-immutable/)
- [560. 和为 K 的子数组](https://leetcode-cn.com/problems/subarray-sum-equals-k/)
- [1314. 矩阵区域和](https://leetcode-cn.com/problems/matrix-block-sum/)
- [1. 两数之和](https://leetcode-cn.com/problems/two-sum/)
- [1248. 统计「优美子数组」](https://leetcode-cn.com/problems/count-number-of-nice-subarrays/)
</details><br>

:ok_hand:  [【随想录10-番外 】前缀和数组](http://erdengk.top/archives/sui-xiang-lu-10--fan-wai)

<details>
<summary>差分数组</summary>

- [370. 区间加法（中等）](https://leetcode-cn.com/problems/range-addition/)
- [1109. 航班预订统计（中等）](https://leetcode-cn.com/problems/corporate-flight-bookings/)
- [1094. 拼车](https://leetcode-cn.com/problems/car-pooling/)

</details><br>


## 链表

<details>
<summary>反转链表</summary>

- [206. 反转链表](https://leetcode-cn.com/problems/reverse-linked-list/)

- [92. 反转链表 II](https://leetcode-cn.com/problems/reverse-linked-list-ii/)

- [25. K 个一组翻转链表](https://leetcode-cn.com/problems/reverse-nodes-in-k-group/)

</details><br>

:ok_hand:  [反转链表总结](http://erdengk.top/archives/sui-xiang-lu-5)


<details>
<summary>反转链表</summary>

- [141. 环形链表](https://leetcode-cn.com/problems/linked-list-cycle/)

- [142. 环形链表 II](https://leetcode-cn.com/problems/linked-list-cycle-ii/)

:ok_hand: [环形链表总结](http://erdengk.top/archives/sui-xiang-lu-6)

:ok_hand: [环形链表相关问题(解决下面这几个问题)](http://erdengk.top/archives/sui-xiang-lu-6-1)

- 如何证明环形链表有环？
- 为什么双指针一定会在环内相遇？
- 如果快指针一次走三步是否一定相遇？5步呢？n步呢？
- 证明一下上一条
- 为什么此题快慢指针中，快指针比慢指针仅多走一步？为什么这么设置？
- 如何找到入环节点
- 证明一下上面方法的正确性
</details>

:ok_hand: [环形链表总结](http://erdengk.top/archives/sui-xiang-lu-6)

:ok_hand: [环形链表相关问题](http://erdengk.top/archives/sui-xiang-lu-6-1)

<details>
<summary>other</summary>

### 移除链表元素

[203. 移除链表元素](https://leetcode-cn.com/problems/remove-linked-list-elements/)

### 删除链表的倒数第 N 个结点

[19. 删除链表的倒数第 N 个结点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/)

###  两两交换链表中的节点

[24. 两两交换链表中的节点](https://leetcode-cn.com/problems/swap-nodes-in-pairs/)


###  链表相交

[面试题 02.07. 链表相交](https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/)


### 回文链表

[234. 回文链表](https://leetcode-cn.com/problems/palindrome-linked-list/)

###  设计链表

[707. 设计链表](https://leetcode-cn.com/problems/design-linked-list/)

</details><br>

## 哈希表

[242. 有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/)

[349. 两个数组的交集](https://leetcode-cn.com/problems/intersection-of-two-arrays/)

[202. 快乐数](https://leetcode-cn.com/problems/happy-number/)

[454. 四数相加 II](https://leetcode-cn.com/problems/4sum-ii/)

[1. 两数之和](https://leetcode-cn.com/problems/two-sum/)

[15. 三数之和](https://leetcode-cn.com/problems/3sum/)

[18. 四数之和](https://leetcode-cn.com/problems/4sum/)

[383. 赎金信](https://leetcode-cn.com/problems/ransom-note/)

[16. 最接近的三数之和](https://leetcode-cn.com/problems/3sum-closest/)



:ok_hand: [总结：nSum 问题重点是去重](http://erdengk.top/archives/sui-xiang-lu-7)



## 字符串




<details>
<summary>翻转相关 </summary>

[344. 反转字符串](https://leetcode-cn.com/problems/reverse-string/)

[541. 反转字符串 II](https://leetcode-cn.com/problems/reverse-string-ii/)

[151. 翻转字符串里的单词](https://leetcode-cn.com/problems/reverse-words-in-a-string/)

[剑指 Offer 58 - II. 左旋转字符串](https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/)


</details><br>


### other

[28. 实现 strStr()](https://leetcode-cn.com/problems/implement-strstr/)

[剑指 Offer 05. 替换空格](https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/)



### 算法类

[459. 重复的子字符串](https://leetcode-cn.com/problems/repeated-substring-pattern/)





<details>
<summary>双指针法 </summary>

[27. 移除元素](https://leetcode-cn.com/problems/remove-element/)

[344. 反转字符串](https://leetcode-cn.com/problems/reverse-string/)

[剑指 Offer 05. 替换空格](https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/)

[151. 翻转字符串里的单词](https://leetcode-cn.com/problems/reverse-words-in-a-string/)

[206. 反转链表](https://leetcode-cn.com/problems/reverse-linked-list/)

[19. 删除链表的倒数第 N 个结点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/)

[面试题 02.07. 链表相交](https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/)

[142. 环形链表 II](https://leetcode-cn.com/problems/linked-list-cycle-ii/)

[15. 三数之和](https://leetcode-cn.com/problems/3sum/)

[18. 四数之和](https://leetcode-cn.com/problems/4sum/)

</details><br>




## 回溯算法


### 组合问题


<details>
<summary>待选组合无重复元素</summary>

[77. 组合](https://leetcode-cn.com/problems/combinations/)

[216. 组合总和 III](https://leetcode-cn.com/problems/combination-sum-iii/)

[17. 电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/)


</details><br>

<details>
<summary>待选组合无重复元素，但可以多次选取同样的元素</summary>


[39. 组合总和](https://leetcode-cn.com/problems/combination-sum/)

</details><br>


<details>
<summary>待选组合有重复元素，且待选元素只可以被使用一次</summary>


[40. 组合总和 II](https://leetcode-cn.com/problems/combination-sum-ii/)

</details><br>


:okhard: [集合问题总结](http://erdengk.top/archives/sui-xiang-lu-9)


### 分割问题

### 子集问题

### 排列问题

### 棋盘问题

### other



## 图论

### 模版

[遍历](https://github.com/erdengk/code-exercise/blob/main/src/daily/exercise/LeetCodeGraph/Modle.java)

### 拓扑排序

- [207. 课程表](https://leetcode-cn.com/problems/course-schedule/)
- [210. 课程表 II](https://leetcode-cn.com/problems/course-schedule-ii/)



## 贪心

[455. 分发饼干](https://leetcode-cn.com/problems/assign-cookies/)

[376. 摆动序列](https://leetcode-cn.com/problems/wiggle-subsequence/)

[53. 最大子数组和](https://leetcode-cn.com/problems/maximum-subarray/)

---

[1005. K 次取反后最大化的数组和](https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations/)

[55. 跳跃游戏](https://leetcode-cn.com/problems/jump-game/)

[45. 跳跃游戏 II](https://leetcode-cn.com/problems/jump-game-ii/)

[122. 买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)

---

[860. 柠檬水找零](https://leetcode-cn.com/problems/lemonade-change/)

[406. 根据身高重建队列](https://leetcode-cn.com/problems/queue-reconstruction-by-height/)

[134. 加油站](https://leetcode-cn.com/problems/gas-station/)

[135. 分发糖果](https://leetcode-cn.com/problems/candy/)

---

[452. 用最少数量的箭引爆气球](https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/)

[435. 无重叠区间](https://leetcode-cn.com/problems/non-overlapping-intervals/)

[763. 划分字母区间](https://leetcode-cn.com/problems/partition-labels/)

[56. 合并区间](https://leetcode-cn.com/problems/merge-intervals/)

---

[738. 单调递增的数字](https://leetcode-cn.com/problems/monotone-increasing-digits/)

[714. 买卖股票的最佳时机含手续费](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/)

[968. 监控二叉树](https://leetcode-cn.com/problems/binary-tree-cameras/)



## 动态规划

[53. 最大子数组和](https://leetcode-cn.com/problems/maximum-subarray/)

[455. 分发饼干](https://leetcode-cn.com/problems/assign-cookies/)

[376. 摆动序列](https://leetcode-cn.com/problems/wiggle-subsequence/)

---

[1005. K 次取反后最大化的数组和](https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations/)

[122. 买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)

[55. 跳跃游戏](https://leetcode-cn.com/problems/jump-game/)

[45. 跳跃游戏 II](https://leetcode-cn.com/problems/jump-game-ii/)

### 简单动态

### 暴力到动态规划

### 经典题



## 单调栈

[739. 每日温度](https://leetcode-cn.com/problems/daily-temperatures/)

[496. 下一个更大元素 I](https://leetcode-cn.com/problems/next-greater-element-i/)

[503. 下一个更大元素 II](https://leetcode-cn.com/problems/next-greater-element-ii/)

[42. 接雨水](https://leetcode-cn.com/problems/trapping-rain-water/)

[84. 柱状图中最大的矩形](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/)

