package Repository;

import Models.CakesBases;

import java.util.HashMap;

public class RepositoryForCakesBases {
    private static RepositoryForCakesBases repositoryForCakesBases;

    public static RepositoryForCakesBases getInstance() {
        if (repositoryForCakesBases == null) {
            repositoryForCakesBases = new RepositoryForCakesBases();
            return repositoryForCakesBases;
        }
        return repositoryForCakesBases;
    }

    private HashMap<Integer, CakesBases> cakesBases = new HashMap<Integer, CakesBases>();

    public void addCakeBase(CakesBases cakeBase) {
        cakesBases.put(cakeBase.getId(), cakeBase);
    }

    public CakesBases getCakeBasesById(int id) {
        return cakesBases.get(id);
    }

    public void deleteCakeBases(CakesBases cakesBase) {
        cakesBases.remove(cakesBase.getId());
    }

    public void updateCakeBase(CakesBases cakeBase) {
        deleteCakeBases(cakeBase);
        addCakeBase(cakeBase);
    }

    public HashMap<Integer, CakesBases> getCakesBases() {
        return cakesBases;
    }
}
