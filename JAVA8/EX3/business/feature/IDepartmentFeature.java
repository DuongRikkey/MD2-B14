package JAVA8.EX3.business.feature;

import JAVA8.EX3.business.entity.Deparment;

public interface IDepartmentFeature {
    void showDepartment();
    void addNewDepartment(Deparment department);
    void removeDepartment(int idDelete);
    void updateDepartment(String updateID,Deparment department);
    void showAllEmployeeByDepartmentID();
    int findDepartmentByID(String id);


}
