package JAVA8.EX3.business.feature.imp;

import JAVA8.EX3.business.entity.Deparment;
import JAVA8.EX3.business.entity.Employee;
import JAVA8.EX3.business.feature.IEmployeeFeature;
import JAVA8.RA.model.Calculator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EmployeeFeatureImp implements IEmployeeFeature {
    public static List<Employee> employees=new ArrayList<Employee>();
    @Override
    public void EmpInformation() {
        employees.forEach(e-> System.out.printf("[Id:%s|Name:%s]\n",e.getEmployeeid(),e.getEmployeeName()));


    }

    @Override
    public void SearchInforEmpByID(String idEmp) {
        for (Employee e: employees) {
            if (e.getEmployeeid().equals(idEmp)) {
                System.out.println("Chi tiết nhân viên");
                e.displayData(DepartmentFeatureImp.deparments);
                return;
            }
        }
    }



    @Override
    public void addNewEmployee(Employee employee) {
        employees.add(employee);

    }

    @Override
    public void updateEmployee(String idUpdate, Employee employee) {

    }

    @Override
    public void deleteEmployee(Employee employee) {

    }

    @Override
    public int findEmployeeByID(String id) {
        return IntStream.range(0,employees.size())
                .filter(i->employees.get(i).getBirthday().equals(id)).findFirst().orElse(-1);
    }

    @Override
    public void findTheMostEmployeeManager() {
        Map<Employee, Long> managerCount =employees.stream().filter(employee -> employee.getManager()!=null).
                collect(Collectors.groupingBy(Employee::getManager,Collectors.counting()));
        managerCount.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(1).forEach(entry -> {
            Employee manager = entry.getKey();
            Long count = entry.getValue();
            System.out.printf("Manager: %s, Number of Employees: %d\n", manager.getEmployeeName(), count);
        });

    }

    @Override
    public double statisticsAverage() {
        return (double) employees.size()/DepartmentFeatureImp.deparments.size();

    }

    @Override
    public void findFiveRoomHasEmpLagest() {
        DepartmentFeatureImp.deparments.stream().sorted(Comparator.comparingInt(Deparment::getTotalMembers).reversed()).limit(5).forEach(Deparment::displayData);

    }

    @Override
    public void findFiveEmpLagestHasHighestAgeEmp() {
      employees.stream().sorted(Comparator.comparing(Employee::getBirthday).reversed()).limit(5).forEach(e->e.displayData(DepartmentFeatureImp.deparments));
    }

    @Override
    public void findFiveEmpLagestHasHighestSalaryEmp() {
      employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).limit(5).forEach(e->e.displayData(DepartmentFeatureImp.deparments));
    }
}
