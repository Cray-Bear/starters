package com.fty1.component.task.repository;

import com.fty1.component.task.domain.Fty1TaskHistoryDO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

public interface Fty1TaskHistoryRepository extends CrudRepository<Fty1TaskHistoryDO, String> {

}
