package com.ljheee.algorithm.tree;


class TreeNode {
    public final static int MAX_SIZE = 26;
    char data;
    boolean isEnd = false;
    TreeNode[] childs;

    public TreeNode() {
        childs = new TreeNode[MAX_SIZE];
        isEnd = false;
    }
}

/**
 * 英文字典树
 * 题目：1000w个单词，如何判定某一个词是否在其中？
 */
public class TrieTree {


    public void createTireTree(TreeNode node, String str) {

        char[] d = str.toLowerCase().toCharArray();
        for (int i = 0; i < d.length; i++) {

            int loc = d[i] - 'a';
            if (node.childs[loc] == null) {
                node.childs[loc] = new TreeNode();
                node.childs[loc].data = d[i];
            }
            node = node.childs[loc];
        }
        node.isEnd = true;
    }


    public boolean find(TreeNode node, String str) {

        char[] d = str.toLowerCase().toCharArray();
        for (int i = 0; i < d.length; i++) {

            int loc = d[i] - 'a';
            if (node.childs[loc] != null) {
                node = node.childs[loc];
            } else {
                return false;
            }
        }

        return node.isEnd;
    }

    public static void main(String[] args) {
        TrieTree trieTree = new TrieTree();

        String s[] = {"java", "ps", "php", "ui", "css", "js"};
        TreeNode root = new TreeNode();


        for (String ss : s) {
            trieTree.createTireTree(root, ss);
        }
        System.out.println("created Finished");


        System.out.println(trieTree.find(root, "java"));//true
        System.out.println(trieTree.find(root, "jav"));// false
    }
}
