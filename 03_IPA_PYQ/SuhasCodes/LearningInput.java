import java.util.*;

public class LearningInput {
    public static void main(String [] args){

        Scanner sc = new Scanner(System.in);
        
        // Read first int
        System.out.print("Enter first integer: ");
        int firstInt = sc.nextInt();

        // Read second int
        System.out.print("Enter second integer: ");
        int secondInt = sc.nextInt();

        // Read double
        System.out.print("Enter a double: ");
        double doubleValue = sc.nextDouble();


        System.out.print("Enter a int: ");
        int a = sc.nextInt();

         sc.nextLine();
        System.out.print("Enter a string: ");
        String b = sc.nextLine();

        // Consume the newline character left after reading double
        // sc.nextLine(); 

        // Read a full line of text (String)
        // System.out.print("Enter your name: ");
        // String name = sc.nextLine();

        System.out.println("First Integer: " + firstInt);
        System.out.println("Second Integer: " + secondInt);
        System.out.println("Double Value: " + doubleValue);
        // System.out.println("Your Name: " + name);
    }
}
