package JAVA8.EX3.presentation;

import JAVA8.EX3.business.entity.Employee;
import JAVA8.EX3.business.feature.IEmployeeFeature;
import JAVA8.EX3.business.feature.imp.DepartmentFeatureImp;
import JAVA8.EX3.business.feature.imp.EmployeeFeatureImp;

import java.util.Scanner;

public class EmployeeManagement {
    IEmployeeFeature employeeFeature=new EmployeeFeatureImp();
    public void menuEmployee(Scanner scanner) {
        EmployeeManagement employeeManagement = new EmployeeManagement();
        boolean isLoop = true;
        do {
            System.out.println("---------------------------Department-MANAGEMENT---------------------------\n" +
                    "\n" +
                    "1. Hiển thị danh sách thông tin tất cả nhân viên(mã nhân viên và tên)\n" +
                    "2. Xem chi tiết thông tin nhân viên theo mã nhân viên (toàn bộ thông tin)\n" +
                    "3. Thêm mới nhân viên\n" +
                    "4. Chỉnh sửa thông tin nhân viên\n" +
                    "5. Xóa thông tin nhân viên\n" +
                    "6. Thống kê số lượng nhân viên trung bình của mỗi phòng\n" +
                    "7. Tìm ra 5 phòng có số lượng nhân viên đông nhất\n" +
                    "8. Tìm ra người quản lý nhiều nhân viên nhất\n" +
                    "9. Tìm ra 5 nhân viên có tuổi cao nhất công ty\n" +
                    "10. Tìm ra 5 nhân viên hưởng lương cao nhất\n" +
                    "11. Thoát\n"
            );
            System.out.println("lua chon");
            byte choice = Byte.parseByte(scanner.nextLine());
            switch (choice) {
                case 1:{
                    employeeManagement.showEmp();
                    break;
                }
                case 2:{
                    employeeManagement.searchEmpByID(scanner);
                    break;

                }
                case 3:{
                    employeeManagement.addEmp(scanner);
                    break;


                }
                case 4:{
                    employeeManagement.updateEmp(scanner);
                    break;
                }
                case 5:{
                    employeeManagement.deleteEmp(scanner);
                    break;
                }
                case 6:{
                    employeeManagement.statisticsoftheaverage();
                    break;
                }
                case 7:{
                    employeeManagement.top5DepartmentsByMembers();
                    break;
                }
                case 8:{
                    employeeManagement.findTheMostEmployeeManager();
                    break;
                }
                case 9:{
                    employeeManagement.findFiveEmpLagestHasHighestAgeEmp();
                    break;
                }
                case 10:{
                    employeeManagement.findFiveEmpLagestHasHighestSalaryEmp();
                    break;
                }
                case 11:{isLoop = false;
                    break;
                }
                default:
                    System.err.println("Vui lòng nhập lại từ 1 -> 5");

            }




        }while (isLoop);
    }

    private void findFiveEmpLagestHasHighestSalaryEmp() {
        employeeFeature.findFiveEmpLagestHasHighestSalaryEmp();
    }

    public void findFiveEmpLagestHasHighestAgeEmp() {
        employeeFeature.findFiveEmpLagestHasHighestAgeEmp();
    }

    public void findTheMostEmployeeManager() {
        employeeFeature.findTheMostEmployeeManager();
    }

    public void top5DepartmentsByMembers() {
        employeeFeature.findFiveRoomHasEmpLagest();
    }

    public void statisticsoftheaverage() {
        if (DepartmentFeatureImp.deparments.isEmpty()) {
            System.out.println("Danh sách phòng ban trống.");
            return;
        }
        employeeFeature.statisticsAverage();
    }

    public void deleteEmp(Scanner scanner) {
        if(EmployeeFeatureImp.employees.isEmpty()){
            System.err.println("Danh sach trong");
            return;
        }
        String idDelete = scanner.nextLine();
        int index=employeeFeature.findEmployeeByID(idDelete);
    }

    public void updateEmp(Scanner scanner) {
        if(EmployeeFeatureImp.employees.isEmpty()){
            System.err.println("Danh sach trong");
            return;
        }
        System.out.println("Mời bạn nhập idUpdate");
        String idUpdate = scanner.nextLine();
        int index = employeeFeature.findEmployeeByID(idUpdate);
        if(index != -1){
            Employee updateEmployee=EmployeeFeatureImp.employees.get(index);
            updateEmployee.inputUpdate(scanner,EmployeeFeatureImp.employees,DepartmentFeatureImp.deparments);
            employeeFeature.updateEmployee(idUpdate,updateEmployee);
            System.out.println("Cap nhat thanh cong");

        }
        else {
            System.err.println("Khong tim thay idUpdate"+idUpdate);
        }
    }

    public void searchEmpByID(Scanner scanner) {
        System.out.println("Mời bạn nhập ID");
        String employeeId = scanner.nextLine();
       employeeFeature.SearchInforEmpByID(employeeId);


    }



    public void addEmp(Scanner scanner) {
        System.out.println("Mời bạn nhập số phòng ban cần thêm vào");
        do {
            int n=Integer.parseInt(scanner.nextLine());
            if(n>0){
                for (int i=0;i<n;i++) {
                    Employee employee=new Employee();
                    employee.inputData(scanner,EmployeeFeatureImp.employees, DepartmentFeatureImp.deparments);
                    employeeFeature.addNewEmployee(employee);
                }
                break;
            }else {
                System.out.println("ko tìm thấy");
            }

        }while (true);

    }

    public void showEmp() {
        employeeFeature.EmpInformation();

    }
}
