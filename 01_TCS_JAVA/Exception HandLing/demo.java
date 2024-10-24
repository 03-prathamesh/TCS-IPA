public class demo{
    public static void main(String [] args){


        System.out.println("Hello Guys");
        try{
            int num=5/0;
        }
        catch(ArithmeticException e){
              System.out.println("This is arithmetic exception error");
              System.out.println(e);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            System.out.println(e);
        }
        System.out.println("Bye guys");
    }
}