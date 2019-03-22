package com.fty1.center.mock.orm.metadata;

import com.fty1.center.mock.orm.metadata.enums.ColumnType;
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
    private ColumnType columnType;




}
