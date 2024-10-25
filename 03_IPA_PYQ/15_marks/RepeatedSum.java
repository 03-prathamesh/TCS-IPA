import java.util.*;

public class RepeatedSum{

    static int repeatedSum(int n){

        int ans=n;
        int sum=0;
        while(true){
             
            int temp=ans;
            
            while(temp!=0){
                int tp=temp%10;
                sum=sum+tp;
                temp=temp/10;
            }

            if(sum<=10){
                return sum;
            }
            else{
                ans=sum;
                sum=0;
            }
        }
        
    }
    public static void main(String [] args){
        
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        // sc.nextLine();

        int ans=repeatedSum(n);
        System.out.println(ans);


    }
}