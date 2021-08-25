package test;

import databaseConnection.JDBCConnection;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

import java.io.IOException;
import java.sql.SQLException;

public class TestSetups {

    @BeforeEach
    public void setUp(TestInfo testInfo) {
        try {
            Assertions.assertNotNull(JDBCConnection.connectToDB());
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        try {
            JDBCConnection.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
