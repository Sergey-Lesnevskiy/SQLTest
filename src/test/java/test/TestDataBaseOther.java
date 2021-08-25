package test;

import databaseConnection.JDBCConnection;
import dateDB.DataDB;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class TestDataBaseOther {

    DataDB dataDB = new DataDB();

    @Test
    @DisplayName("Проверка создания таблицы в БД")
    public void testCreateTable() {
        String query = "CREATE TABLE City_Country ("
                + "CITY_ID int(6) NOT NULL,"
                + "CITY VARCHAR(45) NOT NULL)";
        JDBCConnection.createTable(query);
    }

    @Test
    @DisplayName("Заполняем таблицу из city")
    public void testInsertRequestTwo() {
        String query = "INSERT INTO City_Country (CITY_ID , CITY) SELECT city.country_id, city.city from city";
        JDBCConnection.insertIntoTable(query);
    }

    @Test
    @Order(3)
    @DisplayName("Обновление данных")
    public void testUpdate() throws SQLException, IOException {
        String query = "UPDATE City_Country SET CITY = '" + dataDB.cityMinsk() + "' WHERE CITY_ID='" + dataDB.idCity() + "'";
        JDBCConnection.updateInTable(query);
        String selectQuery = "SELECT CITY FROM City_Country WHERE CITY_ID = '" + dataDB.idCity() + "'";
        ResultSet rs = JDBCConnection.selectFromTable(selectQuery);
        String expectedTown = dataDB.cityMinsk();
        String actualTown = rs.getString("CITY");
        assertEquals(expectedTown, actualTown);
    }

    @Test
    @DisplayName("Отправка DELETE запроса")
    public void testDeleteRequest() throws IOException {
        String query = "DELETE FROM City_Country WHERE CITY='" + dataDB.townCity() + "'";
        JDBCConnection.deleteFromTable(query);
    }

    @Test
    @DisplayName("Проверка удаления таблицы из БД")
    public void testDelete() {
        JDBCConnection.dropTable("City_Country");
    }

    @Test
    @DisplayName("Проверка адреса SELECT")
    public void testGetAddress() throws SQLException {
        String query = "SELECT * FROM City_Country WHERE CITY_ID=3";
        ResultSet rs = JDBCConnection.selectFromTable(query);
        String expectAddress = dataDB.getAddressId4();
        String actualAddress = rs.getString("CITY");
        assertEquals(expectAddress, actualAddress);
    }

    @Test
    @DisplayName("SELECT INNER JOIN Проверка принадлежности города стране")
    public void testCheckAndCountry() throws SQLException {
        String query = "SELECT * from city inner join country on  city.country_id=country.country_id where city.city='Kabul'";
        ResultSet rs = JDBCConnection.selectFromTable(query);
        String expectedCountry = "Afghanistan";
        String actualCountry = rs.getString("country");
        assertEquals(expectedCountry, actualCountry);
    }
}