public class FinallyKeyword{
    public static void main(String [] args){


        int arr[]=new int[5];

        try{
            System.out.println(arr[2]);
        }
        catch(Exception e){
            System.out.println("Handled the exception");
        }
        finally{
            System.out.println("I will run always");
        }

        System.out.println("Bye world");
    }
}