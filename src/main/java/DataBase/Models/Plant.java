package DataBase.Models;

import org.w3c.dom.Element;

public class Plant {
    private int ID;
    private String COMMON;
    private String BOTANICAL;
    private int ZONE;
    private String LIGHT;
    private double PRICE;
    private int AVAILABILITY;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCOMMON() {
        return COMMON;
    }

    public void setCOMMON(String COMMON) {
        this.COMMON = COMMON;
    }

    public String getBOTANICAL() {
        return BOTANICAL;
    }

    public void setBOTANICAL(String BOTANICAL) {
        this.BOTANICAL = BOTANICAL;
    }

    public int getZONE() {
        return ZONE;
    }

    public void setZONE(int ZONE) {
        this.ZONE = ZONE;
    }

    public String getLIGHT() {
        return LIGHT;
    }

    public void setLIGHT(String LIGHT) {
        this.LIGHT = LIGHT;
    }

    public double getPRICE() {
        return PRICE;
    }

    public void setPRICE(double PRICE) {
        this.PRICE = PRICE;
    }

    public int getAVAILABILITY() {
        return AVAILABILITY;
    }

    public void setAVAILABILITY(int AVAILABILITY) {
        this.AVAILABILITY = AVAILABILITY;
    }

    public static Plant getPlant(Element node) {
        Plant plant = new Plant();
        plant.setLIGHT(
                node.getElementsByTagName("LIGHT").item(0).getTextContent()
        );
        plant.setBOTANICAL(
                node.getElementsByTagName("BOTANICAL").item(0).getTextContent()
        );
        plant.setCOMMON(
                node.getElementsByTagName("COMMON").item(0).getTextContent()
        );
        plant.setZONE(
                Integer.parseInt(node.getElementsByTagName("ZONE").item(0).getTextContent())
        );
        plant.setPRICE(
                Double.parseDouble(node.getElementsByTagName("PRICE").item(0).getTextContent()
                        .replace("$", ""))
        );
        plant.setAVAILABILITY(
                Integer.parseInt(node.getElementsByTagName("AVAILABILITY").item(0).getTextContent())
        );
        return plant;
    }
}
