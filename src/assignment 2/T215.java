import java.util.Scanner;

public class T215 {
    public static int[][] array = new int[3][3];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        int[][] flippedArray = new int[3][3];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                flippedArray[i][j] = array[j][i];
            }
        }
        for (int i = 0; i < flippedArray.length; i++) {
            for (int j = 0; j < flippedArray[i].length; j++) {
                System.out.print(flippedArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}