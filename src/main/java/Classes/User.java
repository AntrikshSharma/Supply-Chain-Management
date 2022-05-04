/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author archi
 */
public class User {
    
    String name;
    int phn;
    String address;
    String email;
    
    public User() {
        this.address = "";
        this.name = "";
        this.phn = 0;
        this.email = "";
    }
    
    public User( String username, int phone, String addr, String eml)
    {
        this.address = addr;
        this.name = username;
        this.phn = phone;
        this.email = eml;
    }
    
    public String getName() {
        
        return this.name;
    }
    
    public String getAddress() {
        
        return this.address;
    }
    
    public int getPhone() {
        
        return this.phn;
    }
    public String getEmail() {
        
        return this.email;
    }
}
