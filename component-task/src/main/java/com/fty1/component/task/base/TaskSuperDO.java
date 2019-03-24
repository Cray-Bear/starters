package com.fty1.component.task.base;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class TaskSuperDO {

    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "Fty1TaskUUIDIdGenerator")
    @Column(name = "UUID", length = 64)
    private String uuid;

    @Column(name = "CHANNEL")
    private String channel;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    @Version
    @Column(name = "VERSION", length = 11)
    @ColumnDefault("0")
    private Long version;

    @Column(name = "RECORD", length = 2)
    @ColumnDefault("0")
    private Integer record;


}
