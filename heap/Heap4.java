package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// https://programmers.co.kr/learn/courses/30/lessons/42627

public class Heap4 {
    public static void main(String[] args) {
        int[][] jobs = { { 0, 3 }, { 1, 9 }, { 2, 6 } };

        Heap4 heap = new Heap4();
        System.out.println(heap.solution(jobs));
    }

    public class Job implements Comparable<Job> {
        int array, work;

        public Job(int array, int work) {
            this.array = array;
            this.work = work;
        }

        @Override
        public int compareTo(Job o) {
            return this.work - o.work;
        }
    }

    public int solution(int[][] jobs) {
        Queue<Job> q = new PriorityQueue<>();
        for (int[] job : jobs) {
            q.add(new Job(job[0], job[1]));
        }

        int answer = 0;

        int time = 0;
        while (!q.isEmpty()) {
            Job job = q.poll();

            List<Job> temp = new ArrayList<>();
            boolean check = false;
            while (job.array > time) {
                temp.add(job);

                if (q.isEmpty()) {
                    time++;
                    check = true;
                    break;
                }
                job = q.poll();
            }
            q.addAll(temp);

            if (!check) {
                answer += job.work + time - job.array;
                time += job.work;
            }
        }

        return answer / jobs.length;
    }
}
