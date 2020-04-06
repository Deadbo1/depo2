package Repository;

import Models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Repository {

    private static Repository repository;
    public static Repository getInstance(){
        if(repository == null){
            repository = new Repository();
            return repository;
        }
        return repository;
    }

    private HashMap<Integer, Customers> customers = new HashMap<Integer, Customers>();
    private HashMap<Integer, Cakes> cakes = new HashMap<Integer, Cakes>();
    private HashMap<Integer, CakesBases> cakesBases = new HashMap<Integer, CakesBases>();
    private HashMap<Integer, Decorations> decorations = new HashMap<Integer, Decorations>();
    private HashMap<Integer, Characteristics> characteristics = new HashMap<Integer, Characteristics>();
    private List<CakesDecorations>  cakesDecorations = new ArrayList<CakesDecorations>();
    private List<DecorationsCharacteristics> decorationsCharacteristics = new ArrayList<DecorationsCharacteristics>();
    private List<CakesCharacteristics> cakesCharacteristics = new ArrayList<CakesCharacteristics>();

    public void addCustomer(Customers customer){
        customers.put(customer.getId(),customer);
    }
    public void addCake(Cakes cake){
        cakes.put(cake.getId(),cake);
    }
    public void addCharacteristic(Characteristics characteristic){
        characteristics.put(characteristic.getId(),characteristic);
    }
    public void addCakeBase(CakesBases cakeBase){
        cakesBases.put(cakeBase.getId(),cakeBase);
    }
    public void addDecoration(Decorations decoration){
        decorations.put(decoration.getId(),decoration);
    }

    public void addCakesDecorations(CakesDecorations cakeDecoration){
        cakesDecorations.add(cakeDecoration);
    }

    public void addDecorationsCharacteristics(DecorationsCharacteristics decorationsCharacteristic){
        decorationsCharacteristics.add(decorationsCharacteristic);
    }

    public void addCakesCharacteristics(CakesCharacteristics cakeCharacteristic){
        cakesCharacteristics.add(cakeCharacteristic);
    }

    public Customers getCustomerById(int id) {
        return customers.get(id);
    }

    public Decorations getDecorationById(int id) {
        return decorations.get(id);
    }

    public CakesBases getCakeBasesById(int id) {
        return cakesBases.get(id);
    }

    public Cakes getCakeById(int id) {
        return cakes.get(id);
    }

    public Characteristics getCharacteristicById(int id) {
        return characteristics.get(id);
    }

    public Customers getCustomerByFNameAndLName(String fName, String lName) {
        List<Customers> customers = new ArrayList<Customers>(getCustomers().values());
        Customers cust = null;
        for (Customers customer : customers) {
            if(customer.getFirstName().equals(fName) && customer.getLastName().equals(lName)){
                cust = customer;
            }
        }
        return cust;
    }

    public void deleteCustomer(Customers customer)
    {
        customers.remove(customer.getId());
    }//x8
    public void deleteCake(Cakes cake)
    {
        cakes.remove(cake.getId());
    }
    public void deleteDecoration(Decorations decoration) {
        decorations.remove(decoration.getId());
    }
    public void deleteCakeBases(CakesBases cakesBase) {
        cakesBases.remove(cakesBase.getId());
    }
    public void deleteCharacteristic(Characteristics characteristic) {
        characteristics.remove(characteristic.getId());
    }

    public void deleteCakesDecorations(int cakeId,int decorationId) {//переделать под интератор
            for (CakesDecorations cakesDecoration: cakesDecorations) {
                if (cakesDecoration.getCakeId() == cakeId && cakesDecoration.getDecorationId() == decorationId){
                    cakesDecorations.remove(cakesDecoration);
                }
            }
    }

    public void deleteCakesCharacteristic(int cakeId,int decorationId) {
        for (CakesCharacteristics cakesCharacteristic: cakesCharacteristics) {
            if (cakesCharacteristic.getCakeId() == cakeId && cakesCharacteristic.getCharacteristicId() == decorationId){
                cakesDecorations.remove(cakesCharacteristic);
            }
        }
    }

    public void deleteDecorationsCharacteristic(int characteristicId,int decorationId) {
        for (DecorationsCharacteristics decorationCharacteristic: decorationsCharacteristics) {
            if (decorationCharacteristic.getDecorationCharacteristicId() == characteristicId && decorationCharacteristic.getDecorationId() == decorationId){
                cakesDecorations.remove(decorationCharacteristic);
            }
        }
    }

    public void updateCustomer(Customers customer) {
        deleteCustomer(customer);
        addCustomer(customer);
    }

    public void updateCake(Cakes cake) {
        deleteCake(cake);
        addCake(cake);
    }

    public void updateCakeBase(CakesBases cakeBase) {
        deleteCakeBases(cakeBase);
        addCakeBase(cakeBase);
    }

    public void updateDecorations(Decorations decoration) {
        deleteDecoration(decoration);
        addDecoration(decoration);
    }

    public void updateCharacteristic(Characteristics characteristic) {
        deleteCharacteristic(characteristic);
        addCharacteristic(characteristic);
    }

    public HashMap<Integer, Customers> getCustomers() {
        return customers;
    }

    public HashMap<Integer, Cakes> getCakes() {
        return cakes;
    }

    public HashMap<Integer, CakesBases> getCakesBases() {
        return cakesBases;
    }

    public HashMap<Integer, Decorations> getDecorations() {
        return decorations;
    }

    public HashMap<Integer, Characteristics> getCharacteristics() {
        return characteristics;
    }

    public List<CakesDecorations> getCakesDecorations() {
        return cakesDecorations;
    }

    public List<DecorationsCharacteristics> getDecorationsCharacteristics() {
        return decorationsCharacteristics;
    }

    public List<CakesCharacteristics> getCakesCharacteristics() {
        return cakesCharacteristics;
    }
}
