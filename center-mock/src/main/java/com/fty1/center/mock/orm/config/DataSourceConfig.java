package com.fty1.center.mock.orm.config;

import lombok.Data;


@Data
public class DataSourceConfig {
    private String dbUrl;
    private String dbName;
    private String dbUser;
    private String dbPwd;
}
