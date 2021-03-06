/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fox0fNight
 */
public class DataConnection {

    private static Connection con;
    private static String URL;
    private static String USER;
    private static String PASSWORD;

    public static void main(String[] args) {
        Connection c;
        c = getConnection();
        if (c == null) {
            System.out.println("Loi");
        } else {
            System.out.println("Ket noi thanh cong");
        }
    }

    public static Connection getConnection() {
        con = null;
        Properties properties = new Properties();
        try {

            properties.load(new FileReader(new File("info.properties")));
            URL = properties.getProperty("url");
            USER = properties.getProperty("user");
            PASSWORD = properties.getProperty("password");
            
            con = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (con);
    }

    public static void freeConnection() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
