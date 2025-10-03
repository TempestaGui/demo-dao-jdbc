package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.io.IOException;
import java.sql.SQLException;

public class program2 {
    public static void main(String[] args) throws SQLException, IOException {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== Test 1: Insert department");
        Department department = new Department("Gym", null);
        departmentDao.insert(department);
        System.out.println("Inserted department");


    }
}
