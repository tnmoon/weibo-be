package org.azhang.weibo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan({"org.azhang.weibo.mapper", "org.azhang.weibo.dao"})
public class MyBatisConfig {
}
