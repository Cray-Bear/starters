package com.fty1.task.repository;

import com.fty1.task.domain.Fty1TaskHistoryDO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface Fty1TaskHistoryRepository extends CrudRepository<Fty1TaskHistoryDO, String> {

}
