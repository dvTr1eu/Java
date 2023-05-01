/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author uesr
 */
public class connect {
    
    public static Connection getConnection() {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setServerName("DESKTOP-GLPDGQ8");
        ds.setDatabaseName("QLBanHangJava");
        ds.setPortNumber(1433);
        ds.setUser("sa");
        ds.setPassword("trieu");
        ds.setEncrypt("false");
        try {
            Connection conn = ds.getConnection();
            System.out.println("Kết nối thành công");
            return conn;
        } catch (SQLServerException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws SQLException {
        Connection cn = getConnection();
    }
}
