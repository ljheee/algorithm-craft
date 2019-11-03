package com.ljheee.algorithm.tree;

/**
 * 目前 还没有完全实现
 */
public class RedBlackTree {


    public enum Color {
        RED, BLACK
    }

    class Node {
        int data;
        Color color = Color.RED;
        Node left;
        Node right;
        Node parent;

        public Node(int data) {
            this.data = data;
        }
    }


    public void insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
        }

        if (root.data < data) { // insert right
            if (root.right == null) {
                root.right = new Node(data);
            } else {
                insert(root.right, data);
            }
        } else { // insert left
            if (root.left == null) {
                root.left = new Node(data);
            } else {
                insert(root.left, data);
            }
        }
        // 检查：是否需要旋转
    }


    public void leftRotate(Node node) {
        if (node.parent == null) { //node is root
            Node right = node.right;
            node.right = right.left;
            right.left.parent = node;
            node.parent = right;
            right.parent = null;

        } else {//node is not root
            if (node == node.parent.left) {
                node.parent.left = node.right;
            } else {
                node.parent.right = node.right;
            }
            Node right = node.right;
            node.right = right.left;
            right.left.parent = node;
            right.parent = node.parent;
            node.parent = right;
        }
    }

}
