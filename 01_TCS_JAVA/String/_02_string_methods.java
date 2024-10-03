public class _02_string_methods {
    public static void main(String[] args){

// all this methods gives new string to you , it doesnt modify exhisting string. purani string vaise ki vaisehi padi rahegi memory me , garbage collector apna role play karega fir
// in methods se purane wale string ke andar koi  change nahi ho raha

        //1] .toUpperCase: -32 and .toLowerCase() +32
        String name="prathamesh";
        System.out.println(name.toUpperCase());
        // System.out.println(up);

        char ch[]=name.toCharArray();     // converting the string to character array
        for(int i=0;i<ch.length;i++){
            ch[i]=(char)(ch[i]-32);
        }
        name= new String(ch);      //converting charArray to the string
        System.out.println(name);

        //2] .trim() : used to remove the spaces from front and back
        String c="    catch the ball      ";
        System.out.println(c.trim());

        //3] .startsWith(): 
        System.out.println("Carpet".startsWith("Car"));

        //4] endsWith(): 
        System.out.println("Carpet".endsWith("pet"));

        String petName="tommy";
        char cp=petName.charAt(1);
        System.out.println(cp);

        //5] valueOf(): used to convert number value into string 
        int age=123;
        String ages=String.valueOf(age+2);
        System.out.println(ages+2);

        // 6].replace(): 
        String sentence="I love java, Java is a good language";
        // lets replace java with c++
        System.out.println(sentence.replace("java","c++"));
        System.out.println(sentence);
        sentence=sentence.replace("java","c++");

        // String newSentence=sentence.replace("language", "lang");
        // System.out.println(newSentence);
        // System.out.println(sentence);

        boolean cont=sentence.contains("c++");
        System.out.println(cont);

        //7] .subString(inclusive, exclusive);
        String substr=sentence.substring(1,6);
        System.err.println(substr);

        //8] .split(): it will return array of string
        String myName="My name is Prathamesh!";
        String words[]=myName.split(" ");
        for(int i=0;i<words.length;i++){
            System.out.print(words[i]);
        }

        //9] .toCharArray(): used to convert a string into the character array
        String color="Brown";
        char arr[]=color.toCharArray();
        arr[0]='p';
        color =new String(arr);
        System.err.println(color);

        //10] .isEmpty()
        // 11] .isBlank(): even if you have spaces and dont have any char then it considers as blank string


    }
}
