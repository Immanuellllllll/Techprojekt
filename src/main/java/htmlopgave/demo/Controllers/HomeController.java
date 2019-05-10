package htmlopgave.demo.Controllers;


import htmlopgave.demo.Models.Blogpost;
import htmlopgave.demo.Models.Login;
import htmlopgave.demo.Service.Blogservice;
import htmlopgave.demo.Service.Loginservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class HomeController {
    @Autowired
    Blogservice bs;
    @Autowired
    Loginservice ls;

    @GetMapping("/")
    public String home(Model model) throws SQLException {
        return "Login";
    }
    @GetMapping("/Blogs")
    public String Blogs(@ModelAttribute Login login, Model model) throws SQLException {

        model.addAttribute("blogposts", bs.getAllBlogposts());
        model.addAttribute("blogpost", new Blogpost());

        return "index";
    }
    @PostMapping("/Blogs")
    public String login(@ModelAttribute Login login, Model model, HttpSession session) throws SQLException {

        try {
            ls.verifyLogin(login.getUsername(),login.getPassword());
            Boolean admin= ls.getAdmin();
            session.setAttribute("admin", admin);
            model.addAttribute("blogposts", bs.getAllBlogposts());
            model.addAttribute("blogpost", new Blogpost());

            return "index";
        }
        catch(Exception e){
            model.addAttribute("invalidCredentials", true);
            return "Login";
        }

    }


    @GetMapping("ViewBlogpost/{bid}")
    public String viewBlogpost(@PathVariable int bid, Model model) throws SQLException {
        model.addAttribute("blogpost", bs.getSingleBlogpost(bid));

        return "Blogpost";
    }

    @PostMapping("CreateBlogpost")
    public String createBlogpost(@ModelAttribute Blogpost blogpost) throws SQLException {
        System.out.println(blogpost.getText());
        bs.createBlogpost(blogpost);
        return "index";
    }
    @GetMapping("Logout")
    public String Logout(HttpSession session){
        session.removeAttribute("admin");
        return "redirect:/";

    }
    @PostMapping("CreateUser")
    public String CreateUser(@ModelAttribute Login login) throws SQLException {
        ls.Createuser(login);
        return "redirect:/";

    }



}
