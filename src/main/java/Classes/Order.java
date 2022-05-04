/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Order {

    String name;
    String phn;
    float total;
    
    public String getName() {
        return name;
    }
    
    public String getPhone() {
        return phn;
    }
    
    public float getTotal() {
        return total;
    }
    
    public void save() {
        
    }
}
