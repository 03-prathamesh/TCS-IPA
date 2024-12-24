
/*
 * 3. Online Retail Store
Class: Customer
Attributes:
customerId: int
name: String
loyaltyPoints: int
purchases: List of Purchase objects
Class: Purchase
Attributes:
purchaseId: int
productName: String
category: String
purchaseAmount: double
Methods:
getTopSpendingCustomers

Returns a list of customers who spent above a specified amount on purchases.
Parameters: list of Customer objects, minAmount.
Output: List of customer names or "No Customers Found" if none match.
getPopularProductCategory

Identifies the product category with the highest number of purchases across all customers.
Parameters: list of Customer objects.
Output: The category name with the most purchases.
Sample Test Case
Input:

plaintext
Copy code
2
301
Sophie
500
2
701
Laptop
Electronics
1200.00
702
Headphones
Electronics
150.00
302
Jack
300
2
703
Book
Books
25.00
704
Laptop
Electronics
1000
1000.0
Output:


Sophie
Electronics

 */



 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import java.util.Scanner;
 
 class Purchase{
     private int pid;
     private String pName;
     private String cat;
     private double amt;
     public Purchase(int pid, String pName, String cat, double amt) {
         this.pid = pid;
         this.pName = pName;
         this.cat = cat;
         this.amt = amt;
     }
     public int getPid() {
         return pid;
     }
     public String getpName() {
         return pName;
     }
     public String getCat() {
         return cat;
     }
     public double getAmt() {
         return amt;
     }
 
 }
 
 
 class Customer{
     private int cid;
     private String name;
     private double rp;
     List<Purchase> purchases=new ArrayList<>();
     public Customer(int cid, String name, double rp) {
         this.cid = cid;
         this.name = name;
         this.rp = rp;
     }
 
     public void addPurchase(Purchase p){
         purchases.add(p);
     }
     public int getCid() {
         return cid;
     }
     public String getName() {
         return name;
     }
     public double getRp() {
         return rp;
     }
 
     
 }
 
 public class OnlineRetailStore {
     public static List<String> getTopSpendingCustomers(List<Customer> customers,double minAmt){
         List<String> list=new ArrayList<>();
         for(Customer c:customers){
             for(Purchase p:c.purchases){
                 if(p.getAmt()>minAmt){
                     list.add(c.getName());
                 }
             }
         }
         if(list.isEmpty()){
             System.out.println("No Customers Found");
             return null;
         }
         return list;
     }
 
     public static List<String> getPopularProductCategory(List<Customer> customers){
         List<String> list=new ArrayList<>();
         Map<String,Integer> hm=new HashMap<>();
         int max=Integer.MIN_VALUE;
         for(Customer c:customers){
             for(Purchase p:c.purchases){
                 hm.put(p.getCat(), hm.getOrDefault(p.getCat(),0)+1);
             }
         }
         for(Map.Entry<String,Integer> entry:hm.entrySet()){
             if(entry.getValue()>max){
                 max=entry.getValue();
             }
         }
         for(Map.Entry<String,Integer> entry:hm.entrySet()){
             if(entry.getValue()==max){
                 list.add(entry.getKey());
             }
         }
         return list;
     }
 
     public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
         int n=sc.nextInt();
         List<Customer> customers=new ArrayList<>();
         for (int i = 0; i < n; i++) {
             int cid = sc.nextInt();
             sc.nextLine();
             String cname = sc.nextLine();
             double rp = sc.nextDouble();
             sc.nextLine(); 
             Customer c = new Customer(cid, cname, rp);
     
             int pno = sc.nextInt();
             sc.nextLine(); 
             for (int j = 0; j < pno; j++) {
                 int pid = sc.nextInt();
                 sc.nextLine(); 
                 String pname = sc.nextLine();
                 String cat = sc.nextLine();
                 double amt = sc.nextDouble();
                 sc.nextLine(); 
                 Purchase p = new Purchase(pid, pname, cat, amt);
                 c.addPurchase(p);
             }
             customers.add(c);
         }
 
         double minAmt=sc.nextDouble();sc.nextLine();
         List<String> r1=getTopSpendingCustomers(customers,minAmt);
         if(r1!=null){
             for(String s:r1){
                 System.out.println(s);
             }
         }
 
         List<String> r2=getPopularProductCategory(customers);
         if(r2!=null){
             for(String s:r2){
                 System.out.println(s);
             }
         }
     }
 }