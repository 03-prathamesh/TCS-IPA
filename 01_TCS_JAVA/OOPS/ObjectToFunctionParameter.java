class Student{


   private int roll_no; //this are accessible only within the class itself
   private String name;

   //lets write the constructor for initializing the class properties(roll_no, name)
   public Student(int roll_no,String name){
       this.roll_no=roll_no;
       this.name=name;
   }

   public Student(int roll_no){
    this.roll_no=roll_no;
   }

   public void setName(String name){
    this.name=name;
   }




   //lets get the details now. private means this function can be acccesisible only within class
   public String  getName(){
       return name;
   }
   
   //lets write the display function to display the properties
   public void DisplayDetails(){
       System.out.println("The roll no of student is: "+roll_no+" and the name of student is: "+getName());
    //    System.out.println("The roll no of student is: "+roll_no+" and the name of student is: "+name);
   }


}

public class ObjectToFunctionParameter{

    public static void main(String [] args){

      
         // lets create array of Student class
         Student s[]=new Student[4];
         s[0]=new Student(01);
         s[0].setName("Prathamesh");
         s[1]=new Student(02,"Prasad Solase");
         s[2]=new Student(03,"Siddhesh Amundkar");
         s[3]=new Student(04,"Sanket katkade");


         //now lets pass this s object to the displayDetails() function
         displayStudentDetails(s);

    }


    public static void displayStudentDetails(Student[] st){ //how to take array of object as parameter input

         for(int i=0;i<st.length;i++){
            st[i].DisplayDetails();
         }
    }



}