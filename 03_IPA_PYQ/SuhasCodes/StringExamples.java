import java.util.*;


public class StringExamples {
    public static void main(String [] args){


        Scanner sc=new Scanner(System.in);
        String myString=sc.nextLine();

        HashMap<Character,Integer>mp=new HashMap<>();

        for(int i=0;i<myString.length();i++){
            if(myString.charAt(i)!=' '){
                mp.put(myString.charAt(i),mp.getOrDefault(myString.charAt(i),0)+1);
            }
        }

        for(Map.Entry<Character,Integer>m:mp.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }


    }
}
