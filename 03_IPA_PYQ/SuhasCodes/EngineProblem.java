import java.util.*;


class Engine{

    private int engineId;
    private String engineName;
    private String engineType;
    private double enginePrice;

    public Engine(int engineId, String engineName, String engineType, double enginePrice){
        this.engineId=engineId;
        this.engineName=engineName;
        this.engineType=engineType;
        this.enginePrice=enginePrice;
    }
    public int getId(){
        return engineId;
    }
    public String getEngineName(){
        return engineName;
    }
    public String getEngineType(){
        return engineType;
    }
    public double getEnginePrice(){
        return enginePrice;
    }
}


public class EngineProblem {
    public static void main(String [] args){
   
       Scanner sc=new Scanner(System.in);
       Engine eng[]=new Engine[4];
       for(int i=0;i<eng.length;i++){
             int a=sc.nextInt();
             sc.nextLine();
             String b=sc.nextLine();
             String c=sc.nextLine();
             Double d=sc.nextDouble();
             sc.nextLine();

             eng[i]=new Engine(a,b,c,d);
       }

       String param1=sc.nextLine();
       String param2=sc.nextLine();
  
       double ans=findAvgPriceByType(eng, param1);
       if(ans!=0){
        System.out.println(ans);
       }
       else{
        System.out.println("There are no Engine with given type");
       }


       Engine ans2[]=searchEngineByName(eng, param2);
       if(ans2!=null){
           for(int i=0;i<ans2.length;i++){
              System.out.println(ans2[i].getId());
           }
       }else{
        System.out.println("There are no Engine with the given name");
       }

    }

    public static double findAvgPriceByType(Engine en[], String param){
         int count=0;
         int avgPrice=0;
         for(int i=0;i<en.length;i++){
            if(en[i].getEngineType().equalsIgnoreCase(param)){
                count++;
                avgPrice+=en[i].getEnginePrice();

            }
         }
         if(count==0){
            return 0;
         }
         return avgPrice/count;
    }
    public static Engine[] searchEngineByName(Engine en[], String param){
        List<Engine>l1=new ArrayList<>();
        for(int i=0;i<en.length;i++){
            if(en[i].getEngineName().equalsIgnoreCase(param)){
                l1.add(en[i]);
            }
        }
        if(l1.isEmpty()){
            return null;
        }
        Collections.sort(l1,(s1,s2)->Integer.compare(s1.getId(),s2.getId()));    
        return l1.toArray(new Engine[0]);
    }
}
