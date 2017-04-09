/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tooltip;

/**
 * FXML Controller class
 *
 * @author 749849
 */
public class Group2 implements Initializable {
      

    @FXML
    private JFXComboBox<Integer> cbProdId;
    @FXML
    private JFXTextField tfProdName;
    @FXML
    private JFXButton btnAddProduct;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton btnCancel;
    @FXML
    private JFXComboBox<Integer> cbPackageId;
    @FXML
    private JFXTextField tfPackageName;
    @FXML
    private JFXDatePicker dtStartDate;
    @FXML
    private JFXDatePicker dtEndDate;
    @FXML
    private JFXTextField tfDesc;
    @FXML
    private JFXTextField tfBasePrice;
    @FXML
    private JFXTextField tfAgencyCommission;
    @FXML
    private JFXButton btnAdd1;
    @FXML
    private JFXButton btnUpdate1;
    @FXML
    private JFXButton btnCancel1;
    @FXML
    private JFXButton btnAdd3;
    @FXML
    private JFXButton btnUpdate3;
    @FXML
    private JFXButton btnCancel3;
    @FXML
    private JFXTextField tfFirstName;
    @FXML
    private JFXTextField tfLastName;
    @FXML
    private JFXTextField tfAddress;
    @FXML
    private JFXTextField tfCity;
    @FXML
    private JFXTextField tfProv;
    @FXML
    private JFXTextField tfPostal;
    @FXML
    private JFXTextField tfCountry;
    @FXML
    private JFXTextField tfHomePhone;
    @FXML
    private JFXTextField tfBusPhone;
    @FXML
    private JFXTextField tfEmail;
    @FXML
    private JFXTextField tfAgentId;
    @FXML
    private JFXComboBox<Integer> cbCustID;
    @FXML
    private JFXButton btnAdd2;
    @FXML
    private JFXButton btnUpdate2;
    @FXML
    private JFXButton btnCancel2;
    @FXML
    private JFXComboBox<Integer> cbBookingId;
    @FXML
    private JFXDatePicker dtBookingDate;
    @FXML
    private JFXTextField tfBookingNo;
    @FXML
    private JFXTextField tfTravelerCount;
    @FXML
    private JFXTextField tfCustomerId;
    @FXML
    private JFXTextField tfTripTypeId;
    @FXML
    private JFXTextField tfpackageId;
    @FXML
    private JFXTextField tfPassword;
    @FXML
    private JFXButton btnLogin;
    @FXML
    private JFXTextField tfUser;
    @FXML
    private TabPane travelexperts;
    @FXML
    private JFXButton btnloginCancel;
    @FXML
    private JFXComboBox<Integer> cbCustId;

    @FXML
    private ListView lstInvoice;

    @FXML
    private JFXTextField tfNoOfPackages;

    @FXML
    private JFXTextField tfPayment;
    private Label lblCarribean;
     ArrayList list; 
    

//dhwani
    /**
     * Initializes the controller class.
     */
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select ProductId from products");
            ArrayList list = new ArrayList();
            while (rs.next())
            {
                list.add(rs.getInt(1));
            }
            ObservableList<Integer> intList = FXCollections.observableArrayList(list);
            cbProdId.getItems().addAll(intList);
            cbProdId.getSelectionModel().selectedIndexProperty()
                    .addListener(new ChangeListener<Number>(){

                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");

                        Statement stmt = conn.createStatement();
                        ResultSet rs = stmt.executeQuery("select ProdName from products where ProductId=" + newValue);
                        if (rs.next())
                        {
                            tfProdName.setText(rs.getString(1));
                        }
                        conn.close();                        
                    } catch (ClassNotFoundException ex) {
                        new Alert(Alert.AlertType.ERROR,
                                "Driver class not found: " + ex.getMessage(), ButtonType.OK).showAndWait();
                        Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        new Alert(Alert.AlertType.ERROR,
                                "An SQL Exception occurred: " + ex.getMessage(), ButtonType.OK).showAndWait();
                        Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            conn.close();
        
        } catch (ClassNotFoundException ex) {
            new Alert(Alert.AlertType.ERROR,
                    "Driver class not found: " + ex.getMessage(), ButtonType.OK).showAndWait();
            Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            new Alert(Alert.AlertType.ERROR,
                    "An SQL Exception occurred: " + ex.getMessage(), ButtonType.OK).showAndWait();
            Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
        }

       // TODO
         try {
            //Connection String
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");

            Statement stmt = conn.createStatement();
            //Displays all data from agents
            ResultSet rs = stmt.executeQuery("select * from packages");
            ArrayList list = new ArrayList();
         
            while (rs.next())
            {
                list.add(rs.getInt(1));
            }
            ObservableList<Integer> intList = FXCollections.observableArrayList(list);
            //values fetched from database according to combo box selected item
            cbPackageId.getItems().addAll(intList);
            cbPackageId.getSelectionModel().selectedIndexProperty()
                    .addListener(new ChangeListener<Number>(){

                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    try {
                        System.out.println("Old: " + oldValue);
                        System.out.println("New: " + newValue);
                        int packageId = cbPackageId.getItems().get(newValue.intValue());
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");

                        Statement stmt = conn.createStatement();
                        //fetches values from database for combox value
                        ResultSet rs = stmt.executeQuery("select PkgName,PkgStartDate,PkgEndDate,PkgDesc,PkgBasePrice,PkgAgencyCommission from packages where PackageId=" + packageId);
                        if (rs.next())
                        {//load the values
                            tfPackageName.setText(rs.getString(1));
                            dtStartDate.setValue(rs.getDate(2).toLocalDate());
                            dtEndDate.setValue(rs.getDate(3).toLocalDate());
                            tfDesc.setText(rs.getString(4));
                            tfBasePrice.setText(rs.getString(5));
                            tfAgencyCommission.setText(rs.getString(6));
                           
                        }
                        conn.close();
                        //exception catch block identifies which type of exception has occured
                    } catch (ClassNotFoundException ex) {
                        new Alert(Alert.AlertType.ERROR,
                                "Driver class not found: " + ex.getMessage(), ButtonType.OK).showAndWait();
                        Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        new Alert(Alert.AlertType.ERROR,
                                "An SQL Exception occurred: " + ex.getMessage(), ButtonType.OK).showAndWait();
                        Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            conn.close();
        
        } catch (ClassNotFoundException ex) {
            new Alert(Alert.AlertType.ERROR,
                    "Driver class not found: " + ex.getMessage(), ButtonType.OK).showAndWait();
            Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            new Alert(Alert.AlertType.ERROR,
                    "An SQL Exception occurred: " + ex.getMessage(), ButtonType.OK).showAndWait();
            Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         try {
            //Connection String
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");

            Statement stmt = conn.createStatement();
            //Displays all data from agents
            ResultSet rs = stmt.executeQuery("select * from bookings");
            ArrayList list = new ArrayList();
         
            while (rs.next())
            {
                list.add(rs.getInt(1));
            }
            ObservableList<Integer> intList = FXCollections.observableArrayList(list);
            //values fetched from database according to combo box selected item
            cbBookingId.getItems().addAll(intList);
            cbBookingId.getSelectionModel().selectedIndexProperty()
                    .addListener(new ChangeListener<Number>(){

                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    try {
                        System.out.println("Old: " + oldValue);
                        System.out.println("New: " + newValue);
                        int bookingId = cbBookingId.getItems().get(newValue.intValue());
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");

                        Statement stmt = conn.createStatement();
                        //fetches values from database for combox value
                        ResultSet rs = stmt.executeQuery("select BookingDate,BookingNo,TravelerCount,CustomerId,TripTypeId,PackageId from bookings where BookingId=" + bookingId);
                        if (rs.next())
                        {//load the values
                            
                            
                            //dtBookDate.setText(rs.getString(1));
                            dtBookingDate.setValue(rs.getDate(1).toLocalDate());
                            tfBookingNo.setText(rs.getString(2));
                            tfTravelerCount.setText(rs.getString(3));
                            tfCustomerId.setText(rs.getString(4));
                            tfTripTypeId.setText(rs.getString(5));
                            tfpackageId.setText(rs.getString(6));
                           
                        }
                        conn.close();
                        //exception catch block identifies which type of exception has occured
                    } catch (ClassNotFoundException ex) {
                        new Alert(Alert.AlertType.ERROR,
                                "Driver class not found: " + ex.getMessage(), ButtonType.OK).showAndWait();
                        Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        new Alert(Alert.AlertType.ERROR,
                                "An SQL Exception occurred: " + ex.getMessage(), ButtonType.OK).showAndWait();
                        Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            conn.close();
        
        } catch (ClassNotFoundException ex) {
            new Alert(Alert.AlertType.ERROR,
                    "Driver class not found: " + ex.getMessage(), ButtonType.OK).showAndWait();
            Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            new Alert(Alert.AlertType.ERROR,
                    "An SQL Exception occurred: " + ex.getMessage(), ButtonType.OK).showAndWait();
            Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
        }
          try {
            //Connection String
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");

            Statement stmt = conn.createStatement();
            //Displays all data from agents
            ResultSet rs = stmt.executeQuery("select * from customers");
            ArrayList list = new ArrayList();
            while (rs.next())
            {
                list.add(rs.getInt(1));
            }
            ObservableList<Integer> intList = FXCollections.observableArrayList(list);
            //values fetched from database according to combo box selected item
            cbCustID.getItems().addAll(intList);
            cbCustID.getSelectionModel().selectedIndexProperty()
                    .addListener(new ChangeListener<Number>(){

                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    try {
                        System.out.println("Old: " + oldValue);
                        System.out.println("New: " + newValue);
                        int customerId = cbCustID.getItems().get(newValue.intValue());
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");
                        
                        Statement stmt = conn.createStatement();
                        //fetches values from database for combox value
                        ResultSet rs = stmt.executeQuery("select CustFirstName,CustLastName,CustAddress,CustCity,CustProv,CustPostal,CustCountry,CustHomePhone,CustBusPhone,CustEmail,AgentId from customers where CustomerId=" + customerId);
                       
                        if (rs.next())
                        {//load the values
                                
                             tfFirstName.setText(rs.getString(1));
                            tfLastName.setText(rs.getString(2));
                            tfAddress.setText(rs.getString(3));
                            tfCity.setText(rs.getString(4));
                            tfProv.setText(rs.getString(5));
                            tfPostal.setText(rs.getString(6));
                            tfCountry.setText(rs.getString(7));
                             tfHomePhone.setText(rs.getString(8));
                              tfBusPhone.setText(rs.getString(9));
                               tfEmail.setText(rs.getString(10));
                                tfAgentId.setText(rs.getString(11));
                            
                        }
                        conn.close();
                        //exception catch block identifies which type of exception has occured
                    } catch (ClassNotFoundException ex) {
                        new Alert(Alert.AlertType.ERROR,
                                "Driver class not found: " + ex.getMessage(), ButtonType.OK).showAndWait();
                        Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        new Alert(Alert.AlertType.ERROR,
                                "An SQL Exception occurred: " + ex.getMessage(), ButtonType.OK).showAndWait();
                        Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            conn.close();
        
        } catch (ClassNotFoundException ex) {
            new Alert(Alert.AlertType.ERROR,
                    "Driver class not found: " + ex.getMessage(), ButtonType.OK).showAndWait();
            Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            new Alert(Alert.AlertType.ERROR,
                    "An SQL Exception occurred: " + ex.getMessage(), ButtonType.OK).showAndWait();
            Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
        }

          list = InvoiceDB.getCustomerList();
             ObservableList<Integer> intList = FXCollections.observableArrayList(list); //puts array into observablelist
             cbCustId.getItems().addAll(intList); //adds list to the combobox
             cbCustId.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() //listener start triggeredby the swich cbo
            {
                
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) 
                {
                        int id = (int) list.get((int)newValue);
                        String total = InvoiceDB.getTotalForCustomer(id);                                
                        tfPayment.setText(total);
                        
                        
                        ArrayList<Invoice> invoices  = new ArrayList<Invoice>();

                        ArrayList<String> strings = new ArrayList<String>();
                        invoices = InvoiceDB.getInvoice(id);
                        for (Invoice in : invoices)                        
                        {
                            strings.add(in.toString());
                        }
                        
                        ObservableList<String> ins = FXCollections.observableList(strings);
                        lstInvoice.setItems(ins);
                        
                        tfNoOfPackages.setText(String.valueOf( invoices.size()));
                        
                        
                          }
            }); 
             
          }    

    @FXML
    private void handlePackageAddAction(ActionEvent event) {
        try
        {
            //connection string for database
            
            Class.forName("com.mysql.jdbc.Driver");  
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");
          
            String sql="insert into packages (PkgName,PkgStartDate,PkgEndDate,PkgDesc,pkgBasePrice,PkgAgencyCommission) values (?,?,?,?,?,?)";
            
          PreparedStatement stmt = conn.prepareStatement(sql);

          stmt.setString(1,tfPackageName.getText());
            stmt.setString(2,dtStartDate.getValue().toString());
            stmt.setString(3,dtEndDate.getValue().toString());
            stmt.setString(4,tfDesc.getText());
            stmt.setString(5,tfBasePrice.getText());
            stmt.setString(6,tfAgencyCommission.getText());
             
            
              if (stmt.executeUpdate() > 0)
            {
                new Alert(Alert.AlertType.INFORMATION,
                    "Package inserted successfully", ButtonType.CLOSE).showAndWait();
            }
            else
            {
                new Alert(Alert.AlertType.WARNING,
                    "Package insert failed", ButtonType.CLOSE).showAndWait();
            }
            conn.close();
        } catch (ClassNotFoundException ex) {
            new Alert(Alert.AlertType.ERROR,
                    "Driver class not found: " + ex.getMessage(), ButtonType.OK).showAndWait();
            Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            new Alert(Alert.AlertType.ERROR,
                    "An SQL Exception occurred: " + ex.getMessage(), ButtonType.OK).showAndWait();
            Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    

    @FXML
    private void handlePackageUpdateAction(ActionEvent event) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");
            //query to update agents table in travel experts
            String sql = "update packages set PkgName = ?, PkgStartDate = ?, PkgEndDate = ?, PkgDesc = ?, PkgBasePrice = ? , PkgAgencyCommission = ? where PackageId = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, tfPackageName.getText());
            stmt.setString(2, dtStartDate.getValue().toString());
            stmt.setString(3, dtEndDate.getValue().toString());
            stmt.setString(4, tfDesc.getText());
            stmt.setString(5, tfBasePrice.getText());
            stmt.setString(6, tfAgencyCommission.getText());
             
              
            Object o = cbPackageId.getSelectionModel().getSelectedItem();
            String s = o.toString();
            int i = Integer.parseInt(s);
            //sets updated value to the fields
          
            String k = tfPackageName.getText();
            String l = dtStartDate.getValue().toString();
            String m =dtEndDate.getValue().toString();
            String n = tfDesc.getText();
            String p = tfBasePrice.getText();
             String q = tfAgencyCommission.getText();
            
            
              stmt.setString(1,k);
              stmt.setString(2,l);
              stmt.setString(3,m);
              stmt.setString(4,n);
              stmt.setString(5,p);
              stmt.setString(6,q);
              
              stmt.setInt(7,i);
              
          if (stmt.executeUpdate() > 0)
            {
                new Alert(Alert.AlertType.INFORMATION,
                    "package updated successfully", ButtonType.CLOSE).showAndWait();
            }
            else
            {
                new Alert(Alert.AlertType.WARNING,
                    "Package update failed", ButtonType.CLOSE).showAndWait();
            }
            conn.close();
        } catch (ClassNotFoundException ex) {
            new Alert(Alert.AlertType.ERROR,
                    "Driver class not found: " + ex.getMessage(), ButtonType.OK).showAndWait();
            Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            new Alert(Alert.AlertType.ERROR,
                    "An SQL Exception occurred: " + ex.getMessage(), ButtonType.OK).showAndWait();
            Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
      
    

    @FXML
    private void handleProductAddAction(ActionEvent event){
         try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");
            String sql = "insert into products (ProdName) values (?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, tfProdName.getText());
            if (stmt.executeUpdate() > 0)
            {
                new Alert(Alert.AlertType.INFORMATION,
                    "Product inserted successfully", ButtonType.CLOSE).showAndWait();
            }
            else
            {
                new Alert(Alert.AlertType.WARNING,
                    "Product insert failed", ButtonType.CLOSE).showAndWait();
            }
            conn.close();
        } catch (ClassNotFoundException ex) {
            new Alert(Alert.AlertType.ERROR,
                    "Driver class not found: " + ex.getMessage(), ButtonType.OK).showAndWait();
            Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            new Alert(Alert.AlertType.ERROR,
                    "An SQL Exception occurred: " + ex.getMessage(), ButtonType.OK).showAndWait();
            Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleUpdateAction(ActionEvent event) {
         try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");
            String sql = "update products set ProdName = ? where ProductId = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, tfProdName.getText());
            Object o = cbProdId.getSelectionModel().getSelectedItem();
            String s = o.toString();
            int i = Integer.parseInt(s);
            stmt.setInt(2, i);
            //stmt.setInt(2, Integer.parseInt(cbProdId.getSelectionModel().getSelectedItem().toString()));
            if (stmt.executeUpdate() > 0)
            {
                new Alert(Alert.AlertType.INFORMATION,
                    "Product updated successfully", ButtonType.CLOSE).showAndWait();
            }
            else
            {
                new Alert(Alert.AlertType.WARNING,
                    "Product update failed", ButtonType.CLOSE).showAndWait();
            }
            conn.close();
        } catch (ClassNotFoundException ex) {
            new Alert(Alert.AlertType.ERROR,
                    "Driver class not found: " + ex.getMessage(), ButtonType.OK).showAndWait();
            Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            new Alert(Alert.AlertType.ERROR,
                    "An SQL Exception occurred: " + ex.getMessage(), ButtonType.OK).showAndWait();
            Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void handleCustomerAddAction(ActionEvent event) {
        try
        {
            //connection string for database
            Class.forName("com.mysql.jdbc.Driver");  
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");
          
            String sql="insert into customers (CustFirstName,CustLastName,CustAddress,CustCity,CustProv,CustPostal,CustCountry,CustHomePhone,CustBusPhone,CustEmail,AgentId) values (?,?,?,?,?,?,?,?,?,?,?)";
            
          PreparedStatement stmt = conn.prepareStatement(sql);

            //sets updated values to the required fields
            stmt.setString(1,tfFirstName.getText());
            stmt.setString(2,tfLastName.getText());
            stmt.setString(3,tfAddress.getText());
            stmt.setString(4,tfCity.getText());
            stmt.setString(5,tfProv.getText());
            stmt.setString(6,tfPostal.getText());
            stmt.setString(7,tfCountry.getText());

            stmt.setString(8,tfHomePhone.getText());
            stmt.setString(9,tfBusPhone.getText());
            stmt.setString(10,tfEmail.getText());
            stmt.setString(11,tfAgentId.getText());
             
              if (stmt.executeUpdate() > 0)
            {
                new Alert(Alert.AlertType.INFORMATION,
                    "Customer inserted successfully", ButtonType.CLOSE).showAndWait();
            }
            else
            {
                new Alert(Alert.AlertType.WARNING,
                    "Customer insert failed", ButtonType.CLOSE).showAndWait();
            }
            conn.close();
        } catch (ClassNotFoundException ex) {
            new Alert(Alert.AlertType.ERROR,
                    "Driver class not found: " + ex.getMessage(), ButtonType.OK).showAndWait();
            Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            new Alert(Alert.AlertType.ERROR,
                    "An SQL Exception occurred: " + ex.getMessage(), ButtonType.OK).showAndWait();
            Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleCustomerUpdateAction(ActionEvent event) {
            try {
                
                 Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");
            //query to update agents table in travel experts
            String sql = "update customers set CustFirstName = ?, CustLastName = ?, CustAddress = ?, CustCity = ?, CustProv = ?, CustPostal = ?, CustCountry = ?, CustHomePhone = ?, CustBusPhone = ?, CustEmail = ?, AgentId = ? where CustomerId = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, tfFirstName.getText());
            stmt.setString(2,tfLastName.getText());
            stmt.setString(3, tfAddress.getText());
            stmt.setString(4, tfCity.getText());
            stmt.setString(5, tfProv.getText());
            stmt.setString(6,tfPostal.getText());
             stmt.setString(7, tfCountry.getText());
              stmt.setString(8, tfHomePhone.getText());
               stmt.setString(9, tfBusPhone.getText());
                stmt.setString(10, tfEmail.getText());
                 stmt.setString(11, tfAgentId.getText());
              
            Object o = cbCustID.getSelectionModel().getSelectedItem();
            String s = o.toString();
            int i = Integer.parseInt(s);
            //sets updated value to the fields
            String j = tfFirstName.getText();
            String k = tfLastName.getText();
            String l = tfAddress.getText();
            String m = tfCity.getText();
            String n = tfProv.getText();
            String p = tfPostal.getText();
            String q = tfCountry.getText();
             String r = tfHomePhone.getText();
              String a = tfBusPhone.getText();
               String t = tfEmail.getText();
                String u = tfAgentId.getText();
              
               
              stmt.setString(1,j);
              stmt.setString(2,k);
              stmt.setString(3,l);
              stmt.setString(4,m);
              stmt.setString(5,n);
              stmt.setString(6,p);
              stmt.setString(7,q);
              stmt.setString(8,r);
              stmt.setString(9,a);
              stmt.setString(10,t);
              stmt.setString(11,u);
              stmt.setInt(12,i);
              
          if (stmt.executeUpdate() > 0)
            {
                new Alert(Alert.AlertType.INFORMATION,
                    "Customers updated successfully", ButtonType.CLOSE).showAndWait();
            }
            else
            {
                new Alert(Alert.AlertType.WARNING,
                    "Customers update failed", ButtonType.CLOSE).showAndWait();
            }
            conn.close();
        } catch (ClassNotFoundException ex) {
            new Alert(Alert.AlertType.ERROR,
                    "Driver class not found: " + ex.getMessage(), ButtonType.OK).showAndWait();
            Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            new Alert(Alert.AlertType.ERROR,
                    "An SQL Exception occurred: " + ex.getMessage(), ButtonType.OK).showAndWait();
            Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

    @FXML
    private void handleBookingAddAction(ActionEvent event) {
        try
        {
            //connection string for database
            
            Class.forName("com.mysql.jdbc.Driver");  
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");
          
            String sql="insert into bookings (BookingDate,BookingNo,TravelerCount,CustomerId,TripTypeId) values (?,?,?,?,?)";
            
          PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1,dtBookingDate.getValue().toString());
            stmt.setString(2,tfBookingNo.getText());
            stmt.setString(3,tfTravelerCount.getText());
            stmt.setString(4,tfCustomerId.getText());
            stmt.setString(5,tfTripTypeId.getText());
            //stmt.setString(6,tfPackageID.getText());
             
            
              if (stmt.executeUpdate() > 0)
            {
                new Alert(Alert.AlertType.INFORMATION,
                    "Booking inserted successfully", ButtonType.CLOSE).showAndWait();
            }
            else
            {
                new Alert(Alert.AlertType.WARNING,
                    "Booking insert failed", ButtonType.CLOSE).showAndWait();
            }
            conn.close();
        } catch (ClassNotFoundException ex) {
            new Alert(Alert.AlertType.ERROR,
                    "Driver class not found: " + ex.getMessage(), ButtonType.OK).showAndWait();
            Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            new Alert(Alert.AlertType.ERROR,
                    "An SQL Exception occurred: " + ex.getMessage(), ButtonType.OK).showAndWait();
            Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleBookingUpdateAction(ActionEvent event) {
         try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");
            //query to update agents table in travel experts
            String sql = "update bookings set BookingDate = ?, BookingNo = ?, TravelerCount = ?, CustomerId = ?, TripTypeId = ? , PackageId = ? where BookingId = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, dtBookingDate.getValue().toString());
            stmt.setString(2, tfBookingNo.getText());
            stmt.setString(3, tfTravelerCount.getText());
            stmt.setString(4, tfCustomerId.getText());
            stmt.setString(5, tfTripTypeId.getText());
            stmt.setString(6, tfpackageId.getText());
             
              
            Object o = cbBookingId.getSelectionModel().getSelectedItem();
            String s = o.toString();
            int i = Integer.parseInt(s);
            //sets updated value to the fields
           // String j = dtBookDate.getText();
            String k = tfBookingNo.getText();
            String l = tfTravelerCount.getText();
            String m =tfCustomerId.getText();
            String n = tfTripTypeId.getText();
            String p = tfpackageId.getText();
            
             // stmt.setString(1,j);
              stmt.setString(2,k);
              stmt.setString(3,l);
              stmt.setString(4,m);
              stmt.setString(5,n);
              stmt.setString(6,p);
              
              stmt.setInt(7,i);
              
          if (stmt.executeUpdate() > 0)
            {
                new Alert(Alert.AlertType.INFORMATION,
                    "Bookings updated successfully", ButtonType.CLOSE).showAndWait();
            }
            else
            {
                new Alert(Alert.AlertType.WARNING,
                    "Bookings update failed", ButtonType.CLOSE).showAndWait();
            }
            conn.close();
        } catch (ClassNotFoundException ex) {
            new Alert(Alert.AlertType.ERROR,
                    "Driver class not found: " + ex.getMessage(), ButtonType.OK).showAndWait();
            Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            new Alert(Alert.AlertType.ERROR,
                    "An SQL Exception occurred: " + ex.getMessage(), ButtonType.OK).showAndWait();
            Logger.getLogger(Group2.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    

    @FXML
    private void handleLoginAction(ActionEvent event) {
         String username = tfUser.getText();
         String password = tfPassword.getText();
         
         if(username.equals("bob") && password.equals("smith"))
         {
             System.out.println("Welcome To Travel Experts");
         }
         else
             System.out.println("Invalid Login Attempt");
    }
        void handleLabelAction(MouseEvent event) {
          lblCarribean.setTooltip(new Tooltip("Tooltip for Button"));
    } 
      @FXML
    private void handleCancelAction(ActionEvent event) {
    System.exit(0);
    }
   // RequiredFieldValidator validator = new  RequiredFieldValidator();
 
    
    
}
