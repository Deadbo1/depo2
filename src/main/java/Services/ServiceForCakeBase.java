package Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;

import Repository.*;
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

    private RepositoryForCakesBases repositoryForCakesBases;
    private static final Logger log = Logger.getLogger(ServiceForCakeBase.class);

    private ServiceForCakeBase() {
        this.repositoryForCakesBases = RepositoryForCakesBases.getInstance();
    }


    public void addCakeBase(CakesBases cakesBases) {
        repositoryForCakesBases.addCakeBase(cakesBases);
        log.info("Cake base" + cakesBases + "has been added");
    }

    public CakesBases getCakeBasesById(int id) {
        return repositoryForCakesBases.getCakeBasesById(id);
    }

    public void updateCakeBases(int id, String name, float price) {
        CakesBases updatedCakeBases = getCakeBasesById(id);
        log.info("Cake base " + updatedCakeBases +" before update");
        updatedCakeBases.setName(name);
        updatedCakeBases.setPrice(price);
        repositoryForCakesBases.updateCakeBase(updatedCakeBases);
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
        repositoryForCakesBases.deleteCakeBases(getCakeBasesById(id));
    }

    public List<CakesBases> getCakeBasesByName(String name) {
        List<CakesBases> cakeBases = new ArrayList<CakesBases>(repositoryForCakesBases.getCakesBases().values());
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
        List<CakesBases> cakeBases = new ArrayList<CakesBases>(repositoryForCakesBases.getCakesBases().values());
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
        List<CakesBases> cakeBases = new ArrayList<CakesBases>(repositoryForCakesBases.getCakesBases().values());
        log.info("List of all cake base " + cakeBases);
        return cakeBases;
    }

    public HashMap<Integer, CakesBases> getCakesBases() {
        return repositoryForCakesBases.getCakesBases();
    }

    public List<CakesBases> getCakeBasesByNameAndPrice(String name, float price) {
        List<CakesBases> cakeBases = new ArrayList<CakesBases>(repositoryForCakesBases.getCakesBases().values());
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
