import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        if (n % 2 != 0){
            while (n% 2 == 0){
                n = s.nextInt();
            }
        }
        char el = '8';
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (n - 2 * i); j++) {
                System.out.print(el);
            }
            System.out.println();
        }
        for (int i = 0; i < n/2; i++){
            System.out.print(" ");
        }
        System.out.println(el);
        for (int i = n / 2 - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (n - 2 * i); j++) {
                System.out.print(el);
            }
            System.out.println();
        }
    }
}
