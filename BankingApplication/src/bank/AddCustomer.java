
import BankingApplication.src.bank.Bank;
import BankingApplication.customer.Customer;

import java.util.Scanner;

public class AddCustomer {

    static void init() {
        Scanner s = new Scanner(System.in);
        int id;
        long accountNo;
        String name;
        double balance = Bank.initialBalance;
        String password;
        System.out.print("Enter Customer Name :");
        name = s.nextLine();
        System.out.print("Enter Password :");
        password = s.nextLine();
        System.out.println("ReEnter Password :");
        String newPassword = s.nextLine();
        if(password.equals(newPassword)){
            id = Customer.lastId+1;
            accountNo = Customer.lastAcNo+1;
            balance = Bank.initialBalance;
            Customer customer = new Customer(id,accountNo,name,balance,password);
        }


    }
}
