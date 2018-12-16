package com.ljheee.algorithm.tree.huffmen;

/**
 * Created by lijianhua04 on 2018/12/16.
 */
public class Node implements Comparable<Node> {

    private String chars;//节点存的字符
    private int fre;//权重
    private Node leftNode;
    private Node rightNode;
    private Node parent;


    public String getChars() {
        return chars;
    }

    public void setChars(String chars) {
        this.chars = chars;
    }

    public int getFre() {
        return fre;
    }

    public void setFre(int fre) {
        this.fre = fre;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    @Override
    public int compareTo(Node o) {
        return this.fre - o.fre;
    }
}
