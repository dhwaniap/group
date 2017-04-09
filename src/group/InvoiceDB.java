/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author 749849
 */
public class InvoiceDB {
    
     public static ArrayList getCustomerList()
    {   
        ArrayList list;
        try{

                Class.forName("com.mysql.jdbc.Driver");   //driversformysql
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");  //seetting connection

                Statement stmt = conn.createStatement(); //inst statement from conn method
                ResultSet rs = stmt.executeQuery("select CustomerId from Customers");
                list = new ArrayList();
                while (rs.next())
                {
                    list.add(rs.getInt(1)); //add to array 
                }


            }
        catch (ClassNotFoundException ex) 
            {
                new Alert(Alert.AlertType.ERROR,
                        "Driver class not found: " + ex.getMessage(), ButtonType.OK).showAndWait();
                Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
                list = null;
            } 

            catch (SQLException ex) 
            {
                new Alert(Alert.AlertType.ERROR,
                        "An SQL Exception occurred: " + ex.getMessage(), ButtonType.OK).showAndWait();
                Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
                list = null;
            }
        return list;
    }
    
    public static String getTotalForCustomer(int id)
    {
       String total="";
       try
       {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select SUM(b.TravelerCount*d.BasePrice) as Total " +
                                            "FROM Bookings b INNER JOIN BookingDetails d " +
                                            "ON b.BookingId = d.BookingId " +
                                            "where b.CustomerId =" + id+
                                            " Group by b.CustomerId" );    
            if (rs.next())
                             {
                                 total = rs.getString(1);                        
                             }
            conn.close();   
            return total;
       }
            catch (ClassNotFoundException ex) 
            {
                new Alert(Alert.AlertType.ERROR,
                        "Driver class not found: " + ex.getMessage(), ButtonType.OK).showAndWait();
                Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            } 

            catch (SQLException ex) 
            {
                new Alert(Alert.AlertType.ERROR,
                        "An SQL Exception occurred: " + ex.getMessage(), ButtonType.OK).showAndWait();
                Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
                return null;
                
            }
    
    
    }
    
    public static ArrayList<Invoice> getInvoice(int id)
    {   ArrayList<Invoice> invoices = new ArrayList<Invoice>();
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT b.BookingId, b.TravelerCount, d.BasePrice, d.AgencyCommission, d.Destination " +
                                                "FROM Bookings b INNER JOIN BookingDetails d " +
                                                "ON b.BookingId = d.BookingId " +
                                                "where b.CustomerId =" +id+
                                                " Group by b.BookingId, b.TravelerCount, d.BasePrice, d.AgencyCommission, d.Destination" );
            while (rs.next())
            {
                Invoice invoice = new Invoice();
                invoice.setBookingId(rs.getString(1));
                invoice.setTravelerCount(rs.getString(2));
                invoice.setBasePrice(rs.getString(3));
                invoice.setAgencyCommision(rs.getString(4));
                invoice.setDestination(rs.getString(5));
                
                invoices.add(invoice);
                      
            }
            conn.close(); 
            return invoices;
        } 
        catch (ClassNotFoundException ex) 
        {
            new Alert(Alert.AlertType.ERROR,
                    "Driver class not found: " + ex.getMessage(), ButtonType.OK).showAndWait();
            Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (SQLException ex) {
            new Alert(Alert.AlertType.ERROR,
                    "An SQL Exception occurred: " + ex.getMessage(), ButtonType.OK).showAndWait();
            Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
            
}
