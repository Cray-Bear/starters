package com.fty1.task.repository;

import com.fty1.task.domain.Fty1TaskStepDO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

public interface Fty1TaskStepRepository extends CrudRepository<Fty1TaskStepDO, String> {

}
