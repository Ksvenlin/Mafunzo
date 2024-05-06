package com.Mafunzo.Mafunzo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import com.Mafunzo.Mafunzo.Controller.*;

import java.util.TimerTask;

/**
 * WebapplicationApplication is the main class of the application.
 *
 * @Author Kevin Nordkvist, Kasper Svenlin, William Starå, Adam Mheisen & Isak Hakola
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class WebapplicationApplication {
    private static MongoClientConnectionExample con = new MongoClientConnectionExample();
    private static TimeHandler timeHandler;

    public static void main(String[] args) {
        SpringApplication.run(WebapplicationApplication.class, args);
        con.connectMongo();
        timeHandler.dailyStreakCheck();
    }
}