import java.util.*;

class Antena{
    private int antenaId;
    private String antenaName;
    private String projectLead;
    private double antenaVSWR;


    public Antena(int antenaId, String antenaName, String projectLead, double antenaVSWR){
        this.antenaId=antenaId;
        this.antenaName=antenaName;
        this.projectLead=projectLead;
        this.antenaVSWR=antenaVSWR;
    }

    //getters
    public int getId(){
        return antenaId;
    }
    public String getName(){
        return antenaName;
    }
    public String getLead(){
        return projectLead;
    }
    public double getVSWR(){
        return antenaVSWR;
    }

}

public class AntenaProblem{

    public static void main(String [] args){
             Scanner sc=new Scanner(System.in);
             Antena an[]=new Antena[4];
             for(int i=0;i<an.length;i++){
                 int a=sc.nextInt();
                 sc.nextLine();
                 String b=sc.nextLine();
                 String c=sc.nextLine();
                 Double d=sc.nextDouble();
                 sc.nextLine();
                
                 an[i]=new Antena(a,b,c,d);

             }
             String inp1=sc.nextLine();
             double inp2=sc.nextDouble();
             int ans=searchAntenaByName(an,inp1 );
             if(ans!=0){
                System.out.println(ans);
             }
             else{
                System.out.println(" There is no antena with the given parameter");
             }
             
            
            
             Antena a[]=sortAntenaByVSWR(an,inp2);
             if(a!=null){ 
                for(int i=0;i<a.length;i++){
                    System.out.println(a[i].getLead());
                }

             }
             else{
                System.out.println("No Antena Found");
             }
    }


    public static int searchAntenaByName(Antena arr[], String name){
        for(int i=0;i<arr.length;i++){
            if(arr[i].getName().equalsIgnoreCase(name)){
                return arr[i].getId();
            }
        }
        return 0;
    }

    public static Antena[] sortAntenaByVSWR(Antena arr[], double param){
        List<Antena>l1=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i].getVSWR()<param){
                l1.add(arr[i]);
                //arr[i] is already an object which is arr[i]=new Antena(2,"'fiefe",ef,33);
            }
        }
        if(l1.isEmpty()){
            return null;
        }
        Collections.sort(l1,(s1,s2)->Double.compare(s1.getVSWR(),s2.getVSWR()));
        Antena ans[]=l1.toArray(new Antena[0]);
        return ans;
    }

}