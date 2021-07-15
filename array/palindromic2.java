package array;

// Leetcode
// Add Two Numbers
// https://leetcode.com/problems/add-two-numbers/submissions/

public class palindromic2 {
    private int[] p;
    private String s;
    private char[] t;

    public palindromic2(String s){
        this.s = s;
        preprocess();
        p = new int[t.length];

        int center = 0;
        int right = 0;
        for(int i=1; i<t.length-1; i++){
            int mirror = 2*center - i;

            if(right > 1)
                p[i] = Math.min(right-i, p[mirror]);
            
            while(t[i + (1 + p[i])] == t[i - (1 + p[i])])
                p[i]++;

            if(i + p[i] > right){
                center = i;
                right = i + p[i];
            }
        }
    }

    private void preprocess(){
        t = new char[s.length()*2 + 3];
        t[0] = '$';
        t[s.length()*2 + 2] = '@';
        for(int i=0; i<s.length(); i++){
            t[2*i + 1] = '#';
            t[2*i + 2] = s.charAt(i);
        }
        t[s.length()*2 + 1] = '#';
    }

    public String longestPalindromicSubString(){
        int length = 0;
        int center = 0;
        for(int i=1; i<p.length; i++){
            if(p[i] > length){
                length = p[i];
                center = i;
            }
        }
        return s.substring((center -1 - length) / 2, (center - 1 + length) / 2);
    }

    public static void main(String[] args){
        String s = "aaa";
        palindromic2 test = new palindromic2(s);
        System.out.println(test.longestPalindromicSubString());
    }
}
