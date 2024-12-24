/*
 * 
 * Problem Statement:

Your task is to design a system to manage the records in a music library. The system should involve two classes: Artist and Album. An Artist can have multiple Albums. Your task is to implement a solution that will maintain a list of Album objects within the Artist class and perform specific operations.

Class Definitions:
Class Artist:

Attributes:

artistId: (int)
artistName: (String)
genre: (String)
albums: (List of Album objects)
Class Album:

Attributes:

albumId: (int)
albumTitle: (String)
releaseYear: (int)
Methods:
1. getAlbumsByYearRange()

This method retrieves all album titles released by a particular artist within a specified range of years (inclusive).

Parameters:

artists: List of Artist objects.
artistId: The ID of the artist for whom to retrieve albums.
startYear: The starting year of the range.
endYear: The ending year of the range.
Output:

Returns a list of album titles released within the specified year range.
If no albums are found within the range, print the message "No Albums Found in the Specified Year Range".
If no artist is found, print the message "Artist Not Found".
2. getGenresWithMostAlbums()

This method identifies and returns the genre that has the most albums released across all artists.

Parameters:

artists: List of Artist objects.
Output:

Returns the genre with the most albums.
If no albums are found, print the message "No Albums Found".
These methods should be called from the main method.

Sample Input 1:
yaml
Copy code
3
201
Adele
Pop
3
1001
21
2011
1002
25
2015
1003
30
2021
202
Taylor Swift
Pop
2
1004
1989
2014
1005
Red
2012
203
Linkin Park
Rock
2
1006
Hybrid Theory
2000
1007
Meteora
2003
201
2010
2020
Sample Output 1:
21
25
Red
------------
Pop
------------
Sample Input 2:
2
301
Jazz
Sample Output 2:
Artist Not Found
No Albums Found
 */



 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import java.util.Scanner;
 
 class Artist{
     private int artistId;
     private String artistName;
     private String artistGenre;
     List<Album> albums;
     public Artist(int artistId, String artistName, String artistGenre) {
         this.artistId = artistId;
         this.artistName = artistName;
         this.artistGenre = artistGenre;
         this.albums=new ArrayList<>();
     }
 
     public void addAlbums(Album album){
         albums.add(album);
     }
 
     public int getArtistId() {
         return artistId;
     }
 
     public String getArtistName() {
         return artistName;
     }
 
     public String getArtistGenre() {
         return artistGenre;
     }
 
 }
 
 
 class Album{
 
     private int albumId;
     private String albumTitle;
     private int albumReleaseYear;
 
     
     public Album(int albumId, String albumTitle, int albumReleaseYear) {
         this.albumId = albumId;
         this.albumTitle = albumTitle;
         this.albumReleaseYear = albumReleaseYear;
     }
 
 
     public int getAlbumId() {
         return albumId;
     }
 
 
     public String getAlbumTitle() {
         return albumTitle;
     }
 
 
     public int getAlbumReleaseYear() {
         return albumReleaseYear;
     }
 
     
 
 
 }
 public class MusicSystem {
 
     public static List<String> getAlbumsByYearRange(List<Artist> artists,int artistId,int sYear,int endYear){
         for(Artist a:artists){
             if(a.getArtistId()==artistId){
                 List<String> titles=new ArrayList<>();
                 for(Album al:a.albums){
                     if(al.getAlbumReleaseYear()>=sYear && al.getAlbumReleaseYear()<=endYear){
                         titles.add(al.getAlbumTitle());
                     }
                 }
                 if(titles.isEmpty()){
                     System.out.println("No Albums Found in the Specified Year Range");
                     return null;
                 }
                 return titles;
             }
         }
         System.out.println("Artist Not Found");
         return null;
     }
 
     public static String getGenresWithMostAlbums(List<Artist> artists){
         int max=Integer.MIN_VALUE;
         HashMap<String,Integer> hm=new HashMap<>();
          for(Artist a:artists){
             hm.put(a.getArtistGenre(), hm.getOrDefault(a.getArtistGenre(),0)+1);
          }
          for(Map.Entry<String,Integer> entry:hm.entrySet()){
             if(entry.getValue()>max){
                 max=entry.getValue();
             }
          }
          for(Map.Entry<String,Integer> entry:hm.entrySet()){
             if(entry.getValue()==max){
                 return entry.getKey();
             }
          }
         return "No Album Found";
     }
 
     public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
         List<Artist> artists=new ArrayList<>();
         int no=sc.nextInt();
         sc.nextLine();
         for(int i=0;i<no;i++){
             int aid=sc.nextInt();
             sc.nextLine();
             String n=sc.nextLine();
             String g=sc.nextLine();
             Artist artist=new Artist(aid, n, g);
             int ano=sc.nextInt();
             sc.nextLine();
             for(int j=0;j<ano;j++){
                 int id=sc.nextInt();
                 sc.nextLine();
                 String t=sc.nextLine();
                 int yr=sc.nextInt();
                 sc.nextLine();
                 Album album=new Album(id, t, yr);
                 artist.addAlbums(album);
             }
             artists.add(artist);
         }
 
         int aid=sc.nextInt();
         sc.nextLine();
         int sy=sc.nextInt();
         sc.nextLine();
         int ey=sc.nextInt();
         sc.nextLine();
 
         List<String> r1=getAlbumsByYearRange(artists, aid, sy, ey);
         if(r1!=null){
             for(String s:r1){
                 System.out.println(s);
             }
         }
 
         String r2=getGenresWithMostAlbums(artists);
         System.out.println(r2);
     }
     
 }