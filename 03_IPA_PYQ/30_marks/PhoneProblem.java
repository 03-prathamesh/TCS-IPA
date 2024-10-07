import java.util.Scanner;

class Phone{


    private int phoneId;
    private String os;
    private String brand;
    private int price;

    //lets write the parameterised constructor
    public Phone(int phoneId, String os,String brand, int price){
        this.phoneId=phoneId;
        this.os=os;
        this.brand=brand;
        this.price=price;
    }

    //lets write the setter methods;
    public void setId(int phoneId){
        this.phoneId=phoneId;
    }
    public void setOs(String os){
        this.os=os;
    }
    public void setBrand(String brand){
        this.brand=brand;
    }
    public void setPrice(int price){
        this.price=price;
    }

    //no lets write the getter methods
    public int getId(){   //you have to note you fun jave phoneID as it is class but it is defined insidet the function body
        return phoneId;
    }
    public String getOs(){
        return os;
    }
    public String getBrand(){
        return brand;

    }
    public int getPrice(){
        return price;
    }





}








public class PhoneProblem {
    public static void main(String [] args){


        Scanner sc=new Scanner(System.in);
         // 4 objects of Phone class we have to create
         Phone ph[]=new Phone[4];
         for(int i=0;i<ph.length;i++){
            int id=sc.nextInt();
            sc.nextLine();
            String os=sc.nextLine();
            String brand=sc.nextLine();
            int price=sc.nextInt();
            sc.nextLine();


            ph[i]=new Phone(id, os, brand, price);

         }


         //reading the value for brand
         String brand=sc.nextLine();
         int findValue=findPriceForGivenBrand(ph, brand);
        
         //reading the value for os
         String os=sc.nextLine();
         Phone myPhone=phv(ph,os);

         if(findValue>0){
            System.out.println(findValue);
         }
         else{
            System.out.println("The given brand is not available");
         }
         
         if(myPhone==null){
            System.out.println("no phones are available with specified os and price range");
         }
         else{
           int id= myPhone.getId();
           System.err.println(id);

         }

    }


    public static int findPriceForGivenBrand(Phone[] p, String brand){

        int sum=0;
        for(int i=0;i<p.length;i++){
            if(p[i].getBrand().equals(brand)){
                sum=sum+p[i].getPrice();
            }
        }

        return sum;
    }
    
    public static Phone phv(Phone[] arr,String os){
        for(int i=0;i<arr.length;i++){
            if(arr[i].getOs().equals(os) && arr[i].getPrice()>=50000){
               return arr[i];
            }
        }
        return null;
    }


    
}
