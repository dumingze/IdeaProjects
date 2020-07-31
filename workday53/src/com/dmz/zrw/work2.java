package com.dmz.zrw;

import org.junit.Test;

import java.io.*;
import java.sql.*;
import java.util.Properties;

/*2. 在test数据库中，创建user表(id, username, password, balance).
     批量插入10000条记录, 然后查询 balance>10000 的用户有哪些？将username和balance输出到test.txt文件中。*/
public class work2 {

    @Test
    public void insertIntoUser() throws SQLException, IOException { //11291ms,设置参数后：177ms
        Connection conn = getConnection();
        String sql = "insert into user(username,password,banlance) values(?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {

            //可以设置缓存为1000
            if (i % 1000 == 0) {
                pstmt.executeBatch();
                pstmt.clearBatch();
            }
            pstmt.setString(1, ""+i);
            pstmt.setString(2,"123456");
            pstmt.setInt(3,10001);
            pstmt.addBatch();
        }
        pstmt.executeBatch();//9999
        //long end = System.currentTimeMillis();
       // System.out.println(end - start + "ms");
        pstmt.close();
        conn.close();
    }

    @Test
    public void queryFromUser() throws SQLException, IOException {
        Connection conn = getConnection();
        String sql = "select id, username ,banlance ,password from user where banlance>10000";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        BufferedWriter bw = new BufferedWriter(new FileWriter("test.txt"));
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("username");//这里使用的是别名
            String password = rs.getString("password");
            String banlance = rs.getString("banlance");
            StringBuilder sb = new StringBuilder();
            sb.append(name).append(": ").append(banlance).append(System.lineSeparator());
            System.out.println(sb.toString());
            bw.write(sb.toString());
           // System.out.println(id + " " + name + " " + password);
        }
        bw.close();
        rs.close();
        pstmt.close();
        conn.close();
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
    @Test
    public  void  mytest(){
        String s=" "+1;
        System.out.println(s);
    }
}
