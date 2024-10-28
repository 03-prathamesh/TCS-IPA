import java.util.*;

class HeadSets{

    private String headSetName;
    private String brand;
    private int price;
    private boolean available;

    public HeadSets(String headSetName, String brand, int price, boolean available){
          this.headSetName=headSetName;
          this.brand=brand;
          this.price=price;
          this.available=available;
    }

    public String getName(){
        return headSetName;
    }
    public String getBrand(){
        return brand;
    }
    public int getPrice(){
        return price;
    }
    public boolean getAvailable(){
        return available;
    }
}

public class HeadSetProblem {
    public static void main(String [] args){


        Scanner sc=new Scanner(System.in);
        HeadSets h[]=new HeadSets[4];
        for(int i=0;i<4;i++){
              String a=sc.nextLine();
              String b=sc.nextLine();
              int c=sc.nextInt();
              sc.nextLine();
              boolean d=sc.nextBoolean();
              sc.nextLine();

              h[i]=new HeadSets(a,b,c,d);
        }

        String brand=sc.nextLine();
        int ans1=findTotalPriceForGivenBrand(h, brand);
        if(ans1>0){
            System.out.println(ans1);
        }
        else{
            System.out.println("No headsets available with the given Brand");
        }

        HeadSets ans2=findAvailableHeadsetWithSecMinPrice(h);
        if(ans2==null){
            System.out.println("No headsets available");
        }
        else{
          
                System.out.println(ans2.getName());
                System.out.println(ans2.getPrice());
           
        }
    }

    public static int findTotalPriceForGivenBrand(HeadSets h[], String brand){
        int totalPrice=0;
      
        for(HeadSets s:h){
            if(s.getBrand().equalsIgnoreCase(brand)){
               
                totalPrice=totalPrice+s.getPrice();
            }
        }
        return totalPrice;

    }

    public static HeadSets findAvailableHeadsetWithSecMinPrice(HeadSets h[]){
        List<HeadSets>newH=new ArrayList<>();
        for(HeadSets s:h){
            if(s.getAvailable()){
                newH.add(s);
            }
        }
        if(newH.size()<2){
            return null;
        }
        Collections.sort(newH,(s1,s2)->Integer.compare(s1.getPrice(),s2.getPrice()));
        // list.sort((p1,p2)->Integer.compare(p2.getHeadSetsPrice(),p1.getHeadSetsPrice()));
        return newH.get(1);
    }
}
