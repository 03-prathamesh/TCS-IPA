import java.util.*;


class Genre{
    private int genreId;
    private String genreName;
    private Map<Integer,Book>books=new HashMap<>();
    
    public Genre(int genreId, String genreName){
          this.genreId=genreId;
          this.genreName=genreName;
    }

    public void addBook(Book book1){
       books.put(book1.getBookId(),book1);
    }

    //getrs
    public int getGenreId(){
        return genreId;
    }
    public String getGenreName(){
       return genreName; 
    }

    public static List<String>getBooksByAuthor(List<Genre>g, String authorName, int genreId){
      
        for(int i=0;i<g.size();i++){
            List<String>ans=new ArrayList<>();
            if(g.get(i).getGenreId()==genreId){
               for(Book b:g.get(i).books.values()){
                   if(b.getAuthorName().equalsIgnoreCase(authorName)){
                      ans.add(b.getTitle());
                   }
               }
               if(ans==null){
                System.out.println("No books found");
                return null;
               }
               Collections.sort(ans);
               return ans;
            }
        }
        System.out.println("genre not found");
        return null;
       
       
    }

    public static List<String>getGenresByBookId(List<Genre>g, int bookId){
        List<String>name=new ArrayList<>();
        for(int i=0;i<g.size();i++){
            for(Book b:g.get(i).books.values()){
                if(b.getBookId()==bookId){
                    name.add(g.get(i).getGenreName());
                }
            }
        }
        if(name.isEmpty()){
            return null;
        }
        return name;
    }

    
    
}

class Book{
    private int bookId;
    private String title;
    private String authorName;

    public Book(int bookId, String title, String authorName){
        this.bookId=bookId;
        this.title=title;
        this.authorName=authorName;
    }
    public int getBookId(){
        return bookId;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthorName(){
        return authorName;
    }

    //method
    
}


public class LibraryManagementProblem {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        // Genre gs[]=new Genre[n];
        List<Genre>gs=new ArrayList<>();
        sc.nextLine();
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            Genre genre=new Genre(a,b);
            int m=sc.nextInt();
            sc.nextLine();
           
            for(int j=0;j<m;j++){

               int p=sc.nextInt();
               sc.nextLine();
               String q=sc.nextLine();
               String r=sc.nextLine();
               
               Book bs=new Book(p,q,r);
               genre.addBook(bs);
             
               
            }
            gs.add(genre);
            
        }


        int genreId = sc.nextInt();
        sc.nextLine();
        String authorName = sc.nextLine();
        int bId = sc.nextInt();

        List<String>ans1=Genre.getBooksByAuthor(gs, authorName, genreId);
        if(ans1==null){
            System.out.println("Genre not found");
        }else{
            for(String s1:ans1){
                System.out.println(s1);
            }
        }

        List<String>ans2=Genre.getGenresByBookId(gs,bId);
        if(ans2==null){
            System.out.println("No genres found");
        }else{
            for(String s:ans2){
                System.out.println(s);
            }
        }
    }

    
}
