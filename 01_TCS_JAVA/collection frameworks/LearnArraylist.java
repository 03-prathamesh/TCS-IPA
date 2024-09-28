import java.util.ArrayList;
import java.util.List;

public class LearnArraylist {
    public static void main(String[] args) {
        
        //arraylist is used to store dynamic element in the continuos memory location

        ArrayList<String> StudentsName=new ArrayList<>();       //declaration and definition of arraylist
        
        // 1].add() method is used to add elements in the arraylist
        StudentsName.add("Prathamesh Amundkar");
        StudentsName.add("Prasad Solase");
        StudentsName.add("Nitesh Mali");

        System.out.println("Total students in arraylist are:"+StudentsName.size());

        // add any element in between
        // add(index, element);
        StudentsName.add(1,"Sanket Katkade"); 
        System.out.println("All students are :"+StudentsName);



        //2] addAll()  method is used to add a whole list into another List
        ArrayList<String>s1=new ArrayList<>();
        s1.add("Kiran Bijja");
        s1.add("Vivek Sarade");

        StudentsName.addAll(s1);
        System.out.println(StudentsName);


        //3] get(): used to get any element at any index
        System.out.println(StudentsName.get(2));
       
         // 4] remove() : used to remove element from the list(arraylist)

         List<Integer>a1=new ArrayList<>();
         a1.add(10);
         a1.add(20);
         a1.add(30);
         
         // a1.remove(index);

         a1.remove(1);
        System.out.println(a1);
        //  a1.clear(); // it will remove all the elements from the list
        //  System.out.println(a1);

         //4] how to update the elements: change the element
         // 4] set: used to update the value of elements in the arraylist

           a1.set(0,500);
           System.out.println(a1);


           // 5] contains() function: used to check if the element is present or not. O(N) time complexity
           ArrayList<Integer>arr1=new ArrayList<>();
           arr1.add(10);
           arr1.add(20);
           arr1.add(30);
           arr1.add(40);
           arr1.add(50);

           if(arr1.contains(50)){
             System.out.println("Element is Present");
           }
           else{
              System.out.println("Element is not present");
           }

           //6] size(): used to give the total elements in the list . ie size of the arraylist(list).
           // you can traverse in arralist using normal for loop as well
           //lets traverse throught arraylist using FOR-EACH LOOP
           for(Integer i: arr1){
            System.out.println("The elemenent is: "+i);
           }
       }


}
