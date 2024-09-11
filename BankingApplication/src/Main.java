

import BankingApplication.bank.Bank;
import BankingApplication.bank.CustomerFileHandler;

public class Main {
    public static void main(String[] args) {
        CustomerFileHandler handle = new CustomerFileHandler();
        try{
            handle.initialize();
        }catch(Exception e){
            System.out.println(e);
        }

        System.out.println(Bank.customers.size());
        System.out.println("HI hello");
    }
    
}