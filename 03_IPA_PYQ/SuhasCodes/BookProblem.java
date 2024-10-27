import java.util.*;

class Book{
    private int id;
    private int pages;
    private String title;
    private String author;
    private double price;

    public Book(int id, int pages, String title, String author, double price){
        this.id=id;
        this.pages=pages;
        this.title=title;
        this.author=author;
        this.price=price;
    }

    public int getId(){
        return id;
    }

    public int getPages(){
        return pages;
    }

    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public double getPrice(){
        return price;
    }

}


public class BookProblem {
    public static void main(String [] args){
           
        Scanner sc=new Scanner(System.in);

        Book b[]=new Book[4];
        for(int i=0;i<b.length;i++){
            int p=sc.nextInt();
            sc.nextLine();
            int q=sc.nextInt();
            sc.nextLine();
            String r=sc.nextLine();
            String s=sc.nextLine();

            Double t=sc.nextDouble();
            sc.nextLine();

            b[i]=new Book(p,q,r,s,t);
        }

        String title=sc.nextLine();
        Book ans[]=findBookWithMaxPrice(b);
        if(ans!=null){
            for(Book bs:ans){
                System.out.println(bs.getId()+" "+bs.getTitle());
            }
            
        }
        else{
            System.out.println("No book found with the mentioned Attribute");
        }

        Book ans2[]=searchBookByTitle(b, title);
        if(ans2!=null){
            for(Book bc:ans2){
                
            }
        }
    }


    public static Book[] findBookWithMaxPrice(Book b[]){

        // Book ans[]=null;
       List<Book>ans=new ArrayList<>();
        double max=Integer.MIN_VALUE;
        for(int i=0;i<b.length;i++){
            if(b[i].getPrice()>max){
                max=b[i].getPrice();
                
            }
        }
        for(int i=0;i<b.length;i++){
            if(b[i].getPrice()==max){
                ans.add(b[i]);
                
            }
        }
        
        if(ans.isEmpty()){
            return null;
        }
        return ans.toArray(new Book[0]);
    }
    public static Book [] searchBookByTitle(Book b[], String title){
        List<Book>l1=new ArrayList<>();
        for(int i=0;i<b.length;i++){
            if(b[i].getTitle().equalsIgnoreCase(title)){
                l1.add(b[i]);
            }
        }
        if(l1.isEmpty()){
            return null;
        }
        return l1.toArray(new Book[0]);
    }
}
