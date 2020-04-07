package Controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import Views.*;
import Models.*;
import Services.*;

public class ControllerForDecoration {
    private static ControllerForDecoration controllerForDecoration;

    public static ControllerForDecoration getInstance() {
        if(controllerForDecoration == null) {
            controllerForDecoration = new ControllerForDecoration();
            return controllerForDecoration;
        }
        return controllerForDecoration;
    }
    private Service service;
    private ServiceForDecoration serviceForDecoration;
    private ViewEditCakeDecoration viewEditCakeDecoration;

    private ControllerForDecoration() {
        this.service = Service.getInstance();
        this.serviceForDecoration = ServiceForDecoration.getInstance();
        this.viewEditCakeDecoration = ViewEditCakeDecoration.getInstance();
    }

    public void menu() throws IOException {
        Scanner in = new Scanner(System.in);
        viewEditCakeDecoration.menu();
        System.out.println("Choose your option");
        String chose = in.next();
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        if ("1".equals(chose)) {
            System.out.println("Enter name decoration");
            String name = br.readLine();
            System.out.println("Enter price decoration");
            float price = in.nextFloat();
            System.out.println("Enter characteristic name");
            String charName = br.readLine();
            System.out.println("Describe the decoration");
            String subscription = br.readLine();
            serviceForDecoration.createDecoration(name, price, charName, subscription);
            System.out.println(service.getRepository().getDecorations());
            service.wantToContinue();
        } else if ("2".equals(chose)) {
            System.out.println(service.getRepository().getDecorations());
            System.out.println("Enter id");
            int id = in.nextInt();
            serviceForDecoration.deleteDecoration(id);
            service.wantToContinue();
        } else if ("3".equals(chose)) {
            System.out.println("What you want to change?: \n 1.Name \n 2.Price \n 3.Name and Price");
            String answer = in.next();
            if ("1".equals(answer)){
                System.out.println(service.getRepository().getDecorations());
                System.out.println(service.getRepository().getCharacteristics());
                System.out.println("Enter id decoration you want to change");
                int id = in.nextInt();
                Decorations decorations = service.getRepository().getDecorationById(id);
                System.out.println("Enter name decoration");
                String name = br.readLine();
                System.out.println("Enter characteristic name");
                String chName = in.next();
                System.out.println("Describe decoration");
                String subscription = br.readLine();
                serviceForDecoration.updateDecoration(id,name,decorations.getPrice(),subscription,chName);
                System.out.println(service.getRepository().getCharacteristics());
                System.out.println(service.getRepository().getDecorations());
                service.wantToContinue();
            } else if ("2".equals(answer)) {
                System.out.println(service.getRepository().getDecorations());
                System.out.println("Enter id decoration you want to change");
                int id = in.nextInt();
                Decorations decorations = service.getRepository().getDecorationById(id);
                System.out.println("Enter price decoration");
                float price = in.nextFloat();
                System.out.println("Enter characteristic name");
                String chName = br.readLine();
                System.out.println("Describe decoration");
                String subscription = br.readLine();
                serviceForDecoration.updateDecoration(id, decorations.getName(), price,subscription,chName);
                service.wantToContinue();
            } else {
                System.out.println(service.getRepository().getDecorations());
                System.out.println("Enter id decoration you want to change");
                int id = in.nextInt();
                System.out.println("Enter name decoration");
                String name = br.readLine();
                System.out.println("Enter price decoration");
                float price = in.nextFloat();
                System.out.println("Enter characteristic name");
                String chName = br.readLine();
                System.out.println("Describe decoration");
                String subscription = br.readLine();
                serviceForDecoration.updateDecoration(id, name, price,subscription,chName);
                service.wantToContinue();
            }
        } else if ("4".equals(chose)) {
            System.out.println("Select a search method:\n 1.By name \n 2.By Price \n 3.By Name and price \n 4.Show all decoration");
            String i = in.next();
            if ("1".equals(i)) {
                System.out.println("Enter the name of decoration");
                String name = br.readLine();
                System.out.println(serviceForDecoration.getDecorationByName(name));
                service.wantToContinue();
            } else if ("2".equals(i)) {
                System.out.println("Enter price of decoration");
                float price = in.nextFloat();
                System.out.println(serviceForDecoration.getDecorationByPrice(price));
                service.wantToContinue();
            } else if ("3".equals(i)) {
                System.out.println("Enter the name of decoration");
                String name = br.readLine();
                System.out.println("Enter price of decoration");
                float price = in.nextFloat();
                System.out.println(serviceForDecoration.getDecorationByNameAndPrice(name, price));
               service.wantToContinue();
            } else {
                System.out.println(serviceForDecoration.getDecorationAll());
                service.wantToContinue();
            }
        } else {
            Controller controller = Controller.getInstance();
            controller.start();
        }
    }

}
