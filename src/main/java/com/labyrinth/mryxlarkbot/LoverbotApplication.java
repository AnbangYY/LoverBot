package com.labyrinth.mryxlarkbot;

import com.labyrinth.mryxlarkbot.shedule.Reader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

//@EnableCaching // 启用缓存功能
@EnableScheduling // 开启定时任务功能
@SpringBootApplication
public class LoverbotApplication {


    public static void main(String[] args) {
        SpringApplication.run(LoverbotApplication.class, args);
    }

}
