package DataBase;

import DataBase.Models.Catalog;
import DataBase.Models.Plant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnection {
    private static Connection connection;
    private static final String DB_URL = "jdbc:postgresql://localhost:5433/DataBase";
    private static final String USER_NAME = "postgres";
    private static final String USER_PASSWORD = "SYSDBA";

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(DB_URL, USER_NAME, USER_PASSWORD);
        }
        return connection;
    }

    public static void LoadToDb(Catalog catalog) throws Exception {
        String sql = "insert into \"D_CAT_CATALOG\"(\"UUID\",\"COMPANY\",\"DELIVERY_DATE\")\n" +
                String.format("values('%s','%s','%s')",catalog.getUUID(),catalog.getCOMPANY(),catalog.getDELIVERY_DATE());

        getConnection().createStatement().executeUpdate(sql);
        sql = "select \"ID\" from \"D_CAT_CATALOG\" " +
                String.format( "where(\"UUID\" = '%s')",catalog.getUUID());
        ResultSet set = getConnection().createStatement().executeQuery(sql);
        int id = 0;
        if(set.next())
            id = set.getInt("ID");
        if(id > 0){
            for (Plant plant :catalog.getPlants()) {
                sql = "INSERT INTO public.\"F_CAT_PLANTS\"( \"COMMON\", \"BOTANICAL\", \"ZONE\", " +
                        "\"LIGHT\", \"PRICE\", \"AVAILABILITY\", \"CATALOG_ID\")"+
                String.format("VALUES ('%s','%s','%s','%s','%s','%s','%s')",plant.getCOMMON(),plant.getBOTANICAL(),
                        plant.getZONE(),plant.getLIGHT(),plant.getPRICE(),plant.getAVAILABILITY(),id);
                getConnection().createStatement().executeUpdate(sql);
            }
        }
    }
}
