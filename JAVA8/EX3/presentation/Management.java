package JAVA8.EX3.presentation;

import java.util.Scanner;

public class Management {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Management main = new Management();
        do{
            System.out.println("=========Menu=========");
            System.out.println("""
                  1.Quản lý Phòng Ban
                  2.Quản lý Nhân Viên
                  3.Thoát
                    
                    """);
            System.out.println("lua chon");
            byte choice = Byte.parseByte(scanner.nextLine());
            switch (choice) {
                case 1:{
                    new DepartmentManagement().menuDepartment(scanner);
                    break;

                }
                case 2:{
                    new EmployeeManagement().menuEmployee(scanner);
                    break;
                }
                case 3:{
                    System.exit(0);
                    break;
                }
                default:
                    System.err.println("Vui long chon tu 1 den 3");
            }

        }while (true);
    }
}
