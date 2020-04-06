package Models;

public class Characteristics {
    private int id;
    private String name;
    private String subscription;
    private static int idInc;

    public Characteristics() {
        this.id = idInc++;
    }

    @Override
    public String toString() {
        return "Models.Characteristics{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subscription='" + subscription + '\'' +
                '}';
    }

    public Characteristics(String name, String subscription) {
        this.id = idInc++;
        this.name = name;
        this.subscription = subscription;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    public String getName() {
        return name;
    }

    public String getSubscription() {
        return subscription;
    }

}
