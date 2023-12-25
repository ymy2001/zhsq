package com.zhsq.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss.file")
public class Alioss {
    private String endPoint;
    private String keyId;
    private String keySecret;
    private String bucketName;

}
