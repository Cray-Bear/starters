package com.fty1.task.domain;

import com.fty1.task.base.TaskSuperDO;
import com.fty1.task.constant.TaskStatus;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "SYS_TASK_WORK")
@Setter
@Getter
public class Fty1TaskWorkDO extends TaskSuperDO {

    @Column(name = "CODE", length = 32)
    private String code;

    @Column(name = "STEP_CODE", length = 32)
    private String stepCode;

    @Column(name = "PROCESS_CODE", length = 32)
    private String processCode;

    @Column(name = "TASK_STATUS")
    @ColumnDefault("INITIAL")
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;
}
