package Controllers;

import Models.*;
import Repository.*;
import Views.*;
import Services.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControllerForSaleCake {
    private static ControllerForSaleCake controllerForSaleCake;

    public static ControllerForSaleCake getInstance() {
        if (controllerForSaleCake == null) {
            controllerForSaleCake = new ControllerForSaleCake();
            return controllerForSaleCake;
        }
        return controllerForSaleCake;
    }

    private ViewForSaleCake viewForSaleCake;

    private Service service;

    private ServiceForCakeBase serviceForCakeBase;

    private ServiceForCakes serviceForCakes;

    private ServiceForCustomers serviceForCustomers;

    private ServiceForDecoration serviceForDecoration;

    private RepositoryForCakesCharacteristics repositoryForCakesCharacteristics;

    private ControllerForSaleCake() {
        this.viewForSaleCake = ViewForSaleCake.getInstance();
        this.service = Service.getInstance();
        this.serviceForCakes = ServiceForCakes.getInstance();
        this.serviceForCustomers = ServiceForCustomers.getInstance();
        this.serviceForCakeBase = ServiceForCakeBase.getInstance();
        this.serviceForDecoration = ServiceForDecoration.getInstance();
        this.repositoryForCakesCharacteristics = RepositoryForCakesCharacteristics.getInstance();
    }

    public void menu(Customers customer) throws IOException {
        viewForSaleCake.menu();
        Scanner in = new Scanner(System.in);
        System.out.println("Choose your option");
        String answer = in.next();
        if ("1".equals(answer)) {
            System.out.println("Do you want to search the desired cake or you want to get all list? \n Press 1 if you want to search or press 2 if you want to get all list");
            String an = in.next();
            if ("1".equals(an)) {
                System.out.println("Enter the cake base id");
                System.out.println(serviceForCakeBase.getCakesBases());
                int cakeBaseId = in.nextInt();
                System.out.println("Chose quantity of decorations");
                int k = in.nextInt();
                System.out.println(serviceForDecoration.getDecorations());
                List<Integer> decorations = new ArrayList<Integer>();
                for (int i = 0; i < k; i++) {
                    decorations.add(in.nextInt());
                }
                System.out.println(serviceForCakes.getCakes());
                System.out.println(serviceForCakes.getCakeByCakeBaseAndFewDecorations(cakeBaseId, decorations));
                List<Cakes> cakes = serviceForCakes.getCakeByCakeBaseAndFewDecorations(cakeBaseId, decorations);
                for (Cakes cake : cakes) {
                    if (customer.getBalance() > cake.getPrice() && cake.isAvailable()) {
                        serviceForCustomers.buyCreateCake(customer, cake);
                    } else {
                        if (!cake.isAvailable()) {
                            System.out.println("The desired cake is not available");
                            Controller controller = Controller.getInstance();
                            controller.start();
                        } else {
                            System.out.println("Not enough money");
                            Controller controller = Controller.getInstance();
                            controller.start();
                        }
                    }
                }
                System.out.println(serviceForCakes.getCakes());
                System.out.println(customer.getBalance());
                service.wantToContinue();
            } else {
                System.out.println(serviceForCakes.getCakes());
                System.out.println("Enter id of the desired cake");
                int cakeId = in.nextInt();
                Cakes cake = serviceForCakes.getCakeById(cakeId);
                System.out.println(service.getRepositoryForCakes().getCakes());
                if (customer.getBalance() > cake.getPrice() && cake.isAvailable()) {
                    serviceForCustomers.buyCreateCake(customer, cake);
                } else {
                    if (!cake.isAvailable()) {
                        System.out.println("The desired cake is not available");
                        Controller controller = Controller.getInstance();
                        controller.start();
                    } else {
                        System.out.println("Not enough money");
                        Controller controller = Controller.getInstance();
                        controller.start();
                    }
                }
                System.out.println(customer.getBalance());
                System.out.println(service.getRepositoryForCakes().getCakes());
                service.wantToContinue();
            }
        } else if ("2".equals(answer)) {
            System.out.println("Chose quantity of decorations");
            int k = in.nextInt();
            System.out.println("Choose your decoration");
            System.out.println(serviceForDecoration.getDecorations());
            List<Integer> decorations = new ArrayList<Integer>();
            for (int i = 0; i < k; i++) {
                decorations.add(in.nextInt());
            }
            System.out.println("Enter cake name");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String name = br.readLine();
            System.out.println("Chose your cake base");
            System.out.println(serviceForCakeBase.getCakesBases());
            int cakeBaseId = in.nextInt();
            System.out.println("Enter characteristic cake name");
            String chaName = br.readLine();
            System.out.println("Describe the cake");
            String subscription = br.readLine();
            System.out.println(serviceForCakes.getCakes());
            Cakes cake = serviceForCakes.createCake(decorations, cakeBaseId, name, chaName, subscription, customer);
            List<CakesCharacteristics> cakesCharacteristics = repositoryForCakesCharacteristics.getCakesCharacteristics();
            System.out.println(serviceForCakes.getCakes().get(cake.getId()));
            serviceForCakes.getSubscription(cake.getId(), cakesCharacteristics);
            System.out.println(serviceForCakes.getCakes());
            if (customer.getBalance() > cake.getPrice() && cake.isAvailable()) {
                serviceForCustomers.buyCreateCake(customer, cake);
                System.out.println(serviceForCakes.getCakes());
                System.out.println(customer.getBalance());
                service.wantToContinue();
            } else {
                if (!cake.isAvailable()) {
                    System.out.println("The desired cake is not available");
                    Controller controller = Controller.getInstance();
                    controller.start();
                } else {
                    System.out.println("Not enough money");
                    Controller controller = Controller.getInstance();
                    controller.start();
                }
            }
        } else {
            Controller controller = Controller.getInstance();
            controller.start();
        }
    }
}
