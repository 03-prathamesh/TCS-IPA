// import java.util.*;

// class Employee{
//     private int employeeId;
//     private String name;
//     private String department;
//     private List<Project>p;
    
//     public Employee(int employeeId, String name, String department, List<Project>p){
//            this.employeeId=employeeId;
//            this.name=name;
//            this.department=department;
//            this.p=p;
//     }

//     //getters
//     public int getId(){
//         return employeeId;
//     }
//     public String getName(){
//         return name;
//     }
//     public String getDepartment(){
//         return department;
//     }
//     public List<Project>getProject(){
//         return p;
//     }

// }

// class Project{

//     private int projectId;
//     private String projectName;
//     private String status;
//     private String completionDate;

//     public Project(int projectId, String projectName, String status, String completionDate){
//         this.projectId=projectId;
//         this.projectName=projectName;
//         this.status=status;
//         this.completionDate=completionDate;
//     }
//     //getters
//     public int getProjectId(){
//         return projectId;
//     }
//     public String getProjectName(){
//         return projectName;
//     }
//     public String getStatus(){
//         return status;
//     }
//     public String getCompletionDate(){
//         return completionDate;
//     }


// }


// public class EmpoyeeProjectManagementSystem {
//     public static void main(String [] args){

//     }


    
//     public static List<String>getProjectByStatus(List<Employee>emp, int empId, String status){
       
//         List<String>ans=new ArrayList<>();
//         for(Employee ep:emp){
//            if(ep.getId()==empId ){
//                for(Project pr:ep.getProject()){
//                    if(pr.getStatus().equalsIgnoreCase(status)){
//                        ans.add(pr.getProjectName());
                       
//                    }
//                }
//            }
//         }
//         if(ans.isEmpty()){
//             return null;
//         }
//         return ans;
//     }   


//     public static List<String>getTopPerformersByDepartment(List<Employee>emp){
//         List<Employee>ans=new ArrayList<>();
//         Map<String,Integer>depCount=new HashMap<>();
//         for(Employee em:emp){
//             int count=0;
//            for(Project p:em.getProject()){
//              if(p.getStatus().equalsIgnoreCase("completed")){
//                   count++;
//              }
//            }
//            if()

//         }
//         return ans;
//     }
// }


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
    public List<Projects>getProjects(){
        return projects;
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
   public static List<Employees> getTopPerformersByDepartment(List<Employees> employees) { 
    Map<String, Integer> maxCom = new HashMap<>();
    Map<String, Employees> topPerformers = new HashMap<>();

    for (Employees e : employees) {
        int countCompleted = 0;

        // Count completed projects for each employee
        for (Projects p : e.getProjects()) {
            if (p.getStatus().equalsIgnoreCase("completed")) {
                countCompleted++;
            }
        }

        String department =e.getDept();

        // Check if this employee has more completed projects than the current max for this department
        if (countCompleted > maxCom.getOrDefault(department, 0)) {
            maxCom.put(department, countCompleted);
            topPerformers.put(department, e);
        }
    }

    // Collect the top performers from each department
    return new ArrayList<>(topPerformers.values());
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
 
