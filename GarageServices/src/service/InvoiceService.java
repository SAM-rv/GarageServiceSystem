package service;

import config.DBConnection;
import entity.Customer;
import entity.Invoice;
import entity.InvoiceItems;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceService {

    public int addInvoice(Invoice invoice) throws SQLException {
        Connection con= DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("insert into invoice " +
                "(customer_id,vehicle_id) values(?,?)", Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1,invoice.getCustmorId());
        ps.setInt(2,invoice.getVehicleId());
        ps.executeUpdate();
        ResultSet rs=ps.getGeneratedKeys();
        rs.next();
        int invoiceId=rs.getInt(1);
        rs.close();
        ps.close();
        con.close();
        return invoiceId;
    }

    public void addInvoiceItems(InvoiceItems invoiceItems) throws SQLException {
        Connection con= DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("insert into invoice_items " +
                "(invoice_id,service_id) values(?,?)");
        ps.setInt(1,invoiceItems.getInvoiceId());
        ps.setInt(2,invoiceItems.getServiceId());
        ps.executeUpdate();
        ps.close();
        con.close();
    }

    public List<Invoice> getAllInvoice() throws SQLException {
        List<Invoice> list=new ArrayList<>();
        Connection con= DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("select * from invoice");
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            list.add(new Invoice(rs.getInt("id"),rs.getInt("customer_id"),
                    rs.getInt("vehicle_id")));
        }
        ps.close();
        con.close();
        return list;
    }

    public List<InvoiceItems> getAllInvoiceItems(int invoiceId) throws SQLException {
        List<InvoiceItems> list=new ArrayList<>();
        Connection con= DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("select * from invoice_items where invoice_id=?");
        ps.setInt(1,invoiceId);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            list.add(new InvoiceItems(rs.getInt("id"),rs.getInt("invoice_id"),
                    rs.getInt("service_id")));
        }
        ps.close();
        con.close();
        return list;
    }
}
