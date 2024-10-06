import java.util.Scanner;
public class LargestWord{

    public static void main(String [] args){

         //Find largest word from a given sentence
         //if two string have the same length then print the first one(for printing last one only use >= (greater than equals to))

         Scanner sc=new Scanner(System.in);
         String str=sc.nextLine();

         String temp[]=str.split(" ");
         int prev=Integer.MIN_VALUE;
        //  for(int i=0;i<temp.length;i++){
        //      int size=temp[i].length();
        //      if(size>prev){
        //         prev=size;
        //      }

        //  }
        //  for(int i=0;i<temp.length;i++){
        //     if(temp[i].length()==prev){
        //         System.out.println(temp[i]);
        //         break;
        //     }
        //  }
        int idx=-1;
        for(int i=0;i<temp.length;i++){
            if(temp[i].length()>prev){
                prev=temp[i].length();
                idx=i;
            }
        }
        System.out.println(temp[idx]);

    }
}