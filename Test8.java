public class Test8 {
    public static void main(String[] args){
        int x = 1534236469;

        int sol = 0; 
        
        while (x != 0) {
            sol += x % 10;
            int checker = sol;
            
            x /= 10;
            
            if (x != 0) {
                sol *= 10;
                if (sol / 10 != checker) {
                    System.out.println(0);
                }
            }
        }

        System.out.println(sol);
    }   
}
