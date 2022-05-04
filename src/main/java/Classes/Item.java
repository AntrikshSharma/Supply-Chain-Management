/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;


public class Item {
    
    User owner = new User();
    String category;
    String description;
    float price;
    
    
    public Item(User itemOwner, String cat, String desc, float pr)
    {
        this.owner = itemOwner;
        this.description = desc;
        this.price = pr;
        this.category = cat;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public float getPrice() {
        return this.price;
    }
}
