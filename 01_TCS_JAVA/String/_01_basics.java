public class _01_basics{

    public static void main(String [] args){
             
        String myname="Prathamesh";
        System.out.println(myname);
        myname="Rahul"; // we are not modifying string we are changing the reference only ..... this is imp and this wont give you error
        System.out.println(myname);
        // myname[0]='r'; this will give you error because strings are immutable

    }
}