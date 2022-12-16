class Solution {
    private TrieNode trieNode = new TrieNode();
    public int solution(String[] words) {
        Solution trie = new Solution();
        for(String s: words){
            trie.insert(s);
        }

        int answer = 0;
        for(String s: words){
            answer += trie.find(s);
        }
        
        return answer;
    }
    
    private void insert(String key){
        trieNode.insert(key + '\0', 0);
    }

    private int find(String key){
        int size = trieNode.find(key + '\0', 0);

        if(size == 0) return key.length();

        return key.length() - size + 2;
    }
}

class TrieNode{
    private TrieNode[] next = new TrieNode[26];
    private int[] count = new int[26];

    void insert(String string, int depth){
        char current = string.charAt(depth);
        
        if(current == '\0') return;
        
        int idx = charIdx(current);
        if(next[idx] == null){
            next[idx] = new TrieNode();
        } 
        
        count[idx]++;
        next[idx].insert(string, depth+1);
    }

    int find(String string, int depth){
        char current = string.charAt(depth);

        if(current == '\0') return 0;

        int idx = charIdx(current);
        if(count[idx] == 1) return string.length() - depth;

        return next[idx].find(string, depth+1);
    }

    private int charIdx(char c){
        if(c < 'a'){
            c += ('a' - 'A');
        }

        return c - 'a';
    }
}