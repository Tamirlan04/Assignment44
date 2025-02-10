import java.util.Scanner;
public class T25{
    public static void main(String [] args){
        Scanner s = new Scanner (System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            int num = s.nextInt();
            arr[i] = num;
        }
        if (n %2 == 1){
            for (int i = 0; i < n; i++){
                System.out.print(arr[i] + ",");
                }
        }
        else{
            for (int i = n-1; i >= 0; i--){
                System.out.print(arr[i]+ ", ");
            }
        }
    }
}