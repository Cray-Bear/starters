package com.fty1.example;

import com.fty1.example.config.Fty1ExampleProperties;
import lombok.Setter;

@Setter
public class Fty1ExampleService {


    private Fty1ExampleProperties properties;

    public Fty1ExampleProperties getProperties() {
        return properties;
    }

    public void setProperties(Fty1ExampleProperties properties) {
        this.properties = properties;
    }


    public String say() {
        return this.properties.getName();
    }

}
