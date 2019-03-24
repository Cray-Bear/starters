package com.fty1.center.mock.orm.metadata;

import lombok.Data;

import java.util.List;

@Data
public class MDTable {

    private String tableName;

    private List<MDColumn> columns;


}
