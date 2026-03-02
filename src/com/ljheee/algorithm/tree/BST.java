package com.ljheee.algorithm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 二叉搜索树Binary Search Tree
 */
public class BST {


    class Node {
        int value;
        Node left;
        Node right;

        public Node(int v) {
            this.value = v;
        }
    }


    /**
     * 将后序遍历数组，转成BST
     *
     * @param postArr
     * @param left
     * @param right   区间包括right边界
     * @return
     */
    public Node postOrder2BST(int[] postArr, int left, int right) {
        if (left > right) {
            return null;
        }

        Node head = new Node(postArr[right]);

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
        return head;
    }

    public Node postOrder2BST0(int[] postArr, int left, int right) {
        if (left > right) {
            return null;
        }
        Node head = new Node(postArr[right]);

        int mid = left - 1;
        for (int i = left; i < right; i++) {
            if (postArr[i] < postArr[right]) {
                mid = i;
            }
        }

        head.left = postOrder2BST(postArr, left, mid);
        head.right = postOrder2BST(postArr, mid + 1, right - 1);
        return head;
    }


    /**
     * 二分法查找m
     *
     * @param postArr
     * @param left
     * @param right
     * @return
     */
    public Node postOrder2BST1(int[] postArr, int left, int right) {
        if (left > right) {
            return null;
        }

        Node head = new Node(postArr[right]);

        int ll = left;
        int rr = right-1;
        int m = left - 1;
        while (ll < rr) {
            //int mid = (ll + rr) / 2;
            int mid = ll + (rr - ll) / 2;
            if (postArr[mid] < postArr[rr]) {
                m = mid;
                ll = mid + 1;
            } else {
                rr = mid - 1;
            }
        }

        head.left = postOrder2BST(postArr, left, m);
        head.right = postOrder2BST(postArr, m + 1, right - 1);

        return head;
    }


    public List<Integer> postOrder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> list = new ArrayList<>();
        list.addAll(postOrder(root.left));
        list.addAll(postOrder(root.right));
        list.add(root.value);
        return list;
    }




    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 3, 6, 8, 7, 5};

        BST bst = new BST();
        Node newTree = bst.postOrder2BST1(arr, 0, arr.length - 1);

        int[] ints = bst.postOrder(newTree).stream().mapToInt(a -> a.intValue()).toArray();
        System.out.println(Arrays.toString(ints));//[2, 4, 3, 6, 8, 7, 5]

    }


}
