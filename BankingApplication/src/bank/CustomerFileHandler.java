package BankingApplication.bank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import BankingApplication.customer.Customer;

public class CustomerFileHandler {
    private static final String fileName = "bank_customer.txt";
    public void initialize () throws IOException{
        File file = new File(fileName);
        List<Customer> customers = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String customer = reader.readLine();
        do {
            Customer cust = HandleCustomerStr(customer);
            customers.add(cust);
            customer = reader.readLine();
        } while (customer != null);

        Bank.customers = customers;
    }
    private Customer HandleCustomerStr(String cust){
        String[] customerData = cust.split(" ");
        int id = Integer.parseInt(customerData[0]);
        long acNo = Long.parseLong(customerData[1]);
        String name = customerData[2];
        double balance = Double.parseDouble(customerData[3]);
        String password = customerData[4];
        Customer customer =  new Customer(id, acNo, name, balance, password);
        return customer;
    }
}
