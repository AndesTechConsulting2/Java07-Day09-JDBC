package org.andestech.learning.rfb18.g2;

import java.sql.*;
import java.util.Properties;
import java.util.Random;

public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException {

    Class.forName("org.postgresql.Driver");

    String Host = "jdbc:postgresql://localhost/RFB18";
    Properties props = new Properties();

    props.setProperty("user", "postgres");
    props.setProperty("password", "postgres");

    Connection con = DriverManager.getConnection(Host, props);

    String process = "create table t09(id int, data varchar);";

    Statement st = con.createStatement();

   // st.execute(process);

//    for(int i=0; i<10; i++) {
//        int id = new Random().nextInt(100000);
//        String st2 = "DATA_";
//        st2 += (char)(65 + new Random().nextInt(23));
//
//        st.executeUpdate(
//                "insert into t09(id,data) values(" + id +", '" + st2 + "')");
//    }
    System.out.println(con);


    ResultSet rset = st.executeQuery("select * from t09 where id<60000;");

    int c = 0;
    while (rset.next())
    {
        int id = rset.getInt("id");
        String data = rset.getString("data");

        System.out.println(++c  + "\t|"+ id + "\t|" + data);
    }



    st.close();;
    con.close();
    }
}
