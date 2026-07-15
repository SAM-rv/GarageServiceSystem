package service;

import config.DBConnection;
import entity.Customer;
import entity.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleService {
    public int addVehicle(Vehicle vehicle) throws SQLException {
        Connection con= DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("insert into vehicle (customer_id,number_plate,model) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, vehicle.getCustomer_id());
        ps.setString(2,vehicle.getNumber_plate());
        ps.setString(3,vehicle.getModel());
        ps.executeUpdate();
        ResultSet rs=ps.getGeneratedKeys();
        rs.next();
        int vehicleId=rs.getInt(1);
        rs.close();
        ps.close();
        con.close();
        return vehicleId;
    }

    public List<Vehicle> getAllVehicles() throws SQLException {
        List<Vehicle> list=new ArrayList<>();
        Connection con= DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("select * from vehicle");
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
