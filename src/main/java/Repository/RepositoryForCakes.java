package Repository;

import Models.*;
import java.util.HashMap;

public class RepositoryForCakes {

    private static RepositoryForCakes repositoryForCakes;
    public static RepositoryForCakes getInstance(){
        if(repositoryForCakes == null){
            repositoryForCakes = new RepositoryForCakes();
            return repositoryForCakes;
        }
        return repositoryForCakes;
    }

    private HashMap<Integer, Cakes> cakes = new HashMap<Integer, Cakes>();

    public void addCake(Cakes cake){
        cakes.put(cake.getId(),cake);
    }

    public Cakes getCakeById(int id) {
        return cakes.get(id);
    }

    public void deleteCake(Cakes cake)
    {
        cakes.remove(cake.getId());
    }

    public void updateCake(Cakes cake) {
        deleteCake(cake);
        addCake(cake);
    }

    public HashMap<Integer, Cakes> getCakes() {
        return cakes;
    }


}
