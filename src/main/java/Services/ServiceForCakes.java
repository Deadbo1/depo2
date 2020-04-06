package Services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import Repository.Repository;
import Models.*;

public class ServiceForCakes {

    private static ServiceForCakes serviceForCakes;

    public static ServiceForCakes getInstance() {
        if(serviceForCakes == null) {
            serviceForCakes = new ServiceForCakes();
            return serviceForCakes;
        }
        return serviceForCakes;
    }

    private Repository repository;

    private ServiceForCakes () {
        this.repository = Repository.getInstance();
    }

    public void addCake(Cakes cake) {
        repository.addCake(cake);
    }

    public Cakes getCakeById(int id) {
        return repository.getCakeById(id);
    }

    public void updateCake(int id, String name, CakesBases cakesBases, List<Decorations> decorations) {
        Cakes updatedCake = getCakeById(id);
        updatedCake.setName(name);
        updatedCake.setCakeBase(cakesBases.getId());
        for (Decorations decoration : decorations) {
            updatedCake.addDecorationId(decoration.getId());
        }
        updatedCake.setPrice(cakesBases, decorations);
        repository.updateCake(updatedCake);
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
            newDecorations.add(repository.getDecorationById(decoration));
        }
        newCake.setPrice(repository.getCakeBasesById(cakesBasesId), newDecorations);
        for (Decorations id : newDecorations) {
            CakesDecorations cakesDecorations = new CakesDecorations(newCake, id);
            repository.addCakesDecorations(cakesDecorations);
        }
        repository.addCakesCharacteristics(cakesCharacteristics);
        repository.addCharacteristic(characteristics);
        repository.addCake(newCake);
        return newCake;
    }

    public List<Cakes> getCakeByCakeBaseAndFewDecorations(int cakeBaseId, List<Integer> decorations) {
        List<Cakes> foundCake = new ArrayList<Cakes>();
        Collections.sort(decorations, new Comparator<Integer>() {
            public int compare(Integer integer, Integer t1) {
                return integer.toString().compareTo(t1.toString());
            }
        });
        for (Cakes cake : new ArrayList<Cakes>(repository.getCakes().values())) {
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
        return foundCake;
    }

    public void deleteCake(int id) {
        repository.deleteCake(getCakeById(id));
    }

    public void updateCharacteristicCake(int cakeId, String name, String subscription) {
        Characteristics characteristics;
        for (CakesCharacteristics cakesCharacteristics : repository.getCakesCharacteristics()) {
            if (cakesCharacteristics.getCakeId() == cakeId) {
                characteristics = repository.getCharacteristicById(cakesCharacteristics.getCharacteristicId());
                characteristics.setName(name);
                characteristics.setSubscription(subscription);
                repository.updateCharacteristic(characteristics);
            }
        }
    }

    public void getSubscription(int id,List<CakesCharacteristics> cakesCharacteristics) {
        Characteristics characteristics;
        for (CakesCharacteristics cakesCharacteristic : cakesCharacteristics) {
            if(cakesCharacteristic.getCakeId() == id){
                characteristics = repository.getCharacteristicById(cakesCharacteristic.getCharacteristicId());
                System.out.println(characteristics.getSubscription());
            }
        }
    }

}
