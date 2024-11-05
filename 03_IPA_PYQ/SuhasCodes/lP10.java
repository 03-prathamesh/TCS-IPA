import java.util.*;


class Employees{

    private int employeeId;
    private String name;
    private String branch;
    private double ratings;
    private boolean companyTransport;

    public Employees(int employeeId, String name, String branch, double ratings, boolean companyTransport){
        this.employeeId=employeeId;
        this.name=name;
        this.branch=branch;
        this.ratings=ratings;
        this.companyTransport=companyTransport;
    }

    public int getEmployeeId(){
        return employeeId;
    }
    public String getName(){
        return name;
    }
    public String getBranch(){
        return branch;
    }
    public double getRatings(){
        return ratings;
    }
    public boolean getCompanyTransport(){
        return companyTransport;
    }
}

public class lP10{
    public static void main(String [] args){


        Scanner sc=new Scanner(System.in);
        Employees emp[]=new Employees[4];
        for(int i=0;i<4;i++){
            int a =sc.nextInt();
            sc.nextLine();
            String b =sc.nextLine();
            String c =sc.nextLine();
            double d =sc.nextDouble();
            sc.nextLine();
            boolean e =sc.nextBoolean();
            sc.nextLine();

            emp[i]=new Employees(a,b,c,d,e);
        }

        String ip=sc.nextLine();
        int ans1=findCountOfEmployeesUsingCompanyTransport(emp, ip);
        if(ans1==0){
            System.out.println("no such employees");
        }
        else{
            System.out.println(ans1);
        }

        Employees ans2=findEmployeesWithSecondHighestRatings(emp);
        if(ans2!=null){
            System.out.println(ans2.getEmployeeId());
            System.out.println(ans2.getName());
        }
        else{
            System.out.println("All employees using company transport");
        }

    }

    public static int findCountOfEmployeesUsingCompanyTransport(Employees emp[], String branch){
        int ans=0;
        for(Employees e:emp){
            if(e.getBranch().equals(branch) && e.getCompanyTransport()==true){
                ans++;
            }
        }
        return ans;
    }

    public static Employees findEmployeesWithSecondHighestRatings(Employees emp[]){
        List<Employees>ans=new ArrayList<>();
        for(Employees e:emp){
            if(e.getCompanyTransport()==false){
                ans.add(e);
            }
        }
        if(ans.isEmpty()){
            return null;
        }
        Collections.sort(ans,(s1,s2)->Double.compare(s2.getRatings(),s1.getRatings()));
        return ans.get(1);
    }

}