package com.fty1.task.repository;

import com.fty1.task.domain.Fty1TaskWorkDO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

public interface Fty1TaskWorkRepository extends CrudRepository<Fty1TaskWorkDO, String> {

}
