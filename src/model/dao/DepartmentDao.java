package model.dao;

import model.entities.Department;

import java.util.List;

public interface DepartmentDao {
    void insert(Department obj);
    void update(Department obj);
    void deleteById(Integer byId);
    Department findById(Integer byId);
    List<Department> findAll();
}
