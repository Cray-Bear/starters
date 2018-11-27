package com.fty1.aliyunoss.oss;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.fty1.aliyunoss.Fty1AliyunOSSProperties;

public class OSSClientFactory {

    private Fty1AliyunOSSProperties fty1AliyunOSSProperties;


    public OSSClientFactory(Fty1AliyunOSSProperties fty1AliyunOSSProperties) {
        this.fty1AliyunOSSProperties = fty1AliyunOSSProperties;
    }


    public OSS getOSSClient() {
        OSSClientBuilder ossClientBuilder = new OSSClientBuilder();
        return ossClientBuilder.build(fty1AliyunOSSProperties.getEndpoint(), fty1AliyunOSSProperties.getAccessKeyId(), fty1AliyunOSSProperties.getAccessKeySecret());
    }


}
