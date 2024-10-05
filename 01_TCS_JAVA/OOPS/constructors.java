import java.nio.ReadOnlyBufferException;

class Rectangle{

    private int length;
    private int breadth;


    //lets write the public constructor to set the values of the class properties length and breadth
    public Rectangle(){
        length=1;
        breadth=1;
    }

    // now parameterised constructor
    public Rectangle(int l, int b){
        length=l;
        breadth=b;
    }

    public int Area(){
        return length*breadth;
    }
}




public class constructors {
    public static void main(String[] args){
         //lets create object of class Rectangle
        // Rectangle r=new Rectangle(); default constructor will be called as soon as we are creating the object
        Rectangle r=new Rectangle(10,20);

        int area=r.Area();
        System.out.println("The area of reactangle: "+area);

    }
}
