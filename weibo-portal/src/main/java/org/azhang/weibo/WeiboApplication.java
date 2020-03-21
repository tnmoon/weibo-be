package org.azhang.weibo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class WeiboApplication {
    public static void main(String[] args) {
        SpringApplication.run(WeiboApplication.class, args);
    }
}
