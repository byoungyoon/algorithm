package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LinkedList2 {
    public static void main(String[] args) {
        String[] words = { "frodo", "front", "frost", "frozen", "frame", "kakao" };
        String[] queries = { "fro??", "????o", "fr???", "fro???", "pro?" };

        LinkedList2 linkedList = new LinkedList2();
        System.out.println(Arrays.toString(linkedList.solution(words, queries)));
    }

    private int[] solution(String[] words, String[] queries) {
        Trie[] trie = new Trie[100001];
        for (String word : words) {
            int len = word.length();
            if (trie[len] == null)
                trie[len] = new Trie();
            trie[len].autoInsert(word);
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int len = queries[i].length();
            if (trie[len] == null) {
                answer[i] = 0;
                continue;
            }
            answer[i] = trie[len].autoSearch(queries[i]);
        }

        return answer;
    }
}

class Trie {
    private TrieNode rootNode;
    private TrieNode revRootNode;

    public Trie() {
        this.rootNode = new TrieNode();
        this.revRootNode = new TrieNode();
    }

    public void autoInsert(String word) {
        insert(word);
        revInsert(word);
    }

    public int autoSearch(String query) {
        if (query.charAt(0) == '?')
            return revSearch(query);
        else
            return search(query);
    }

    private void insert(String word) {
        TrieNode thisNode = this.rootNode;
        for (int i = 0; i < word.length(); i++) {
            thisNode.setCount(thisNode.getCount() + 1);
            thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
    }

    private void revInsert(String word) {
        TrieNode thisNode = this.revRootNode;
        for (int i = word.length() - 1; i >= 0; i--) {
            thisNode.setCount(thisNode.getCount() + 1);
            thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
    }

    private int search(String query) {
        TrieNode thisNode = this.rootNode;

        for (int i = 0; i < query.length(); i++) {
            char character = query.charAt(i);
            if (character == '?')
                break;
            if (!thisNode.getChildNodes().containsKey(character))
                return 0;

            thisNode = thisNode.getChildNodes().get(character);
        }

        return thisNode.getCount();
    }

    private int revSearch(String query) {
        TrieNode thisNode = this.revRootNode;

        for (int i = query.length() - 1; i >= 0; i--) {
            char character = query.charAt(i);

            if (character == '?')
                break;
            if (!thisNode.getChildNodes().containsKey(character))
                return 0;

            thisNode = thisNode.getChildNodes().get(character);
        }

        return thisNode.getCount();
    }
}

class TrieNode {
    private Map<Character, TrieNode> childNodes;
    private int count;

    public TrieNode() {
        this.childNodes = new HashMap<>();
        this.count = 0;
    }

    public Map<Character, TrieNode> getChildNodes() {
        return this.childNodes;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}