import java.util.Scanner;

class Resort{

  private int resortId;
  private String resortName;
  private String category;
  private double price;
  private double rating;

  //constructor
  public Resort(int resortId, String resortName, String category, double price, double rating){
     this.resortId=resortId;
     this.resortName=resortName;
     this.price=price;
     this.category=category;
     this.rating=rating;
  }

  // lets write the getter methods
  public int getResortId(){
    return resortId;
  }

  public String getResortName(){
    return resortName;
  }
  
  public String getCategory(){
    return category;
  }

  public double getPrice(){
    return price;
  }
  public double getRatings(){{
    return rating;
  }}

}





public class ResortProblem{


    public static void main(String [] args){
          
        // lets create array of Resort Object
        Resort r[]=new Resort[4];
        Scanner ip=new Scanner(System.in);
        for(int i=0;i<r.length;i++){
            int id=ip.nextInt();
            ip.nextLine();
            String name=ip.nextLine();
            String category=ip.nextLine();
            double price=ip.nextDouble();
            double ratings=ip.nextDouble();
            ip.nextLine();
            
            r[i]=new Resort(id,name,category,price,ratings);
           
            
        }
        String parameter=ip.nextLine(); 
        int avg=findAvgPriceByCategory(r, parameter);
        if(avg>0){
          System.out.println(avg);
        }
        else{
          System.out.println("There are no such available Resort");
        }

        

    }



    public static int findAvgPriceByCategory(Resort[] rs, String parameter){
        
       int avg=0;
       int count=0;
       int finalAvg=0;
      
       for(int i=0;i<rs.length;i++){
           if(rs[i].getCategory().equalsIgnoreCase(parameter) && rs[i].getRatings()>4){
               avg=avg+(int)(rs[i].getPrice()); 
               //avg+=rs[i].getPrice();  //it is same as above java will implicitely converts it to int while loosing fractional part
               count++;
           }
       }

       if(count>0){
          finalAvg=avg/count;
          return finalAvg;
       }
       return count;


        
    }
}