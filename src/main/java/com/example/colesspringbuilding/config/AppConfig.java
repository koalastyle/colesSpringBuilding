package com.example.colesspringbuilding.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author xuchang
 * @date 2021/11/29
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "app")
@EnableConfigurationProperties
public class AppConfig {
    /**
     * 高德地图开发平台secret key
     */
    private String secretKey;
}
