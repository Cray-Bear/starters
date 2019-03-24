package com.fty1.component.task.facade;

import com.fty1.component.task.facade.vo.TaskWork;

public interface Fty1TaskFacade {


    TaskWork findByTaskCode(String taskCode);

}
