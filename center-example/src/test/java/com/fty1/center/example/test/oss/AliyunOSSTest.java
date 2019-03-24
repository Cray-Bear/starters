package com.fty1.center.example.test.oss;

import com.fty1.aliyunoss.Fty1AliyunOSSService;
import com.fty1.center.example.DemoApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;

public class AliyunOSSTest extends DemoApplicationTests {


    @Autowired
    private Fty1AliyunOSSService fty1AliyunOSSService;


    @Test
    public void test(){
        fty1AliyunOSSService.putObject("fty1-job","ko.log",new ByteArrayInputStream("safdsafsda".getBytes()));
    }

}
