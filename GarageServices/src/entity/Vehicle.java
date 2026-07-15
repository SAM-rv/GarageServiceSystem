package entity;

public class Vehicle {
    private int id;
    private int customer_id;
    private String number_plate;
    private String model;

    public Vehicle(int id, int customer_id, String number_plate, String model) {
        this.id = id;
        this.customer_id = customer_id;
        this.number_plate = number_plate;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getNumber_plate() {
        return number_plate;
    }

    public void setNumber_plate(String number_plate) {
        this.number_plate = number_plate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return " [ vehicle_id=" + id + ", number_plate='" + number_plate + ", model=" + model + " ]";
    }
}
