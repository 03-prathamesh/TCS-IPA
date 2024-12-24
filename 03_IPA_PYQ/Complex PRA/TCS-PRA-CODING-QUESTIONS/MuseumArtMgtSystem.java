/*
 * Question 3: Museum Art Collection System
Design a system to manage records of museums and artworks. The system should involve two classes: Museum and Artwork. A museum can display multiple artworks.

Class Museum:

Attributes:
museumId (int)
museumName (String)
artworks (Map of artwork ID to Artwork objects)
Class Artwork:

Attributes:
artworkId (int)
title (String)
artistName (String)
Methods in Museum Class:

getArtworksByArtist()
Retrieve and return a list of artwork titles by a specific artist within a museum, sorted alphabetically.

Parameters: list of museum objects, museumId, artistName.
Output: List of titles or "No Artworks Found".

getMuseumsByArtworkId()
Find all museums that display an artwork with a specific ID and return a list of museum names.

Parameters: list of museum objects, artworkId.
Output: List of museum names or "No Museums Found".


2
301
Louvre
3
401
Mona Lisa
Leonardo da Vinci
402
Venus de Milo
Unknown
403
Liberty Leading the People
Eugène Delacroix
302
MET
2
404
Starry Night
Vincent van Gogh
405
The Persistence of Memory
Salvador Dalí
301
Vincent van Gogh
404

Starry Night
Louvre
MET



1
303
British Museum
2
406
Rosetta Stone
Unknown
407
Elgin Marbles
Unknown
303
Leonardo da Vinci
999


No Artworks Found
No Museums Found

 */

 import java.util.ArrayList;
 import java.util.Collection;
 import java.util.Collections;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import java.util.Scanner;
 
 class Artwork{
     private int aId;
     private String title;
     private String aname;
 
     public Artwork(int aId, String title, String a) {
         this.aId = aId;
         this.title = title;
         this.aname = a;
     }
 
 
     public int getaId() {
         return aId;
     }
     public String getTitle() {
         return title;
     }
     public String getAname() {
         return aname;
     }
 
  }
 
  class Museum{
     private int mId;
     private String mName;
     Map<Integer,Artwork> artworks=new HashMap<>();
     public Museum(int mId, String mName) {
         this.mId = mId;
         this.mName = mName;
     }
 
     public void addMesuem(Artwork artwork){
         artworks.put(artwork.getaId(), artwork);
     }
     public int getmId() {
         return mId;
     }
     public String getmName() {
         return mName;
     }
 
  }
 
  class MuseumArtMgtSystem{
 
 
     public static List<String> getArtworksByArtist(List<Museum> museums,int mId,String aname){
         List<String> list=new ArrayList<>();
         for(Museum m:museums){
             if(m.getmId()==mId){
                 for(Artwork a: m.artworks.values()){
                     if(a.getAname().equalsIgnoreCase(aname)){
                         list.add(a.getTitle());
                     }
                 }
             }
         }
         if(list.isEmpty()){
             System.out.println("No Artworks Found");
             return null;
         }
         Collections.sort(list);
         return list;
     }
 
     public static List<String> getMuseumsByArtworkId(List<Museum> museums,int aId){
         List<String> list=new ArrayList<>();
         for(Museum m:museums){
             if(m.artworks.containsKey(aId)){
                 list.add(m.getmName());
             }
         }
         if(list.isEmpty()){
             System.out.println("No Museums Found");
             return null;
         }
         return list;
     }
     public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
         int n=sc.nextInt();
         sc.nextLine();
         List<Museum> museums=new ArrayList<>();
 
         for(int i=0;i<n;i++){
             int mid=sc.nextInt();
             sc.nextLine();
             String mn=sc.nextLine();
 
             Museum m=new Museum(mid, mn);
 
             int ano=sc.nextInt();
             sc.nextLine();
             for(int j=0;j<ano;j++){
                 int id=sc.nextInt();
                 sc.nextLine();
                 String t=sc.nextLine();
                 String a=sc.nextLine();
                  Artwork aa=new Artwork(id, t, a);
                  m.addMesuem(aa);
             }
             museums.add(m);
         }
 
         int aid=sc.nextInt();
         sc.nextLine();
         String aname=sc.nextLine();
         int id=sc.nextInt();
 
         List<String> r1=getArtworksByArtist(museums, aid, aname);
         if(r1!=null){
             for(String s:r1){
                 System.out.println(s);
             }
         }
 
         List<String> r2=getMuseumsByArtworkId(museums,id);
         if(r2!=null){
             for(String s:r2){
                 System.out.println(s);
             }
         }
     }
  }