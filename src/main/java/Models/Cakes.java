package Models;

import java.util.ArrayList;
import java.util.List;

public class Cakes {
    private int id;
    private int customerId;
    private int cakeBase;
    private String name;
    private float price = 0;
    private static int idInc;
    private List<Integer> decorationId = new ArrayList<Integer>();
    private boolean available = true;

    public Cakes() {
        this.id = idInc++;
    }

    public boolean isAvailable() {
        return available;
    }

    public Cakes(Customers customerId, String name, CakesBases cakeBase, float price, List<Integer> decorationId) {
        this.id = idInc++;
        this.customerId = customerId.getId();
        this.name = name;
        this.price = price;
        this.cakeBase = cakeBase.getId();
        this.decorationId = decorationId;
    }

    public Cakes(Customers customerId, CakesBases cakeBase, String name) {
        id++;
        this.customerId = customerId.getId();
        this.cakeBase = cakeBase.getId();
        this.name = name;
    }

    public void setPrice(CakesBases cakesBases, List<Decorations> decorations) {
        for (Decorations decoration : decorations) {
            price += (decoration.getPrice());
        }
        price += cakesBases.getPrice() + 250;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCakeBase(int id) {
        this.cakeBase = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer>  getDecorationId() {
        return decorationId;
    }

    public void addDecorationId(int id) {
        this.decorationId.add(id);
    }

    public int getId() {
        return id;
    }

    public int getCakeBaseId() {
        return cakeBase;
    }

    public int getCustomersId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Models.Cakes{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", cakeBase=" + cakeBase +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", decorationId=" + decorationId +
                ", available=" + available +
                '}';
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
