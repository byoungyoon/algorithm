package rescue;

import java.util.Scanner;

// 백준
// 21965
// https://www.acmicpc.net/problem/21965

public class rescue16 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] value = new int[n];

        String answer = "YES";
        int index = value.length;

        for(int i=0; i<n; i++){
            value[i] = Integer.parseInt(sc.next());
            if(i == 0) continue;

            if(value[i-1] > value[i]) index = i;
        }
        
        int nextChange = 0;
        for(int i=0; i<index; i++){
            if(i == 0) continue;
            if(i == 1){
                nextChange = value[i] - value[i-1];
            } else{
                if(nextChange != value[i] - value[i-1]){
                    answer = "NO";
                    break;
                }
            }
        }

        for(int i=index-1; i<value.length; i++){
            if(i == index-1) continue;
            if(i == index){
                nextChange = value[i] - value[i-1];
            } else{
                if(nextChange != value[i] - value[i-1]){
                    answer = "NO";
                    break;
                }
            }
        }

        if(nextChange == 0) answer = "NO";

        System.out.println(answer);

        sc.close();

    }
}
