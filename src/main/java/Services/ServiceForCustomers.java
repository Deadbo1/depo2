package Services;

import java.util.Scanner;
import Repository.Repository;
import Models.*;

public class ServiceForCustomers {
    private static ServiceForCustomers serviceForCustomers;

    public static ServiceForCustomers getInstance() {
        if (serviceForCustomers == null) {
            serviceForCustomers = new ServiceForCustomers();
            return serviceForCustomers;
        }
        return serviceForCustomers;
    }

    private Repository repository;
    Scanner in = new Scanner(System.in);

    private ServiceForCustomers() {
        this.repository = Repository.getInstance();
    }

    public void addCustomer(Customers customer) {
        repository.addCustomer(customer);
    }

    public Customers getCustomerById(int id) {
        return repository.getCustomerById(id);
    }

    public void updateCustomer(int id, String firstName, String lastName) {
        Customers updatedCustomer = getCustomerById(id);
        updatedCustomer.setFirstName(firstName);
        updatedCustomer.setLastName(lastName);
        repository.updateCustomer(updatedCustomer);
    }

    public void deleteCustomer(int id) {
        repository.deleteCustomer(getCustomerById(id));
    }

    public Customers createCustomer(String firstName, String lastName, float balance) {
        Customers customer = new Customers();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setBalance(balance);
        repository.addCustomer(customer);
        return customer;
    }

    public Customers getCustomerByFNameAndLName(String fName, String lName) {
        return repository.getCustomerByFNameAndLName(fName,lName);
    }

    public void buyCreateCake(Customers customer, Cakes cake) {
        customer.setBalance(customer.getBalance() - cake.getPrice());
        cake.setAvailable(false);
    }

}
