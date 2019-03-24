package com.fty1.component.task.base;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.UUIDHexGenerator;

import java.io.Serializable;

public class Fty1TaskUUIDIdGenerator extends UUIDHexGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) {
        return "T"+super.generate(session, obj);
    }
}
