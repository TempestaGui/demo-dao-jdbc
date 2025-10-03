package model.dao.impl;

import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {
    Connection conn = null;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("INSERT INTO department "+
                                        "(name) "+
                                        "VALUES (?) ", Statement.RETURN_GENERATED_KEYS);

            st.setString(1, obj.getName());
            int row = st.executeUpdate();
            if(row > 0){
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    obj.setId(id);
                }else {
                    throw new DbException("Unexpected error! no rows affected!");
                }
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void update(Department obj) {

    }

    @Override
    public void deleteById(Integer byId) {

    }

    @Override
    public Department findById(Integer byId) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("Select * from department where department.id = ?");

            st.setInt(1, byId);
            rs = st.executeQuery();
            if(rs.next()){
                return initialDepartment(rs);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return null;

    }

    @Override
    public List<Department> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("Select * from department");
            rs = st.executeQuery();
            List<Department> list = new ArrayList<>();

            while(rs.next()){
                list.add(initialDepartment(rs));
            }
            return list;
        }catch(SQLException e){
           throw new DbException(e.getMessage());
        }
    }

    private Department initialDepartment(ResultSet rs) throws SQLException {
        Department department = new Department();
        department.setId(rs.getInt("id"));
        department.setName(rs.getString("name"));
        return department;
    }
}
