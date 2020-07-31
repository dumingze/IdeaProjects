package com.dmz.zrw;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class work3 {




    @Test
    public void testCreateTb() throws SQLException {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        String sql = "create table if not exists user(id int primary key, username varchar (233),password varchar (255),banlance int )";
        stmt.execute(sql);
    }

    @Test
    public void insertInto() throws SQLException {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        String sql = "insert into user values(1,'杜明泽','1234',500),(2,'张若葳','1234',500);";
        stmt.execute(sql);
    }

    @Test
    public void updateData() throws SQLException {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
         String sql = "update user set banlance=banlance-100 where username='杜明泽'";
        stmt.executeUpdate(sql);
        sql = "update user set banlance=banlance+100 where username='张若葳'";
        stmt.executeUpdate(sql);
    }

    private Connection getConnection() {
        Properties info = new Properties();
        try (Reader reader = new FileReader("db.properties")) {
            info.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = info.getProperty("url");
        String user = info.getProperty("user");
        String password = info.getProperty("password");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
