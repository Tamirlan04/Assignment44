import java.util.Scanner;
public class T27 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] arr = new String[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = s.nextLine();
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] != null && arr[i].equals(arr[j])) {
                    arr[j] = null;
                    arr[i] = null;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }
}