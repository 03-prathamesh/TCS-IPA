import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    static String removeDublicates(String s){
        Set<Character> set=new HashSet<>();
        String ans="";
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i)) && s.charAt(i)!=' '){
              continue;
            }
            else{
               ans=ans+s.charAt(i);
               set.add(s.charAt(i));
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        System.out.println(removeDublicates("Arijit Ghosh"));
    }
}