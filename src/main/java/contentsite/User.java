package contentsite;

public class User {

    private String userName;
    private String password;
    private boolean isLogIn;
    private boolean isPremiumMember;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public int getPassword() {
        return (userName+password).hashCode();
    }

    public boolean isLogIn() {
        return isLogIn;
    }

    public boolean isPremiumMember() {
        return isPremiumMember;
    }

    public void upgradeForPremium() {
        isPremiumMember = true;
    }

    public void setLogIn(boolean value) {
        isLogIn = value;
    }



}
