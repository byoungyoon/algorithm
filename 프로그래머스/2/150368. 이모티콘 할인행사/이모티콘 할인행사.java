import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
  Queue<int[]> permList = new LinkedList<>();
    
  public int[] solution(int[][] users, int[] emoticons) {
    int[] discount = { 10, 20, 30, 40 };

    int count = 0;
    int plus = 0;

    permutation(discount, new int[emoticons.length], 0, emoticons.length);

    while (!permList.isEmpty()) {
      int[] curr = permList.poll();
      int cCount = 0;
      int cPlus = 0;

      for (int i = 0; i < users.length; i++) {
        int sCount = 0;

        for (int j = 0; j < emoticons.length; j++) {
          if (curr[j] < users[i][0]) continue;

          sCount += discount(emoticons[j], curr[j]);
        }

        if (sCount >= users[i][1]) cPlus++; else cCount += sCount;
      }

      if (cPlus > plus) {
        plus = cPlus;
        count = cCount;
      } else if (cPlus == plus) {
        count = Math.max(count, cCount);
      }
    }

    return new int[] { plus, count };
  }
    
  public void permutation(int[] input, int[] output, int depth, int r) {
    if (depth == r) {
      permList.offer(output.clone());
      return;
    }

    for (int i = 0; i < input.length; i++) {
      output[depth] = input[i];
      permutation(input, output, depth + 1, r);
    }
  }

  public int discount(int count, int discount) {
    return count * (100 - discount) / 100;
  }
}