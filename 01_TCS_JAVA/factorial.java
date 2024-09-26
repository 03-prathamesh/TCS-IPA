import java.util.Scanner;


public class factorial {




    public static int factorial(int a){

          int n=1;
          for(int i=1;i<=a;i++){
            n=n*i;
          }
          return n;


    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number:");
        int num=sc.nextInt();
        System.out.println(factorial(num));
    }  
    
}
