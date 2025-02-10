public class T24 {
    public static int[] firstArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    public static int[] secondArray = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
    public static int[] resultArray;

    public static void main(String[] args) {
        resultArray = new int[firstArray.length+ secondArray.length];
        for (int i = 0; i < firstArray.length; i++) {
            resultArray[i] = firstArray[i];
        }
        for (int i = 10; i < (firstArray.length+ secondArray.length); i++) {
            resultArray[i] = secondArray[i-10];
        }
        for (int i = 0; i < resultArray.length; i++) {
            System.out.print(resultArray[i] + ", ");
        }
    }
}