package Model;

public class User {

    private String fname;
    private String lname;
    private String email;
    private String password;
    private XpSystem xpSystem;



    public User(XpSystem xpSystem, String fname, String lname, String email, String password) {
        this.xpSystem = xpSystem;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
