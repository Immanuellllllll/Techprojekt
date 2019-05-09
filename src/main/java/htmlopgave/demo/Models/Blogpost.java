package htmlopgave.demo.Models;

public class Blogpost {
    private int bid;
    private String text;
    private String image;
    private String headertext;
    private String summary;

    public Blogpost(int bid, String text, String image, String headertext, String summary) {
        this.bid = bid;
        this.text = text;
        this.image = image;
        this.headertext = headertext;
        this.summary = summary;
    }

    public Blogpost() {

    }

    public String getHeadertext() {
        return headertext;
    }

    public void setHeadertext(String headertext) {
        this.headertext = headertext;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
