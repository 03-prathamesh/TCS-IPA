import java.util.*;

class AutonomousCar{

     private int carId;
     private String brand;
     private int noOfTestConducted;
     private int noOfTestPassed;
     private String env;
     private String grade;

     public AutonomousCar(int carId, String brand, int noOfTestConducted, int noOfTestPassed, String env){
        this.carId=carId;
        this.brand=brand;
        this.noOfTestConducted=noOfTestConducted;
        this.noOfTestPassed=noOfTestPassed;
        this.env=env;
     }


     public void setGrade(String grade){
        this.grade=grade;
     }
     //getters
     public int getId(){
        return carId;
     }
     public String getBrand(){
        return brand;
     }
     public int getTestConducted(){
        return noOfTestConducted;
     }
     public int getTestPassed(){
        return noOfTestPassed;
     }
     public String getEnv(){
        return env;
     }

     public String getGrade(){
        return grade;
     }
}



public class AutonomousCarProblem {
    public static void main(String [] args){
          
        Scanner sc=new Scanner(System.in);
        AutonomousCar c[]=new AutonomousCar[4];
        for(int i=0;i<c.length;i++){
            int p=sc.nextInt();
            sc.nextLine();
            String q=sc.nextLine();
            int r=sc.nextInt();
            sc.nextLine();
            int s=sc.nextInt();
            sc.nextLine();
            String t=sc.nextLine();

            c[i]=new AutonomousCar(p,q,r,s,t);
        }

        String inp1=sc.nextLine();
        String inp2=sc.nextLine();
        
        int ans=findTestPassedByEnv(c, inp1);
        if(ans>0){
            System.out.println(ans);
        }
        else{
            System.out.println("There are no test passed in the perticular environment");
        }

        AutonomousCar a[]=upgradeCar(c,inp2);
        if(a!=null){
            for(int i=0;i<a.length;i++){
                System.out.println(a[i].getBrand()+"::"+a[i].getGrade());
            }
        }
        else{
            System.out.println("No car is available with the specified Brand");
        }
    }

    public static int findTestPassedByEnv(AutonomousCar c[], String env){
        int sum=0;
       
        for(int i=0;i<c.length;i++){
            if(c[i].getEnv().equalsIgnoreCase(env)){
                 sum+=c[i].getTestPassed();
                 
            }
        }
       return sum;
        
    }

    public static AutonomousCar[] upgradeCar(AutonomousCar c[], String brand){


        List<AutonomousCar>a1=new ArrayList<>();

        for(int i=0;i<c.length;i++){
            if(c[i].getBrand().equalsIgnoreCase(brand)){
               a1.add(c[i]);
               //making changes here will directly make the changes in oriitnal object, this is not copy this is copy of reference
               int rating=(c[i].getTestPassed()*100)/c[i].getTestConducted();
               if(rating>=18){
                  c[i].setGrade("A1");
               //making changes here will directly make the changes in oriitnal object, this is not copy this is copy of reference
                  
               }
               else{
                  c[i].setGrade("B2");
               }

              
            }
        }
        if(a1.isEmpty()){
            return null;
        }
        return a1.toArray(new AutonomousCar[0]);
    }


}
