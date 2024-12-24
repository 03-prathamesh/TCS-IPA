/*
 * Question 3: Library Management System with Genre
Design a system to manage records of books and genres in a library. The system should involve two classes: Genre and Book. 
A genre can have multiple books. Your task is to implement a solution that will maintain a list of Book objects within the Genre class and perform specific operations.

Class Genre:
Attributes:

genreId (int)
genreName (String)
books (Map of book ID to Book objects)
Class Book:
Attributes:

bookId (int)
title (String)
authorName (String)

Methods in Genre Class:

getBooksByAuthor()
This method retrieves and returns a list of book titles written by a specific author within a genre, sorted alphabetically. 
It takes three arguments: a list of genre objects, genreId, and the authorName. If no genre is found, print "Genre Not Found".
 If no books are found by the author, print "No Books Found".





getGenresByBookId()
This method finds all genres that contain a specific book ID and returns a list of genre names.
 It takes two arguments: a list of genre objects and the bookId. If no genres are found containing the book, print "No Genres Found".



Sample Input 1:
2
101
Fiction
3
501
The Great Gatsby
F. Scott Fitzgerald
502
1984
George Orwell
503
To Kill a Mockingbird
Harper Lee
102
Non-Fiction
2
504
Sapiens
Yuval Noah Harari
505
Educated
Tara Westover
101
F. Scott Fitzgerald
502
Sample Output 1:
The Great Gatsby
Fiction

Sample Input 2:
1
103
Science Fiction
1
506
Dune
Frank Herbert
507
nill
0

Sample Output 2:
Genre Not Found
No Genres Found
 */




 import java.util.ArrayList;
 import java.util.Collections;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import java.util.Scanner;
 
 class Genre{
     private int genreId;
     private String genreName;
     Map<Integer,Book> books;
 
     public Genre(int genreId, String genreName) {
         this.genreId = genreId;
         this.genreName = genreName;
         this.books=new HashMap<>();
     }
 
     public void addBook(Book book){
         books.put(book.getBookId(),book);
     }
 
     public int getGenreId() {
         return genreId;
     }
 
     public String getGenreName() {
         return genreName;
     }
 
     
     
 }
 
 class Book{
     private int bookId;
     private String bookTitle;
     private String bookAuthorName;
     public Book(int bookId, String bookTitle, String bookAuthorName) {
         this.bookId = bookId;
         this.bookTitle = bookTitle;
         this.bookAuthorName = bookAuthorName;
     }
     public int getBookId() {
         return bookId;
     }
     public String getBookTitle() {
         return bookTitle;
     }
     public String getBookAuthorName() {
         return bookAuthorName;
     }
 
 }
 
 public class LibrarySystem {
 
     public static List<String> getBookByAuthor(List<Genre> genres,int genreId,String bookAuthorName){
        
        for(Genre g:genres){
           if(g.getGenreId()==genreId){
             List<String> bookTitle=new ArrayList<>();
             for(Book b:g.books.values()){
                 if(b.getBookAuthorName().equalsIgnoreCase(bookAuthorName)){
                     bookTitle.add(b.getBookTitle());
                 }
             }
             if(bookTitle.isEmpty()){
                 System.out.println("No Book Found");
                 return null;
                }
                Collections.sort(bookTitle);
                return bookTitle;
           }
        }
        System.out.println("Genre not found");
        return null;
     }
 
     public static List<String> getGenreByBookId(List<Genre> genres,int bookId){
         List<String> list=new ArrayList<>();
 
         for(Genre g:genres){
             if(g.books.containsKey(bookId)){
                 list.add(g.getGenreName());
             }
         }
         if(list.isEmpty()){
             System.out.println("No Genre found");
             return null;
         }
         return list;
     }
 
     public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
         int n=sc.nextInt();
         List<Genre> genres=new ArrayList<>();
         for(int i=0;i<n;i++){
             int gid=sc.nextInt();
             sc.nextLine();
             String gname=sc.nextLine();
             Genre genre=new Genre(gid, gname);
             int bno=sc.nextInt();
             sc.nextLine();
             for(int j=0;j<bno;j++){
                 int bid=sc.nextInt();
                 sc.nextLine();
                 String t=sc.nextLine();
                 String an=sc.nextLine();
                 Book book=new Book(bid, t, an);
                 genre.addBook(book);
             }
             genres.add(genre);
         }
 
         int gid=sc.nextInt();
         sc.nextLine();
         String aname=sc.nextLine();
         int bid=sc.nextInt();
 
         List<String> r1=getBookByAuthor(genres,gid,aname);
         if(r1!=null){
             for(String s:r1){
                 System.out.println(s);
             }
         }
         
 
         List<String> r2=getGenreByBookId(genres,bid);
         if(r2!=null){
 
             for(String s:r2){
                 System.out.println(s);
             }
         }
         
     }
 }