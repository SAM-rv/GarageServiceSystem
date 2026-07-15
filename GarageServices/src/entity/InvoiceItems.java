package entity;

public class InvoiceItems {
    private int id;
    private int invoiceId;
    private int serviceId;

    public InvoiceItems(int id, int invoiceId, int serviceId) {
        this.id = id;
        this.invoiceId = invoiceId;
        this.serviceId = serviceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String toString() {
        return " [ " + serviceId + " ] ";
    }
}
