public class T211 {
    public static int[][][]multiarray = new int[][][]{{{4, 8, 15}, {16}}, {{23, 42}, {}}, {{1},
            {2}, {3}, {4, 5}}};
    public static void main(String [] args){
        for (int [][] array2D : multiarray){
            for (int [] array1D : array2D){
                for (int item : array1D){
                    System.out.print(item + ", ");
                }
            }
        }
    }
}
