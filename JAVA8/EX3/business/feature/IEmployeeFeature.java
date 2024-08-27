package JAVA8.EX3.business.feature;

import JAVA8.EX3.business.entity.Employee;

public interface IEmployeeFeature {
 void EmpInformation();
 void SearchInforEmpByID(String idEmp);
 void addNewEmployee(Employee employee);
 void updateEmployee(String idUpdate,Employee employee);
 void deleteEmployee(Employee employee);
 int findEmployeeByID(String id);
 void findTheMostEmployeeManager();
 double statisticsAverage();
 void findFiveRoomHasEmpLagest();
 void findFiveEmpLagestHasHighestAgeEmp();
 void findFiveEmpLagestHasHighestSalaryEmp();
}
