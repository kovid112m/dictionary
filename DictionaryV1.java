package com.MySqlJava;
import java.sql.*;
import java.util.*;

public class DictionaryV1 {
    private final static String url = "jdbc:mysql://localhost:3306/entries";
    private final static String user = "root";
    private final static String pass = "switchiton";
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        Connection c;
	try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        c = DriverManager.getConnection(url, user, pass);
        Statement s1;
        s1 = c.createStatement();
        String str = s.next();
        ResultSet r = s1.executeQuery("select wordtype,definition from entries where word = '"+str+"'");
        while (r.next()) {
            System.out.println(r.getString("definition"));
            System.out.println(r.getString("wordtype"));
        }

        c.close();
        //System.out.println("Closing the Connection");
    }
        catch(Exception e)
    {
        System.err.println(e);
    }
    }
}
