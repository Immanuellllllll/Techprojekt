package htmlopgave.demo.Config;

import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class MySQLConnection {


    private String db_host = "den1.mysql6.gear.host";
    private String db_database = "blogdat18a2019";
    private String db_user = "blogdat18a2019";
    private String db_password = "Mg53iXAx-L4_";
    private Connection con;

    public MySQLConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public Connection create() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://"+db_host+"/"+db_database, db_user, db_password);
            return con;
        } catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void connClose() throws SQLException {
        this.con.close();
    }


}
