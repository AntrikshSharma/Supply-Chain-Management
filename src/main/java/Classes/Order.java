
package Classes;

import credentials.DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class Order implements Items {

    String name;
    String phn;
    float total;
    
    public Order() {
        this.name = "";
        this.phn = "";
        this.total = 0.0f;
    }
    
    public Order(String name, String phn, float total) {
        this.name = name;
        this.phn = phn;
        this.total = total;
    }
    
    public String getName() {
        return name;
    }
    
    public String getPhone() {
        return phn;
    }
    
    public float getTotal() {
        return total;
    }

    @Override
    public List getAll() {
        List <Order> items = new ArrayList<>();
        DataBase db = new DataBase();
        String url = db.getUrl();
        String userName = db.getUserName();
        String password = db.getPassword();
        Connection conn = null;
        Statement smt = null;
        try {
            conn = DriverManager.getConnection(url, userName, password);
            String query =
                    "select * from orders;";
            smt = conn.createStatement();
            ResultSet result = smt.executeQuery(query);
            while(result.next()) {
                Order ord = new Order(result.getString(2), result.getString(3), Float.parseFloat(result.getString(4)));
                items.add(ord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return items;
    }

    @Override
    public void save() {
        DataBase db = new DataBase();
        String url = db.getUrl();
        String userName = db.getUserName();
        String password = db.getPassword();
        
        Connection conn = null;
        Statement smt = null;
        
        try {
            conn = DriverManager.getConnection(url, userName, password);
            smt = conn.createStatement();
            String query = "insert into scm.orders(name, phn, total) values(\""
                    + this.name + "\", \"" + this.phn + "\", \"" + this.total + "\");";
            
            smt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                smt.close();
                conn.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
