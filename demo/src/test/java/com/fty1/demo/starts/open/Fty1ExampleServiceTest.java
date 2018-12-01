package com.fty1.demo.starts.open;

import com.fty1.demo.DemoApplicationTests;
import com.fty1.example.Fty1ExampleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class Fty1ExampleServiceTest extends DemoApplicationTests {

    @Autowired
    private Fty1ExampleService fty1ExampleService;

    @Test
    public void test() {
        System.out.println(fty1ExampleService.say());
    }

}
