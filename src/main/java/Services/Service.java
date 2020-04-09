package Services;

import Controllers.Controller;
import Repository.*;
import Models.*;

import java.util.*;
import org.apache.log4j.Logger;

public class Service {

    private static Service service;
    private static final Logger log = Logger.getLogger(Service.class);


    public static Service getInstance() {
        if (service == null) {
            service = new Service();
            return service;
        }
        return service;
    }


    public RepositoryForCakes getRepositoryForCakes() {
        return repositoryForCakes;
    }


    private RepositoryForCakes repositoryForCakes;

    private RepositoryForCakesBases repositoryForCakesBases;

    private RepositoryForDecorations repositoryForDecorations;

    private RepositoryForCharacteristics repositoryForCharacteristics;

    private RepositoryForCustomers repositoryForCustomers;

    private RepositoryForCakesDecorations repositoryForCakesDecorations;

    private RepositoryForCakesCharacteristics repositoryForCakesCharacteristics;

    private RepositoryForDecorationsCharacteristics repositoryForDecorationsCharacteristics;


    private Service() {
        this.repositoryForCakes = RepositoryForCakes.getInstance();
        this.repositoryForCharacteristics = RepositoryForCharacteristics.getInstance();
        this.repositoryForCakesBases = RepositoryForCakesBases.getInstance();
        this.repositoryForDecorations = RepositoryForDecorations.getInstance();
        this.repositoryForCustomers = RepositoryForCustomers.getInstance();
        this.repositoryForCakesDecorations = RepositoryForCakesDecorations.getInstance();
        this.repositoryForCakesCharacteristics = RepositoryForCakesCharacteristics.getInstance();
        this.repositoryForDecorationsCharacteristics = RepositoryForDecorationsCharacteristics.getInstance();
    }

    public void wantToContinue() {
        Scanner in = new Scanner(System.in);
        System.out.println("Do you want to continue?\"y/n\".");
        String a = in.next();
        if ("y".equals(a)){
            Controller controller = Controller.getInstance();
            controller.start();
        } else {
            Controller controller = Controller.getInstance();
            log.info("Customer " + controller.getCustomer() + " leaves the store");
            controller.setCustomer(null);
            controller.start();
        }
    }


    public void fill() {
        CakesBases cakesBases = new CakesBases("Бисквит", 150);
        CakesBases cakesBases1 = new CakesBases("Рыхлое тесто", 100);
        CakesBases cakesBases2 = new CakesBases("Шоколадный Бискваит", 200);
        repositoryForCakesBases.addCakeBase(cakesBases);
        repositoryForCakesBases.addCakeBase(cakesBases1);
        repositoryForCakesBases.addCakeBase(cakesBases2);
        Decorations decorations = new Decorations("Вишня", 50);
        Characteristics characteristics = new Characteristics(decorations.getName(), "Вишенка на торте хайпа");
        DecorationsCharacteristics decorationsCharacteristics = new DecorationsCharacteristics(decorations, characteristics);
        Decorations decorations1 = new Decorations("Шоколад", 100);
        Characteristics characteristics1 = new Characteristics(decorations1.getName(), "Шоколадный шоколад");
        DecorationsCharacteristics decorationsCharacteristics1 = new DecorationsCharacteristics(decorations1, characteristics1);
        Decorations decorations2 = new Decorations("Сливки", 70);
        Characteristics characteristics2 = new Characteristics(decorations2.getName(), "Сливочные сливки");
        DecorationsCharacteristics decorationsCharacteristics2 = new DecorationsCharacteristics(decorations2, characteristics2);
        Decorations decorations3 = new Decorations("Клубника", 50);
        Characteristics characteristics3 = new Characteristics(decorations3.getName(), "Клубничка на торте хайпа");
        DecorationsCharacteristics decorationsCharacteristics3 = new DecorationsCharacteristics(decorations3, characteristics3);
        Decorations decorations4 = new Decorations("Бизе", 70);
        Characteristics characteristics4 = new Characteristics(decorations4.getName(), "Бизешочка");
        DecorationsCharacteristics decorationsCharacteristics4 = new DecorationsCharacteristics(decorations4, characteristics4);
        repositoryForDecorationsCharacteristics.addDecorationsCharacteristics(decorationsCharacteristics);
        repositoryForDecorationsCharacteristics.addDecorationsCharacteristics(decorationsCharacteristics1);
        repositoryForDecorationsCharacteristics.addDecorationsCharacteristics(decorationsCharacteristics2);
        repositoryForDecorationsCharacteristics.addDecorationsCharacteristics(decorationsCharacteristics3);
        repositoryForDecorationsCharacteristics.addDecorationsCharacteristics(decorationsCharacteristics4);
        repositoryForDecorations.addDecoration(decorations);
        repositoryForDecorations.addDecoration(decorations1);
        repositoryForDecorations.addDecoration(decorations2);
        repositoryForDecorations.addDecoration(decorations3);
        repositoryForDecorations.addDecoration(decorations4);
        List<Integer> decorationId = new ArrayList<Integer>();
        decorationId.add(decorations.getId());
        List<Integer> decorationId1 = new ArrayList<Integer>();
        decorationId1.add(decorations.getId());
        decorationId1.add(decorations2.getId());
        List<Integer> decorationId2 = new ArrayList<Integer>();
        decorationId2.add(decorations.getId());
        decorationId2.add(decorations1.getId());
        Customers customers = new Customers(0,"Admin","Admin");
        repositoryForCustomers.addCustomer(customers);
        Cakes cakes = new Cakes(customers,"Бисквитный Торт с вишней", cakesBases, 450, decorationId);
        Cakes cakes1 = new Cakes(customers,"Торт с вишней", cakesBases1, 500, decorationId1);
        Cakes cakes2 = new Cakes(customers,"Шоколадный Торт с вишней", cakesBases2, 630, decorationId2);
        Characteristics characteristics5 = new Characteristics(cakes.getName(), "Лучший");
        Characteristics characteristics6 = new Characteristics(cakes1.getName(), "Лучш");
        Characteristics characteristics7 = new Characteristics(cakes2.getName(), "Лучши");
        CakesCharacteristics cakesCharacteristics = new CakesCharacteristics(cakes, characteristics);
        CakesCharacteristics cakesCharacteristics1 = new CakesCharacteristics(cakes1, characteristics6);
        CakesCharacteristics cakesCharacteristics2 = new CakesCharacteristics(cakes2, characteristics7);
        repositoryForCakesCharacteristics.addCakesCharacteristics(cakesCharacteristics);
        repositoryForCakesCharacteristics.addCakesCharacteristics(cakesCharacteristics1);
        repositoryForCakesCharacteristics.addCakesCharacteristics(cakesCharacteristics2);
        repositoryForCharacteristics.addCharacteristic(characteristics);
        repositoryForCharacteristics.addCharacteristic(characteristics1);
        repositoryForCharacteristics.addCharacteristic(characteristics2);
        repositoryForCharacteristics.addCharacteristic(characteristics3);
        repositoryForCharacteristics.addCharacteristic(characteristics4);
        repositoryForCharacteristics.addCharacteristic(characteristics5);
        repositoryForCharacteristics.addCharacteristic(characteristics6);
        repositoryForCharacteristics.addCharacteristic(characteristics7);
        repositoryForCakes.addCake(cakes);
        repositoryForCakes.addCake(cakes1);
        repositoryForCakes.addCake(cakes2);
        CakesDecorations cakesDecorations = new CakesDecorations(cakes, decorations);
        CakesDecorations cakesDecorations1 = new CakesDecorations(cakes1, decorations);
        CakesDecorations cakesDecorations2 = new CakesDecorations(cakes1, decorations2);
        CakesDecorations cakesDecorations3 = new CakesDecorations(cakes2, decorations);
        CakesDecorations cakesDecorations4 = new CakesDecorations(cakes2, decorations1);
        repositoryForCakesDecorations.addCakesDecorations(cakesDecorations);
        repositoryForCakesDecorations.addCakesDecorations(cakesDecorations1);
        repositoryForCakesDecorations.addCakesDecorations(cakesDecorations2);
        repositoryForCakesDecorations.addCakesDecorations(cakesDecorations3);
        repositoryForCakesDecorations.addCakesDecorations(cakesDecorations4);
        log.info("Filled our DB with start data");
    }

}
