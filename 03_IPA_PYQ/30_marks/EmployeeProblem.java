
import java.util.*;
class Employee{


    private int id;
    private String name;
    private String designation;
    private double salary;


    //constructor
    public Employee(int id, String name, String designation, double salary){
        this.id=id;
        this.name=name;
        this.designation=designation;
        this.salary=salary;
    }

    //getter methods
    public int getId(){
        return id;
    }
   public  String getName(){
        return name;
    }
    public String getDesignation(){
        return designation;
    }
    double getSalary(){
        return salary;
    }


}




class Company{

     private String companyName;
     private Employee emp[];
     private int numEmployees;

     //parameterised constructor
     public Company(String companyName, Employee emp[], int numEmployees){
        this.companyName=companyName;
        this.emp=emp;
        this.numEmployees=numEmployees;
     }

     public double getAvgSalary(){
        double count=0;
        
        for(int i=0;i<emp.length;i++){
           count=count+emp[i].getSalary();
        }

        return count/emp.length;
     }

     public double getMaxSalary(){
        double max=emp[0].getSalary();
        for(int i=1;i<emp.length;i++){
            if(emp[i].getSalary()>max){
                max=emp[i].getSalary();
            }
        }
        return max;
     }

     public Employee[] emp(String designation){
        Employee em[]=new Employee[0];
        int count=0;
        for(int i=0;i<emp.length;i++){
            if(emp[i].getDesignation().equalsIgnoreCase(designation)){
                count++;
               em=Arrays.copyOf(em,count);
               em[em.length-1]=emp[i];
            }
        }
        if(em.length>0){
            return em;
        }
        return null;
     }

     

}

public class EmployeeProblem{

    public static void main(String [] args){
         
          Scanner sc=new Scanner(System.in);
          String company_name=sc.nextLine();
          int noOfEmployees=sc.nextInt();
          sc.nextLine();
          Employee empl[]=new Employee[noOfEmployees];
          for(int i=0;i<noOfEmployees;i++){
              int id=sc.nextInt();
              sc.nextLine();
              String name=sc.nextLine();
              String design=sc.nextLine();
              double salary=sc.nextDouble();
              sc.nextLine();

              empl[i]=new Employee(id,name,design,salary);
              
          }


          Company c=new Company(company_name,empl,noOfEmployees);
          double ansAvg=c.getAvgSalary();
          System.out.println("Average salary: "+ansAvg);

          double ansMax=c.getMaxSalary();
          System.out.println("Max Salary: "+ansMax);

          System.out.print("Employee With Designatino: ");
          String desgination=sc.nextLine();


         Employee newArr[]= c.emp(desgination);
          for(int i=0;i<newArr.length;i++){
              System.out.print(newArr[i].getId()+" "+newArr[i].getName()+" "+newArr[i].getDesignation()+" "+newArr[i].getSalary());
          }

          
    }
}