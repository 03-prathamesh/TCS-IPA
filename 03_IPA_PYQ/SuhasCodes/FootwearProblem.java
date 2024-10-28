import java.util.*;


class Footwear{

    private int footwearId;
    private String  footwearName;
    private String footwearType;
    private int price;

    public Footwear(int footwearId, String footwearName, String footwearType, int price){
        this.footwearId=footwearId;
        this.footwearName=footwearName;
        this.footwearType=footwearType;
        this.price=price;
    }

    public int getId(){
        return footwearId;
    }
    public String getFootwearName(){

        return footwearName;
    }

    public String getFootwearType(){
        return footwearType;
    }
    public int getPrice(){
        return price;
    }
}


public class FootwearProblem{

    public static void main(String [] args){
      

        Scanner sc=new Scanner(System.in);
        Footwear f[]=new Footwear[5];
        for(int i=0;i<f.length;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            String c=sc.nextLine();
            int d=sc.nextInt();
            sc.nextLine();

            f[i]=new Footwear(a,b,c,d);
        }

        String param1=sc.nextLine();
        String param2=sc.nextLine();

        int ans1=getCountByType(f, param1);
        if(ans1==0){
            System.out.println("Footwear not available");
        }
        else{
            System.out.println(ans1);
        }

        Footwear ans2[]=getSecondHighestFootwearByBrand(f, param2);
        if(ans2==null){
            System.out.println("Brand not available");
        }else{
            for(Footwear f1:ans2){
                System.out.println(f1.getId());
                System.out.println(f1.getFootwearName());
                System.out.println(f1.getPrice());
                
            }
        }
        
    }

    public static int getCountByType(Footwear ft[], String param){
        int count=0;
        for(Footwear f:ft){
            if(f.getFootwearType().equalsIgnoreCase(param)){
                count++;
            }
        }
        return count;
    }
    public static Footwear[] getSecondHighestFootwearByBrand(Footwear ft[], String param){
        List<Footwear>l1=new ArrayList<>();
         for(Footwear f:ft){
            if(f.getFootwearName().equalsIgnoreCase(param)){
              l1.add(f);
            }
         }
         if(l1.isEmpty()){
            return null;
         }
         Collections.sort(l1,(s1,s2)->Integer.compare(s2.getPrice(),s1.getPrice()));
         boolean check=false;
         int first=l1.get(0).getPrice();
         int secondHighestPrice=0;
         for(Footwear l:l1){
            if(l.getPrice()!=first){
                secondHighestPrice=l.getPrice();
                check=true;
                break;
            }
         }
         if(check==false){
            return null;
         }
         List<Footwear>ans=new ArrayList<>();
         for(Footwear f:l1){
            if(f.getPrice()==secondHighestPrice){
                ans.add(f);
            }
         }
         return ans.toArray(new Footwear[0]);
    }
}