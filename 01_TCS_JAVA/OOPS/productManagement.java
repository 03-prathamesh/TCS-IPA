class Product{

    private int itemNo;
    private String name;
    private float price;
    private short qnt;

 //constructors
  public Product(int i){
    itemNo=i;
  }

  public Product(int i, String s){     // lets say price and quant can be changed 
     itemNo=i;
     name=s;
  }

  public Product(int i,string s, float f, short ss){
    itemNo=i;
    name=s;
    price=f;
    qnt=ss;
  }






    //methods

    public int getItemNO(){
        return itemNo;
    }

    public String getName(){
        return name;
    }

    public float getPrice(){
        return price;
    }

    public short getQuantity(){
        return qnt;
    }


    // lets set the values of price and quant
    public void setPrice(float s){
        price=s;
    }

    public void setQuant(short s){
        qnt=s;
    }




}



public class productManagement {
    public static void main(String[] args){
 



        //now lets create the object of class
        
    }
}
