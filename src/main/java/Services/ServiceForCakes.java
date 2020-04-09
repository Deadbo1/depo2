package Services;

import java.util.*;

import Repository.*;
import Models.*;
import org.apache.log4j.Logger;

public class ServiceForCakes {

    private static ServiceForCakes serviceForCakes;

    public static ServiceForCakes getInstance() {
        if(serviceForCakes == null) {
            serviceForCakes = new ServiceForCakes();
            return serviceForCakes;
        }
        return serviceForCakes;
    }

    private RepositoryForCakes repositoryForCakes;

    private RepositoryForCakesBases repositoryForCakesBases;

    private ServiceForDecoration serviceForDecoration;

    private ServiceForCharacteristics serviceForCharacteristics;

    private RepositoryForCharacteristics repositoryForCharacteristics;

    private RepositoryForCakesDecorations repositoryForCakesDecorations;

    private RepositoryForCakesCharacteristics repositoryForCakesCharacteristics;

    private static final Logger log = Logger.getLogger(ServiceForCakeBase.class);

    private ServiceForCakes () {
        this.repositoryForCakes = RepositoryForCakes.getInstance();
        this.repositoryForCakesCharacteristics = RepositoryForCakesCharacteristics.getInstance();
        this.repositoryForCakesBases = RepositoryForCakesBases.getInstance();
        this.repositoryForCharacteristics = RepositoryForCharacteristics.getInstance();
        this.serviceForDecoration = ServiceForDecoration.getInstance();
        this.serviceForCharacteristics = ServiceForCharacteristics.getInstance();
        this.repositoryForCakesDecorations = RepositoryForCakesDecorations.getInstance();
    }

    public void addCake(Cakes cake) {
        log.info("Cake " + cake + "has been added");
        repositoryForCakes.addCake(cake);
    }

    public Cakes getCakeById(int id) {
        return repositoryForCakes.getCakeById(id);
    }

    public HashMap<Integer, Cakes> getCakes() {
        return repositoryForCakes.getCakes();
    }

    public void updateCake(int id, String name, CakesBases cakesBases, List<Decorations> decorations) {
        Cakes updatedCake = getCakeById(id);
        log.info("Cake " + updatedCake +" before update");
        updatedCake.setName(name);
        updatedCake.setCakeBase(cakesBases.getId());
        for (Decorations decoration : decorations) {
            updatedCake.addDecorationId(decoration.getId());
        }
        updatedCake.setPrice(cakesBases, decorations);
        repositoryForCakes.updateCake(updatedCake);
        log.info("Cake " + updatedCake +" after update");
    }

    public Cakes createCake(List<Integer> decorations, int cakesBasesId, String name, String charName, String subscription, Customers customer) {
        Cakes newCake = new Cakes();
        Characteristics characteristics = new Characteristics();
        CakesCharacteristics cakesCharacteristics = new CakesCharacteristics(newCake, characteristics);
        characteristics.setName(charName);
        characteristics.setSubscription(subscription);
        newCake.setCakeBase(cakesBasesId);
        newCake.setName(name);
        newCake.setCustomerId(customer.getId());
        for (Integer id : decorations) {
            newCake.addDecorationId(id);
        }
        List<Decorations> newDecorations = new ArrayList<Decorations>();
        for (Integer decoration : decorations) {
            newDecorations.add(serviceForDecoration.getDecorationById(decoration));
        }
        newCake.setPrice(repositoryForCakesBases.getCakeBasesById(cakesBasesId), newDecorations);
        for (Decorations id : newDecorations) {
            CakesDecorations cakesDecorations = new CakesDecorations(newCake, id);
            repositoryForCakesDecorations.addCakesDecorations(cakesDecorations);
        }
        repositoryForCakesCharacteristics.addCakesCharacteristics(cakesCharacteristics);
        serviceForCharacteristics.addCharacteristic(characteristics);
        addCake(newCake);
        log.info("Create cake " + newCake + " by customer "+ customer.getFirstName() + " " + customer.getLastName());
        return newCake;
    }

    public List<Cakes> getCakeByCakeBaseAndFewDecorations(int cakeBaseId, List<Integer> decorations) {
        List<Cakes> foundCake = new ArrayList<Cakes>();
        Collections.sort(decorations, new Comparator<Integer>() {
            public int compare(Integer integer, Integer t1) {
                return integer.toString().compareTo(t1.toString());
            }
        });
        for (Cakes cake : new ArrayList<Cakes>(repositoryForCakes.getCakes().values())) {
            if (cake.getCakeBaseId() == cakeBaseId) {
                List<Integer> tempList = cake.getDecorationId();
                Collections.sort(tempList, new Comparator<Integer>() {
                    public int compare(Integer integer, Integer t1) {
                        return integer.toString().compareTo(t1.toString());
                    }
                });
                if (tempList.containsAll(decorations)) {
                    foundCake.add(cake);
                }
            }
        }
        log.info("List of cakes selected by cake base and few decorations " + foundCake);
        return foundCake;
    }

    public void deleteCake(int id) {
        repositoryForCakes.deleteCake(getCakeById(id));
    }

    public void updateCharacteristicCake(int cakeId, String name, String subscription) {
        Characteristics characteristics;
        for (CakesCharacteristics cakesCharacteristics : repositoryForCakesCharacteristics.getCakesCharacteristics()) {
            if (cakesCharacteristics.getCakeId() == cakeId) {
                characteristics = serviceForCharacteristics.getCharacteristicsById(cakesCharacteristics.getCharacteristicId());
                characteristics.setName(name);
                characteristics.setSubscription(subscription);
                repositoryForCharacteristics.updateCharacteristic(characteristics);
            }
        }
    }

    public void getSubscription(int id,List<CakesCharacteristics> cakesCharacteristics) {
        Characteristics characteristics;
        for (CakesCharacteristics cakesCharacteristic : cakesCharacteristics) {
            if(cakesCharacteristic.getCakeId() == id){
                characteristics = serviceForCharacteristics.getCharacteristicsById(cakesCharacteristic.getCharacteristicId());
                System.out.println(characteristics.getSubscription());
                log.info("Description " + characteristics.getSubscription());
            }
        }
    }

}
