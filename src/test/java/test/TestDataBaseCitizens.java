//package test;
//
//import databaseConnection.JDBCConnection;
//import dateDB.DataDB;
//import org.junit.Test;
//import org.junit.jupiter.api.*;
//
//import java.io.IOException;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertAll;
//import static org.junit.jupiter.api.TestInstance.*;
//
//@TestInstance(Lifecycle.PER_CLASS)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@DisplayName("Проверка подключени к БД sakila и отправка запросов")
//public class TestDataBaseCitizens extends TestSetups {
//    DataDB dataDB = new DataDB();
//
//    @Test
//    @Order(1)
//    @DisplayName("Проверка создания таблицы в БД")
//    public void testCreateTable() {
//        String query = "CREATE TABLE citizens ("
//                + "ID int(6) NOT NULL,"
//                + "FIRST_NAME VARCHAR(45) NOT NULL,"
//                + "LAST_NAME VARCHAR(45) NOT NULL,"
//                + "TOWN VARCHAR(45),"
//                + "PRIMARY KEY (id))";
//        JDBCConnection.createTable(query);
//    }
//
//    @Test
//    @Order(2)
//    @DisplayName("Отправка INSERT запроса")
//    public void testInsertRequest() throws IOException {
//        String query = "INSERT INTO citizens (ID, FIRST_NAME, LAST_NAME, TOWN) VALUES (" + dataDB.idLeonardo() + ",'" + dataDB.nameLeonardo() + "','" + dataDB.lastNameLeonardo() + "','" + dataDB.townLeonardo() + "')";
//        JDBCConnection.insertIntoTable(query);
//        String selectQuery = "SELECT * FROM citizens WHERE ID='" + dataDB.idLeonardo() + "'";
//        ResultSet rs = JDBCConnection.selectFromTable(selectQuery);
//        assertAll("Should return inserted data",
//                () -> assertEquals(dataDB.idLeonardo(), rs.getString("ID")),
//                () -> assertEquals(dataDB.nameLeonardo(), rs.getString("FIRST_NAME")),
//                () -> assertEquals(dataDB.lastNameLeonardo(), rs.getString("LAST_NAME")),
//                () -> assertEquals(dataDB.townLeonardo(), rs.getString("TOWN")));
//    }
//
//
//    @Test
//    @Order(2)
//    @DisplayName("Отправка INSERT запроса")
//    public void testInsertRequestTwo() throws IOException {
//        String query = "INSERT INTO citizens (ID, FIRST_NAME, LAST_NAME, TOWN) VALUES (" + dataDB.idLeo() + ",'" + dataDB.nameLeo() + "','" + dataDB.lastNameLeo() + "','" + dataDB.townLeo() + "')";
//        JDBCConnection.insertIntoTable(query);
//        String selectQuery = "SELECT * FROM citizens";
//        ResultSet rs = JDBCConnection.selectFromTable(selectQuery);
//        assertAll("Should return inserted data",
//                () -> assertEquals(dataDB.idLeo(), rs.getString("ID")),
//                () -> assertEquals(dataDB.nameLeo(), rs.getString("FIRST_NAME")),
//                () -> assertEquals(dataDB.lastNameLeo(), rs.getString("LAST_NAME")),
//                () -> assertEquals(dataDB.townLeo(), rs.getString("TOWN")));
//    }
//
//    @Test
//    @Order(3)
//    @DisplayName("Обновление данных")
//    public void testUpdate() throws SQLException, IOException {
//        String query = "UPDATE citizens SET TOWN = 'LONDON' WHERE ID='" + dataDB.idLeonardo() + "'";
//        JDBCConnection.updateInTable(query);
//        String selectQuery = "SELECT TOWN FROM citizens WHERE ID= '" + dataDB.idLeonardo() + "'";
//        ResultSet rs = JDBCConnection.selectFromTable(selectQuery);
//        String expectedTown = "LONDON";
//        String actualTown = rs.getString("TOWN");
//        assertEquals(expectedTown, actualTown);
//    }
//
//    @Test
//    @Order(6)
//    @DisplayName("Проверка адреса SELECT")
//    public void testGetAddress() throws SQLException {
//        String query = "SELECT * FROM address WHERE address_id=3";
//        ResultSet rs = JDBCConnection.selectFromTable(query);
//        String expectAddress = dataDB.getAddressId3();
//        String actualAddress = rs.getString("address");
//        assertEquals(expectAddress, actualAddress);
//    }
//
//    @Test
//    @Order(4)
//    @DisplayName("Отправка DELETE запроса")
//    public void testDeleteRequest() throws IOException {
//        String query = "DELETE FROM citizens WHERE ID='" + dataDB.idLeo() + "'";
//        JDBCConnection.deleteFromTable(query);
//    }
//
//    @Test
//    @Order(7)
//    @DisplayName("Проверка удаления таблицы из БД")
//    public void testDelete() {
//        JDBCConnection.dropTable("citizens");
//    }
//
//
//    //
////    @Test
////    @Order(7)
////    @DisplayName("Отправка SELECT JOIN запроса. Проверка принадлежности города стране")
////    public void testSelectWithJoinRequest_CheckCityAndCountry() throws SQLException {
////        String query = "SELECT ct.city, cntr.country FROM city ct LEFT JOIN country cntr ON ct.country_id=cntr.country_id WHERE city='Bratislava'";
////        ResultSet rs = JDBCConnection.selectFromTable(query);
////        String expectedCountry = "Slovakia";
////        String actualCountry = rs.getString("country");
////        assertEquals(expectedCountry, actualCountry, "Actual country is '" + actualCountry + "'. Expected - '" + expectedCountry + "'.");
////    }
//    // create table
//    //insert into table 1
//    //select * from table2 join table3 where условия
//    // joid table4 where условия
//    //
//    @Test
//    @Order(8)
//    @DisplayName("Отправка SELECT JOIN запроса. Проверка языка последнего в списке фильма")
//    public void testSelectWithJoinRequest_CheckFilmLanguage() throws SQLException {
//        String query = "SELECT f.title, l.name FROM film f LEFT JOIN language l ON f.language_id=l.language_id";
//        ResultSet rs = JDBCConnection.selectFromTable(query);
//        rs.last();
//        String expectedLanguage = "English";
//        String actualLanguage = rs.getString("name");
//        assertEquals(expectedLanguage, actualLanguage, "Actual language is '" + actualLanguage + "'. Expected - '" + expectedLanguage + "'.");
//    }
//
//}
