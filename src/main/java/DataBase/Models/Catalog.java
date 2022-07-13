package DataBase.Models;
import org.w3c.dom.Document;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Catalog {

    public Catalog() {
        plants = new ArrayList<>();
    }

    private Date DELIVERY_DATE;
    private String COMPANY;
    private String UUID;
    private int ID;
    private List<Plant> plants;

    public List<Plant> getPlants() {
        return plants;
    }

    public Date getDELIVERY_DATE() {
        return DELIVERY_DATE;
    }

    public void setDELIVERY_DATE(Date DELIVERY_DATE) {
        this.DELIVERY_DATE = DELIVERY_DATE;
    }

    public String getCOMPANY() {
        return COMPANY;
    }

    public void setCOMPANY(String COMPANY) {
        this.COMPANY = COMPANY;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public static Catalog getCatalog(Document doc) throws ParseException {
        Catalog catalog = new Catalog();

        catalog.setUUID(doc.getDocumentElement().getAttribute("uuid"));

        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        Date time = formatter.parse(doc.getDocumentElement().getAttribute("date"));

        catalog.setDELIVERY_DATE(time);
        catalog.setCOMPANY(doc.getDocumentElement().getAttribute("company"));

        return catalog;
    }
}
