package com.cibc.dgp.goalservice;

import io.eventuate.javaclient.driver.EventuateDriverConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
/*@Import({TodoWebConfiguration.class,
        EventuateDriverConfiguration.class,
        CommonSwaggerConfiguration.class})*/
@EnableAutoConfiguration
public class GoalServiceApp {

  public static void main(String[] args) {
    SpringApplication.run(GoalServiceApp.class, args);
  }

}