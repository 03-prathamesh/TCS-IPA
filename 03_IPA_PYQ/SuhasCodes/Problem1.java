import java.util.*;


public class Problem1 {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();

        int temp=n;
        int ans=0;
        while(temp!=0){
            int tp=temp%10;
            if(tp%2!=0){
                ans++;
            }
            temp=temp/10;
        }
        if(ans>=3){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }
    }
}
