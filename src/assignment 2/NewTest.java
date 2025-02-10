import java.util.Scanner;
public class NewTest {
    public int[] array;
    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++){
            int num = s.nextInt();
            array[i] = num;
        }
        NewTest2.sortArray(array);
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}
