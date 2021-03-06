package Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import Repository.RepositoryForCakesBases;
import Views.*;
import Services.*;

public class ControllerForCakeBase {
    private static ControllerForCakeBase controllerForCakeBase;

    public static ControllerForCakeBase getInstance() {
        if (controllerForCakeBase == null) {
            controllerForCakeBase = new ControllerForCakeBase();
            return controllerForCakeBase;
        }
        return controllerForCakeBase;
    }

    private ViewEditCakeBase viewEditCakeBase;

    private ServiceForCakeBase serviceForCakeBase;

    private Service service;

    private ControllerForCakeBase() {
        this.viewEditCakeBase = ViewEditCakeBase.getInstance();
        this.serviceForCakeBase = ServiceForCakeBase.getInstance();
        this.service = Service.getInstance();
    }

    public void menu() throws IOException {
        Scanner in = new Scanner(System.in);
        viewEditCakeBase.menu();
        System.out.println("Choose your option");
        String chose = in.next();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        if ("1".equals(chose)) {
            System.out.println("Enter the name of cake base");
            String name = br.readLine();
            System.out.println("Enter price");
            float price = in.nextFloat();
            serviceForCakeBase.createCakeBases(name, price);
            System.out.println(serviceForCakeBase.getCakesBases());
            service.wantToContinue();
        } else if ("2".equals(chose)) {
            System.out.println(serviceForCakeBase.getCakesBases());
            System.out.println("Enter the number of the desired base");
            int id = in.nextInt();
            serviceForCakeBase.deleteCakeBases(id);
            System.out.println(serviceForCakeBase.getCakesBases());
            service.wantToContinue();
        } else if ("3".equals(chose)) {
            System.out.println(serviceForCakeBase.getCakesBases());
            System.out.println("Enter the number of the desired base");
            int id = in.nextInt();
            System.out.println(serviceForCakeBase.getCakeBasesById(id));
            System.out.println("Enter new name");
            String name = br.readLine();
            System.out.println("Enter new price");
            float price = in.nextFloat();
            serviceForCakeBase.updateCakeBases(id, name, price);
            System.out.println(serviceForCakeBase.getCakeBasesById(id));
            service.wantToContinue();
        } else if ("4".equals(chose)) {
            System.out.println("Select a search method:\n 1.By name \n 2.By Price \n 3.By Name and price \n 4.Show all cake base");
            String i = in.next();
            if ("1".equals(i)) {
                System.out.println("Enter the name of cake base");
                String name = br.readLine();
                System.out.println(serviceForCakeBase.getCakeBasesByName(name));
                service.wantToContinue();
            } else if ("2".equals(i)) {
                System.out.println("Enter price of cake base");
                float price = in.nextFloat();
                System.out.println(serviceForCakeBase.getCakeBasesByPrice(price));
                service.wantToContinue();
            } else if ("3".equals(i)) {
                System.out.println("Enter the name of cake base");
                String name = br.readLine();
                System.out.println("Enter price of cake base");
                float price = in.nextFloat();
                System.out.println(serviceForCakeBase.getCakeBasesByNameAndPrice(name, price));
                service.wantToContinue();
            } else {
                System.out.println(serviceForCakeBase.getCakeBasesAll());
                service.wantToContinue();
            }
        } else {
            Controller controller = Controller.getInstance();
            controller.start();
        }
    }

}
