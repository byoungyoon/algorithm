package basic;

import java.util.Scanner;

// 백준
// 21964
// https://www.acmicpc.net/problem/21964

public class basic27 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();

        char[] ch = new char[n];
        ch = str.toCharArray();

        for(int i=n-5; i<n; i++){
            System.out.print(ch[i]);
        }
    }
}
