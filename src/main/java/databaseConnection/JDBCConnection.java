package databaseConnection;

import java.io.IOException;
import java.sql.*;


public class JDBCConnection {
    static Path path = new Path();
    private static Connection con = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    public static Connection connectToDB() throws SQLException, IOException {

        con = DriverManager.getConnection(path.pathUrl(), path.pathUser(), path.pathPassworld());
        return con;
    }

    public static void closeConnection() throws SQLException {
        if (con != null) {
            con.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (rs != null) {
            rs.close();
        }
    }

    public static void createTable(String query) {
        try {
            stmt = connectToDB().prepareStatement(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public static void dropTable(String tableName) {
//        String query = "DROP TABLE" + tableName;
//        try {
//            stmt = connectToDB().prepareStatement(query);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        try {
//            stmt.executeUpdate(query);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public static void dropTable(String tableName) {
        String query = "DROP TABLE " + tableName;
        try {
            stmt = connectToDB().prepareStatement(query);

            stmt.executeUpdate(query);

        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    public static ResultSet selectFromTable(String query) {
        try {
            stmt = connectToDB().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // addSQLRequestResultsTolog(query);
        return rs;
    }

    public static void insertIntoTable(String query) {
        try {
            stmt = connectToDB().createStatement();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        try {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //    public static void addSQLRequestResultsTolog(String query){
//        StringBuilder builder = new StringBuilder();
//        DSL.using(connectToDB()).fetchStream(query)
//                .foreach(r ->builder.append(r.format()));
//    }
    public static void updateInTable(String query) {
        try {
            stmt = connectToDB().createStatement();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        try {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFromTable(String query) {
        try {
            stmt = connectToDB().createStatement();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        try {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
