package dateDB;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class DataDB {

    //первый способ
    private String addressId3 = "23 Workhaven Lane";

    public String getAddressId3() {
        return addressId3;
    }

    private String addressId4 = "Tafuna";

    public String getAddressId4() {
        return addressId4;
    }

    //второй способ
    String idLeo;
    String nameLeo;
    String lastNameLeo;
    String townLeo;
    String townCity;
    String cityMinsk;
    String idCity;
    String idLeonardo;
    String nameLeonardo;
    String lastNameLeonardo;
    String townLeonardo;
    String rootPath = "src/main/resources/";
    String appConfigPath = rootPath + "dataBD.properties";
    Properties p = new Properties();

    public String idLeonardo() throws IOException {
        p.load(new FileInputStream(appConfigPath));
        idLeonardo = p.getProperty("dataBD.idLeonardo");
        return idLeonardo;

    }

    public String nameLeonardo() throws IOException {
        p.load(new FileInputStream(appConfigPath));
        nameLeonardo = p.getProperty("dataBD.nameLeonardo");
        return nameLeonardo;
    }

    public String lastNameLeonardo() throws IOException {
        p.load(new FileInputStream(appConfigPath));
        lastNameLeonardo = p.getProperty("dataBD.lastNameLeonardo");
        return lastNameLeonardo;
    }

    public String townLeonardo() throws IOException {
        p.load(new FileInputStream(appConfigPath));
        townLeonardo = p.getProperty("dataBD.townLeonardo");
        return townLeonardo;
    }

    public String idLeo() throws IOException {
        p.load(new FileInputStream(appConfigPath));
        idLeo = p.getProperty("dataBD.idLeo");
        return idLeo;
    }

    public String nameLeo() throws IOException {
        p.load(new FileInputStream(appConfigPath));
        nameLeo = p.getProperty("dataBD.nameLeo");
        return nameLeo;
    }

    public String lastNameLeo() throws IOException {
        p.load(new FileInputStream(appConfigPath));
        lastNameLeo = p.getProperty("dataBD.lastNameLeo");
        return lastNameLeo;
    }

    public String townLeo() throws IOException {
        p.load(new FileInputStream(appConfigPath));
        townLeo = p.getProperty("dataBD.townLeo");
        return townLeo;
    }

    public String townCity() throws IOException {
        p.load(new FileInputStream(appConfigPath));
        townCity = p.getProperty("dataBD.townCity");
        return townCity;
    }

    public String cityMinsk() throws IOException {
        p.load(new FileInputStream(appConfigPath));
        cityMinsk = p.getProperty("dataBD.cityMinsk");
        return cityMinsk;

    }

    public String idCity() throws IOException {
        p.load(new FileInputStream(appConfigPath));
        idCity = p.getProperty("dataBD.idCity");
        return idCity;

    }

}