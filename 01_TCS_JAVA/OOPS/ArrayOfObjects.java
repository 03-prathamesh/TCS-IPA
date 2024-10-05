import java.util.Scanner;

class Subject{

    private int subId;
    private String name; 
    private int maxMarks;
    private int marksObtained;
    // private String subjects;
    // we have to create array of subjects

    //lets now write down the different constructors
    // public Subject(int subId, String name){
    //     this.subId=subId;
    //     this.name=name;

    // }
    public Subject(int subId,String name, int maxMarks){
        this.subId=subId;
        this.name=name;
        this.maxMarks=maxMarks;
    }


    //lets set the marksObtained
    public void setMarksObtained(int m){
           marksObtained=m;
    }

    public void setMaxMarks(int m){
         maxMarks=m;
    }

    //lets write the get methods now
    int getsubId(){
        return subId;
    }
    String getName(){
        return name;
    }
    int getMaxmarks(){
        return maxMarks;

    }
    int getMarksObtained(){
        return marksObtained;
    }


    //lets now display the details of the subject class
    public String toString(){
        return "\n name of the subject is"+name+"total marks of for the subject is: "+maxMarks
        +"\n suject id of the Subject is:"+getsubId();
    }

}



public class ArrayOfObjects{

     public static void main(String[] args){

           //now lets create a object 
        //    Subject s=new Subject(101,"DBMS",70);
        //    s.setMarksObtained(60);
        //    System.out.println(s);
        //    int student_obtained=s.getMarksObtained();
        //    System.out.println("out of 70 student got: "+student_obtained);
          
        //now lets create the array of objects
        Scanner sc=new Scanner(System.in);
        Subject s[]=new Subject[3];    // 5 objects has been created with the help of this syntax
        for(int i=0;i<3;i++){

            int subId=sc.nextInt();sc.nextLine();
            String subject=sc.nextLine();
            int max_marks=sc.nextInt(); 

            s[i]=new Subject(subId,subject,max_marks);


        }
        //displaying the details now
        for(Subject sb:s){
            System.out.println(sb);
        }
     }
}