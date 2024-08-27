package JAVA8.EX3.business.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Employee {
    private String  employeeid;
    private String  employeeName;
    private LocalDate birthday;
    private boolean sex;
    private double salary;
    private Employee manager;
    private Deparment department;

    public Employee() {

    }

    public Employee(String employeeid, String employeeName, LocalDate birthday, boolean sex, double salary, Employee manager, Deparment department) {
        this.employeeid = employeeid;
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.sex = sex;
        this.salary = salary;
        this.manager = manager;
        this.department = department;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Deparment getDepartment() {
        return department;
    }

    public void setDepartment(Deparment department) {
        this.department = department;
    }
    public void inputData(Scanner scanner, List<Employee> employees,List<Deparment> deparments){
        this.employeeid = inputEmployeeID(scanner);
        this.employeeName=inputEmployeeName(scanner);
        this.birthday=inputBirthday(scanner);
        this.sex=inputSex(scanner);
        System.out.println("Mời bạn nhập lương cơ bản:");
        this.salary=Double.parseDouble(scanner.nextLine());
        this.manager=inputManager(scanner,employees);
        this.department=inputDepartment(scanner,deparments);

    }



    public void inputUpdate(Scanner scanner, List<Employee> employees,List<Deparment> deparments){

        this.employeeName=inputEmployeeName(scanner);
        this.birthday=inputBirthday(scanner);
        this.sex=inputSex(scanner);
        System.out.println("Mời bạn nhập lương cơ bản:");
        this.salary=Double.parseDouble(scanner.nextLine());
        this.manager=inputManager(scanner,employees);
        this.department=inputDepartment(scanner,deparments);

    }
    public String inputEmployeeName(Scanner scanner) {
        System.out.println("Mời bạn nhập tên nhân viên");
        do {
            String employeeName = scanner.nextLine();
            if(employeeName.trim().isEmpty()){
                System.err.println("Ko den trong ten");
            }
            else {
                return employeeName;
            }

        }while (true);
    }

    public Deparment inputDepartment(Scanner scanner, List<Deparment> deparments) {
        System.out.println("Lựa chọn ID");
        for (Deparment deparment : deparments) {
            System.out.printf("[ID:%S|Name:%s]\n",deparment.getDepartmentId(),deparment.getDepartmentName());
        }
        Deparment selectedDeparment = null;
        boolean isValid = false;
        while (!isValid) {
            String choice = scanner.nextLine();
          for (int i = 0; i < deparments.size(); i++) {
              if(deparments.get(i).getDepartmentId().equals(choice)) {
                  selectedDeparment = deparments.get(i);
                  isValid = true;
                  break;
              }
          }
          if(!isValid){
              System.err.println("Khong tim thay id"+choice);
          }

        }
        return selectedDeparment;
    }
    public String getListDepartById(List<Deparment> deparments) {
        for (Deparment deparment : deparments) {
            if(deparment.getDepartmentId()==this.department.getDepartmentId()) {
                return deparment.getDepartmentName();
            }
        }
        return null;
    }


    public Employee inputManager(Scanner scanner,List<Employee> employees) {
        Employee employee = null;
        do {
            System.out.println("Mời bạn nhập mã nhân viên quản lý");
            String managerId=scanner.nextLine();
            if(managerId.isEmpty()){
                return null;
            }
            manager=findEmployee(employees,managerId);
            if(manager != null){
                return manager;
            }
            else {
                System.err.println("Khong tim thay nhan vien vơi ma"+managerId);
            }

        }while (true);
    }

    public boolean inputSex(Scanner scanner) {
        System.out.println("Mời bạn nhập giới tính Nam-true,Nữ-false");
        do {
            String sex=scanner.nextLine();
            if(sex.equalsIgnoreCase("true")||sex.equalsIgnoreCase("false")){
                return Boolean.parseBoolean(sex);
            }
            else {
                System.err.println("Bạn nhập sai cú pháp");
            }

        }while(true);
    }


    public LocalDate inputBirthday(Scanner scanner) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthday = null;
        do {
            System.out.print("Enter birthday: EX:dd/MM/yyyy ");
            String birthdayString = scanner.nextLine();
            try {
                birthday = LocalDate.parse(birthdayString, formatter);
                break;

            }
            catch (Exception e) {
                System.err.println("Định dạng sai");
            }

        }while(true);
        return birthday;
    }

    public String inputEmployeeID(Scanner scanner) {
        System.out.println("Enter Employee ID: ");
        do {
            String employeeID = scanner.nextLine();
            if (employeeID.matches("^E\\w{4}$")) {
                return employeeID;
            }
            else {
                System.err.println("Bạn đã nhập sai định dạng");
            }


        }
        while (true);


    }
    public Employee findEmployee(List<Employee> employees,String employeeid) {
            return employees.stream().filter(employee -> employee.getEmployeeid().equals(employeeid)).findFirst().orElse(null);
    }
    public  void displayData(List<Deparment> deparments) {
        String managerName = (manager != null) ? manager.getEmployeeName() : "None";
        System.out.printf("[Id:%s|Name:%s|Birthday:%s|Sex:%s|Salary:%f|Manager:%s|Department:%s]\n]",this.employeeid,this.employeeName,this.birthday.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),this.sex?"Nam":"Nu",this.salary,managerName ,getListDepartById(deparments));
    }
}
