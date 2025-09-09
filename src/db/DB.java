package db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Connection connection = null;

    public static Connection getConnection() throws IOException, SQLException {
        if(connection == null) {
            try {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                connection = DriverManager.getConnection(url, props); //salvando os dados de conexao no objeto connection
            } catch (Exception e) {
                throw new DbException(e.getMessage());
            }
        }
        return connection;
    }

    private static Properties loadProperties() throws IOException {
       try(FileInputStream fis = new FileInputStream("db.properties")) {
           Properties props = new Properties();
           props.load(fis); //faz a leitura do aquivo properties e guarda os valores em um objeto Properties
           return props;
       }
       catch (FileNotFoundException e) {
           throw new DbException("File not found: db.properties");
       }
    }

    //metodo para fechar a conexao
    public static void closeConnection(){
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
    public static void closeStatement(Statement st) throws SQLException {
        if(st != null) {
            try {
                st.close();
            }catch(SQLException e){
                throw new DbException(e.getMessage());
        }
        }
    }
    public static void closeResultSet(ResultSet rs){
        if(rs != null){
            try{
                rs.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}
