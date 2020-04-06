package Controllers;

import java.io.IOException;
import java.util.Scanner;
import Services.Service;
import Views.*;
import Models.*;

public class Controller {

    private static Controller controller;

    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
            return controller;
        }
        return controller;
    }

    private Service service;
    private ControllerForDecoration controllerForDecoration;
    private ControllerForCakeBase controllerForCakeBase;
    private ControllerForCustomer controllerForCustomer;
    private ControllerForSaleCake controllerForSaleCake;
    private View view;
    private Customers customer;

    Controller() {
        this.service = Service.getInstance();
        this.service.fill();
        this.controllerForCakeBase = ControllerForCakeBase.getInstance();
        this.controllerForDecoration = ControllerForDecoration.getInstance();
        this.controllerForCustomer = ControllerForCustomer.getInstance();
        this.view = View.getInstance();
        this.controllerForSaleCake = ControllerForSaleCake.getInstance();
        this.customer = null;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }


    public void start() {
        Scanner in = new Scanner(System.in);
        if (customer == null) {
            System.out.println("Enter your first name");
            String fName = in.next();
            System.out.println("Enter your last name");
            String lName = in.next();
            Customers test = controllerForCustomer.getServiceForCustomers().getCustomerByFNameAndLName(fName, lName);
            if (test != null) {
                System.out.println("Do you want to update your balance?\"y/n\".");
                this.customer = test;
                String answer1 = in.next();
                if ("y".equals(answer1)) {
                    System.out.println("Enter your balance");
                    float balance = in.nextFloat();
                    this.customer.setBalance(balance);
                }
            } else {
                    System.out.println("Enter quantity of your money");
                    float balance = in.nextFloat();
                    this.customer = controllerForCustomer.getServiceForCustomers().createCustomer(fName, lName, balance);
                }
            }
        view.menu();
        System.out.println("Choose your option");
        String answer = in.next();
        if ("1".equals(answer)) {
            controllerForCakeBase.menu();
        } else if ("2".equals(answer)) {
            controllerForDecoration.menu();
        } else if ("3".equals(answer)) {
            controllerForCustomer.menu(customer);
        } else if ("4".equals(answer)) {
            try {
                controllerForSaleCake.menu(customer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if ("5".equals(answer)) {
            System.out.println("Enter your first name");
            String fiName = in.next();
            System.out.println("Enter your last name");
            String laName = in.next();
            System.out.println(service.getRepository().getCustomers());
            Customers test1 = controllerForCustomer.getServiceForCustomers().getCustomerByFNameAndLName(fiName, laName);
            if (test1 != null) {
                System.out.println("Do you want to update your balance?\"y/n\".");
                String answer1 = in.next();
                if ("y".equals(answer1)) {
                    System.out.println("Enter your balance");
                    float balance = in.nextFloat();
                    this.customer.setBalance(balance);
                }
                this.customer = controllerForCustomer.getServiceForCustomers().getCustomerByFNameAndLName(fiName, laName);
            } else {
                System.out.println("Enter your balance");
                float balance = in.nextFloat();
                this.customer = controllerForCustomer.getServiceForCustomers().createCustomer(fiName, laName, balance);
            }
            System.out.println(service.getRepository().getCustomers());
            start();
        } else if ("0".equals(answer)) {
            System.exit(0);
        } else {
            start();
        }
    }
}
