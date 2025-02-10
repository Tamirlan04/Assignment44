public class T213 {
    public static int[][] multipication_table;
    public static void main(String[] args){
        multipication_table = new int[10][10];
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                multipication_table[i][j] = (i+1)*(j+1);
            }
        }
        System.out.println(multipication_table[0][0]);
        System.out.println(multipication_table[1][1]);
        System.out.println(multipication_table[2][2]);
        System.out.println(multipication_table[3][3]);
        System.out.println(multipication_table[4][4]);
        System.out.println(multipication_table[5][5]);
        System.out.println(multipication_table[6][6]);
        System.out.println(multipication_table[7][7]);
        System.out.println(multipication_table[8][8]);
        System.out.println(multipication_table[9][9]);
    }
}