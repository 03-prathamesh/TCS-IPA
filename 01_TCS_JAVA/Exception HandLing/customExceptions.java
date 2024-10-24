import java.io.IOException;
import java.util.*;

import javax.naming.InsufficientResourcesException;

public class customExceptions {
    public static void main(String [] args) {


        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        try{
         if(n>100){
            throw new InsufficientBalanceException("Your balance is insufficient");
         }
         else{
            System.out.println("The entered Number is: "+n);
         }
        }catch(InsufficientBalanceException e){
            System.out.println(e.getMessage());
        }


    }
}

class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(String message){
        super(message);
    }
}
