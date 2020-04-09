package Services;

import Repository.*;
import Models.*;
import org.apache.log4j.Logger;

import java.util.HashMap;

public class ServiceForCharacteristics {
    private static ServiceForCharacteristics serviceForCharacteristics;

    public static ServiceForCharacteristics getInstance() {
        if(serviceForCharacteristics == null){
            serviceForCharacteristics = new ServiceForCharacteristics();
            return serviceForCharacteristics;
        }
        return serviceForCharacteristics;
    }

    private RepositoryForCharacteristics repositoryForCharacteristics;

    private RepositoryForCakes repositoryForCakes;

    private RepositoryForDecorationsCharacteristics repositoryForDecorationsCharacteristics;

    private static final Logger log = Logger.getLogger(ServiceForCakeBase.class);

    private ServiceForCharacteristics() {
        this.repositoryForCakes = RepositoryForCakes.getInstance();
        this.repositoryForCharacteristics = RepositoryForCharacteristics.getInstance();
        this.repositoryForDecorationsCharacteristics = RepositoryForDecorationsCharacteristics.getInstance();
    }

    public void updateCharacteristicDecoration(int decorationId, String name, String subscription) {
        Characteristics characteristics;
        for (DecorationsCharacteristics decorationsCharacteristics : repositoryForDecorationsCharacteristics.getDecorationsCharacteristics()) {
            if (decorationsCharacteristics.getDecorationId() == decorationId) {
                characteristics = getCharacteristicsById(decorationsCharacteristics.getDecorationCharacteristicId());
                System.out.println(characteristics);
                characteristics.setName(name);
                characteristics.setSubscription(subscription);
                repositoryForCharacteristics.updateCharacteristic(characteristics);
                System.out.println(characteristics);
            }
        }
    }

    public void addCharacteristic(Characteristics characteristics) {
        repositoryForCharacteristics.addCharacteristic(characteristics);
    }


    public Characteristics getCharacteristicsById(int id) {
        return repositoryForCharacteristics.getCharacteristicById(id);
    }

    public void deleteCharacteristic(int id) {
        repositoryForCharacteristics.deleteCharacteristic(getCharacteristicsById(id));
    }


    public void createCharacteristic(String name, String subscription) {
        Characteristics characteristics = new Characteristics();
        characteristics.setName(name);
        characteristics.setSubscription(subscription);
        addCharacteristic(characteristics);
    }

    public HashMap<Integer, Characteristics> getCharacteristics() {
        return repositoryForCharacteristics.getCharacteristics();
    }
}
