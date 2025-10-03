package model.dao;

import db.DB;
import model.dao.impl.DepartmentDaoJDBC;
import model.dao.impl.SellerDaoJDBC;

import java.io.IOException;
import java.sql.SQLException;

public class DaoFactory {

    public static SellerDao crateSellerDao() throws SQLException, IOException {
        return new SellerDaoJDBC(DB.getConnection());
    }

    public static DepartmentDao createDepartmentDao() throws SQLException, IOException {
        return new DepartmentDaoJDBC(DB.getConnection());
    }

}
