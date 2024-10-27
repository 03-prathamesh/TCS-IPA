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
        //sc.nextLine(); // try to comment this to get the difference and run when commenting and uncommenting this
        p[1]=new Player(b);

        System.out.print("Enter your name: "); //readin after p[1] of int 

        String name=sc.nextLine();  //very very imp here try to comment this and uncomment following name
        // int name=sc.nextInt();
       System.out.println(p[0].playerId);
       System.out.println(p[1].playerId);
       System.out.println(name);

    }
}