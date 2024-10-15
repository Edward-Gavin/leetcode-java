package com.leetcode.middle;

/**
 * @Author: shiwei10
 * @Date: 2024/10/15 15:35
 * @Description: 208. 实现 Trie (前缀树)
 */
public class Trie {

    boolean isEnd;
    Trie[] next;

    public Trie() {
        isEnd = false;
        next = new Trie[26];
    }

    public void insert(String word) {
        Trie trie = this;
        char[] charArray = word.toCharArray();
        for (char c : charArray) {
            if (trie.next[c - 'a'] == null) {
                trie.next[c - 'a'] = new Trie();
            }
            trie = trie.next[c - 'a'];
        }
        trie.isEnd = true;
    }

    public boolean search(String word) {
        Trie trie = searchPrefix(word);
        return trie != null && trie.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie node = this;
        char[] charArray = prefix.toCharArray();
        for (char c : charArray) {
            if (node.next[c - 'a'] == null) {
                return null;
            }
            node = node.next[c - 'a'];
        }
        return node;
    }
}
