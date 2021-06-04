import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test7 {
    public static void main(String[] args){
        String dartResult = "1S2D*3T";

        List<Integer> special = new ArrayList<>();
        for(int i=0; i<dartResult.length(); i++){
            if(dartResult.charAt(i) == '*'){
                special.add(i/2);
            } else if(dartResult.charAt(i) == '#'){
                special.add(-1*i/2);
            }
        }
        String[] normal = dartResult.replaceAll("[*#]", "").split("(?<=\\G.{" + 2 + "})");

        int[] answer = new int[normal.length];
        for(int i=0; i<normal.length; i++){
            String[] value = normal[i].split("");
            int pow = 0;
            switch(value[1]){
                case "S":
                    pow = 1;
                    break;
                case "D":
                    pow = 2;
                    break;
                default:
                    pow = 3;
                    break;
            }

            answer[i] = (int)Math.pow(Integer.parseInt(value[0]), pow);
        }
        
        System.out.println(Arrays.stream(answer).boxed().collect(Collectors.toList()));
        System.out.println(Arrays.stream(normal).collect(Collectors.toList()));
    }
}
