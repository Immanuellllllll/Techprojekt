package htmlopgave.demo.Service;

import com.mysql.cj.protocol.Resultset;
import htmlopgave.demo.Models.Blogpost;
import htmlopgave.demo.Repo.Blogrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Blogservice {
    @Autowired
    Blogrepo br;


    public Blogpost getSingleBlogpost(int id) throws SQLException {
        ResultSet rs =br.getSingleBlogpost(id);
        rs.next();
        Blogpost blogpost = new Blogpost(
                rs.getInt("bid"),
                rs.getString("text"),
                rs.getString("image"),
                rs.getString("headertext"),
                rs.getString("summary"));

        return blogpost;
    }
    public List<Blogpost> getAllBlogposts() throws SQLException {
        ResultSet rs = br.getAllBlogpost();
        List bloglist = new ArrayList();

        while (rs.next()){
            bloglist.add(new Blogpost(
                    rs.getInt("bid"),
                    rs.getString("text"),
                    rs.getString("image"),
                    rs.getString("headertext"),
                    rs.getString("summary")));
        }
        return bloglist;

    }

    public void createBlogpost(Blogpost blogpost) throws SQLException {
        blogpost.setSummary(blogpost.getText().substring(0,96)+"...");
        br.createBlogpost(blogpost.getBid(),blogpost.getText(),"Random",blogpost.getHeadertext(),blogpost.getSummary());
    }
}
