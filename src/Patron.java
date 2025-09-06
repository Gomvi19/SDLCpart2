//Patron class has 4 attributes id,name,address, and fine amount and holds all the information of the Patrons it also overrides the toString method
public class Patron {
    private String id;
    private String name;
    private String address;
    private double fineAmount;

    //constructor
    public Patron(String id, String name, String address, Double fineAmount) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.fineAmount = fineAmount;
    }

    //setters and getters

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String email) {
        this.address = email;
    }
    public double getFineAmount() {
        return fineAmount;
    }
    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }

    @Override
    public String toString() {
        return "Patron ID: " + id + ", Name: " + name + ", Address: " + address + ", Fine: $" + String.format("%.2f", fineAmount);
    }
}
