package BankingApplication.Customer;

public class Customer {
    int id;
    public long accountNo;
    public String name;
    double balance;
    String password;

    public static int lastId;
    public static long lastAcNo;
    public Customer(int id,long acNo,String name,double balance,String password){
        this.id = id;
        this.accountNo = acNo;
        this.name = name;
        this.balance = balance;
        this.password = password;
        Customer.lastId = id;
        Customer.lastAcNo = acNo;

    }

}
