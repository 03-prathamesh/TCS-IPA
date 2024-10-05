import java.util.Scanner;

public class StringProblem {
    public static void main(String[] args){



        //lets read the string 
        // all search should be case insensitive
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();

        //test case 1:  Everyone should practice and learn to become professional
        int count=0;
        String temp="";
        for(int i=0;i<str.length();i++){
       
             
             if(str.charAt(i)!=' '){
                  temp=temp+str.charAt(i);
             }
             else{
                temp=temp.toUpperCase();
                 if(temp.charAt(0)=='A' || temp.charAt(0)=='E' || temp.charAt(0)=='I' || temp.charAt(0)=='O' || temp.charAt(0)=='U'  ){
                    count++;
                 }
                 temp="";
             }


        }
                temp=temp.toUpperCase();
                 if(temp.charAt(0)=='A' || temp.charAt(0)=='E' || temp.charAt(0)=='I' || temp.charAt(0)=='O' || temp.charAt(0)=='U'  ){
                    count++;
                 }

                if(count>0){
                    System.out.println(count);
                }
                else{
                    System.out.println("No string found");
                }


        
    }
}
