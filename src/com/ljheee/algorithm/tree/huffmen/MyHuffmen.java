package com.ljheee.algorithm.tree.huffmen;

import java.util.*;

/**
 * 哈弗曼树
 */
public class MyHuffmen {


    class Node implements Comparable<Node> {

        String chars;//节点存的字符
        int fre;//权重
        Node leftNode;
        Node rightNode;
        Node parent;

        @Override
        public int compareTo(Node o) {
            return this.fre - o.fre;
        }
    }


    private Node root;
    private List<Node> leafs;    //叶子节点
    Map<String, Integer> leafsWeight;

    public MyHuffmen(Map<String, Integer> leafsWeight) {
        this.leafsWeight = leafsWeight;
        leafs = new ArrayList<>();
    }

    public void creatTree() {

        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>();
        String[] keys = leafsWeight.keySet().toArray(new String[0]);

        //遍历所有叶子节点并 加入队列
        for (String key : keys) {
            Node node = new Node();
            node.chars = key;
            node.fre = leafsWeight.get(key);

            priorityQueue.add(node);
            leafs.add(node);
        }

        int len = priorityQueue.size();
        for (int i = 1; i <= len - 1; i++) {

            Node n1 = priorityQueue.poll();
            Node n2 = priorityQueue.poll();//取最小的2个，合并成一个

            Node newNode = new Node();
            newNode.fre = n1.fre + n2.fre;
            newNode.chars = n1.chars + n2.chars;
            newNode.leftNode = n1;
            newNode.rightNode = n2;

            n1.parent = newNode;
            n2.parent = newNode;

            priorityQueue.add(newNode);
        }
        root = priorityQueue.poll();
        System.out.println("Huffmen build success!");
    }

    // 遍历生成 所有节点的 哈夫曼编码
    private Map<String, String> codeInfo() {
        Map<String, String> map = new HashMap<>();

        // 从叶子节点开始-向上找到根
        for (Node node : leafs) {
            String c = node.chars;
            String code = "";
            Node start = node;
            do {
                if (start.parent != null && start == start.parent.leftNode) {        //判断是否为左节点
                    code = "0" + code;    //因为是先从叶子节点开始的 所以这里不要放到code后面去加
                } else {
                    code = "1" + code;
                }
                start = start.parent;
            } while (start.parent != null);
            map.put(c, code);
        }
        return map;
    }

    // 由字符 得到哈夫曼编码
    public String getHuffmenCode(String keyWord) {
        Map<String, String> map = codeInfo();
        char[] keys = keyWord.toCharArray();
        StringBuffer buffer = new StringBuffer();
        for (char character : keys) {
            System.out.println(character + ":" + map.get(character+""));
            buffer.append(map.get(character+""));
        }
        return buffer.toString();
    }

    /**
     * 由哈夫曼编码 解码得到明文
     * O(n)
     * @param code
     * @return
     */
    public String deCode(String code) {
        StringBuffer buffer = new StringBuffer();
        char cs[] = code.toCharArray();
        LinkedList<Character> characters = new LinkedList<Character>();
        for (char c : cs) {
            characters.add(c);
        }

        while (characters.size() > 0) {
            Node node = root;
            do {
                Character c = characters.removeFirst();        //每次取第一次字符
                if (c.charValue() == '0') {
                    node = node.leftNode;
                } else {
                    node = node.rightNode;
                }
            } while (node.chars.length() != 1);
            buffer.append(node.chars);
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        //a:3 b:24 c:6 d:20 e:34 f:4 g:12
        //一般可以以某本书为标准，统计每个字出现的次数作为权重表
        map.put("中", 300);
        map.put("午", 24);
        map.put("小", 9);
        map.put("树", 20);
        map.put("林", 85);
        map.put("见", 1);
        map.put(".", 10);

        MyHuffmen huffmenTree = new MyHuffmen(map);
        huffmenTree.creatTree();
        huffmenTree.codeInfo().forEach((k,v)->System.out.println("keyWord:" + k + " code:" + v));
        //keyWord:树 code:0010
        //keyWord:见 code:001110
        //keyWord:林 code:01
        //keyWord:午 code:000
        //keyWord:中 code:1
        //keyWord:. code:00110
        //keyWord:小 code:001111


        System.out.println(huffmenTree.getHuffmenCode("中"));// 1
        System.out.println(huffmenTree.getHuffmenCode("中午"));// 1000

        System.out.println(huffmenTree.deCode("1000"));//中午
    }


}
