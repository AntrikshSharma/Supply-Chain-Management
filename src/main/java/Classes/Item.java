package Classes;

import credentials.DataBase;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class Item implements Items{
    public User owner;
    String category;
    String description;
    float price;

    public Item() {
        this.owner = null;
        this.category = "";
        this.description = "";
        this.price = 0.0f;
    }

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
    
    public String getCategory () {
        return this.category;
    }

    @Override
    public void save() {
        DataBase db = new DataBase();
        String url = db.getUrl();
        String userName = db.getUserName();
        String password = db.getPassword();
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, userName, password);
            String query =
                    "insert into items(userName, phn, address, email, category, description, price)" +
                    " values(?, ?, ?, ?, ?, ?, ?);";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, this.owner.getName());
            statement.setString(2, this.owner.getPhone() + "");
            statement.setString(3, this.owner.getAddress());
            statement.setString(4, this.owner.getEmail());
            statement.setString(5, this.category);
            statement.setString(6, this.description);
            statement.setString(7, this.price + "");

            statement.execute();

        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List getAll() {
        List<Item> items = new ArrayList<>();
        DataBase db = new DataBase();
        String url = db.getUrl();
        String userName = db.getUserName();
        String password = db.getPassword();
        Connection conn = null;
        Statement smt = null;
        try {
            conn = DriverManager.getConnection(url, userName, password);
            String query =
                    "select * from items;";
            smt = conn.createStatement();
            ResultSet result = smt.executeQuery(query);
            while(result.next()) {
                User user = new User(
                        result.getString(2),
                        Integer.parseInt(result.getString(3)),
                        result.getString(4),
                        result.getString(5)
                        );
                Item item = new Item(
                        user,
                        result.getString(6), // category
                        result.getString(7), // description
                        Float.parseFloat(result.getString(8))
                        );

                items.add(item);
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
}

