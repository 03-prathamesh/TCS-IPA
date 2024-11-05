import java.util.*;

class Music{

    private int playListNo;
    private String type;
    private int count;
    private double duration;

    public Music(int playListNo, String type, int count, double duration){
        this.playListNo=playListNo;
        this.type=type;
        this.count=count;
        this.duration=duration;
    }
    public int getPlayListNo(){
        return playListNo;
    }
    public String getType(){
        return type;
    }
    public int getCount(){
        return count;
    }
    public double getDuration(){
        return duration;
    }

}

public class IPA31 {
    public static void main(String [] args){

           Scanner sc=new Scanner(System.in);
           Music mp[]=new Music[4];
           for(int i=0;i<4;i++){
                int a=sc.nextInt();
                sc.nextLine();
                String b=sc.nextLine();
                int c=sc.nextInt();
                double d=sc.nextDouble();
                sc.nextLine();

                mp[i]=new Music(a,b,c,d);
           }
           int inp1=sc.nextInt();
           int inp2=sc.nextInt();
           sc.nextLine();

           int ans1=findAvgOfCount(mp, inp1);
           if(ans1==0){
            System.out.println("No playList fount");

           }
           else{
            System.out.println(ans1);
           }
           Music ans2[]=sortTypeByDuration(mp, inp2);
           if(ans2!=null){
               for(Music m:ans2){
                System.out.println(m.getType());
               }
           }else{
            System.out.println("No playlist found with mentioned attribute");
           }
    }

    public static int findAvgOfCount(Music mp[], int value){
        int sum=0;
        int count=0;
        for(int i=0;i<mp.length;i++){
            if(mp[i].getCount()>value){
               sum=sum+(mp[i].getCount());
               count++;
            }
        }
        if(sum==0){
            return 0;
        }
        return sum/count;
    }

    public static Music[] sortTypeByDuration(Music mp[], int duration){
        List<Music>ans=new ArrayList<>();
        for(int i=0;i<mp.length;i++){
            if(mp[i].getDuration()>duration){
                ans.add(mp[i]);
            }
            
        }
        if(ans.isEmpty()){
            return null;    
        }
        Collections.sort(ans,(s1,s2)->Double.compare(s1.getDuration(),s2.getDuration()));
        return ans.toArray(new Music[0]);
    }
}

