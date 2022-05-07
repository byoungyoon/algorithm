package test;

import java.util.Scanner;

public class Test7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();

        if (n <= 25) {
            System.out.println(s);
        } else {
            if (s.substring(11, s.length() - 11).endsWith(".") && !s.substring(11, s.length() - 11).startsWith(".")) {
                System.out.println(s.substring(0, 11) + "..." + s.substring(s.length() - 11, s.length()));
            } else {
                System.out.println(s.substring(0, 9) + "......" + s.substring(s.length() - 10, s.length()));
            }
        }

        sc.close();
    }
}
