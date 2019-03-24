package com.fty1.center.mock.utils;

import com.fty1.center.mock.orm.config.DataSourceConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;

import java.io.File;

@Slf4j
public class ConfigUtils {

    public static void main(String[] args) {

        Configurations configs = new Configurations();
        try {
            PropertiesConfiguration config = configs.properties(new File("database.properties"));
            String dbHost = config.getString("database.host");
            int dbPort = config.getInt("database.port");
            String dbUser = config.getString("database.user");
            String dbPassword = config.getString("database.password", "secret");  // provide a default
            long dbTimeout = config.getLong("database.timeout");

            DataSourceConfig dataSourceConfig = new DataSourceConfig();
            dataSourceConfig.setDbUrl(dbHost);


            // access configuration properties
        } catch (org.apache.commons.configuration2.ex.ConfigurationException e) {
            e.printStackTrace();
        }
    }
}
