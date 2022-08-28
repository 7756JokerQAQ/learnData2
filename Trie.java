package Trie_;

import java.util.TreeMap;

public class Trie {
    private class Node {
        public boolean isWorld;
        //Character是个假设 可以适用于不同的情况 能够分为一个一个的单元
        public TreeMap<Character, Node> next;

        public Node(boolean isWorld) {
            this.isWorld = isWorld;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    //像Trie中添加一个新的单词word
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWorld) {
            cur.isWorld = true;
            size++;
        }
    }
    //查询单词 word是否在Trie中
    public boolean contains(String word){
        Node cur=root;
        for (int i = 0; i < word.length(); i++) {
            char c=word.charAt(i);
            if(cur.next.get(c)==null){
                return false;
            }
            cur= cur.next.get(c);
        }
        return cur.isWorld;
    }
    public boolean isPrefix(String prefix){
        Node cur=root;
        for (int i = 0; i < prefix.length(); i++) {
            char c=prefix.charAt(i);
            if(cur.next.get(c)==null)
                return false;
            cur=cur.next.get(c);
        }
        return true;
    }
}
