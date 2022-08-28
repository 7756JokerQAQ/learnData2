package Trie_;

import java.util.TreeMap;

public class WordDictionary {
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

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.isWorld = true;
    }

    public boolean search(String word) {
        return match(root, word, 0);
    }

    private boolean match(Node node, String word, int index) {
        if (index == word.length()) {
            return node.isWorld;
        }
        char c = word.charAt(index);
        if (c != '.') {
            if (node.next.get(c) == null) {
                return false;
            }
            return match(node.next.get(c), word, index + 1);
        } else {
            for (char nextChar :
                    node.next.keySet()) {
                if (match(node.next.get(nextChar), word, index + 1))
                    return true;

            }
            return false;
        }
    }
}
