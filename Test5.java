public class Test5 {
    public static void main(String[] args){
        String s = "aaaaabbbbb";
        String t = "ab";

        int answer = 0;

        String value = s;
        while(true){
            int index = value.indexOf(t);
            if(index == -1) break;

            int leftIndex = index - 1;
            int rightIndex = index + t.length();
            
            String left = "";
            String right = "";

            if(leftIndex >= 0){
                left = value.substring(0, leftIndex+1);
            }
            if(rightIndex <= value.length()){
                right = value.substring(rightIndex, value.length());
            }

            value = left + right;

            answer = answer + 1;
        }

        System.out.println(answer);
    }
}
