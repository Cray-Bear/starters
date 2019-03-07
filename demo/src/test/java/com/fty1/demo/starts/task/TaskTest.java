package com.fty1.demo.starts.task;

import com.fty1.demo.DemoApplicationTests;
import com.fty1.task.facade.Fty1TaskFacade;
import com.fty1.task.facade.vo.TaskWork;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class TaskTest extends DemoApplicationTests {

    @Autowired
    private Fty1TaskFacade fty1TaskFacade;

    @Test
    public void test() {
        String taskCode = "K123456";
        TaskWork taskWork = fty1TaskFacade.findByTaskCode(taskCode);
        log.info(taskWork.toString());
    }


}
