import java.util.*;

class Spotify{

    private int spotifyId;
    private String subscriptionName;
    private String subscriptionType;
    private double subscriptionPrice;
    private String subscriptionAvailable;

    public Spotify(int spotifyId, String subscriptionName, String subscriptionType, Double subscriptionPrice, String subscriptionAvailable){
        this.spotifyId=spotifyId;
        this.subscriptionName=subscriptionName;
        this.subscriptionType=subscriptionType;
        this.subscriptionAvailable=subscriptionAvailable;
        this.subscriptionPrice=subscriptionPrice;
    }

    public int getId(){
        return spotifyId;
    }
    public String getName(){
        return subscriptionName;
    }
    public String getSpotifyType(){
        return subscriptionType;
    }
    public double getSpotifyPrice(){
        return subscriptionPrice;

    }
    public String getAvailable(){
        return subscriptionAvailable;
    }

}
public class SpotifyProblem{


      public static void main(String [] args){
           Scanner sc=new Scanner(System.in);
           Spotify sp[]=new Spotify[4];
           for(int i=0;i<4;i++){
                int a=sc.nextInt();
                sc.nextLine();
                String b=sc.nextLine();
                String c =sc.nextLine();
                Double d=sc.nextDouble();
                sc.nextLine();
                String e=sc.nextLine();

                sp[i]=new Spotify(a,b,c,d,e);
           }
           String param1=sc.nextLine();
           String param2=sc.nextLine();

           Double ans=getAvg(sp, param1, param2);
           if(ans>0){
              System.out.println(ans);
           }
           else{
            System.out.println("Not Present");
           }
        }
      

      public static double getAvg(Spotify sp[], String param1, String param2){
          
            int sum=0;
            int  count=0;
            for(int i=0;i<sp.length;i++){
                 if(sp[i].getSpotifyType().equalsIgnoreCase(param1) && sp[i].getAvailable().equalsIgnoreCase(param2)){
                    sum+=sp[i].getSpotifyPrice();
                    count++;
                 }
            }
            if(count==0){
                return 0.0;
            }
            return sum/count;
      }
    

}

