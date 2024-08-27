package JAVA8.EX3.presentation;

import JAVA8.EX3.business.entity.Deparment;
import JAVA8.EX3.business.entity.Employee;
import JAVA8.EX3.business.feature.IDepartmentFeature;
import JAVA8.EX3.business.feature.imp.DepartmentFeatureImp;
import JAVA8.EX3.business.feature.imp.EmployeeFeatureImp;

import java.util.Scanner;

public class DepartmentManagement {
    IDepartmentFeature departmentFeature= new  DepartmentFeatureImp();
    public void menuDepartment(Scanner scanner) {
        DepartmentManagement departmentManagement = new DepartmentManagement();
        boolean isLoop = true;
        do {
            System.out.println("---------------------------Department-MANAGEMENT---------------------------\n" +
                    "\n" +
                    "1. Hiển thị danh sách phòng ban\n" +
                    "2. Thêm mới phòng ban\n" +
                    "3. Chỉnh sửa tên phòng ban\n" +
                    "4. Hiển thị danh sách nhân viên của phòng ban theo mã phòng\n" +
                    "5. Xóa phòng ban (chỉ xóa khi ko có nhân viên nào)\n" +
                    "6. Thoát\n"
            );
            System.out.println("lua chon");
            byte choice = Byte.parseByte(scanner.nextLine());
            switch (choice) {
                case 1:{
                     departmentManagement.showAllDepartment();
                    break;
                }
                case 2:{
                    departmentManagement.addNewDepart(scanner);
                    break;

                }
                case 3:{
                    departmentManagement.updateDepartment(scanner);
                    break;

                }
                case 4:{
                    departmentManagement.showListEmpByDepartID(scanner);
                    break;
                }
                case 5:{
                   departmentManagement.deleteDepart(scanner);
                    break;
                }
                case 6:{
                    isLoop = false;
                    break;
                }
                default:
                    System.err.println("Vui lòng nhập lại từ 1 -> 5");

            }




        }while (isLoop);
    }

    public void showListEmpByDepartID(Scanner scanner) {
         departmentFeature.showAllEmployeeByDepartmentID();
    }

    public void deleteDepart(Scanner scanner) {
        System.out.println("Mời bạn nhập ID muốn xóa:");
        String id = scanner.nextLine();
        int indexDelete=departmentFeature.findDepartmentByID(id);
        if(indexDelete!=-1){
            boolean check= EmployeeFeatureImp.employees.stream().anyMatch(e->e.getDepartment().getDepartmentId().equals(id));
            if(check){
                System.err.println("Không thể xóa vì nhân viên đang ở trong phòng ban");
            }
            else {
                EmployeeFeatureImp.employees.remove(id);
                System.out.println("Xóa thành công");
            }
        }
        else {
            System.err.println("Không tìm thấy phòng ban"+id);
        }
    }

    public void updateDepartment(Scanner scanner) {
        if (DepartmentFeatureImp.deparments.isEmpty()) {
            System.err.println("Danh sach trong");
            return;
        }
        System.out.println("Moi bạn nhap ID can thay doi");
        String id = scanner.nextLine();
        int index=departmentFeature.findDepartmentByID(id);
        if(index!=-1){
            Deparment deparment = DepartmentFeatureImp.deparments.get(index);
            deparment.inputUpdate(scanner,DepartmentFeatureImp.deparments);
            departmentFeature.updateDepartment(id,deparment);
            System.out.println("Cap thanh thanh cong");
        }
        else {
            System.err.println("Khong thay ID ");
        }

    }

    public void addNewDepart(Scanner scanner) {
        System.out.println("Số phòng ban cần thêm vào");
        do {
        int n= Integer.parseInt(scanner.nextLine());
        if (n>0){
            for (int i=0;i<n;i++){
                Deparment deparment= new Deparment();
                deparment.inputData(scanner,DepartmentFeatureImp.deparments);
                departmentFeature.addNewDepartment(deparment);
            }
            break;
        }
        else {
            System.out.println("số lượng phải lớn hơn 0");
        }

        }while (true);
    }

    public void showAllDepartment() {
        departmentFeature.showDepartment();

    }
}
