package entity;

public class Invoice {
    private int id;
    private int custmorId;
    private int vehicleId;

    public Invoice(int id, int custmorId, int vehicleId) {
        this.id = id;
        this.custmorId = custmorId;
        this.vehicleId = vehicleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustmorId() {
        return custmorId;
    }

    public void setCustmorId(int custmorId) {
        this.custmorId = custmorId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", custmorId=" + custmorId +
                ", vehicleId=" + vehicleId +
                '}';
    }
}
