package array;

import java.util.ArrayList;
import java.util.List;

// 프로그래머스
// [1차] 비밀지도

public class array8 {
    public static void main(String[] args){
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        List<String> answer = new ArrayList<>();

        for(int i=0; i<n; i++){
            String value1 = arr(arr1[i], n);
            String value2 = arr(arr2[i], n);

            String answerValue = "";

            for(int j=0; j<n; j++){
                if(value1.charAt(j) != value2.charAt(j)){
                    answerValue += "#";
                } else{
                    if(value1.charAt(j) == '0' && value2.charAt(j) == '0'){
                        answerValue += " ";
                    } else{
                        answerValue += "#";
                    }
                }
            }

            answer.add(answerValue);
        }

        System.out.println(answer);
    }

    static String arr(int num, int n){
        String value = "";
        while(num > 0){
            value = num % 2 + value;
            num = num / 2;
        }

        while(value.length() != n){
            value = 0 + value;
        }

        return value;
    }
}
