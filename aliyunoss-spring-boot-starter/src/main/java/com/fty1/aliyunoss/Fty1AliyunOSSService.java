package com.fty1.aliyunoss;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.PutObjectResult;

import java.io.InputStream;

public class Fty1AliyunOSSService {

    private OSS oss;

    public Fty1AliyunOSSService(OSS oss) {
        this.oss = oss;
    }

    public PutObjectResult putObject(String bucketName, String objectName, InputStream inputStream) {
       return oss.putObject(bucketName,objectName,inputStream);
    }

}
