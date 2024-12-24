/*
 * Question 2: School Subject Management System
Design a system to manage records of subjects and teachers in a school. The system should involve two classes: Subject and Teacher. A subject can be taught by multiple teachers.

Class Subject:

Attributes:
subjectId (int)
subjectName (String)
teachers (Map of teacher ID to Teacher objects)
Class Teacher:

Attributes:
teacherId (int)
name (String)
experience (int in years)
Methods in Subject Class:

getTeachersWithExperienceAbove()
Retrieve and return a list of teacher names with experience above a specified threshold within a subject, sorted alphabetically.

Parameters: list of subject objects, subjectId, experienceThreshold.
Output: List of teacher names or "No Teachers Found".

getSubjectsByTeacherId()
Find all subjects taught by a teacher with a specific ID and return a list of subject names.

Parameters: list of subject objects, teacherId.
Output: List of subject names or "No Subjects Found".


2
201
Mathematics
3
301
Alice
15
302
Bob
7
303
Charlie
20
202
Physics
2
304
David
10
305
Eve
12
201
10
305

Alice
Charlie
Physics


1
203
Chemistry
1
306
Frank
8
203
12
400

No Teachers Found
No Subjects Found

 */

 import java.util.ArrayList;
 import java.util.Collections;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import java.util.Scanner;
 
 class Teacher{
     private int tId;
     private String tname;
     private int eyr;
     public Teacher(int tId, String tname, int eyr) {
         this.tId = tId;
         this.tname = tname;
         this.eyr = eyr;
     }
     public int gettId() {
         return tId;
     }
     public String getTname() {
         return tname;
     }
     public int getEyr() {
         return eyr;
     }
     
  }
 
 
 
  class Subject{
     private int sId;
     private String sName;
     Map<Integer,Teacher> teachers=new HashMap<>();
     public Subject(int sId, String sName) {
         this.sId = sId;
         this.sName = sName;
     }
 
     public void addTeacher(Teacher teacher){
         teachers.put(teacher.gettId(), teacher);
     }
     public int getsId() {
         return sId;
     }
     public String getsName() {
         return sName;
     }
 
  }
 
 
 public class SchoolSubjectMgtSystem {
     
     public static List<String> getTeachersWithExperienceAbove(List<Subject> subjects,int sId,int eTh){
         List<String> list=new ArrayList<>();
         for(Subject s:subjects){
             if(s.getsId()==sId){
                 for(Teacher t:s.teachers.values()){
                     if(t.getEyr()>eTh){
                         list.add(t.getTname());
                     }
                 }
             }
         }
         if(list.isEmpty()){
             System.out.println("No Teachers found");
             return null;
         }
         Collections.sort(list);
         return list;
     }
 
     public static List<String> getSubjectsByTeacherId(List<Subject> subjects,int tId){
         List<String> list=new ArrayList<>();
         for(Subject s:subjects){
             if(s.teachers.containsKey(tId)){
                 list.add(s.getsName());
             }
         }
         if(list.isEmpty()){
             System.out.println("No subjects found");
             return null;
         }
         return list;
     }
 
     public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
         List<Subject> subjects=new ArrayList<>();
         int n=sc.nextInt();
         sc.nextLine();
         for(int i=0;i<n;i++){
             int sid=sc.nextInt();
             sc.nextLine();
             String sn=sc.nextLine();
             Subject s=new Subject(sid, sn);
 
             int tno=sc.nextInt();
             sc.nextLine();
             for(int j=0;j<tno;j++){
                 int tid=sc.nextInt();
                 sc.nextLine();
                 String tn=sc.nextLine();
                 int eyr=sc.nextInt();
                 sc.nextLine();
                 Teacher t=new Teacher(tid, tn, eyr);
                 s.addTeacher(t);
             }
             subjects.add(s);
         }
 
         int sid=sc.nextInt();
         sc.nextLine();
         int eyr=sc.nextInt();
         sc.nextLine();
         int tid=sc.nextInt();
         sc.nextLine();
         List<String> r1=getTeachersWithExperienceAbove(subjects,sid,eyr);
         if(r1!=null){
             for(String s:r1){
                 System.out.println(s);
             }
         }
 
         List<String> r2=getSubjectsByTeacherId(subjects, tid);
         if(r2!=null){
             for(String s:r2){
                 System.out.println(s);
             }
         }
     }
 }