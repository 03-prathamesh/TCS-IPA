import java.util.*;

class Fruit{
    private int fruitId;
    private String fruitName;
    private int price;
    private int ratings;

    public Fruit(int fruitId,String fruitName, int price, int ratings){
        this.fruitId=fruitId;
        this.fruitName=fruitName;
        this.price=price;
        this.ratings=ratings;
    }

    public int getFruitId(){
        return fruitId;
    }
    

    public String getFruitName(){
        return fruitName;
    }
    public int getPrice(){
        return price;
    }
    public int getRatings(){
        return ratings;
    }
}


public class IPA21 {
    public static void main(String [] args){



        Scanner sc=new Scanner(System.in);
        Fruit fruits[]=new Fruit[4];
        for(int i=0;i<4;i++){
            int p=sc.nextInt();
            sc.nextLine();
            String a=sc.nextLine();
            int b=sc.nextInt();
            int c=sc.nextInt();
            sc.nextLine();

            fruits[i]=new Fruit(p,a,b,c);
        }

        int ratings=sc.nextInt();
        sc.nextLine();

        Fruit ans=findMaximumPriceByRating(fruits,ratings);
        if(ans==null){
            System.out.println("No Such Fruit");
        }
        else{
            System.out.println(ans.getFruitId());
        }
    }

    public static Fruit findMaximumPriceByRating(Fruit ft[], int ratings){

         List<Fruit>f=new ArrayList<>();
         for(int i=0;i<ft.length;i++){
            if(ft[i].getRatings()>ratings){
                f.add(ft[i]);
            }
         }
         if(f.isEmpty()){
            return null;
         }

         Collections.sort(f,(s1,s2)->Integer.compare(s2.getPrice(),s1.getPrice()));
         Fruit fruits[]=f.toArray(new Fruit[0]);
         return fruits[0];
    }
}
