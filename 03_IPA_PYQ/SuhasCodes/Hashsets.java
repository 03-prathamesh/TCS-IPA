import java.util.*;

public class Hashsets{

      public static void main(String [] args){


          int arr[]=new int[5];
          for(int i=0;i<arr.length-1;i++){
            arr[i]=i+1;
          }
          arr[arr.length-1]=1;
        //   HashSet<Integer>h1=new HashSet<>(Arrays.asList(arr)); it wont work for primitive datat types , with work with String and objects
          
           HashSet<Integer>h1=new HashSet<>();
           for(int i=0;i<arr.length;i++){
               h1.add(arr[i]);
           }

           for(Integer i:h1){

              System.out.println(i);
           }

           Set<Integer>s1=new LinkedHashSet<>();
           //only make change here HashSet<>();
           s1.add(40);
           s1.add(30);
           s1.add(90);
           s1.add(10);
           s1.add(30);
           
           int elem=30;
        //    for(Integer a:s1){
        //       if(a.contains(elem)){ //it will give you the error
        //         System.out.println("Element is Present");
        //       }
        //    }
        if(s1.contains(elem)){
            System.out.println("Element is Present in the set");
        }

        //lets convert this set into a List
        List<Integer>l1=new ArrayList<>(s1);
        for(Integer a:l1){
            System.out.print(a+" ");
        }
      }

}