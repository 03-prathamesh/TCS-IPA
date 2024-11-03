import java.util.*;

class Member{
   private int memberId;
   private String name;
   private String membershipLevel;
   private List<Books>b;

   
   public Member(int memberId, String name, String membershipLevel, List<Books>b){
        this.memberId=memberId;
        this.name=name;
        this.b=b;
        this.membershipLevel=membershipLevel;
   }

   //getters
   public int getMemberId(){
     return memberId;
   }
   public String getName(){
    return name;
   }
   public List<Books>getBooksList(){
    return b;
   }
  public String getMembershilLevel(){
    return membershipLevel;
  }
}


class Books{
     private int bookId;
     private String title;
     private String author;
     private String borrowDate;

     public Books(int bookId, String title, String author, String borrowDate){
        this.bookId=bookId;
        this.title=title;
        this.author=author;
        this.borrowDate=borrowDate;
     }

     public int getBookId(){
        return bookId;
     }
     public String getTitle(){
        return title;
     }
     public String getAuthor(){
        return author;
     }
     public String getBorrowDate(){
        return borrowDate;
     }
}



public class LibraryBorrowSystem{

    public static void main(String [] args){
               
        Scanner sc=new Scanner(System.in);
        int sz=sc.nextInt();
        sc.nextLine();
        List<Member>m=new ArrayList<>();
        for(int i=0;i<sz;i++){
            int a=sc.nextInt();
            sc.nextLine();
            String b=sc.nextLine();
            List<Books>bs=new ArrayList<>();
            String c=sc.nextLine();
            int size=sc.nextInt();
            sc.nextLine();
            for(int j=0;j<size;j++){
                int p=sc.nextInt();
                sc.nextLine();
                String q=sc.nextLine();
                String r=sc.nextLine();
                String s=sc.nextLine();
                bs.add(new Books(p,q,r,s));
            }
            m.add(new Member(a,b,c,bs));
        }

        int ip1=sc.nextInt();
        sc.nextLine();
        int ip2=sc.nextInt();
        sc.nextLine();
        int ip3 =sc.nextInt();
        sc.nextLine();

        List<String>ans1=getBooksByBorrowedInYear(m, ip1,ip2);
        if(ans1!=null){
           for(String s:ans1){
            System.out.println(s);
           }
        }else{
            System.out.println("No Books Borrowed");
        }

        Map<String,String>ans2=getFrequentBorrowersByMembershipLevel(m, ip3);
        for(Map.Entry<String,String>entry:ans2.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

    }

    public static List<String>getBooksByBorrowedInYear(List<Member>mb, int memberId, int year){
        List<String>ans=new ArrayList<>();
        for(Member m:mb){
            if(m.getMemberId()==memberId){
                for(Books bs:m.getBooksList()){
                    String getYear=bs.getBorrowDate();
                    String Arr[]=getYear.split("-");
                    String y=Arr[0];
                    int mainYear=Integer.parseInt(y);
                    if(mainYear==year){
                        ans.add(bs.getTitle());
                    }
                }
            }
        }
        if(ans.isEmpty()){
            return null;
        }
        return ans;
    }
    
    public static Map<String,String>getFrequentBorrowersByMembershipLevel(List<Member>mb,int minBooksBorrowed){
         Map<String,String>ans=new HashMap<>();
         for(Member m:mb){
            if(m.getBooksList().size()<minBooksBorrowed){
                ans.put(m.getName(),m.getMembershilLevel());
            }
         }

        return ans;
    }
}