import java.util.Scanner;
public class T26 {
    public static int[] array;
    public static void main(String [] args) throws Exception{
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        array = new int[n];
        for (int i = 0; i < n; i++){
            int num = s.nextInt();
            array[i] = num;
        }
        int max = array[0];
        for (int i = 0; i < array.length; i++){
            if (array[i] > max){
                max = array[i];
            }
        }
        System.out.println(max);
    }
}
