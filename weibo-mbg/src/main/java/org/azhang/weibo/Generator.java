package org.azhang.weibo;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 启动 MyBatis Generator 共有四种方法：命令行、Ant、Maven、Java。http://mybatis.org/generator/running/running.html
 * 此处选择了使用 Java 代码启动
 */

public class Generator {
    public static void main(String[] args) throws Exception{

        // 接收MBG执行过程中的警告信息
        List<String> warnings = new ArrayList<>();

        InputStream is = Generator.class.getResourceAsStream("/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        is.close();

        DefaultShellCallback callback = new DefaultShellCallback(true); // 设置为true代表当生成的代码重复时覆盖原代码
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);

        for(String warning : warnings){
            System.out.println(warning);
        }
    }
}
