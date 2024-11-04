import java.util.*;

class Genre{


    private int genreId;
    private String genreName;
    private Map<Integer,Movies>mp;

    public Genre(int genreId, String genreName, Map<Integer,Movies>mp){
        this.genreId=genreId;
        this.genreName=genreName;
        this.mp=mp;
    }
    
    public int getGenreId(){
        return genreId;
    }
    public String getGenreName(){
        return genreName;
    }
    public Map<Integer,Movies>getMap(){
        return mp;
    }
    
    //methods
    public static List<String>getMoviesByDirector(List<Genre>g, int genreId, String director){

        List<String>ans=new ArrayList<>();
        for(Genre gs:g){
            if(gs.getGenreId()==genreId){
                for(Movies m:gs.mp.values()){
                    if(m.getDirector().equalsIgnoreCase(director)){
                        ans.add(m.getTitle());
                    }
                }
            }
        }
        if(ans.isEmpty()){
            return null;    
        }
        Collections.sort(ans,(s1,s2)->s1.compareTo(s2));
        // Collection.sort(ans);
        return ans;
    }
     
    public static List<String>getGenresByMoviesId(List<Genre>gn, int movieId){
      
        List<String>ans=new ArrayList<>();
        for(Genre g:gn){
            if(g.getMap().containsKey(movieId)){
                ans.add(g.getGenreName());
            }
        }

       if(ans.isEmpty()){
        return null;
       }
       return ans;
        
    }


}

class Movies{

     private int movieId;
     private String title;
     private String director;

     public Movies(int movieId,String title,String director){
        this.movieId=movieId;
        this.title=title;
        this.director=director;
     }

     public int getMovieId(){
        return movieId;
     }
     public String getTitle(){
        return title;
     }
     public String getDirector(){
        return director;
     }

}
public class MovieDatabaseProblem{
    public static void main(String [] args){

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); sc.nextLine();
        List<Genre>gen=new ArrayList<>();
        for(int i=0;i<n;i++){
            int a=sc.nextInt(); sc.nextLine();
            String b=sc.nextLine();

            List<Movies>mp=new ArrayList<>();
            int size=sc.nextInt(); sc.nextLine();
            Map<Integer,Movies>map=new HashMap<>();
            for(int j=0;j<size;j++){
                int p=sc.nextInt(); sc.nextLine();
                String q=sc.nextLine();
                String r=sc.nextLine();

                // mp.add(new Movies(p,q,r));
                
               
                
                map.put(p,new Movies(p,q,r));
            }
            gen.add(new Genre(a,b,map));

        }
        int ab=sc.nextInt(); sc.nextLine();
        String bc=sc.nextLine();    
        int cd=sc.nextInt(); sc.nextLine();

        List<String>ans1=Genre.getMoviesByDirector(gen, ab, bc);
        if(ans1!=null){
            for(String s:ans1){
                System.out.println(s);
            }
        }else{
            System.out.println("No Movies Found");
        }

        List<String>ans2=Genre.getGenresByMoviesId(gen, cd);
        if(ans2!=null){
            for(String s:ans2){
                System.out.println(s);
            }
        }else{
            System.out.println("No genres found");
        }
       
        
    }
}