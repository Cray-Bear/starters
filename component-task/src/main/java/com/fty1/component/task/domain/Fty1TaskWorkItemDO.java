package com.fty1.component.task.domain;

import com.fty1.component.task.base.TaskSuperDO;
import com.fty1.component.task.constant.TaskStatus;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SYS_TASK_WORK_ITEM")
@Setter
@Getter
public class Fty1TaskWorkItemDO extends TaskSuperDO {

    @Column(name = "TASK_CODE", length = 32)
    private String taskCode;

    @Column(name = "CODE", length = 32)
    private String code;

    @Column(name = "TASK_ITEM_STATUS")
    @ColumnDefault("INITIAL")
    private TaskStatus taskItemStatus;
}
