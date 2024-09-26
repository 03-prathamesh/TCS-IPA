import  java.util.Scanner;

public class User_input1 {


    public static void main(String[] args) {
        
           Scanner input_for_all_variables = new Scanner(System.in); //only one Scanner class object is needed for all the variables

           System.out.println("Enter your role number");
           int roll_no=input_for_all_variables.nextInt();
           System.out.println("Enter your name:");
           String name=input_for_all_variables.nextLine();

           System.out.println("Your name is: "+name+"! and your roll no is: "+roll_no);
    }
    
}
