package com.aylfq5.online.tutor.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: aylfq5
 * @CreateDate: 2019/3/13 10:37
 * @Version: 1.0
 */
@Configuration
public class DruidConfig {
    /**
     * 配置绑定
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource druid() {
        return new DruidDataSource();
    }
}
