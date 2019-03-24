package com.fty1.center.mock.orm.metadata.enums;

public enum ColumnType {
    VARCHAR(255),
    BIGINT(20),
    INT(11),
    SMALLINT(4);

    private int code;

    ColumnType(int code) {
        this.code = code;
    }
}
