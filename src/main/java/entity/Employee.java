package entity;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Employee {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private String name;
    private String address;
    private String email;
    private String account;
    private String password;
    private String createdAt = dateFormat.format(new Date());
    private String updatedAt = dateFormat.format(new Date());
    private int status;
    private ArrayList<String> errors;

    public Employee() {
    }

    public Employee(String name, String address, String email, String account, String password) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.account = account;
        this.password = password;
    }

    public ArrayList<String> getErrors() {
        return errors;
    }

    public void setErors(ArrayList<String> erors) {
        this.errors = errors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }



}
