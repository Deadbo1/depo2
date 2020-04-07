package Services;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

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
    private static final Logger log = Logger.getLogger(ServiceForCakeBase.class);

    private ServiceForCakeBase() {
        this.repository = Repository.getInstance();
    }


    public void addCakeBase(CakesBases cakesBases) {
        repository.addCakeBase(cakesBases);
        log.info("Cake base" + cakesBases + "has been added");
    }

    public CakesBases getCakeBasesById(int id) {
        return repository.getCakeBasesById(id);
    }

    public void updateCakeBases(int id, String name, float price) {
        CakesBases updatedCakeBases = getCakeBasesById(id);
        log.info("Cake base " + updatedCakeBases +" before update");
        updatedCakeBases.setName(name);
        updatedCakeBases.setPrice(price);
        repository.updateCakeBase(updatedCakeBases);
        log.info("Cake base " + updatedCakeBases +" after update");
    }

    public void createCakeBases(String name, float price) {
        CakesBases newCakeBases = new CakesBases();
        newCakeBases.setName(name);
        newCakeBases.setPrice(price);
        addCakeBase(newCakeBases);
        log.info("Created cake base " + newCakeBases);
    }

    public void deleteCakeBases(int id) {
        log.info("Cake base " + getCakeBasesById(id) + " has been deleted");
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
        log.info("List of cake base selected by name " + foundCakeBase);
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
        log.info("List of cake base selected by price " + foundCakeBase);
        return foundCakeBase;
    }

    public List<CakesBases> getCakeBasesAll() {
        List<CakesBases> cakeBases = new ArrayList<CakesBases>(repository.getCakesBases().values());
        log.info("List of all cake base " + cakeBases);
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
        log.info("List of cake base selected by price and name " + foundCakeBase);
        return foundCakeBase;
    }
}
