import java.util.*;

class Employee{

   private int employeeId;
   private String  employeeName;
   private int age;
   private char gender;
   private double salary;

   //parameterised constructor to initialized this attributes of class
   public Employee(int employeeId, String employeeName, int age, char gender, double salary){
          this.employeeId=employeeId;
          this.employeeName=employeeName;
          this.age=age;
          this.gender=gender;
          this.salary=salary;
   }
 
   //lets write the getter methods now
   public int getId(){
        return employeeId;
   }
   public String getName(){
      return employeeName;
   }

   public int getAge(){
    return age;
   }

   public char getGender(){
    return gender;
   }

   public double getSalary(){
       return salary;
   }

   // lets write setter method if neccesary
   public void setId(int employeeId){
     this.employeeId=employeeId;
   }

   public void setName(String employeeName){
     this.employeeName=employeeName;
   }

   public void setAge(int age){
    this.age=age;
   }

   public void setGender(char gender){
    this.gender=gender;
   }

   public void setSalary(double salary){
    this.salary=salary;
   }

}



public class Solution {
    public static void main(String [] args){
         //lets create array of object of the class Employee
         Scanner sc=new Scanner(System.in);
         int n=sc.nextInt();
         sc.nextLine();
         Employee emp[]=new Employee[n];
         for(int i=0;i<emp.length;i++){
             int id=sc.nextInt();
             sc.nextLine();
             String name=sc.nextLine();
             int age=sc.nextInt();
             sc.nextLine();
             char gender=sc.next().charAt(0);
             double salary=sc.nextDouble();


             emp[i]=new Employee(id,name,age,gender,salary);
             // Employee sc
             //sc=new Employee(id,name,age,gender,salary)
                   
            
         }    

         int age=sc.nextInt();
         
        Employee em[]=  getSecondLowestSalary(emp); //storing array of returned objects into em which is array of object
        if(em==null){
            System.out.println("Null");
        }
        else{
            for(int i=0;i<em.length;i++){
                System.out.println(em[i].getId()+"#"+em[i].getName());
            }
        }

        int count_emp_age=countEmpBasedOnAge(emp, age);
        if(count_emp_age>0){
            System.out.println(count_emp_age);
        }
        else{
            System.out.println("No Employee found for the given age");
        }


    }

    public static Employee[] getSecondLowestSalary(Employee arr[]){

        if(arr.length<=1){
             return null;
        }


         Employee new_arr[]=new Employee[0];
        //first sort the salary
            // for(int i=0;i<arr.length;i++){
            //     for(int j=1;j<arr.length;j++){
            //         if(arr[j-1].getSalary()>arr[j].getSalary()){
            //             Employee temp=arr[j-1];
            //             arr[j-1]=arr[j];
            //             arr[j]=temp;
            //         }
            //     }
            // }
              Arrays.sort(arr, (e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));

         int count=0;
        double min=arr[0].getSalary();
        double sec_lowest=min;
        // then get the second lowest salary(note first element can have duplicated on 2 nd also)
        for(int i=1;i<arr.length;i++){
            if(arr[i].getSalary()>min){
                sec_lowest=arr[i].getSalary();
                break;
            }
        }

        //lets check which employee has same salary of sec_lowest
        for(int i=0;i<arr.length;i++){
           if(arr[i].getSalary()==sec_lowest){
                count++;
                new_arr=Arrays.copyOf(new_arr,count);
                new_arr[new_arr.length-1]=arr[i];
           }
        }



        if(min==sec_lowest){
            return null;
        }
        return new_arr;


    }

    public static int countEmpBasedOnAge(Employee arr[],int age){


        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getAge()==age){
                count++;
            }
        }
        return count;   
    }


}
