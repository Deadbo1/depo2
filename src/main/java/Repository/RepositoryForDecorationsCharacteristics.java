package Repository;

import Models.DecorationsCharacteristics;

import java.util.ArrayList;
import java.util.List;

public class RepositoryForDecorationsCharacteristics {

    private static RepositoryForDecorationsCharacteristics repositoryForDecorationsCharacteristics;

    public static RepositoryForDecorationsCharacteristics getInstance() {
        if (repositoryForDecorationsCharacteristics == null) {
            repositoryForDecorationsCharacteristics = new RepositoryForDecorationsCharacteristics();
            return repositoryForDecorationsCharacteristics;
        }
        return repositoryForDecorationsCharacteristics;
    }

    private List<DecorationsCharacteristics> decorationsCharacteristics = new ArrayList<DecorationsCharacteristics>();

    public void addDecorationsCharacteristics(DecorationsCharacteristics decorationsCharacteristic){
        decorationsCharacteristics.add(decorationsCharacteristic);
    }

    public void deleteDecorationsCharacteristic(int decorationId) {
        List<DecorationsCharacteristics> decorationsCharacteristics1 = new ArrayList<DecorationsCharacteristics>();
            for (DecorationsCharacteristics decorationCharacteristic : decorationsCharacteristics) {
                if (decorationCharacteristic.getDecorationId() == decorationId) {
                    decorationsCharacteristics1.add(decorationCharacteristic);
                }
            }
                decorationsCharacteristics.removeAll(decorationsCharacteristics1);
    }

    public List<DecorationsCharacteristics> getDecorationsCharacteristics() {
        return decorationsCharacteristics;
    }
}
