package com.fty1.component.task.domain;

import com.fty1.component.task.base.TaskSuperDO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "SYS_TASK_STEP")
@Getter
@Setter
public class Fty1TaskStepDO extends TaskSuperDO {


    @Column(name = "CODE", length = 32)
    private String code;

    @Column(name = "NAME", length = 200)
    private String name;

    @Column(name = "`DESCRIBE`", length = 400)
    private String describe;

}
