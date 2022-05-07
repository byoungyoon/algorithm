package test;

public class Test6 {
    public static void main(String[] args) {
        int[] money = { 90, 0, 0, 95, 1, 1 };

        // int answer = 0;
        int[] type1 = new int[money.length];
        int[] type2 = new int[money.length];

        type1[0] = money[0];
        type1[1] = 0;
        type2[1] = money[1];

        for (int i = 2; i < money.length; i++) {
            type1[i] = Math.max(type1[i - 2] + money[i], type1[i - 1]);
            type2[i] = Math.max(type2[i - 2] + money[i], type2[i - 1]);
        }

        System.out.println(Math.max(type1[money.length - 2], type2[money.length - 1]));
    }
}
