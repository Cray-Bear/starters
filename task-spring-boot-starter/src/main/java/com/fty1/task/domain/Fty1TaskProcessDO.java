package com.fty1.task.domain;

import com.fty1.task.base.TaskSuperDO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SYS_TASK_PROCESS")
@Setter
@Getter
public class Fty1TaskProcessDO extends TaskSuperDO {

    @Column(name = "CODE", length = 32)
    private String code;

    @Column(name = "NAME", length = 200)
    private String name;

    @Column(name = "`DESCRIBE`",length = 400)
    private String describe;

}
