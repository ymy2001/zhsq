package com.zhsq.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss.file")
public class Alioss {
    private String endpoint;
    private String KeyId;
    private String KeySecret;
    private String bucketName;

}
