import java.util.UUID;

public class User {

    private String name;
    private String gender;

    private UUID accountNo;

    private String userName;
    private String password;
    private float balance;

    public User( ) {
    }

    public User(String name, String userName, String password, String gender,UUID accountNo, float balance ) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public UUID getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(UUID accountNo) {
        this.accountNo = accountNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", accountNo=" + accountNo +
                ", balance= '" + balance + '\'' +
                '}';
    }

    public String toCSVString() {
       return String.format("%s,%s,%s,%s,%s,%.2f", name, userName, password, gender, accountNo.toString(), balance);
    }
}
