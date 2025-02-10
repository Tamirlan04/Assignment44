public class T22 {
    public static final String ODD = "odd";
    public static final String EVEN = "even";
    public static String[] strings = new String[5];
    public static void main (String[] args){
        for (int i = 0; i< 5;i++){
            if (i%2 ==0){
                strings[i] = EVEN;
            }else{
                strings[i] = ODD;
            }
        }
        System.out.print("index = 0");
        System.out.println(" value = " + strings[0]);
        System.out.print("index = 1");
        System.out.println(" value = " + strings[1]);
        System.out.print("index = 2");
        System.out.println(" value = " + strings[2]);
        System.out.print("index = 3");
        System.out.println(" value = " + strings[3]);
        System.out.print("index = 4");
        System.out.println(" value = " + strings[4]);
    }
}
