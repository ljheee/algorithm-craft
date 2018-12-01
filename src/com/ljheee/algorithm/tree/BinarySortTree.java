package com.ljheee.algorithm.tree;

/**
 * 二叉排序树 就是 二叉搜索树
 */
public class BinarySortTree {

    int n;
    BinarySortTree left;
    BinarySortTree right;

    public BinarySortTree(int n) {
        this.n = n;
        left = null;
        right = null;
    }


    public void insert(BinarySortTree root, int n) {
        if (n > root.n) { //右子树
            if (root.right == null) {
                root.right = new BinarySortTree(n);
            } else {
                insert(root.right, n);
            }
        } else {
            //在左子树
            if (root.left == null) {
                root.left = new BinarySortTree(n);
            } else {
                insert(root.left, n);
            }
        }
    }

    //前序遍万
    public void preOrder(BinarySortTree root) {
        System.out.println(root.n + ",");
        preOrder(root.left);
        preOrder(root.right);
    }

    //中序遍历
    public void inOrder(BinarySortTree root) {
        inOrder(root.left);
        System.out.println(root.n + ",");
        inOrder(root.right);
    }

    // 后序遍历
    public void postOrder(BinarySortTree root) {
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.n + ",");
    }

}
