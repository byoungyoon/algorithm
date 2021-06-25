package rescue;

// Leetcode
// Container With Most Water
// https://leetcode.com/problems/container-with-most-water/

public class rescue17 {
    public static void main(String[] args){
        int[] height = {1,2,4,3};

        int front = 0;
        int back = height.length-1;

        int answer = 0;
        while(front != back){
            int length = height[front] < height[back] ? height[front] : height[back];
            int width = back - front;
            
            answer = answer > length*width ? answer : length*width;
            
            if(height[front] < height[back]){
                front = front + 1;
            } else{
                back = back - 1;
            }

        }

        System.out.println(answer);
    }
}
