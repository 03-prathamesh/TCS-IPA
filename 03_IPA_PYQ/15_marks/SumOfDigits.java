import java.util.Scanner;

public class SumOfDigits{
    public static void main(String[] args){


         // take an Integer as input and calculate the sum of its digits
        //  if sum is divisible by 3 then print true
         Scanner sc=new Scanner(System.in);
         int num=sc.nextInt();

         int sum=0;
         while(num!=0){
            int temp=num%10;
            sum=sum+temp;
            num=num/10;
         }
        //  System.out.println(sum);
        if(sum%3==0){
            System.out.println("TRUE");
        }
        else{
            System.out.println("FALSE");
        }
    }
}