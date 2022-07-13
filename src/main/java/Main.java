import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import DataBase.Models.Catalog;
import DataBase.Models.Plant;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

import static DataBase.DbConnection.LoadToDb;
import static DataBase.Models.Catalog.getCatalog;
import static DataBase.Models.Plant.getPlant;

public class Main {

    private static String[] pathsToFiles = {
            "src\\main\\java\\Sources\\plants__000.xml",
            "src\\main\\java\\Sources\\plants__001.xml",
//            "src\\main\\java\\Sources\\plants__002.xml", есть проблемы с данными в теге ZONE
            "src\\main\\java\\Sources\\plants__003.xml",
            "src\\main\\java\\Sources\\plants__004.xml"
    };

    public static void main(String[] args) {
        try {
            for (String item : pathsToFiles) {
                Document doc = getDocument(item);//load file
                NodeList nList = doc.getElementsByTagName("PLANT");//get list by name
                Catalog catalog = getCatalog(doc);
                for (int i = 0; i < nList.getLength(); i++) {
                    Node nNode = nList.item(i);
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Plant plant = getPlant((Element) nNode);
                        catalog.getPlants().add(plant);
                    }
                }
                LoadToDb(catalog);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Document getDocument(String filePath) throws ParserConfigurationException, SAXException, IOException {
        File fXmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc;
    }
}
