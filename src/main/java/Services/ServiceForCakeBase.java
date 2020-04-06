package Services;

import java.util.ArrayList;
import java.util.List;
import Repository.Repository;
import Models.*;

public class ServiceForCakeBase {
    private static ServiceForCakeBase serviceForCakeBase;

    public static ServiceForCakeBase getInstance() {
        if (serviceForCakeBase == null) {
            serviceForCakeBase = new ServiceForCakeBase();
            return serviceForCakeBase;
        }
        return serviceForCakeBase;
    }

    private Repository repository;

    private ServiceForCakeBase() {
        this.repository = Repository.getInstance();
    }


    public void addCakeBase(CakesBases cakesBases) {
        repository.addCakeBase(cakesBases);
    }

    public CakesBases getCakeBasesById(int id) {
        return repository.getCakeBasesById(id);
    }

    public void updateCakeBases(int id, String name, float price) {
        CakesBases updatedCakeBases = getCakeBasesById(id);
        updatedCakeBases.setName(name);
        updatedCakeBases.setPrice(price);
        repository.updateCakeBase(updatedCakeBases);
    }

    public void createCakeBases(String name, float price) {
        CakesBases newCakeBases = new CakesBases();
        newCakeBases.setName(name);
        newCakeBases.setPrice(price);
        repository.addCakeBase(newCakeBases);
    }

    public void deleteCakeBases(int id) {
        repository.deleteCakeBases(getCakeBasesById(id));
    }

    public List<CakesBases> getCakeBasesByName(String name) {
        List<CakesBases> cakeBases = new ArrayList<CakesBases>(repository.getCakesBases().values());
        List<CakesBases> foundCakeBase = new ArrayList<CakesBases>();
        for (CakesBases cakesBases : cakeBases) {
            if (cakesBases.getName().equals(name)) {
                foundCakeBase.add(cakesBases);
            }
        }
        return foundCakeBase;
    }

    public List<CakesBases> getCakeBasesByPrice(float price) {
        List<CakesBases> cakeBases = new ArrayList<CakesBases>(repository.getCakesBases().values());
        List<CakesBases> foundCakeBase = new ArrayList<CakesBases>();
        for (CakesBases cakesBases : cakeBases) {
            if (cakesBases.getPrice() == price) {
                foundCakeBase.add(cakesBases);
            }
        }
        return foundCakeBase;
    }

    public List<CakesBases> getCakeBasesAll() {
        List<CakesBases> cakeBases = new ArrayList<CakesBases>(repository.getCakesBases().values());
        return cakeBases;
    }

    public List<CakesBases> getCakeBasesByNameAndPrice(String name, float price) {
        List<CakesBases> cakeBases = new ArrayList<CakesBases>(repository.getCakesBases().values());
        List<CakesBases> foundCakeBase = new ArrayList<CakesBases>();
        for (CakesBases cakesBases : cakeBases) {
            if (cakesBases.getName().equals(name) && cakesBases.getPrice() == price) {
                foundCakeBase.add(cakesBases);
            }
        }
        return foundCakeBase;
    }
}
