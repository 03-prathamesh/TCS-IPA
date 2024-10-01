public class _01_basics {

    // public static void greet(){ it will also work here
    //     System.out.println("Hi! My name is Prathamesh!");
    // }


    public static void main(String[] args){
        _01_basics obj1=new _01_basics();
        obj1.greet();
    }
    public  void greet(){        // non static method - we need to create instance or object of class to call or execute this method
        System.out.println("Hi! My name is Prathamesh!");
    }
}
