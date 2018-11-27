package main.java.configurations;

import com.github.mongobee.Mongobee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoBeeConfiguration {

    @Value("${spring.data.mongodb.host}")
    private String mongoDbURl;
    @Value("${spring.data.mongodb.port}")
    private String mongoDbPort;
    @Value("${spring.data.mongodb.database}")
    private String mongoDbName;

    @Bean
    public Mongobee mongobee(){
        Mongobee runner = new Mongobee(String.format("mongodb://%s:%s/", mongoDbURl, mongoDbPort));
        runner.setDbName(mongoDbName);
        runner.setChangeLogsScanPackage(
                "main.java.repositories.migrations");
        return runner;
    }

}
