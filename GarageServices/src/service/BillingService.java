package service;

import entity.Customer;
import entity.Invoice;
import entity.InvoiceItems;
import entity.Vehicle;

import java.sql.SQLException;
import java.util.List;

public class BillingService {

    CustomerService customerService=new CustomerService();
    InvoiceService invoiceService=new InvoiceService();

    public void createInvoice(int customer_id, int vehicle_id, List<Integer> service_ids) throws SQLException {
        int invoiceId=invoiceService.addInvoice(new Invoice(0,customer_id,vehicle_id));
        for (int serviceId : service_ids)
            invoiceService.addInvoiceItems(new InvoiceItems(0,invoiceId,serviceId));
    }

    public void showAllInvoices() throws SQLException {
        List<Invoice> list=invoiceService.getAllInvoice();
        for(Invoice invoice:list) {
            System.out.println(invoice);
            System.out.print("Services :- ");
            List<InvoiceItems> list1=invoiceService.getAllInvoiceItems(invoice.getId());
            for (InvoiceItems invoiceItems : list1)
                System.out.print(invoiceItems);
        }
    }

    public void showAllCustomers() throws SQLException {
        List<Customer> list1=customerService.getAllCustomer();

        for(Customer customer:list1){
            System.out.println(customer);
            List<Vehicle>list2=customerService.getAllVehicles(customer.getId());
            for(Vehicle vehicle:list2)
                System.out.println(vehicle);
        }
    }
}
