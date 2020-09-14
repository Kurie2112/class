package com.neusoft.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

    /**
     *  通过userId删除对象
     */
    public static void main(String[] args){
        //1.四个参数
        String jdbcDriver="com.mysql.jdbc.Driver";
        String jdbcURL="jdbc:mysql://localhost:3306/elm";
        String jdbcUsername="root";
        String jdbcPassword="mysql";


        try {
            //2.获取连接
            Class.forName(jdbcDriver);
            Connection conn = DriverManager.getConnection(jdbcURL,jdbcUsername, jdbcPassword);

            //3.产生执行sql的对象
            Statement st=conn.createStatement();

            //4.编写sql语句
            String sql = "DELETE from user WHERE userId=2";

            //5.执行sql语句
            int rows = st.executeUpdate(sql);
            if(rows>0)
                    System.out.println("删除成功！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
