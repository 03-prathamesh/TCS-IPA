import java.util.*;

class Contact{


    private int contactId;
    private String name;
    private String contactType;
    private int noOfContacts;
    private Set<Integer>phoneNumbers;

    public Contact(int contactId, String name, String contactType, int noOfContacts, Set<Integer>phoneNumbers){
        this.contactId=contactId;
        this.name=name;
        this.contactType=contactType;
        this.noOfContacts=noOfContacts;
        this.phoneNumbers=phoneNumbers;
    }
    
    public int getId(){
        return contactId;
    }
    public String getName(){
        return name;
    }
    public String getContactType(){
        return contactType;
    }
    public int getContacts(){
        return noOfContacts;
    }
    public Set<Integer>getSet(){
         return phoneNumbers;
    }
}

class PhoneBook{

            private String categoryName;
            private int cNum;
            private List<Contact>contactList;

    public PhoneBook(String categoryName, int cNum, List<Contact>contactList){
        this.categoryName=categoryName;
        this.cNum=cNum;
        this.contactList=contactList;
    }

    public String getCategoryName(){
        return categoryName;
    }
    public int getCnum(){
        return cNum;
    }
    public List<Contact>getContactList(){
        return contactList;
    }

}


public class phoneBookManagementSystem{
    public static void main(String [] args){

    }
}