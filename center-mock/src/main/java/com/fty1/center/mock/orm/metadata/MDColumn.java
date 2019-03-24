package com.fty1.center.mock.orm.metadata;

import lombok.Data;

@Data
public class MDColumn {

    /**
     * 字段名称
     */
    private String columnName;

    /**
     * 字段类型
     */
    private Class columnType;

    /**
     * 备注
     */
    private String comment;
}
