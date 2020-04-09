package Repository;

import Models.Customers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepositoryForCustomers {

    private static RepositoryForCustomers repositoryForCustomers;

    public static RepositoryForCustomers getInstance() {
        if (repositoryForCustomers == null) {
            repositoryForCustomers = new RepositoryForCustomers();
            return repositoryForCustomers;
        }
        return repositoryForCustomers;
    }

    private HashMap<Integer, Customers> customers = new HashMap<Integer, Customers>();

    public void addCustomer(Customers customer){
        customers.put(customer.getId(),customer);
    }

    public Customers getCustomerById(int id) {
        return customers.get(id);
    }

    public Customers getCustomerByFNameAndLName(String fName, String lName) {
        List<Customers> customers = new ArrayList<Customers>(getCustomers().values());
        Customers cust = null;
        for (Customers customer : customers) {
            if(customer.getFirstName().equals(fName) && customer.getLastName().equals(lName)){
                cust = customer;
            }
        }
        return cust;
    }

    public void deleteCustomer(Customers customer)
    {
        customers.remove(customer.getId());
    }

    public void updateCustomer(Customers customer) {
        deleteCustomer(customer);
        addCustomer(customer);
    }

    public HashMap<Integer, Customers> getCustomers() {
        return customers;
    }
}
