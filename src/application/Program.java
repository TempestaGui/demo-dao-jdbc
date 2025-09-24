package application;

import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Program {
    public static void main(String[] args) {
        Department dp = new Department( "books",1);

        Seller s1 = new Seller(1,"John","John@gmail",new Date(),3000.0,dp);
        System.out.println(s1);
        System.out.println(dp.toString());
    }
}
