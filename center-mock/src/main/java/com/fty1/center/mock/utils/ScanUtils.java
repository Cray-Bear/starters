package com.fty1.center.mock.utils;

import com.fty1.center.mock.orm.metadata.MDTable;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ClassUtils;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class ScanUtils {


    public static void main(String[] args) throws Exception {

        String[] classNames = {
                "com.fty1.center.mock.CenterMockApplication",
                "com.fty1.center.mock.utils.ScanUtils",
                "com.fty1.center.mock.ip.IPSchedule",
                "com.fty1.center.mock.demo.DUser"
        };

        List<MDTable> mdTables = new LinkedList<>();
        for (String className : classNames) {
            Class<?> claz = ClassUtils.getClass(className);
            Entity entityAnnotation = claz.getAnnotation(Entity.class);
            if (entityAnnotation == null) {
                continue;
            }

            log.info("className:" + className);
            Table tableAnnotation = claz.getAnnotation(Table.class);
            String tableName = tableAnnotation.name();
            log.info("tableName:" + tableName);

            MDTable mdTable = new MDTable();
        }
    }


}
