package controller;

import entity.Employee;
import model.EmployeeModel;

import java.util.Scanner;

public class EmployeeController {
    private EmployeeModel employeeModel = new EmployeeModel();
    Scanner scanner = new Scanner(System.in);
    Employee employee;

    public void signUp() {
        System.out.println("Đăng ký tài khoản :");
        while (true) {
            System.out.println("Nhập tên nhân viên: ");
            String name = scanner.nextLine();
            System.out.println("Nhập Dia chi: ");
            String address = scanner.nextLine();
            System.out.println("Nhap email: ");
            String email = scanner.nextLine();
            System.out.println("Nhập tài khoản: ");
            String account = scanner.nextLine();
            System.out.println("Nhập mật khẩu: ");
            String password = scanner.nextLine();

            if (employeeModel.checkExistAccount(account)) {
                System.out.println("tài khoản đã tồn tại, vui lòng nhập lại.");
            } else if ( name.length() == 0 || address.length() == 0 || email.length() == 0 || account.length() == 0 || password.length() == 0) {
                System.out.println("Vui lòng nhập đầy đủ thông tin");
            } else {
                Employee emp = new Employee(name, address, email, account, password);
                employeeModel.register(emp);
                break;

            }
        }
    }

    public void signIn() {
        System.out.println("Đăng nhập tài khoản :");

        while (true) {
            System.out.println("Nhập tài khoản: ");
            String account = scanner.nextLine();
            System.out.println("Nhập mật khẩu: ");
            String password = scanner.nextLine();
            employee = employeeModel.login(account, password);
            if (employee == null) {
                System.out.println("Đăng nhập thất bại.Vui lòng thử lại.");
            } else {
                System.out.println("Đăng nhập thành công.");
                break;
            }
        }
    }
}
