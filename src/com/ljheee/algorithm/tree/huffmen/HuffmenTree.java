package com.ljheee.algorithm.tree.huffmen;

import java.util.*;

public class HuffmenTree {

    private Node root;
    private List<Node> leafs;    //叶子节点
    Map<Character, Integer> weights;

    public HuffmenTree(Map<Character, Integer> weights) {
        this.weights = weights;
        leafs = new ArrayList<Node>();
    }

    private void printCode() {
        Map<Character, String> map = codeInfo();
        Character[] keys = weights.keySet().toArray(new Character[0]);
        for (Character character : keys) {
            System.out.println(character + ":" + map.get(character));
        }
    }

    //由哈夫曼编码 解码得到明文
    private String deCode(String str) {
        StringBuffer buffer = new StringBuffer();
        char cs[] = str.toCharArray();
        LinkedList<Character> characters = new LinkedList<Character>();
        for (char c : cs) {
            characters.add(c);
        }
        while (characters.size() > 0) {
            Node node = root;
            do {
                Character c = characters.removeFirst();        //每次取第一次字符
                if (c.charValue() == '0') {
                    node = node.getLeftNode();
                } else {
                    node = node.getRightNode();
                }
            } while (node.getChars().length() != 1);
            buffer.append(node.getChars());
        }
        return buffer.toString();
    }

    // 由字符 得到哈夫曼编码
    private String enCode(String str) {
        Map<Character, String> map = codeInfo();
        char[] keys = str.toCharArray();
        StringBuffer buffer = new StringBuffer();
        for (char character : keys) {
            System.out.println(character + ":" + map.get(character));
            buffer.append(map.get(character));
//			System.out.println(character + ":" + map.get(character));
        }
        return buffer.toString();
    }

    // 遍历生成 所有节点的 哈夫曼编码
    private Map<Character, String> codeInfo() {
        Map<Character, String> map = new HashMap<Character, String>();
        for (Node node : leafs) {
            Character c = new Character(node.getChars().charAt(0));
            String code = "";
            Node start = node;
            do {
                if (start.getParent() != null && start == start.getParent().getLeftNode()) {        //判断是否为左节点
                    code = "0" + code;    //因为是先从叶子节点开始的 所以这里不要放到code后面去加
                } else {
                    code = "1" + code;
                }
                start = start.getParent();
            } while (start.getParent() != null);
            map.put(c, code);
        }
        return map;
    }

    private void creatTree() {
        Character[] keys = weights.keySet().toArray(new Character[0]);
        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>();
        for (Character c : keys) {
            Node node = new Node();
            node.setChars(c.toString());
            node.setFre(weights.get(c));
            priorityQueue.add(node);
            leafs.add(node);
        }
        int len = priorityQueue.size();
        for (int i = 1; i <= len - 1; i++) {        //最后一个不用走，直接合成
            Node n1 = priorityQueue.poll();        //每次加进来都会排序 队列是一个排好序的 从小到大
            Node n2 = priorityQueue.poll();
            Node newNode = new Node();
            newNode.setChars(n1.getChars() + n2.getChars());
            newNode.setFre(n1.getFre() + n2.getFre());
            newNode.setLeftNode(n1);
            newNode.setRightNode(n2);
            n1.setParent(newNode);
            n2.setParent(newNode);

            priorityQueue.add(newNode);
        }
        root = priorityQueue.poll();
        System.out.println("哈夫曼树构建成功");
    }

    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        //a:3 b:24 c:6 d:20 e:34 f:4 g:12
        //一般可以以某本书为标准，统计每个字出现的次数作为权重表
        map.put('中', 300);
        map.put('午', 24);
        map.put('小', 9);
        map.put('树', 20);
        map.put('林', 85);
        map.put('见', 1);
        map.put('。', 10);

        HuffmenTree huffmenTree = new HuffmenTree(map);
        huffmenTree.creatTree();
//        huffmenTree.printCode();
        String str = "中午小树林见";
        System.out.println(huffmenTree.enCode(str));
        //00101111001101101101010
        //1000001111001001001110
        //
        System.out.println(huffmenTree.deCode("1000001111001001001110"));
        //压缩怎么做：
        //String 中午小树林见
        //1000001111001001001110 byte app
        //app 我使用c++写的，没有办法破解的。
    }
}
