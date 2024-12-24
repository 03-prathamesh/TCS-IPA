/*
 * Library Borrowing System
Class: Member
Attributes:
memberId: int
name: String
borrowedBooks: List of Book objects
membershipLevel: String ("Gold", "Silver", "Bronze")
Class: Book
Attributes:
bookId: int
title: String
author: String
borrowedDate: String ("YYYY-MM-DD")
Methods:
getBooksBorrowedInYear

Retrieves a list of book titles borrowed by a specific member in a given year.
Parameters: list of Member objects, memberId, year.
Output: List of book titles, or "No Books Borrowed" if none are found.
getFrequentBorrowersByMembershipLevel

Identifies members who borrowed more than a certain number of books (e.g., 5) in the last year, grouped by membership level.
Parameters: list of Member objects, minBooksBorrowed.
Output: List of member names with their membership level.
Sample Test Case
Input:

3
101
Helen
Gold
2
801
The Iliad
Homer
2023-01-12
802
The Aeneid
Virgil
2023-04-23
102
Ian
Silver
3
803
The Divine Comedy
Dante Alighieri
2023-06-14
804
Paradise Lost
John Milton
2023-09-19
805
The Inferno
Dante Alighieri
2023-11-03
103
Jake
Bronze
1
806
Metamorphoses
Ovid
2023-02-10
2023
1
5
No Books Borrowed
Jake, Bronze
Ian, Silver
Helen, Gold
 */




 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import java.util.Scanner;
 
 class Books3{
     private int bid;
     private String title;
     private String author;
     private String date;
     public Books3(int bid, String title, String author, String date) {
         this.bid = bid;
         this.title = title;
         this.author = author;
         this.date = date;
     }
     public int getBid() {
         return bid;
     }
     public String getTitle() {
         return title;
     }
     public String getAuthor() {
         return author;
     }
     public String getDate() {
         return date;
     }
 
 }
 
 class Member{
     private int mid;
     private String mn;
     private String level;
     List<Books3> books=new ArrayList<>();
     public Member(int mid, String mn,String level) {
         this.mid = mid;
         this.mn = mn;
         this.level=level;
     }
 
     public void addBooks(Books3 b){
         books.add(b);
     }
     public int getMid() {
         return mid;
     }
     public String getMn() {
         return mn;
     }
     public String getLevel(){
         return level;
     }
 
     
 }
 
 
 
 class LibraryBorrowSystem{
 
     public static List<String> getBooksBorrowedInYear(List<Member> members,int mid,int yr){
         List<String> list=new ArrayList<>();
         for(Member m:members){
             if(m.getMid()==mid){
                 for(Books3 b:m.books){
                     String dates=b.getDate();
                     String arr[]=dates.split("-");
                     int y=Integer.parseInt(arr[0]);
                     if(y==yr){
                         list.add(b.getTitle());
                     }
 
                 }
                 break;
             }
         }
         if(list.isEmpty()){
             System.out.println("No Books Borrowed");
             return null;
         }
         return list;
     }
 
     public static Map<String, String> getFrequentBorrowersByMembershipLevel(List<Member> members,int minBookBorrow){
         Map<String,String> list=new HashMap<>();
         for(Member m:members){
             if(minBookBorrow>m.books.size()){
                 list.put(m.getMn(), m.getLevel());
             }
         }
         return list;
     }
 
     public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
         int n=sc.nextInt();
         List<Member> members=new ArrayList<>();
         for(int i=0;i<n;i++){
             int mid=sc.nextInt();sc.nextLine();
             String name=sc.nextLine();
             String level=sc.nextLine();
             Member m=new Member(mid, name,level);
 
             int bno=sc.nextInt();sc.nextLine();
             for(int j=0;j<bno;j++){
                 int bid=sc.nextInt();sc.nextLine();
                 String t=sc.nextLine();
                 String a=sc.nextLine();
                 String d=sc.nextLine();
                 Books3 b=new Books3(bid, t, a, d);
                 m.addBooks(b);
             }
             members.add(m);
         }
 
         int mid=sc.nextInt();sc.nextLine();
         int yr=sc.nextInt();sc.nextLine();
         int min=sc.nextInt();sc.nextLine();
 
         List<String> r1=getBooksBorrowedInYear(members, mid, yr);
         if(r1!=null){
             for(String s:r1){
                 System.out.println(s);
             }
         }
 
         Map<String,String> r2=getFrequentBorrowersByMembershipLevel(members,min);
         for(Map.Entry<String,String> entry:r2.entrySet()){
             System.out.println(entry.getKey()+", "+entry.getValue());
         }
 
     }
 }