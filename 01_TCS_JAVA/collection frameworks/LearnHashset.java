
// hashset is used to have only unique element. It doesnt allows duplicate element
// set has different order of elements, order can be change anytime of elements in set
import java.util.Set; // dont use utils. it will give you the error
import java.util.HashSet;

// set is the interface and Hashset is the class. So remember this 
// import java.util.Hashset;
public class LearnHashset {
    public static void main(String[] args) {

        // basic syntax of defining set or Hashset
        Set<Integer> s1 = new HashSet<>();
        // HashSet<Interger>s1=new HashSet<>();
        /*
         * Set<Integer> s1 = new HashSet<>();:
         * Uses the Set interface.
         * More flexible: You can easily switch to another Set type like TreeSet or
         * LinkedHashSet.
         * HashSet<Integer> s1 = new HashSet<>();:
         * Uses the HashSet class directly.
         * Less flexible: You're tied to the HashSet implementation.
         * Do they work differently?
         * Purpose: Both work the same in terms of functionality (storing unique
         * elements), but the first one gives you flexibility to switch the Set
         * implementation without changing much code. eg set<Integet>s1=new LinkedHashset<>(); we have changed only hashset to linkedhashset . this is the main flexibility use
         */
        s1.add(10);
        s1.add(20);
        s1.add(20);
        s1.add(20);  // set(HashSet) wont containt the duplicate elements
        s1.add(20);
        s1.add(30);
        s1.add(40);
        s1.add(50);
        System.out.println(s1);

        //almost all the function of set is same as functions of ArrayList
        //lets remove element 50 from the set
        s1.remove(50);       //.remove() method is used to remove element from the list
        System.out.println(s1);

        if(s1.contains(20)){
            System.out.println("20 is present in the list");

        }
        else{
            System.out.println("20 is not present in the list");
        }

        System.out.println(s1.size()); //.size() used to give total elements in the list

        // .isEmpty() is used to check if set is empty or not
        if(s1.isEmpty()){
            System.out.println("Set is empty");
        }
        else{
            System.out.println("Set has "+s1.size()+" elements");
        }
       
        // set.clear()    used to clear or empty the set

    }
}
