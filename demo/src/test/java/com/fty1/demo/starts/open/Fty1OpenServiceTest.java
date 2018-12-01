package com.fty1.demo.starts.open;

import com.fty1.demo.DemoApplicationTests;
import com.fty1.open.Fty1OpenService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class Fty1OpenServiceTest extends DemoApplicationTests {

    @Autowired
    private Fty1OpenService fty1OpenService;

    @Test
    public void test() {
        System.out.println(fty1OpenService.getHtml());
    }

}
