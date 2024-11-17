import java.util.*;

public class Problem {
    public static void main(String [] args){
         
        Scanner sc=new Scanner(System.in);
        String myString=sc.nextLine();


        String myArray[]=myString.split(" ");
        for(int i=0;i<myArray.length;i++){
            String s=myArray[i];
            char StrArray[]=s.toCharArray();
            for(int j=0;j<StrArray.length;j++){
                 char var=StrArray[j];
                 if(j==0){
                   StrArray[j]=Character.toUpperCase(var);
                 }
            }
            String n=new String(StrArray);
            // System.out.println(n);
            myArray[i]=n;
        }

        for(String s:myArray){
            System.out.print(s+" ");
        }

        


    }
}
