package Services;

import Repository.*;
import Models.*;
import org.apache.log4j.Logger;

import java.util.HashMap;

public class ServiceForCustomers {
    private static ServiceForCustomers serviceForCustomers;

    public static ServiceForCustomers getInstance() {
        if (serviceForCustomers == null) {
            serviceForCustomers = new ServiceForCustomers();
            return serviceForCustomers;
        }
        return serviceForCustomers;
    }
    private static final Logger log = Logger.getLogger(ServiceForCustomers.class);

    private RepositoryForCustomers repositoryForCustomers;

    private ServiceForCustomers() {
        this.repositoryForCustomers = RepositoryForCustomers.getInstance();
    }

    public void addCustomer(Customers customer) {
        repositoryForCustomers.addCustomer(customer);
        log.info("Customer "+ customer +" add to DB");
    }

    public Customers getCustomerById(int id) {
        return repositoryForCustomers.getCustomerById(id);
    }

    public void updateCustomer(int id, String firstName, String lastName) {
        Customers updatedCustomer = getCustomerById(id);
        log.info("Customer " + updatedCustomer +" before update");
        updatedCustomer.setFirstName(firstName);
        updatedCustomer.setLastName(lastName);
        repositoryForCustomers.updateCustomer(updatedCustomer);
        log.info("Customer " + updatedCustomer +" after update");
    }

    public void deleteCustomer(int id) {
        log.info("Customer " + getCustomerById(id) + "has been deleted");
        repositoryForCustomers.deleteCustomer(getCustomerById(id));
    }

    public Customers createCustomer(String firstName, String lastName, float balance) {
        Customers customer = new Customers();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setBalance(balance);
        addCustomer(customer);
        log.info("Created customer " + customer);
        return customer;
    }

    public Customers getCustomerByFNameAndLName(String fName, String lName) {
        log.info("Customer " + repositoryForCustomers.getCustomerByFNameAndLName(fName,lName) + " was found by first name and last name");
        return repositoryForCustomers.getCustomerByFNameAndLName(fName,lName);
    }

    public void buyCreateCake(Customers customer, Cakes cake) {
        log.info("Customer " + customer + " balance " + customer.getBalance() + " was changed to " + (customer.getBalance()-cake.getPrice()));
        customer.setBalance(customer.getBalance() - cake.getPrice());
        cake.setAvailable(false);
        log.info("Cake " + cake + " was sold");
    }

    public HashMap<Integer, Customers> getCustomers() {
        return repositoryForCustomers.getCustomers();
    }

}
