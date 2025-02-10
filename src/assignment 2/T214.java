import java.util.Scanner;
public class T214 {
    public static int[][] array = new int[3][3];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        int[] rowSums = new int[3];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                rowSums[i] += array[i][j];
            }
        }
        int[] colSums = new int[3];
        for (int j = 0; j < array[0].length; j++) {
            for (int i = 0; i < array.length; i++) {
                colSums[j] += array[i][j];
            }
        }
        int minSum = rowSums[0];
        for (int sum : rowSums) {
            if (sum < minSum) {
                minSum = sum;
            }
        }
        for (int sum : colSums) {
            if (sum < minSum) {
                minSum = sum;
            }
        }
        System.out.println(minSum);
    }
}