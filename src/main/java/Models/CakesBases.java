package Models;

public class CakesBases {
    private int id;
    private static int idInc;
    private float price;
    private String name;

    public CakesBases() {
        this.id = idInc++;
    }

    public CakesBases(String name, float price) {
        this.id = idInc++;
        this.name = name;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Models.CakesBases{" +
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

}
