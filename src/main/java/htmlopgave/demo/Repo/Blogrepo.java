package htmlopgave.demo.Repo;


import htmlopgave.demo.Config.MySQLConnection;
import htmlopgave.demo.Models.Blogpost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class Blogrepo {
    Connection con;



    public Blogrepo() {
       // try {
            MySQLConnection msc=new MySQLConnection();
            con = msc.create();
        //}catch (Exception e) { }
    }



    public ResultSet getSingleBlogpost(int id){
        String q ="Select * from Blogposts where bid="+id;
        try {
            ResultSet rs = Query(q);
            return rs;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    private ResultSet Query (String query) throws SQLException
    {
        Statement stmt = con.createStatement();
        return (stmt.executeQuery(query));
    }

    public ResultSet getAllBlogpost() {
        String q ="Select * from Blogposts order by bid desc";
        try {
            ResultSet rs = Query(q);
            return rs;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public void createBlogpost(int bid, String text, String random, String headertext, String summary) throws SQLException {
        String q = "insert into blogposts (text,image,headertext,summary)" + "values (?,?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(q);
        preparedStatement.setString(1, text);
        preparedStatement.setString(2, random);
        preparedStatement.setString(3, headertext);
        preparedStatement.setString(4, summary);
        preparedStatement.execute();
        preparedStatement.close();

    }
}
