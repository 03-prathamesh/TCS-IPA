import java.util.*;

class Bill{

    private int billNo;
    private String name;
    private String typeOfConnection;
    private double billAmount;
    private boolean status;


    //constructor
    public Bill(int billNo, String name, String typeOfConnection, double billAmount, boolean status){
        this.billNo=billNo;
        this.name=name;
        this.typeOfConnection=typeOfConnection;
        this.billAmount=billAmount;
        this.status=status;
    }
    //getters
    public int getBillNo(){
        return billNo;
    }
    public String getName(){
        return name;
    }
    public String getTypeOfConnection(){
        return typeOfConnection;
    }
    public double getBillAmount(){
        return billAmount;
    }
    public boolean getStatus(){
        return status;
    }

}



public class BillProblem {
    public static void main(String [] args){

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        Bill b[]=new Bill[n];
        for(int i=0;i<n;i++){
            int p=sc.nextInt();
            sc.nextLine();
            String q=sc.nextLine();
            String r=sc.nextLine();
            Double s=sc.nextDouble();
            sc.nextLine();
            boolean t=sc.nextBoolean();
            sc.nextLine();

            b[i]=new Bill(p,q,r,s,t);
        }
        boolean param=sc.nextBoolean();
        sc.nextLine();
        String param2=sc.nextLine();
        Bill ans[]=findBillWithMaxBillAmountBasedOnStatus(b, param);
        if(ans==null){
            System.out.println("There are no bills with the given status");
        }
        else{
            for(int i=0;i<ans.length;i++){
                System.out.println(ans[i].getBillNo()+"#"+ans[i].getName());
            }
        }

        int ans2=getCountWithTypeOfConnection(b, param2);
        if(ans2==0){
            System.out.println("There are no bills with the given type of connection");
        }
        else{
            System.out.println(ans2);
        }

    }

    public static Bill[] findBillWithMaxBillAmountBasedOnStatus(Bill b[], boolean status){

       double max=Double.MIN_VALUE;
       for(int i=0;i<b.length;i++){
           if(b[i].getBillAmount()>max){
             max=b[i].getBillAmount();
           }
       }
       List<Bill>ans=new ArrayList<>();

       for(int i=0;i<b.length;i++){
        if(b[i].getBillAmount()==max && b[i].getStatus()==status){
             ans.add(b[i]);
        }
       }

       Bill [] newAns=ans.toArray(new Bill[0]);
       Arrays.sort(newAns, (s1,s2)->Integer.compare(s1.getBillNo(), s2.getBillNo()));
       
       if(newAns.length!=0){
        return newAns;
       }

        return null;
    }

    public static int getCountWithTypeOfConnection(Bill b[], String typeOfCon){
        int ans=0;
        for(int i=0;i<b.length;i++){
            if(b[i].getTypeOfConnection().equalsIgnoreCase(typeOfCon)){
                ans++;
            }
        }
        return ans;
    }
}
