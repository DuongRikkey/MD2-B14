package JAVA8.EX3.business.feature.imp;

import JAVA8.EX3.business.entity.Deparment;
import JAVA8.EX3.business.entity.Employee;
import JAVA8.EX3.business.feature.IDepartmentFeature;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class DepartmentFeatureImp implements IDepartmentFeature {
    public static List<Deparment> deparments = new ArrayList<Deparment>();
    static {
        deparments.add(new Deparment(12,"SSSSS","D123"));
        deparments.add(new Deparment(45,"SSSS1","D124"));
        deparments.add(new Deparment(47,"SSS12","D125"));
    }
    @Override
    public void showDepartment() {
      deparments.forEach(Deparment::displayData);
    }

    @Override
    public void addNewDepartment(Deparment department) {
      deparments.add(department);
    }

    @Override
    public void removeDepartment(int idDelete) {
       deparments.remove(idDelete);
    }

    @Override
    public void updateDepartment(String updateID, Deparment department) {
      deparments.set(deparments.indexOf(department), department );
    }

    @Override
    public void showAllEmployeeByDepartmentID() {
        for (Deparment deparment : deparments) {
            System.out.println("Mã phòng ban "+deparment.getDepartmentId());
            int count=0;
            for (Employee employee: EmployeeFeatureImp.employees){
                if(deparment.getDepartmentId()==employee.getDepartment().getDepartmentId()){
                    employee.displayData(DepartmentFeatureImp.deparments);
                    count++;
                }
            }
            if(count==0){
                System.err.println("Phòng trống");
            }
            else {
                System.out.println("Phong co so nhan vien la"+count);
            }
        }


    }

//    @Override
//    public int findDepartmentByID(String id) {
//        for (int i = 0; i < deparments.size(); i++) {
//            if(deparments.get(i).getDepartmentId().equals(id)){
//                return i;
//
//            }
//        }
//        return -1;
//    }
    @Override
    public int findDepartmentByID(String id) {
       return IntStream.range(0,deparments.size()).
               filter(i->deparments.get(i).getDepartmentId().equals(id)).
               findFirst().
               orElse(-1);
    }
}
