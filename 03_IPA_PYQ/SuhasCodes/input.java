import java.util.*;
class Player{

    int playerId;
    public Player(int playerId){
        this.playerId=playerId;
    }

}
public class input{
    public static void main(String [] args){


        Scanner sc=new Scanner(System.in);
        
        Player p[]=new Player[2];
        int a=sc.nextInt();
        // sc.nextLine();
        p[0]=new Player(a);
        int b=sc.nextInt();
        sc.nextLine();
        p[1]=new Player(b);

        System.out.print("Enter your name: ");
        String name=sc.nextLine();
       System.out.println(p[0].playerId);
       System.out.println(p[1].playerId);
       System.out.println(name);

    }
}