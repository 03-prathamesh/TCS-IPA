import java.util.*;

public class StringBuilder {
    public static void main(String [] args){
              
        Map<Character,Integer>mp=new TreeMap<>();

        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        for(int i=0;i<s.length();i++){
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
        }
        // for(Integer ip:mp.values()){
        //     System.out.println(ip);
        // }
        // for(Character c:mp.keySet()){
        
        //     System.out.println(c);
        // }
        for(Map.Entry<Character,Integer>m:mp.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }


        String newString="Hello World";
        Set<Character>st=new TreeSet<>();
        for(int i=0;i<newString.length();i++){
            if(!st.contains(newString.charAt(i)) || newString.charAt(i)!=' '){
                st.add(newString.charAt(i));
            }
        }
        for(Character sp:st){
            System.out.println(sp);
        }


        int num=100;
        String str=String.valueOf(num);
        System.out.println(str);

        String my="100";
        int get=Integer.parseInt(my);
        System.out.println(get);

    }
}
