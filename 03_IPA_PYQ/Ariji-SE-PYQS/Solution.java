import java.util.*;

class Fruits{
    private int fruitId;
    private String fruitName;
    private int price;
    private int ratings;
    
    //parameterised constructor
    public Fruits(int fruitId, String fruitName, int price, int ratings){
        this.fruitId=fruitId;
        this.fruitName=fruitName;
        this.price=price;
        this.ratings=ratings;
    }
    
    //getter methods
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

public class Solution{
    public static void main(String [] args){ 
     Scanner sc=new Scanner(System.in);
     //lets create the object of class Fruits
     Fruits fr[]=new Fruits[4];
     for(int i=0;i<fr.length;i++){
         int id=sc.nextInt();
         sc.nextLine();
         String name=sc.nextLine();
         int price=sc.nextInt();
         sc.nextLine();
         int ratings=sc.nextInt();
         sc.nextLine();
         
         fr[i]=new Fruits(id,name,price,ratings);
     }
     
     int ratings=sc.nextInt();
     sc.nextLine();
     
     Fruits fruitAns=findMaximumPriceByRatings(fr,ratings);
     if(fruitAns!=null){
         System.out.println(fruitAns.getFruitId());
     }
     else{
         System.out.println("No such Fruit");
     }
    }
     
     public static Fruits findMaximumPriceByRatings(Fruits arr[],int ratings){
         int low=0;
         //Fruits f;
         for(int i=0;i<arr.length;i++){
             if(arr[i].getPrice()>low && arr[i].getRatings()>ratings){
                 low=arr[i].getPrice();
                
             }
         }
         
         for(int i=0;i<arr.length;i++){
             if(arr[i].getPrice()==low){
                //f=arr[i];
                 return arr[i];
                 //return f;
                 
             }
         }
         return null;
     }
     
     
     
     
}