package tree;

// https://programmers.co.kr/learn/courses/30/lessons/42892

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Tree1 {
    public static void main(String[] args) {
        int[][] nodeinfo = { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 },
                { 2, 2 } };

        Tree1 tree = new Tree1();
        int[][] answer = tree.solution(nodeinfo);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(Arrays.toString(answer[i]));
        }
    }

    static List<Integer> pre = new ArrayList<>();
    static List<Integer> post = new ArrayList<>();

    private int[][] solution(int[][] nodeinfo) {
        Queue<Node> nodes = new PriorityQueue<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));
        }
        Node root = nodes.poll();
        while (!nodes.isEmpty()) {
            onInsert(root, nodes.poll());
        }
        onOrder(root);

        int[][] answer = { pre.stream().mapToInt(i -> i).toArray(), post.stream().mapToInt(i -> i).toArray() };
        return answer;
    }

    // 노드 추가
    private void onInsert(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null)
                parent.left = child;
            else
                onInsert(parent.left, child);
        } else {
            if (parent.right == null)
                parent.right = child;
            else
                onInsert(parent.right, child);
        }
    }

    // 전위, 후위 표기법
    private void onOrder(Node curr) {
        pre.add(curr.index);
        if (curr.left != null) {
            onOrder(curr.left);
        }
        if (curr.right != null) {
            onOrder(curr.right);
        }
        post.add(curr.index);
    }

    class Node implements Comparable<Node> {
        int x;
        int y;
        int index;
        Node left;
        Node right;

        public Node(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            return o.y == this.y ? this.x - o.x : o.y - this.y;
        }
    }
}
