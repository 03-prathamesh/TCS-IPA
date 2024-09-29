class Solution {
    public int String_compression(char[] chars) {
        String s="";
        // int count=0;

         int count=1;
         int prev=0;
        for(int i=1;i<chars.length;i++){
            if(chars[prev]==chars[i]){
                count++;
            }
            else if(count==1){
                s=s+chars[prev];
                prev=i;
               
            }
            else{
                s=s+chars[prev];
                s=s+count;
                count=1;
                prev=i;
            }
        }
         
         if(count!=1){
            s=s+chars[chars.length-1];
            s=s+count;
         }
         else{
            s=s+chars[chars.length-1];
         }
        for(int i=0;i<s.length();i++){
            chars[i]=s.charAt(i);
        }
        System.out.println(s);
        return s.length();
    }
}