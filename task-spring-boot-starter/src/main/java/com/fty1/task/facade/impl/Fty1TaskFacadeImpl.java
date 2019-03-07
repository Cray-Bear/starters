package com.fty1.task.facade.impl;

import com.fty1.task.domain.Fty1TaskWorkDO;
import com.fty1.task.facade.Fty1TaskFacade;
import com.fty1.task.facade.vo.TaskWork;
import com.fty1.task.repository.Fty1TaskWorkRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class Fty1TaskFacadeImpl implements Fty1TaskFacade {


    @Autowired
    private Fty1TaskWorkRepository fty1TaskWorkRepository;

    @Override
    public TaskWork findByTaskCode(String taskCode) {
        log.info("taskCode:{}", taskCode);
        Iterable<Fty1TaskWorkDO> works = fty1TaskWorkRepository.findAll();
        if(works == null){
            return null;
        }

        Fty1TaskWorkDO fty1TaskWorkDO =  works.iterator().next();
        if(fty1TaskWorkDO == null){
            return null;
        }

        TaskWork taskWork = new TaskWork();
        taskWork.setTaskCode(fty1TaskWorkDO.getCode());
        return taskWork;
    }
}
