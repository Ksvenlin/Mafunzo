package com.Mafunzo.Mafunzo;

import com.Mafunzo.Mafunzo.Model.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import com.Mafunzo.Mafunzo.Controller.*;

import java.util.TimerTask;

/**
 * WebapplicationApplication is the main class of the application.
 *
 * @author Kevin Nordkvist, Kasper Svenlin, William Starå, Adam Mheisen & Isak Hakola
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class WebapplicationApplication {
    private static MongoClientConnectionExample con = new MongoClientConnectionExample();
    @Autowired
    private static TimeHandler timeHandler = new TimeHandler();

    public static void main(String[] args) {
        SpringApplication.run(WebapplicationApplication.class, args);
        con.connectMongo();
    }
}