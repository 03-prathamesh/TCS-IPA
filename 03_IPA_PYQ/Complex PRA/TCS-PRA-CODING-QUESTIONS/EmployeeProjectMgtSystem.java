/*
 * Employee Project Management System
Class: Employee
Attributes:
employeeId: int
name: String
department: String
projects: List of Project objects
Class: Project
Attributes:
projectId: int
projectName: String
status: String ("Completed", "In Progress", "Pending")
completionDate: String ("YYYY-MM-DD")
Methods:
getProjectsByStatus

Retrieves a list of project names assigned to a particular employee filtered by project status.
Parameters: list of Employee objects, employeeId, status.
Output: List of project names, or "No Projects Found" if none match the status.
getTopPerformersByDepartment

Identifies employees in each department who have completed the most projects.
Parameters: list of Employee objects.
Output: List of employee names by department with the highest project completion count.
Sample Test Case
Input:

plaintext
Copy code
3
201
Emily
IT
3
601
Cloud Migration
Completed
2023-05-10
602
Network Upgrade
In Progress
2023-08-01
603
Security Audit
Pending
2023-10-12
202
Mark
Finance
2
604
Budget Review
Completed
2023-06-21
605
Tax Compliance
Completed
2023-07-25
203
Alice
IT
1
606
Data Migration
Completed
2023-03-14
201
Completed

Output:

plaintext
Copy code
Cloud Migration
Emily, IT
Mark, Finance

 */

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import java.util.Scanner;
 
 class Projects{
     private int pid;
     private String pname;
     private String status;
     private String cDate;
     public Projects(int pid, String pname, String status, String cDate) {
         this.pid = pid;
         this.pname = pname;
         this.status = status;
         this.cDate = cDate;
     }
     public int getPid() {
         return pid;
     }
     public String getPname() {
         return pname;
     }
     public String getStatus() {
         return status;
     }
     public String getcDate() {
         return cDate;
     }
 
     
     
  }
 
 
  class Employees{
     private int eId;
     private String ename;
     private String dept;
     List<Projects> projects=new ArrayList<>();
     public Employees(int eId, String ename, String dept) {
         this.eId = eId;
         this.ename = ename;
         this.dept = dept;
     }
 
     public void addProjects(Projects p){
         projects.add(p);
     }
     public int geteId() {
         return eId;
     }
     public String getEname() {
         return ename;
     }
     public String getDept() {
         return dept;
     }
 
     
  }
 
 
 
 public class EmployeeProjectMgtSystem {
     public static List<String> getProjectsByStatus(List<Employees> employees,int eid,String status){
         List<String> list=new ArrayList<>();
         for(Employees e:employees){
             if(e.geteId()==eid){
                 for(Projects p:e.projects){
                     if(p.getStatus().equalsIgnoreCase(status)){
                         list.add(p.getPname());
                     }
                 }
                 break;
             }
         }
         if(list.isEmpty()){
             System.out.println("No Projects Found");
             return null;
         }
         return list;
     }
 
     // public static List<Employees> getTopPerformersByDepartment(List<Employees> employees){
     //     List<Employees> list=new ArrayList<>();
     //     for(Employees e:employees){
     //         for(Projects p:e.projects){
     //             if(p.getStatus().equalsIgnoreCase("Completed")){
     //                 list.add(e);
     //             }
     //         }
     //     }
     //     return list;
     // }
 
     //Most Important concept which is dynamically tested the hashmap values;
     public static List<Employees> getTopPerformersByDepartment(List<Employees> employees){ 
         Map<String,Integer> maxCom=new HashMap<>();
         List<Employees> emp=new ArrayList<>();
         for(Employees e:employees){
             int count_completed=0;
             for(Projects p:e.projects){
                 if(p.getStatus().equalsIgnoreCase("completed")){
                     count_completed++;
                 }
             }
             String find_dept=e.getDept();
             if(count_completed>maxCom.getOrDefault(find_dept,0)){
                 maxCom.put(find_dept, count_completed);
                 emp.add(e);
             }
         }
         return emp;
     }
 
     public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
         List<Employees> employees=new ArrayList<>();
         int n=sc.nextInt(); sc.nextLine();
         for(int i=0;i<n;i++){
             int id=sc.nextInt();sc.nextLine();
             String na=sc.nextLine();
             String d=sc.nextLine();
             Employees e=new Employees(id, na, d);
 
             int pno=sc.nextInt();sc.nextLine();
             for(int j=0;j<pno;j++){
                 int pid=sc.nextInt();sc.nextLine();
                 String pn=sc.nextLine();
                 String s=sc.nextLine();
                 String da=sc.nextLine();
                 Projects p=new Projects(pid, pn, s, da);
                 e.addProjects(p);
             }
             employees.add(e);
         }
 
         int eid=sc.nextInt();sc.nextLine();
         String s=sc.nextLine();
 
         List<String> r1=getProjectsByStatus(employees, eid, s);
         if(r1!=null){
             for(String ss:r1){
                 System.out.println(ss);
             }
         }
 
         List<Employees> r2=getTopPerformersByDepartment(employees);
         if(r2!=null){
             for(Employees e:r2){
                 System.out.println(e.getEname()+", "+e.getDept());
             }
         }
     }
 }
  