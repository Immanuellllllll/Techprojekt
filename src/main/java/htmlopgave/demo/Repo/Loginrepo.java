package htmlopgave.demo.Repo;

import htmlopgave.demo.Config.MySQLConnection;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class Loginrepo {
    Connection con;
    MySQLConnection msc;

    public Loginrepo(MySQLConnection msc) throws Exception
    {
        this.msc=msc;
        this.con=msc.create();
        //Lets load the driver

    }



    public ResultSet verifyLogin(String username, String password) {
        String sql = "SELECT * FROM login WHERE username = '"+username+"' AND password = '"+password+"'";
        try {
            ResultSet rs = Query(sql);
            return rs;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }



    private ResultSet Query(String query) throws SQLException
    {
        Statement stmt = con.createStatement();
        return(stmt.executeQuery(query));
    }

    public void Createuser(String username, String password) throws SQLException {
        String q ="insert into login (username, password,admin)"+"values (?,?,?)";
        PreparedStatement preparedStatement=con.prepareStatement(q);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        preparedStatement.setBoolean(3, false);
        preparedStatement.execute();
        preparedStatement.close();



    }
}

