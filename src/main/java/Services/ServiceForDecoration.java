package Services;

import Models.*;
import Repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class ServiceForDecoration {
    private static ServiceForDecoration serviceForDecoration;

    public static ServiceForDecoration getInstance() {
        if(serviceForDecoration == null){
            serviceForDecoration = new ServiceForDecoration();
            return serviceForDecoration;
        }
        return serviceForDecoration;
    }

    private Repository repository;
    private ServiceForCharacteristics serviceForCharacteristics;

    private ServiceForDecoration() {
        this.repository = Repository.getInstance();
        this.serviceForCharacteristics =ServiceForCharacteristics.getInstance();
    }

    public void addDecorations(Decorations decorations) {
        repository.addDecoration(decorations);
    }

    public Decorations getDecorationById(int id) {
        return repository.getDecorationById(id);
    }

    public void updateDecoration(int id, String name, float price,String subscription,String chName) {
        Decorations updatedDecoration = getDecorationById(id);
        updatedDecoration.setName(name);
        updatedDecoration.setPrice(price);
        serviceForCharacteristics.updateCharacteristicDecoration(id,chName,subscription);
        repository.updateDecorations(updatedDecoration);
    }

    public void createDecoration(String name, float price, String charName, String subscription) {
        Decorations newDecoration = new Decorations();
        Characteristics characteristic = new Characteristics();
        DecorationsCharacteristics decorationsCharacteristics = new DecorationsCharacteristics(newDecoration, characteristic);
        newDecoration.setName(name);
        newDecoration.setPrice(price);
        characteristic.setName(charName);
        characteristic.setSubscription(subscription);
        repository.addDecorationsCharacteristics(decorationsCharacteristics);
        repository.addDecoration(newDecoration);
        repository.addCharacteristic(characteristic);
    }

    public void deleteDecoration(int id) {
        repository.deleteDecoration(getDecorationById(id));
    }

    public List<Decorations> getDecorationByName(String name) {
        List<Decorations> decorations = new ArrayList<Decorations>(repository.getDecorations().values());
        List<Decorations> foundDecorations = new ArrayList<Decorations>();
        for (Decorations decoration : decorations) {
            if (decoration.getName().equals(name)) {
                foundDecorations.add(decoration);
            }
        }
        return foundDecorations;
    }

    public List<Decorations> getDecorationByPrice(float price) {
        List<Decorations> decorations = new ArrayList<Decorations>(repository.getDecorations().values());
        List<Decorations> foundDecorations = new ArrayList<Decorations>();
        for (Decorations decoration : decorations) {
            if (decoration.getPrice() == price) {
                foundDecorations.add(decoration);
            }
        }
        return foundDecorations;
    }

    public List<Decorations> getDecorationAll() {
        List<Decorations> decorations = new ArrayList<Decorations>(repository.getDecorations().values());
        return decorations;
    }

    public List<Decorations> getDecorationByNameAndPrice(String name, float price) {
        List<Decorations> decorations = new ArrayList<Decorations>(repository.getDecorations().values());
        List<Decorations> foundDecorations = new ArrayList<Decorations>();
        for (Decorations decoration : decorations) {
            if (decoration.getName().equals(name) && decoration.getPrice() == price) {
                foundDecorations.add(decoration);
            }
        }
        return foundDecorations;
    }
}
