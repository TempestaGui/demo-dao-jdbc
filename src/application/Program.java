package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

public class Program {
    public static void main(String[] args) throws SQLException, IOException {
        SellerDao sellerDao = DaoFactory.crateSellerDao(); //injecao de dependicia sem instancia a aplicaçao

        Seller seller = sellerDao.findById(22);
        System.out.println(seller);
    }
}
