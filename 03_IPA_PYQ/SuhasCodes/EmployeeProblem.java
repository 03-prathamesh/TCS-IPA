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

    //getters
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getDesignation(){
        return designation;
    }
    public double getSalary(){
        return salary;
    }
}

class Company{

    private String companyName;
    private Employee emp[];
    private int numEmployees;

    //parameterised constructoors
    public Company(String companyName,Employee emp[], int numEmployees){
        this.companyName=companyName;
        this.emp=emp;
        this.numEmployees=numEmployees;
    }

    public String getName(){
        return companyName;
    }
    public Employee[] getEmployee(){
        return emp;
    }
    public int getNoEmp(){
        return numEmployees;
    }


    public  double getAvgSalary(){
        double sum=0;
        for(int i=0;i<emp.length;i++){
            sum=sum+emp[i].getSalary();
        }

        return sum/emp.length;
    }

    public double getMaxSalary(){
        double min=Integer.MIN_VALUE;
        for(int i=0;i<emp.length;i++){
           if(emp[i].getSalary()>min){
            min=emp[i].getSalary();
           }
        }
        return min;
    }

    public Employee[] getEmployeeByDesignation(String designation){
        List<Employee>em=new ArrayList<>();
        for(int i=0;i<emp.length;i++){
            if(emp[i].getDesignation().equalsIgnoreCase(designation)){
                em.add(emp[i]);
            }
        }
        return em.toArray(new Employee[0]);
    }
}


public class EmployeeProblem{
    public static void main(String [] args){

          Scanner sc=new Scanner(System.in);
         


          System.out.print("Enter company Name: ");
          String companyName=sc.nextLine();
          System.out.print("Enter No of Emmployee");
          int noOfEmployees=sc.nextInt();
          sc.nextLine();
          Employee emp[]=new Employee[noOfEmployees];
          for(int i=0;i<noOfEmployees;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            String c=sc.nextLine();
            double d=sc.nextDouble();
            sc.nextLine();
            emp[i]=new Employee(a,b,c,d);
          }

          Company cm=new Company(companyName, emp, noOfEmployees);

          double avgSalary=cm.getAvgSalary();
          System.out.println("Average salary of Employees: "+avgSalary);
          double maxSalary=cm.getMaxSalary();
          System.out.println("Maximum Salary of Employee: "+maxSalary);
          
          System.out.print("Enter designation: ");
          String designation=sc.nextLine();
          Employee ans[]=cm.getEmployeeByDesignation(designation);
          for(Employee s:ans){
              System.out.println("Id: "+s.getId()+" Name: "+s.getName()+" Designation: "+s.getDesignation()+" Salary: "+s.getSalary());
          }
    }
}