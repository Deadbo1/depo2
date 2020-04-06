package Models;

public class Decorations {
    private int id;
    private String name;
    private float price;
    private static int idInc;

    public Decorations() {
        this.id = idInc++;
    }

    public Decorations(String name, float price) {
        this.id = idInc++;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Models.Decorations{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
