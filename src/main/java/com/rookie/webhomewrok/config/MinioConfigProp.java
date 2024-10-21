package com.rookie.webhomewrok.config;

import io.minio.MinioClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "minio")
@Component
public class MinioConfigProp {
    private String endpoint="http://localhost:9000";
    private String accessKey="1145141918";
    private String secretKey="1145141918";
    private String imgHost;
    public static String MinioEndpoint = "http://localhost:9000";

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
                .build();
    }

}

