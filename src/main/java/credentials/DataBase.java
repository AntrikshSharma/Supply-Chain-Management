package credentials;

public class DataBase {
    private final String url = "jdbc:myql://localhost:3360/scm";
    private final String userName = "root";
    private final String password = "admin";
    
    public String getUrl() {
        return this.url;
    }
    
    public String getUserName() {
        return this.userName;
    }
    
    public String getPassword(){
        return this.password;
    }
}
