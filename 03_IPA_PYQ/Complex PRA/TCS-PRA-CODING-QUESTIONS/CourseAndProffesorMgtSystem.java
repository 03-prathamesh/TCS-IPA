/*
 * Question 2: Course and Professor Management System
Design a system to manage university courses and professors. Each professor may teach multiple courses.

Class Definitions:

Course:

courseId (int)
courseName (String)
semester (String)
professors (List of Professor objects)
Professor:

professorId (int)
name (String)
yearsOfExperience (int)
Methods:

getCoursesByProfessorAndSemester()

Retrieves courses taught by a specific professor in a particular semester.
Parameters: list of Course objects, professorId, semester
Output: List of course names or "No Courses Found" / "Professor Not Found".
getProfessorWithMostExperience()

Finds the professor with the most years of experience.
Parameters: list of Course objects
Output: Professor's name or "No Professors Found".

2
401
Data Structures
Fall 2023
2
501
Dr. Smith
10
502
Dr. Jane
15
402
Machine Learning
Spring 2023
1
501
Dr. Smith
10
501
Fall 2023

Data Structures
------------
Dr. Jane


 */

 import java.util.ArrayList;
 import java.util.List;
 import java.util.Scanner;
 
 class Professor{
     private int pid;
     private String pname;
     private int yre;
     public Professor(int pid, String pname, int yre) {
         this.pid = pid;
         this.pname = pname;
         this.yre = yre;
     }
     public int getPid() {
         return pid;
     }
     public String getPname() {
         return pname;
     }
     public int getYre() {
         return yre;
     }
 }
 
 
 
 
 class Course{
     private int cid;
     private String cname;
     private String sem;
     List<Professor> professors=new ArrayList<>();
     public Course(int cid, String cname, String sem) {
         this.cid = cid;
         this.cname = cname;
         this.sem = sem;
     }
 
     public void addProfessors(Professor p){
         professors.add(p);
     }
     public int getCid() {
         return cid;
     }
     public String getCname() {
         return cname;
     }
     public String getSem() {
         return sem;
     }
 
     
     
 }
 public class CourseAndProffesorMgtSystem {
     public static List<String> getCoursesByProfessorAndSemester(List<Course>courses,int pid,String sem){
         for(Course c:courses){
             List<String> cnames=new ArrayList<>();
             for(Professor p:c.professors){
                 if(p.getPid()==pid && c.getSem().equalsIgnoreCase(sem)){
                     cnames.add(c.getCname());
                 }
             }
             if(cnames.isEmpty()){
                 System.out.println("No Courses Found");
                 return null;
             }
             return cnames;
         }
         System.out.println("Professor Not Found");
         return null;
     }
 
     public static List<String> getProfessorWithMostExperience(List<Course> courses){
         List<String> list=new ArrayList<>();
         int max=Integer.MIN_VALUE;
         for(Course c:courses){
             for(Professor p:c.professors){
                 if(p.getYre()>max){
                     max=p.getYre();
                 }
             }
         }
 
         for(Course c:courses){
             for(Professor p:c.professors){
                 if(p.getYre()==max){
                     list.add(p.getPname());
                 }
             }
         }
         if(list.isEmpty()){
             System.out.println("No Professors Found");
             return null;
         }
         return list;
     }
 
     public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);
          List<Course> courses=new ArrayList<>();
          int n=sc.nextInt();
          sc.nextLine();
          for(int i=0;i<n;i++){
             int cid=sc.nextInt();
             sc.nextLine();
             String cn=sc.nextLine();
             String sem=sc.nextLine();
             Course c=new Course(cid, cn, sem);
 
             int pno=sc.nextInt();
             sc.nextLine();
             for(int j=0;j<pno;j++){
                 int pid=sc.nextInt();
                 sc.nextLine();
                 String pname=sc.nextLine();
                 int yr=sc.nextInt();
 
                 Professor p=new Professor(pid, pname, yr);
                 c.addProfessors(p);
             }
             courses.add(c);
          }
          int pid=sc.nextInt();
          sc.nextLine();
          String sem=sc.nextLine();
 
          List<String> r1=getCoursesByProfessorAndSemester(courses, pid, sem);
          if(r1!=null){
             for(String s:r1){
                 System.out.println(s);
             }
          }
 
          List<String> r2=getProfessorWithMostExperience(courses);
          if(r2!=null){
             for(String s:r2){
                 System.out.println(s);
             }
          }
     }
 }