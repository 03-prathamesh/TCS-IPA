import java.util.*;

class Course{

    private int courseId;
    private String courseName;
    private String courseAdmin;
    private int quiz;
    private int handsOn;

    //constructor
    public Course(int courseId, String courseName, String courseAdmin, int quiz, int handsOn){
        this.courseId=courseId;
        this.courseName=courseName;
        this.courseAdmin=courseAdmin;
        this.quiz=quiz;
        this.handsOn=handsOn;
    }

    //getters
    public int getId(){
        return courseId;
    }
    public String getCourseName(){
        return courseName;
    }
    public String getCourseAdmin(){
        return courseAdmin;
    }
    public int getQuiz(){
        return quiz;
    }
    public int getHandsOn(){
        return handsOn;
    }
}




public class CourseProblem {
        public static void main(String[] args){

            Scanner sc=new Scanner(System.in);
            Course c[]=new Course[4];
            for(int i=0;i<c.length;i++){
                int p=sc.nextInt();
                sc.nextLine();
                String q=sc.nextLine();
                String r=sc.nextLine();
                int s=sc.nextInt();
                sc.nextLine();
                int t=sc.nextInt();
                sc.nextLine();

                c[i]=new Course(p,q,r,s,t);
            }
            String param1=sc.nextLine();
            int param2=sc.nextInt();
            
            int ans=findAvgOfQuizByAdmin(c, param1);
            if(ans==0){
                System.out.println("No course found");

            }
            else{
                System.out.println(ans);
            }

            Course an[]=sortCourseByHandsOn(c, param2);
            if(an!=null){
                for(int i=0;i<an.length;i++){
                    System.out.println(an[i].getCourseName());
                }
           }
           else{
            System.out.println("No course found with the mentioned attribute");
           }
        }



        public static int findAvgOfQuizByAdmin(Course c[], String admin){
            int count=0;
            int quiz=0;
            for(int i=0;i<c.length;i++){
                if(c[i].getCourseAdmin().equalsIgnoreCase(admin)){
                    count++;
                    quiz=quiz+c[i].getQuiz();
                }
            } 

            if(count==0){
                return 0;
            }
            return quiz/count;
        }

        public static Course[] sortCourseByHandsOn(Course c[], int value){
        
            List<Course>l1=new ArrayList<>();
            for(int i=0;i<c.length;i++){
               if(c[i].getHandsOn()<value){
                 l1.add(c[i]);
               }
            }
            if(l1.isEmpty()){
                return null;
            }
            
            Course ans[]=l1.toArray(new Course[0]);
            Arrays.sort(ans,(s1,s2)->Integer.compare(s1.getHandsOn(), s2.getHandsOn()));
            return ans;
        }
}

