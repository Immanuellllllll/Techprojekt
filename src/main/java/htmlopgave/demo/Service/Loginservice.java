package htmlopgave.demo.Service;

import htmlopgave.demo.Models.Login;
import htmlopgave.demo.Repo.Loginrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class Loginservice {
    @Autowired
    Loginrepo lr;
    Boolean admin;


    public Boolean verifyLogin(String username, String password) throws SQLException {
        ResultSet rs =lr.verifyLogin(username, password);
        rs.next();
        String checkLoginuser = rs.getString("username");
        String checkLoginpass = rs.getString("password");
        admin= rs.getBoolean("admin");

        if ((checkLoginuser).equals(username) && (checkLoginpass).equals(password)){

            return true;
        }
        else{
            return false;
        }

    }

    public Boolean getAdmin() {
        return admin;
    }

    public void Createuser(Login login) throws SQLException {
        lr.Createuser(login.getUsername(),login.getPassword());
    }
}
