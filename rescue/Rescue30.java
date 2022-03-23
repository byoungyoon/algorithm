package rescue;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/42885

public class Rescue30 {
    public static void main(String[] args) {
        int[] people = { 100, 500, 500, 900, 950 };
        int limit = 1000;

        Rescue30 rescue = new Rescue30();
        System.out.println(rescue.solution(people, limit));
    }

    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int answer = 0;
        int max = people.length;

        for (int i = 0; i < max; i++) {
            if (people[i] + people[max - 1] > limit)
                i--;

            max--;
            answer++;
        }

        return answer;
    }
}
