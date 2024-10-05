import java.util.concurrent.RejectedExecutionHandler;

class Rectangle{


      private int length;
      private int breadth;


      public void setLength(int l){
         length=l;
      } 

      public void setBreadth(int b){
         breadth=b;
      }

      public int  getLength(){
        return length;
      }

      public int getBreadth(){
        return breadth;
      }

      public int area(){  //functions can directly access the var or properties like lenght and breadth of the class
        return breadth*length;
        // return getlength()*getBreadth();
      }

}



public class DataHiding {
    public static void main(String [] args){

        //lets create the object of Rectangle class
        Rectangle r=new Rectangle();
        // as soon as you create object then before initializing the properties of class , its values are 0
        r.setLength(10);
         r.setBreadth(20);
        System.out.println(r.getLength());
        System.out.println(r.getBreadth());
        int areaOfRectangle=r.area();
        System.out.println(areaOfRectangle);
        // r.setLength(10);
        // r.setBreadth(20); it will give values of r.get and r.getbreath as 0 becase we are pringin before intitializing it

    }
}
