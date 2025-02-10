import java.util.Scanner;
public class T228 {
    public static void main(String[] args){
        Scanner s = new Scanner (System.in);
        long a = s.nextLong();
        System.out.println(cube(a));
    }
    public static long cube(long a){
        return a*a*a;
    }
}
