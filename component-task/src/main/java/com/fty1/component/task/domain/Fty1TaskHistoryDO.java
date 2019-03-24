package com.fty1.component.task.domain;

import com.fty1.component.task.base.TaskSuperDO;
import com.fty1.component.task.constant.TaskStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SYS_TASK_HISTORY")
@Setter
@Getter
public class Fty1TaskHistoryDO extends TaskSuperDO {


    @Column(name = "TASK_CODE", length = 32)
    private String taskCode;

    @Column(name = "STEP_CODE", length = 32)
    private String stepCode;

    @Column(name = "PROCESS_CODE", length = 32)
    private String processCode;

    @Column(name = "BEGIN_TIME")
    private Date beginTime;

    @Column(name = "END_TIME")
    private Date endTime;

    @Column(name = "TASK_STATUS")
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

}
