public class T29 {
    public static void main(String[] args) {
        int[][] array = new int[10][];
        for (int i = 0; i < 10; i++) {
            array[i] = new int[i + 1];
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <= i; j++) {
                array[i][j] = i + j;
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}