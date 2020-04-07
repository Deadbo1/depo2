package Services;

import Repository.Repository;
import Models.*;
import org.apache.log4j.Logger;

public class ServiceForCharacteristics {
    private static ServiceForCharacteristics serviceForCharacteristics;

    public static ServiceForCharacteristics getInstance() {
        if(serviceForCharacteristics == null){
            serviceForCharacteristics = new ServiceForCharacteristics();
            return serviceForCharacteristics;
        }
        return serviceForCharacteristics;
    }

    private Repository repository;
    private static final Logger log = Logger.getLogger(ServiceForCakeBase.class);

    private ServiceForCharacteristics() {
        this.repository = Repository.getInstance();
    }

    public void updateCharacteristicDecoration(int decorationId, String name, String subscription) {
        Characteristics characteristics;
        for (DecorationsCharacteristics decorationsCharacteristics : repository.getDecorationsCharacteristics()) {
            if (decorationsCharacteristics.getDecorationId() == decorationId) {
                characteristics = getCharacteristicsById(decorationsCharacteristics.getDecorationCharacteristicId());
                System.out.println(characteristics);
                characteristics.setName(name);
                characteristics.setSubscription(subscription);
                repository.updateCharacteristic(characteristics);
            }
        }
    }

    public void addCharacteristic(Characteristics characteristics) {
        repository.addCharacteristic(characteristics);
    }


    public Characteristics getCharacteristicsById(int id) {
        return repository.getCharacteristicById(id);
    }


//    public void updateCharacteristic(int id, String name, String subscription) {
//        Models.Characteristics updatedCharacteristics = getCharacteristicsById(id);
//        updatedCharacteristics.setName(name);
//        updatedCharacteristics.setSubscription(subscription);
//        repository.updateCharacteristic(updatedCharacteristics);
//    }


    public void deleteCharacteristic(int id) {
        repository.deleteCharacteristic(getCharacteristicsById(id));
    }


    public void createCharacteristic(String name, String subscription) {
        Characteristics characteristics = new Characteristics();
        characteristics.setName(name);
        characteristics.setSubscription(subscription);
        addCharacteristic(characteristics);
    }
}
