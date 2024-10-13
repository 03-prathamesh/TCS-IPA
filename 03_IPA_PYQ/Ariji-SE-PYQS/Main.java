import java.util.*;

class Associates{
    private int id;
    private String name;
    private String technology;
    private int expInYears;
    
    //parameterised constructor
    public Associates(int id, String name, String technology,int expInYears){
         this.id=id;
         this.name=name;
         this.technology=technology;
         this.expInYears=expInYears;
    }
    
    //getter methods
    public int getId(){
        return id;
    }
    public String getName(){
        return  name;
    }
    public String getTechnology(){
        return technology;
    }
    public int getExp(){
        return expInYears;
    }
    
    
}



public class Main{
    public static void main(String [] args){
        
        Scanner sc=new Scanner(System.in);
        Associates A[]=new Associates[5];
        for(int i=0;i<A.length;i++){
            
            int id=sc.nextInt();
            sc.nextLine();
            String name=sc.nextLine();
            String technology=sc.nextLine();
            int exp=sc.nextInt();
            sc.nextLine();
            
            A[i]=new Associates(id,name,technology,exp);
        }
        
        String technology=sc.nextLine();
        
        Associates newA[]=AssociatesForGivenTechnology(A,technology);
        for(int i=0;i<newA.length;i++){
            System.out.println(newA[i].getId());
        }
        

    }
    
    
    public static Associates[] AssociatesForGivenTechnology(Associates arr[], String technology){
        Associates new_arr[]=new Associates[0];
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i].getTechnology().equalsIgnoreCase(technology) && (arr[i].getExp()%5==0)){
                count++;
                new_arr=Arrays.copyOf(new_arr,count);
                new_arr[new_arr.length-1]=arr[i];
            }
            
        }
        
        return new_arr;
        
    }
}   