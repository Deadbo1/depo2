package Repository;

import Models.Characteristics;

import java.util.HashMap;

public class RepositoryForCharacteristics {

    private static RepositoryForCharacteristics repositoryForCharacteristics;

    public static RepositoryForCharacteristics getInstance() {
        if (repositoryForCharacteristics == null) {
            repositoryForCharacteristics = new RepositoryForCharacteristics();
            return repositoryForCharacteristics;
        }
        return repositoryForCharacteristics;
    }

    private HashMap<Integer, Characteristics> characteristics = new HashMap<Integer, Characteristics>();

    public void addCharacteristic(Characteristics characteristic){
        characteristics.put(characteristic.getId(),characteristic);
    }

    public Characteristics getCharacteristicById(int id) {
        return characteristics.get(id);
    }

    public void deleteCharacteristic(Characteristics characteristic) {
        characteristics.remove(characteristic.getId());
    }

    public void updateCharacteristic(Characteristics characteristic) {
        deleteCharacteristic(characteristic);
        addCharacteristic(characteristic);
    }

    public HashMap<Integer, Characteristics> getCharacteristics() {
        return characteristics;
    }


}
