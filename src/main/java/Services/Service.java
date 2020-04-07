package Services;

import Controllers.Controller;
import Repository.Repository;
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


    public Repository getRepository() {
        return repository;
    }


    private Repository repository;


    private Service() {
        this.repository = Repository.getInstance();
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
        repository.addCakeBase(cakesBases);
        repository.addCakeBase(cakesBases1);
        repository.addCakeBase(cakesBases2);
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
        repository.addDecorationsCharacteristics(decorationsCharacteristics);
        repository.addDecorationsCharacteristics(decorationsCharacteristics1);
        repository.addDecorationsCharacteristics(decorationsCharacteristics2);
        repository.addDecorationsCharacteristics(decorationsCharacteristics3);
        repository.addDecorationsCharacteristics(decorationsCharacteristics4);
        repository.addDecoration(decorations);
        repository.addDecoration(decorations1);
        repository.addDecoration(decorations2);
        repository.addDecoration(decorations3);
        repository.addDecoration(decorations4);
        List<Integer> decorationId = new ArrayList<Integer>();
        decorationId.add(decorations.getId());
        List<Integer> decorationId1 = new ArrayList<Integer>();
        decorationId1.add(decorations.getId());
        decorationId1.add(decorations2.getId());
        List<Integer> decorationId2 = new ArrayList<Integer>();
        decorationId2.add(decorations.getId());
        decorationId2.add(decorations1.getId());
        Customers customers = new Customers(0,"Admin","Admin");
        Cakes cakes = new Cakes(customers,"Бисквитный Торт с вишней", cakesBases, 450, decorationId);
        Cakes cakes1 = new Cakes(customers,"Торт с вишней", cakesBases1, 500, decorationId1);
        Cakes cakes2 = new Cakes(customers,"Шоколадный Торт с вишней", cakesBases2, 630, decorationId2);
        Characteristics characteristics5 = new Characteristics(cakes.getName(), "Лучший");
        Characteristics characteristics6 = new Characteristics(cakes1.getName(), "Лучш");
        Characteristics characteristics7 = new Characteristics(cakes2.getName(), "Лучши");
        CakesCharacteristics cakesCharacteristics = new CakesCharacteristics(cakes, characteristics);
        CakesCharacteristics cakesCharacteristics1 = new CakesCharacteristics(cakes1, characteristics6);
        CakesCharacteristics cakesCharacteristics2 = new CakesCharacteristics(cakes2, characteristics7);
        repository.addCakesCharacteristics(cakesCharacteristics);
        repository.addCakesCharacteristics(cakesCharacteristics1);
        repository.addCakesCharacteristics(cakesCharacteristics2);
        repository.addCharacteristic(characteristics);
        repository.addCharacteristic(characteristics1);
        repository.addCharacteristic(characteristics2);
        repository.addCharacteristic(characteristics3);
        repository.addCharacteristic(characteristics4);
        repository.addCharacteristic(characteristics5);
        repository.addCharacteristic(characteristics6);
        repository.addCharacteristic(characteristics7);
        repository.addCake(cakes);
        repository.addCake(cakes1);
        repository.addCake(cakes2);
        CakesDecorations cakesDecorations = new CakesDecorations(cakes, decorations);
        CakesDecorations cakesDecorations1 = new CakesDecorations(cakes1, decorations);
        CakesDecorations cakesDecorations2 = new CakesDecorations(cakes1, decorations2);
        CakesDecorations cakesDecorations3 = new CakesDecorations(cakes2, decorations);
        CakesDecorations cakesDecorations4 = new CakesDecorations(cakes2, decorations1);
        repository.addCakesDecorations(cakesDecorations);
        repository.addCakesDecorations(cakesDecorations1);
        repository.addCakesDecorations(cakesDecorations2);
        repository.addCakesDecorations(cakesDecorations3);
        repository.addCakesDecorations(cakesDecorations4);
        log.info("Filled our DB with start data");
    }

}
