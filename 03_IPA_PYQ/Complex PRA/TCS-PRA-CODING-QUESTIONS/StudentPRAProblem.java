/*
 * Class student 
Attributes
Id,name,subject,grade
Method 1 - studentswithAverageaboveThreshold - return list of students with average grade higher than average
2. Students with maximum unique grades
Take students list as argument for both methods
Return studetns with maximum unique grades

Imput 
3
101
Abc
2
Physics
78
Maths
99
102
Xyz
3
Chem
80
Maths
80
Physics
73
103
Dfg
4
Physics
67
Chem
67
Maths
67
PRA1
67
Output
Abc,xyz
Abc,xyz
 */




 import java.util.ArrayList;
 import java.util.Collection;
 import java.util.HashMap;
 import java.util.HashSet;
 import java.util.List;
 import java.util.Map;
 import java.util.Map.Entry;
 import java.util.Scanner;
 
 class Students{
 
     private int id;
     private String name;
      Map<String,Integer> subGrade;
        public Students(int id, String name) {
         this.id = id;
         this.name = name;
         this.subGrade=new HashMap<>();
         
     }
 
     public void addSubGrade(String sub,int grade){
         subGrade.put(sub,grade);
     }
     public int getId() {
         return id;
     }
     public void setId(int id) {
         this.id = id;
     }
     public String getName() {
         return name;
     }
     public void setName(String name) {
         this.name = name;
     }
 
     public double avgCal(){
         int sum=0;
         int count=0;
         for(int g:subGrade.values()){
             sum+=g;
             count++;
         }
         if(count>0){
             return sum/count;
         }
         return 0;
     }
 
     public int uniqueGrade(){
         return new HashSet<>(subGrade.values()).size();
     }
     
     
 }
 
 
 public class StudentPRAProblem {
     
     public static List<Students> studentswithAverageaboveThreshold(List<Students> students){
         List<Students> list=new ArrayList<>();
         List<Integer> grade=new ArrayList<>();
         double avg=0;
         int sum=0;
         int count=0;
         for(Students s:students){
             sum+=s.avgCal();
             count++;
         }
         if(count>0){
             avg=sum/count;
         }
 
         for(Students s:students){
             if(s.avgCal()>avg){
                 list.add(s);
             }
         }
         return list;
     }
 
 
 
     public static List<Students> studentsWithMaxGrade(List<Students> students){
         int max=Integer.MIN_VALUE;
         List<Students> list=new ArrayList<>();
         for(Students s:students){
             if(s.uniqueGrade()>max){
                 max=s.uniqueGrade();
             }
         }
         for(Students s:students){
             if(s.uniqueGrade()==max){
                 list.add(s);
             }
         }
 
         return list;
     }
 
     public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);
          int n=sc.nextInt();
          List<Students> students=new ArrayList<>();
          for(int i=0;i<n;i++){
             int id=sc.nextInt();
             sc.nextLine();
             String name=sc.nextLine();
             
             Students s=new Students(id, name);
             int sgn=sc.nextInt();
             sc.nextLine();
             for(int j=0;j<sgn;j++){
                 String sub=sc.nextLine();
                 int grade=sc.nextInt();
                 sc.nextLine();
                 s.addSubGrade(sub, grade);
             }
             students.add(s);
          }
          List<Students> r1=studentswithAverageaboveThreshold(students);
          if(r1!=null){
            for(Students s:r1){
             System.out.println(s.getName());
            }
          }
          List<Students> r2=studentsWithMaxGrade(students);
          if(r2!=null){
             for(Students s:r2){
                 System.out.println(s.getName());
             }
          }
     }
 }