package dp;

// https://programmers.co.kr/learn/courses/30/lessons/81305

public class dp3 {
    public static void main(String[] args) {
        int k = 3;
        int[] num = { 12, 30, 1, 8, 8, 6, 20, 7, 5, 10, 4, 1 };
        int[][] links = { { -1, -1 }, { -1, -1 }, { -1, -1 }, { -1, -1 }, { 8, 5 }, { 2, 10 }, { 3, 0 }, { 6, 1 },
                { 11, -1 }, { 7, 4 }, { -1, -1 }, { -1, -1 } };

        dp3 dp = new dp3();
        System.out.println(dp.solution(k, num, links));
    }

    Node[] nodes;
    int group;

    private int solution(int k, int[] num, int[][] links) {
        // node 초기화
        nodes = new Node[num.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(num[i]);
        }

        // node 값 정의
        for (int i = 0; i < links.length; i++) {
            nodes[i].setChild(links[i]);

            if (links[i][0] != -1)
                nodes[links[i][0]].setParent(i);
            if (links[i][1] != -1)
                nodes[links[i][1]].setParent(i);
        }

        int root = getRoot();

        // 이진 분석으로 한 그룹당 최대 인원수 구함
        // group의 인원 수는 dfs를 통해 끝 뿌리 부분부터 왼쪽, 오른쪽 노드의 인원 수 비교를 통해 구함
        int left = 0, right = (int) 1e9;
        for (int i = 0; i < num.length; i++)
            left = Math.max(left, nodes[i].getPeople());
        while (left <= right) {
            int mid = (left + right) / 2;
            if (getGroup(mid, root) <= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right + 1;
    }

    // rootNode index 정의
    private int getRoot() {
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].getParent() == -1)
                return i;
        }
        return -1;
    }

    private int getGroup(int limit, int root) {
        group = 0;
        dfs(root, limit);
        return group + 1;
    }

    // 1. 부모 + 왼쪽,오른쪽 노드가 정한 최대 인원 수 보다 작다면 좀 더 부모노드로 이동
    // 2. 부모 + 한쪽 노드가 최대 인원 수 보다 작다면 group + 1
    // 3. 부모가 최대 인원 수 보다 작다면 group + 2
    // 1 -> 3번 순서대로 조건
    private int dfs(int current, int limit) {
        int leftPeople = 0, rightPeople = 0;

        if (nodes[current].getLeft() != -1)
            leftPeople = dfs(nodes[current].getLeft(), limit);
        if (nodes[current].getRight() != -1)
            rightPeople = dfs(nodes[current].getRight(), limit);

        int people = nodes[current].getPeople();

        if (people + leftPeople + rightPeople <= limit)
            return people + leftPeople + rightPeople;

        if (people + Math.min(leftPeople, rightPeople) <= limit) {
            group += 1;
            return people + Math.min(leftPeople, rightPeople);
        }

        group += 2;
        return people;
    }

    // parent : 노드의 부모 index, 없다면 -1
    // left: 노드의 자식
    // right: 노드의 자식
    // people: 노드의 최대 인원수
    class Node {
        private int parent;
        private int left;
        private int right;
        private int people;

        public Node() {
        }

        public Node(int people) {
            this.people = people;
            this.parent = -1;
        }

        public void setParent(int parent) {
            this.parent = parent;
        }

        public int getParent() {
            return this.parent;
        }

        public void setChild(int[] child) {
            this.left = child[0];
            this.right = child[1];
        }

        public int getLeft() {
            return this.left;
        }

        public int getRight() {
            return this.right;
        }

        public int getPeople() {
            return this.people;
        }
    }
}
