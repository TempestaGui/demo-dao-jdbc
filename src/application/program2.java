package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;

public class program2 {
    public static void main(String[] args) throws SQLException, IOException {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== Test 1: Insert department");
        Department department = new Department("Gym", null);
        departmentDao.insert(department);
        System.out.println("Inserted department");

        System.out.println("=== Test 2: FindById department");
        Department dep = departmentDao.findById(13);
        System.out.println(dep);

        System.out.println("=== Test 3: FindAll departments");
        List<Department> list = departmentDao.findAll();
        for(Department d: list){
            System.out.println(d);
        }

        System.out.println("=== Test 4: Delete department");
        departmentDao.deleteById(14);

        System.out.println("=== Test 5: Update department");
        departmentDao.findById(13);
        dep.setName("New gym");
        departmentDao.update(dep);
        System.out.println("department updated successfully");
        departmentDao.findById(13);
    }
}
