import entity.Customer;
import entity.Vehicle;
import service.BillingService;
import service.CustomerService;
import service.VehicleService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    CustomerService customerService=new CustomerService();
    VehicleService vehicleService=new VehicleService();
    BillingService billingService=new BillingService();
    Scanner sc=new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        new App().start();
    }


    public void start() throws SQLException {
        System.out.println("-----------|  Welcome to the Janta Garage  |-----------");
        while(true){
            System.out.println("""
                    1.Add Customer With Vehicle \s
                    2.Generate Invoice  \s
                    3.Get All Invoice \s
                    4.Get All Customers With their vehicles \s
                    5.Exit""");
            int ch=sc.nextInt();
            switch(ch){
                case 1:addCustomer();
                    break;
                case 2:createInvoice();
                    break;
                case 3:viewAllInvoice();
                    break;
                case 4:getAllCustomers();
                    break;
                case 5:System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    public void addCustomer() throws SQLException {
        System.out.print("\nEnter Name:- ");
        String name=sc.next();
        System.out.print("\nEnter Phone No:- ");
        String  phone=sc.next();
        System.out.print("\nEnter Vehicle Number:- ");
        String num=sc.next();
        System.out.print("\nEnter Vehicle model:- ");
        String model= sc.next();
        int user_id=customerService.addCustomer(new Customer(0,name,phone));
        System.out.println("Customer Added Successfully ");
        System.out.println("Customer_Id :- "+user_id);
        user_id=vehicleService.addVehicle(new Vehicle(0,user_id,num,model));
        System.out.println("Vehicle_Id :- "+user_id);
    }

    public void createInvoice() throws SQLException {
        System.out.print("\nEnter Customer_Id:- ");
        int customer_Id=sc.nextInt();
        System.out.print("\nEnter Vehicle_Id:- ");
        int vehicle_Id=sc.nextInt();
        System.out.print("\nEnter Number Of Services:- ");
        int n=sc.nextInt();
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            System.out.print("\nEnter Service Id :-");
            list.add(sc.nextInt());
        }
        billingService.createInvoice(customer_Id,vehicle_Id,list);
        System.out.println("Invoice Generated Successfully");
    }

    public  void viewAllInvoice() throws SQLException {
        billingService.showAllInvoices();
    }

    public void getAllCustomers() throws SQLException {
        billingService.showAllCustomers();
    }
}

