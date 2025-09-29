package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) throws SQLException, IOException {
        SellerDao sellerDao = DaoFactory.crateSellerDao(); //injecao de dependicia sem instancia a aplicaçao
        System.out.println("=== Test 1: seller findById ===");
        Seller seller = sellerDao.findById(24);
        System.out.println(seller);

        System.out.println("\n=== Test 2: seller findSellerByDepartmentId ===");
        Department dep = new Department(null, 2);
        List<Seller> list = sellerDao.findByDepartmentId(dep);
        for(Seller s: list){
            System.out.println(s);
        }

        System.out.println("\n=== Test 3: seller findAll ===");
        List<Seller> list2 = sellerDao.findAll();
        for(Seller s: list2){
            System.out.println(s);
        }

        System.out.println("\n=== Test 4: seller insert seller");
        Seller seller1 = new Seller(null,"test","teste@gmail", new Date(), 3000.0, dep);
        sellerDao.insert(seller1);
        System.out.println("inserted! new id = "+ seller1.getId());

        System.out.println("\n=== Test 5: seller update seller ===");
        seller = sellerDao.findById(24);
        seller.setName("teste2");
        sellerDao.update(seller);
        System.out.println("update seller successful");
    }
}
