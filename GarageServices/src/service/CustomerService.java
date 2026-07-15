package service;

import config.DBConnection;
import entity.Customer;
import entity.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    public int addCustomer(Customer customer) throws SQLException {
        Connection con= DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("insert into customer (name,phone) values(?,?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1,customer.getName());
        ps.setString(2,customer.getPhone());
        ps.executeUpdate();
        ResultSet rs=ps.getGeneratedKeys();
        rs.next();
        int customerId=rs.getInt(1);
        rs.close();
        ps.close();
        con.close();
        return customerId;
    }

    public List<Customer> getAllCustomer() throws SQLException {
        List<Customer> list=new ArrayList<>();
        Connection con= DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("select * from customer");
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            list.add(new Customer(rs.getInt("id"),
                    rs.getString("name"),rs.getString("phone")));
        }
        ps.close();
        con.close();
        return list;
    }

    public List<Vehicle> getAllVehicles(int customerId) throws SQLException {
        List<Vehicle> list=new ArrayList<>();
        Connection con= DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("select * from vehicle where customer_id =?");
        ps.setInt(1,customerId);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            list.add(new Vehicle(rs.getInt("id"),rs.getInt("customer_id"),
                    rs.getString("number_plate"),rs.getString("model")));
        }
        ps.close();
        con.close();
        return list;
    }

}
