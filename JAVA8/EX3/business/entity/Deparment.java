package JAVA8.EX3.business.entity;

import java.util.List;
import java.util.Scanner;

public class Deparment {
    private String departmentId ;
    private String departmentName ;
    private int totalMembers  ;

    public Deparment() {
    }

    public Deparment(int totalMembers, String departmentName, String departmentId) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.totalMembers = totalMembers;

    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(int totalMembers) {
        this.totalMembers = totalMembers;
    }
    public void inputData(Scanner scanner, List<Deparment> deparmentList ){
        this.departmentId = inputDepartmentID(scanner,deparmentList);
        this.departmentName=inputDepartmentName(scanner,deparmentList);
        System.out.println("Mời bạn nhập tổng nhân viên phòng đó");
        this.totalMembers=Integer.parseInt(scanner.nextLine());
    }
    public void inputUpdate(Scanner scanner, List<Deparment> deparmentList ){

        this.departmentName=inputDepartmentName(scanner,deparmentList);
        System.out.println("Mời bạn nhập tổng nhân viên phòng đó");
        this.totalMembers=Integer.parseInt(scanner.nextLine());
    }

    public String inputDepartmentName(Scanner scanner, List<Deparment> deparmentList) {
        System.out.println("Mời bạn nhập tên phòng");
        do {
            String departmentName = scanner.nextLine();
            if(departmentName.trim().isEmpty()){
                System.err.println("Không để trống tên");
            }
            else {
                boolean exists = deparmentList.stream().anyMatch(d -> d.getDepartmentName().equalsIgnoreCase(departmentName));

                if(!exists){
                    return departmentName;
                }
                else {
                    System.err.println("Tên đã trùng hehee");
                }

            }

        }while(true);
    }

    public String inputDepartmentID(Scanner scanner, List<Deparment> deparmentList) {
        System.out.println("Mời bạn nhập ID cho Deparment D100");
        do {
            String idBook= scanner.nextLine();
            if (idBook.matches("^D\\w{3}")) {
                boolean exits=deparmentList.stream().anyMatch(d->d.getDepartmentId().equals(idBook));
                if (!exits){
                    return idBook;
                }
                else {
                    System.err.println("Mã phòng đã bị trùng xin vui lòng nhập lai");
                }
            }else {
                System.err.println("Bạn đã nhập sai ký tự xin vui lòng ");
            }

        }while(true);
    }
    public void displayData(){
        System.out.printf("[Id:%s|Name:%s|TotalMember:%d]\n",this.departmentId,this.departmentName,this.totalMembers);
    }
}
