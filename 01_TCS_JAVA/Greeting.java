public class Greeting {
    public static void main(String[] args) {
        // Check if any arguments were passed
        if (args.length > 0) {
            // args[0] contains the first argument (name)
            System.out.println("Hello, " + args[0] + "!");
        } else {
            System.out.println("No name provided.");
        }
    }
}
