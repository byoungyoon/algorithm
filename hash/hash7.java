package hash;

import java.util.HashMap;

// 프로그래머스
// 전화번호 목록

public class hash7 {
    public static void main(String[] args){
        String[] phone_book = {"119", "97674223", "1195524421"};
        
        HashMap<String, Integer> hm = new HashMap<>();
        for(String s: phone_book){
            hm.put(s, 0);
        }
        
        for(String key: hm.keySet()){
            for(int i=1; i<key.length(); i++){
                if(hm.containsKey(key.substring(0,i))){
                    System.out.println(false);
                }
            }
        }

        System.out.println(true);
    }
}
