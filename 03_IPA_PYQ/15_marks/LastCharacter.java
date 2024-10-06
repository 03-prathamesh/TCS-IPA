
import java.util.Scanner;
public class LastCharacter {
    public static void main(String[] args){


         //print the last character of every word, dont use any digits and white spaces
         Scanner sc=new Scanner(System.in);
         String str=sc.nextLine();
         String ans="";
         String temp[]=str.split(" ");
         for(int i=0;i<temp.length;i++){
             int size=temp[i].length();
             if((temp[i].charAt(size-1)>='A' && temp[i].charAt(size-1)<='Z') ||  (temp[i].charAt(size-1)>='a' && temp[i].charAt(size-1)<='z')){
                ans=ans+temp[i].charAt(size-1);
             }

         }
         System.out.println(ans);
    }
}
