/*
 * Question 1: Movie Database System
Design a system to manage records of movies and genres in a movie database. 
The system should involve two classes: Genre and Movie. A genre can have multiple movies.

Class Genre:

Attributes:
genreId (int)
genreName (String)
movies (Map of movie ID to Movie objects)
Class Movie:

Attributes:
movieId (int)
title (String)
director (String)
Methods in Genre Class:

getMoviesByDirector()
Retrieve and return a list of movie titles directed by a specific director within a genre, sorted alphabetically.
Parameters: list of genre objects, genreId, director.
Output: List of titles or "No Movies Found" if no movies match the director.
getGenresByMovieId()
Find all genres that contain a specific movie ID and return a list of genre names.
Parameters: list of genre objects, movieId.
Output: List of genre names or "No Genres Found" if the movie ID is not found.


2
101
Action
3
501
Die Hard
John McTiernan
502
Mad Max: Fury Road
George Miller
503
Gladiator
Ridley Scott
102
Drama
2
504
Forrest Gump
Robert Zemeckis
505
The Shawshank Redemption
Frank Darabont
101
George Miller
502

Mad Max: Fury Road
Action
Drama


1
103
Sci-Fi
2
506
Interstellar
Christopher Nolan
507
The Matrix
The Wachowskis
103
James Cameron
999

No Movies Found
No Genres Found

 */

 import java.util.ArrayList;
 import java.util.Collections;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import java.util.Scanner;
 
 class Movies{
     private int mId;
     private String title;
     private String dir;
 
     public Movies(int mId, String title, String dir) {
         this.mId = mId;
         this.title = title;
         this.dir = dir;
     }
 
     public int getmId() {
         return mId;
     }
     public String getTitle() {
         return title;
     }
     public String getDir() {
         return dir;
     }
     
  }
 
 
 
 
  class Genres{
     private int gId;
     private String gname;
     Map<Integer,Movies> movies=new HashMap<>();
     
     public Genres(int gId, String gname) {
         this.gId = gId;
         this.gname = gname;
     }
 
     public void addMovie(Movies movie){
         movies.put(movie.getmId(), movie);
     }
 
     public int getgId() {
         return gId;
     }
 
     public String getGname() {
         return gname;
     }
 
     
  }
 public class MovieDatabaseProblem {
     
     public static List<String> getMoviesByDirector(List<Genres> genres,int gId,String dir){
         List<String> title=new ArrayList<>();
 
         for(Genres g:genres){
             if(g.getgId()==gId){
                 for(Movies m:g.movies.values()){
                     if(m.getDir().equalsIgnoreCase(dir)){
                         title.add(m.getTitle());
                     }
                 }
             }
         }
         if(title.isEmpty()){
             System.out.println("No Movies Found");
             return null;
         }
         Collections.sort(title);
         return title;
     }
 
     public static List<String> getGenresByMovieId(List<Genres> genres,int mId){
         List<String> list=new ArrayList<>();
         for(Genres g:genres){
             if(g.movies.containsKey(mId)){
                 list.add(g.getGname());
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
         List<Genres>genres=new ArrayList<>();
         int n=sc.nextInt();
         sc.nextLine();
         for(int i=0;i<n;i++){
             int id=sc.nextInt();
             sc.nextLine();
             String gn=sc.nextLine();
             Genres g=new Genres(id, gn);
 
             int mno=sc.nextInt();
             sc.nextLine();
             for(int j=0;j<mno;j++){
                 int mid=sc.nextInt();
                 sc.nextLine();
                 String t=sc.nextLine();
                 String d=sc.nextLine();
                 Movies m=new Movies(mid, t, d);
                 g.addMovie(m);
             }
             genres.add(g);
         }
         int gid=sc.nextInt();
         sc.nextLine();
         String dir=sc.nextLine();
         int mid=sc.nextInt();
         
         List<String> r1=getMoviesByDirector(genres,gid,dir);
         if(r1!=null){
             for(String s:r1){
                 System.out.println(s);
             }
         }
 
         List<String> r2=getGenresByMovieId(genres,mid);
         if(r2!=null){
             for(String s:r2){
                 System.out.println(s);
             }
         }
 
     }
 }