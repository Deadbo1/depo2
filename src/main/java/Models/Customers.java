package Models;

public class Customers {
    private int id;
    private String firstName;
    private String lastName;
    private float balance;
    private static int idInc = 1;

    public Customers() {
        this.id =idInc++;
    }

    public Customers(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Models.Customers{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public Customers(String firstName, String lastName) {
        this.id =idInc++;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getBalance(){
        return balance;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
