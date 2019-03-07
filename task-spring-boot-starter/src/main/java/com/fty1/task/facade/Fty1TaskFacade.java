package com.fty1.task.facade;

import com.fty1.task.facade.vo.TaskWork;

public interface Fty1TaskFacade {


    TaskWork findByTaskCode(String taskCode);

}
