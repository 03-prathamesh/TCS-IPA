import java.util.*;

class Institution{

    int institutionId;
    String institutionName;
    int noOfStudentsPlaced;
    int noOfStudentsCleared;
    String location;
    String grade;

    //lets write the constructor to initialize the attributes of the class
    public Institution(int institutionId, String institutionName,int noOfStudentsPlaced,int noOfStudentsCleared,String location){
        this.institutionId=institutionId;
        this.institutionName=institutionName;
        this.noOfStudentsPlaced=noOfStudentsPlaced;
        this.noOfStudentsCleared=noOfStudentsCleared;
        this.location=location;
        
    }

    //lets write the getter methodss
    public int getId(){
        return institutionId;
    }
    public String getName(){
        return institutionName;

    }
    public int getStudentsPlaced(){
        return noOfStudentsPlaced;

    }
    public int getStudentsCleared(){
        return noOfStudentsCleared;
    }
    public String getLocation(){
        return location;
    }
    public String getGrade(){
        return grade;
    }


    //lets write the setter methods
    public void setId(int institutionId){
        this.institutionId=institutionId;
    }
    public void setName(String institutionName){
       this.institutionName=institutionName;
    }
    public void setStudentsPlaced(int noOfStudentsPlaced){
        this.noOfStudentsPlaced=noOfStudentsPlaced;
    }
    public void setStudentsCleared(int noOfStudentsCleared){
        this.noOfStudentsCleared=noOfStudentsCleared;
    }

    public void setLocation(String location){
       this.location=location;
    }
    public void setGrade(String grade){
        this.grade=grade;
    }
}




public class InstitutionProblem {
    public static void main(String [] args){
       
        //lets create the array of object of class Institution
        Institution is[]=new Institution[4];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<is.length;i++){
            int id=sc.nextInt();
            sc.nextLine();
            String name=sc.nextLine();
            int placed=sc.nextInt();
            sc.nextLine();
            int cleared=sc.nextInt();
            sc.nextLine();
            String location=sc.nextLine();

            //lets create object
            is[i]=new Institution(id,name,placed,cleared,location);
        }

        String loc=sc.nextLine();
        
        int findNumAns=findNumClearanceByLoc(is,loc);
        if(findNumAns>0){
            System.out.println(findNumAns);
        }
        else{
            System.out.println("There are no cleared Students in this perticular locations");
        }
        
        String name=sc.nextLine();

        //
        Institution newObj=updateInstitutionGrade(name,is);
        if(newObj==null){
            System.out.println("No Institution is available with specified name");

        }
        else{
            System.out.println(newObj.getName()+"::"+newObj.getGrade());
        }
       


    }

    public static int findNumClearanceByLoc(Institution arr[],String location){
       
         int sum=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getLocation().equalsIgnoreCase(location)){
              sum=sum+arr[i].getStudentsCleared();
            }
        }


           return sum;
    }

    public static Institution updateInstitutionGrade(String Name, Institution obj[]){
        
        for(int i=0;i<obj.length;i++){

            int rating=(obj[i].getStudentsPlaced()*100)/obj[i].getStudentsCleared();
            if(rating==80){
               obj[i].setGrade("A");
            }
            else{
                obj[i].setGrade("B");
            }
            if(obj[i].getName().equals(Name)){
                return obj[i];
            }

        }
        return null;
    }
}
