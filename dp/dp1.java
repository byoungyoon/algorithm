package dp;

import java.util.ArrayList;
import java.util.List;

// Leetcode
// Different Ways to Add Parentheses
// https://leetcode.com/problems/different-ways-to-add-parentheses/

public class dp1 {
    public static void main(String[] args){
        // String expression = "2*3-4*5";

        // List<Integer>[][] dp = new ArrayList[expression.length()+1][expression.length()+1];

        // System.out.println(findDifferentWaysToCompute(expression, 0, expression.length(), dp));
    }

    static List<Integer> findDifferentWaysToCompute(String expression, int start, int end, List<Integer>[][] dp){
        if(dp[start][end] != null){
            return dp[start][end];
        }
        boolean present = false;

        List<Integer> result = new ArrayList<>();
        for(int i=start; i<end; i++){
            if(expression.charAt(i) - 48 < 0){
                present = true;
                List<Integer> leftValue = findDifferentWaysToCompute(expression, start, i, dp);
                List<Integer> rightValue = findDifferentWaysToCompute(expression, i+1, end, dp);

                for(int left: leftValue){
                    for(int right: rightValue){
                        result.add(calculateExpression(expression.charAt(i), left, right));
                    }
                }
            }
        }
        if(!present){
            result.add(Integer.valueOf(expression.substring(start, end)));
        }

        dp[start][end] = result;

        return result;
    }

    static int calculateExpression(char operation, int left, int right){
        if(operation == '+'){
            return left + right;
        } else if(operation == '-'){
            return left - right;
        } else{
            return left * right;
        }
    }
}
