public class T226 {
    public static void main (String[] args){
        universalMethod();
        universalMethod(15);
        universalMethod("Hello");
        universalMethod(5, 10);
        universalMethod(true);
        universalMethod(10, "world");
        universalMethod(3.14);
        universalMethod(3.14, 2.71);
        int[] arr = {1, 2, 3, 4, 5};
        universalMethod(arr);
        universalMethod(1, 2, 3);
    }
    public static void universalMethod(){
        System.out.println("no parameters");
    }
    public static void universalMethod(int n){
        System.out.println("int parameter: " + n);
    }
    public static void universalMethod(String s){
        System.out.println("String parameter: " + s);
    }
    public static void universalMethod(int a, int b){
        System.out.println("sum of 2 integers: " + (a + b));
    }
    public static void universalMethod(boolean s){
        System.out.println("boolean parameter: " + s);
    }
    public static void universalMethod(int a, String s){
        System.out.println("int and String parameters: " + a + " " + s);
    }
    public static void universalMethod(double d){
        System.out.println("double parameter: " + d);
    }
    public static void universalMethod(double a, double b){
        System.out.println("sum of 2 doubles: " + (a + b));
    }
    public static void universalMethod(int[] arr){
        System.out.println("array of integers: ");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void universalMethod(int a, int b, int c){
        System.out.println("sum of 3 integers: " + (a + b + c));
    }
}
