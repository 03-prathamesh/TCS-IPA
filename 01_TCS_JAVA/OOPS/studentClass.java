class Student{

     public int rollNo;
     public String name;
     public String Course;
     public int m1,m2,m3;


     public int Total(){

        return m1+m2+m3;
     }
     
     public float average(){

        return (float)Total()/3;
     }

     public char Grade(){
        if(average()>=60){
            return 'A';
        }
        return 'B';
     }

     public void StudentDetails(){
        System.out.println("Student name is: "+name);
        System.out.print("\n");
        System.out.println("Student Course is: "+Course);
        System.out.println("Students total marks is: "+Total());
        System.out.println("Students grade is: "+Grade());
     }


}


public class studentClass {
         public static void main(String[] args) {
              Student s=new Student();   // s is a reference variable that holds the memory address (reference) of the actual object.
              //The object is created by new Student(), and s refers to that object.
              //the object is created in memory by new Student(), and s is just a reference (or pointer) to that object.
              s.name="Prathamesh";
              s.Course="BE";
              s.rollNo=03;
              s.m1=40;
              s.m2=60;
              s.m3=20;
            //   s.Total();
            //   s.average();
            //   s.Grade();
              s.StudentDetails();

         }
}
