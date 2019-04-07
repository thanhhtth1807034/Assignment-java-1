package utility;

import controller.EmployeeController;

import java.util.Scanner;

public class MenuEmployee {
    public void generateMenu() {
        Scanner scanner = new Scanner(System.in);
        EmployeeController employeeController = new EmployeeController();

        while (true) {
            System.out.println("------Menu------");
            System.out.println("1. Đăng ký");
            System.out.println("2. Đăng nhập");
            System.out.println("3. Thoát");
            System.out.println("-------------------");
            System.out.println("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    employeeController.signUp();
                    break;
                case 2:
                    employeeController.signIn();
                    break;
                case 3:

                    System.out.println("Thoát");
                    break;
                default:
                    System.out.println("lựa chọn sai vui lòng chọn lại.");
                    break;
            }
            if (choice == 3){
                System.out.println("Xin chào và hẹn gặp lại");
                break;
            }
        }
    }
}
