package com.sflin.algorithmic.string;

/**
 * Created by MagicFrost.
 *
 * 前缀树
 */
public class Trie {

    private TreeNode node;

    /** Initialize your data structure here. */
    public Trie() {
        node = new TreeNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode node = this.node;
        for (char c:word.toCharArray()){
            if (node.child[c - 'a'] == null){
                node.child[c - 'a'] = new TreeNode();
            }
            node = node.child[c - 'a'];
        }
        node.value = word;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode node = this.node;
        for (char c:word.toCharArray()){
            if (node.child[c - 'a'] == null){
                return false;
            }
            node = node.child[c - 'a'];
        }
        return node.value.equals(word);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode node = this.node;
        for (char c:prefix.toCharArray()){
            if (node.child[c - 'a'] == null){
                return false;
            }
            node = node.child[c - 'a'];
        }
        return true;
    }

    public TreeNode next(char c){
        if ( 'a' <= c && c <= 'z'){
            return node.child[c];
        }
        return null;
    }

    class TreeNode{
        String value;
        TreeNode[] child;

        public TreeNode(){
            value = "";
            child = new TreeNode[26];
        }
    }
}
