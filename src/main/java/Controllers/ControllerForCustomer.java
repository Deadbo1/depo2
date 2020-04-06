package Controllers;

import java.util.Scanner;
import Views.*;
import Models.*;
import Services.*;

public class ControllerForCustomer {
    private static ControllerForCustomer controllerForCustomer;

    public static ControllerForCustomer getInstance() {
        if(controllerForCustomer == null) {
            controllerForCustomer = new ControllerForCustomer();
            return controllerForCustomer;
        }
        return controllerForCustomer;
    }
    private ViewEditCustomer viewEditCustomer;
    private ServiceForCustomers serviceForCustomers;
    private Service service;

    private ControllerForCustomer() {
       this.viewEditCustomer = ViewEditCustomer.getInstance();
       this.serviceForCustomers = ServiceForCustomers.getInstance();
       this.service = Service.getInstance();
    }

    public ServiceForCustomers getServiceForCustomers() {
        return serviceForCustomers;
    }

    public void menu(Customers customer) {
        Scanner in = new Scanner(System.in);
        viewEditCustomer.menu();
        System.out.println("Chose your option");
        String answer = in.next();
        if("1".equals(answer)){
            System.out.println("Enter the first name");
            String fName = in.next();
            serviceForCustomers.updateCustomer(customer.getId(),fName,customer.getLastName());
            service.wantToContinue();
        } else if ("2".equals(answer)) {
            System.out.println("Enter the last name");
            String lName = in.next();
            serviceForCustomers.updateCustomer(customer.getId(),customer.getFirstName(),lName);
            service.wantToContinue();
        } else if ("3".equals(answer)) {
            System.out.println("Enter the first name");
            String fName = in.next();
            System.out.println("Enter the last name");
            String lName = in.next();
            serviceForCustomers.updateCustomer(customer.getId(),fName,lName);
            service.wantToContinue();
        } else {
            Controller controller = Controller.getInstance();
            controller.start();
        }
    }
}
