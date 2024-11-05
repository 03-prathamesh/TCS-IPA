import java.util.*;


class Projector{

    private int projectorId;
    private String projectorName;
    private int price;
    private int ratings;
    private String availableIn;

    public Projector(int projectorId, String projectorName, int price, int ratings,String availableIn){
        this.projectorId=projectorId;
        this.projectorName=projectorName;
        this.price=price;
        this.ratings=ratings;
        this.availableIn=availableIn;
    }

    public int getProjectorId(){
        return projectorId;
    }
    public String getProjectorName(){
        return projectorName;
    }
    public int getPrice(){
        return price;
    }
    public int getRatings(){
        return ratings;
    }
    public String getAvailableIn(){
        return availableIn;
    }

}


public class Problem2 {
    public static void main(String [] args){
        
        Scanner sc=new Scanner(System.in);
        Projector pro[]=new Projector[4];
        for(int i=0;i<4;i++){
            int a =sc.nextInt();
            sc.nextLine();
            String b =sc.nextLine();
            int c =sc.nextInt();
            sc.nextLine();
            int d =sc.nextInt();
            sc.nextLine();
            String e=sc.nextLine();

            pro[i]=new Projector(a,b,c,d,e);
        }

        int ratings=sc.nextInt();
        sc.nextLine();

        Projector a=findMaxPriceByRatings(pro, ratings);
        if(a==null){
            System.out.println("No Such Projector");
        }
        else{
            System.out.println(a.getProjectorId());
        }
    }

    public static Projector findMaxPriceByRatings(Projector pr[],int ratings){
        List<Projector>ans=new ArrayList<>();
        for(int i=0;i<pr.length;i++){
            if(pr[i].getRatings()>ratings &&  pr[i].getAvailableIn().contains("TataCliq")){
                ans.add(pr[i]);
            }
        }
        if(ans.isEmpty()){
            return null;
        }
        Collections.sort(ans,(s1,s2)->Integer.compare(s2.getPrice(), s1.getPrice()));
        return ans.get(0);
    }
}
