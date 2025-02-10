import java.util.Scanner;
public class T216 {
    public static char[][] array;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        array = new char[height][2 * height - 1];
        for (int i = 0; i < height; i++) {
            int start = height - 1 - i;
            int end = height - 1 + i;
            for (int j = 0; j < array[i].length; j++) {
                if (j >= start && j <= end) {
                    array[i][j] = '#';
                } else {
                    array[i][j] = ' ';
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}