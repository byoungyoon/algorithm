
import java.util.Scanner;

public class conversion {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();
        `
        value = value.replaceAll("[\\[]", "{").replaceAll("[\\]]", "}");
        System.out.println(value);
    }
}
