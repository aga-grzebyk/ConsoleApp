package pl.grzebyk.konto.Entity;

public class User {
    private String userName;
    private String password;
    private double account;

    public User() {
    }

    public User(String userName, String password, double account) {
        this.userName = userName;
        this.password = password;
        this.account = account;
    }

    public String getUserName(){
        return userName;
    }

    public String getPassword(){
        return password;
    }

    public double getAccount() {
        return account;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccount(double account) {
        this.account = account;
    }
}
