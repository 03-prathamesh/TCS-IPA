import java.util.Scanner;

public class functions {


    public static void PrintName(){        // function declaration and definition

        System.out.println("My  name is Prathamesh Jitendra Amundkar");
    }

    // anothe function for adding the 2 values
    public static int sum(int a , int b){
        return a+b;
    }

    public static void main(String[] args) {
        

        PrintName();
        Scanner sc=new Scanner(System.in);
        int p=sc.nextInt();
        int q=sc.nextInt();

        System.out.println(sum(p,q));

    }
}
