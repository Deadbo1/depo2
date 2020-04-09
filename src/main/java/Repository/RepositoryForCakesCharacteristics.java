package Repository;

import Models.CakesCharacteristics;

import java.util.ArrayList;
import java.util.List;

public class RepositoryForCakesCharacteristics {

    private static RepositoryForCakesCharacteristics repositoryForCakesCharacteristics;

    public static RepositoryForCakesCharacteristics getInstance() {
        if (repositoryForCakesCharacteristics == null) {
            repositoryForCakesCharacteristics = new RepositoryForCakesCharacteristics();
            return repositoryForCakesCharacteristics;
        }
        return repositoryForCakesCharacteristics;
    }

    private List<CakesCharacteristics> cakesCharacteristics = new ArrayList<CakesCharacteristics>();

    public void addCakesCharacteristics(CakesCharacteristics cakeCharacteristic){
        cakesCharacteristics.add(cakeCharacteristic);
    }

    public void deleteCakesCharacteristic(int cakeId,int decorationId) {
        for (CakesCharacteristics cakesCharacteristic: cakesCharacteristics) {
            if (cakesCharacteristic.getCakeId() == cakeId && cakesCharacteristic.getCharacteristicId() == decorationId){
                cakesCharacteristics.remove(cakesCharacteristic);
            }
        }
    }

    public List<CakesCharacteristics> getCakesCharacteristics() {
        return cakesCharacteristics;
    }
}
