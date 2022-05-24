import java.util.ArrayList;
import java.util.List;

public class Test6 {
    public static void main(String[] args){
        String s = "abcxyasdfasdfxyabc";

        List<Integer> index = new ArrayList<>();
        String left = "";
        String right = "";
        for(int i=0; i<s.length()/2; i++){
            left += s.charAt(i);
            right += s.charAt(s.length()-i-1);
            
            String rightValue = "";
            for(int j=right.length()-1; j>=0; j--){
                rightValue += right.charAt(j);
            }
            if(left.equals(rightValue)){
                index.add(i);
                left = "";
                right = "";
            }
            if(i==s.length()/2-1 && !left.equals("")){
                index.add(-1);
            }
        }

        List<String> answer = new ArrayList<>();
        int lastIndex = 0;
        int check = 0;
        for(int i=0; i<index.size(); i++){
            if(index.get(i) == -1){
                int size = (s.length()/2 - lastIndex) * 2;
                answer.add(s.substring(lastIndex, lastIndex+size));
                check = 1;
            } else{
                answer.add(s.substring(lastIndex, index.get(i)+1));
                lastIndex = index.get(i)+1;
            }
        }

        int size = answer.size();
        for(int i=size-check-1; i>=0; i--){
            answer.add(answer.get(i));
        }

        System.out.println(answer);
    }
}
