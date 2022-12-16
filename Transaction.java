package com.training.jdbc;

import java.sql.*;
import java.util.Scanner;

public class Transaction {
    public static void main(String... args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/infinite";
        String user = "root";
        String  password="root@123";
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the account number");
        long number=sc.nextLong();
        System.out.println("enter the bill month");
        int month=sc.nextInt();
        System.out.println("enter the bill amount ");
        int amount=sc.nextInt();
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            String sql = "{ call get_Transaction(?,?,?) }";
            CallableStatement stmt = con.prepareCall(sql);
            stmt.setLong(1,number);
            stmt.setInt(2,month);
            stmt.registerOutParameter(3,Types.VARCHAR);
            stmt.executeQuery();
            int due = stmt.getInt(3);
            int discount=due/100*5;
            int due1=due-discount;
            System.out.println("total due after discount is "+due1);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
