import java.util.Scanner;
public class T227 {
    public static void main(String[] args){
        Scanner s =new Scanner(System.in);
        String user = s.nextLine();
        signIn(user);
    }
    public static void signIn(String user){
        if (user.equals("user"))
            return;
        System.out.println("you're welcome " + user);
    }
}
