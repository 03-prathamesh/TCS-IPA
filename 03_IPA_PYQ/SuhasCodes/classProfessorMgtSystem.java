import java.util.*;

class Course{

    private int courseId;
    private String courseName;
    private String semester;
    private List<Professor>professors;

    public Course(int courseId, String courseName, String semester, List<Professor>professors){
        this.courseId=courseId;
        this.courseName=courseName;
        this.semester=semester;
        this.professors=professors;
    }

    public int getCourseId(){
        return courseId;
    }
    public String getCourseName(){
        return courseName;
    }
    public String getSemester(){
        return semester;
    }
    public List<Professor>getProfessors(){
        return professors;
    }

}

class Professor{

    private int professorId;
    private String name;
    private int yearsOfExp;

    public Professor(int professorId, String name, int yearsOfExp){
        this.professorId=professorId;
        this.name=name;
        this.yearsOfExp=yearsOfExp;
    }

    public int getProfessorId(){
        return professorId;
    }
    public String getProfessorName(){
        return name;
    }
    public int getExp(){
        return yearsOfExp;
    }

}


public class classProfessorMgtSystem {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        List<Course>cour=new ArrayList<>();
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            String c=sc.nextLine();
            int m=sc.nextInt();
            sc.nextLine();

            List<Professor>ps=new ArrayList<>();
            for(int j=0;j<m;j++){
                int p=sc.nextInt();
                sc.nextLine();
                String q=sc.nextLine();
                int r=sc.nextInt();
                sc.nextLine();

                ps.add(new Professor(p, q, r));

            }
            cour.add(new Course(a,b,c,ps));
        }

        int id=sc.nextInt();
        sc.nextLine();
        String sem=sc.nextLine();

        List<Course>ans1=getCoursesByProfessorAndSemester(cour, id, sem);
        if(ans1==null){
            System.out.println("No Course/Professor found");
        }
        for(Course c:ans1){
            System.out.println(c.getCourseName());
        }

        List<Professor>ans2=getProfessorsWithMostExp(cour);
        if(ans2==null){
            System.out.println("No professor found");
        }
        for(Professor p:ans2){
            System.out.println(p.getProfessorName());
        }
    }

    public static List<Course> getCoursesByProfessorAndSemester(List<Course>ls, int id, String sem){

        List<Course>ans=new ArrayList<>();
        for(Course c:ls){
            if(c.getSemester().equalsIgnoreCase(sem)){
                for(Professor p:c.getProfessors()){
                    if(p.getProfessorId()==id){
                        ans.add(c);
                    }
                }
            }
        }

        if(ans.isEmpty()){
            return null;
        }
        return ans;
    }

    public static List<Professor> getProfessorsWithMostExp(List<Course>cs){

        List<Professor>ans=new ArrayList<>();
        int big=0;
        for(Course c:cs){
           
            for(Professor p:c.getProfessors()){
                if(p.getExp()>big){
                    big=p.getExp();
                }
            }
        }
        for(Course c:cs){
           
            for(Professor p:c.getProfessors()){
                if(p.getExp()==big){
                   ans.add(p);
                }
            }
        }

        if(ans.isEmpty()){
            return null;
        }
        return ans;
    }
}
