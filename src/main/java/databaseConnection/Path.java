package databaseConnection;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class Path {
    static String url = null;
    static String User = null;
    static String password = null;
    String rootPath = "src/main/resources/";
    String appConfigPath = rootPath + "connect.properties";
    Properties p = new Properties();

    public String pathUser() throws IOException {
        p.load(new FileInputStream(appConfigPath));
        User = p.getProperty("connect.user");
        return User;
    }

    public String pathUrl() throws IOException {
        p.load(new FileInputStream(appConfigPath));
        url = p.getProperty("connect.url");
        return url;
    }

    public String pathPassworld() throws IOException {
        p.load(new FileInputStream(appConfigPath));
        password = p.getProperty("connect.password");
        return password;
    }
}
