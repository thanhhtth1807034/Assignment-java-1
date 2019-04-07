package model;

import entity.Employee;

import java.sql.*;

public class EmployeeModel {
    private Connection connection;
    private  void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()){
            connection =
                    DriverManager
                            .getConnection("jdbc:mysql://localhost:3306/human_resource?user=root&password=");
        }
    }

    public boolean register(Employee emp){
        try {
            initConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into employees (name , address, email, account , password) values (?, ?, ?, ?, ?)");
            preparedStatement.setString(1,emp.getName());
            preparedStatement.setString(2,emp.getAddress());
            preparedStatement.setString(3,emp.getEmail());
            preparedStatement.setString(4,emp.getAccount());
            preparedStatement.setString(5,emp.getPassword());
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            System.out.println("Error:" + ex.getMessage());
        }
        return false;
    }

    public boolean checkExistAccount(String account){
        try{
            initConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from employees where account = ? ");
            preparedStatement.setString(1,account);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return  true;
            }
        } catch (Exception ex){
            System.out.println("Error:" + ex.getMessage());
            return false;
        }
        return false;
    }

    public Employee login(String account, String password){
        try {
            initConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from employees where account = ? AND password = ?");
            preparedStatement.setString(1,account);
            preparedStatement.setString(2,password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                Employee employee =new Employee();
                employee.setAccount(resultSet.getString(1));
                employee.setEmail(resultSet.getString(2));
                employee.setPassword(resultSet.getString(3));
                employee.setName(resultSet.getString(4));
                employee.setAddress(resultSet.getString(5));
                employee.setStatus(resultSet.getInt(6));
                employee.setCreatedAt(resultSet.getString(7));
                employee.setUpdatedAt(resultSet.getString(8));
                return employee;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
