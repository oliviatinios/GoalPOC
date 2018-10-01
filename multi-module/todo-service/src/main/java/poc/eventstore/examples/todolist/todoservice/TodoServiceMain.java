package poc.eventstore.examples.todolist.todoservice;

import io.eventuate.javaclient.driver.EventuateDriverConfiguration;
import poc.eventstore.examples.todolist.commonswagger.CommonSwaggerConfiguration;
import poc.eventstore.examples.todolist.todoservice.web.TodoWebConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({TodoWebConfiguration.class,
        EventuateDriverConfiguration.class,
        CommonSwaggerConfiguration.class})
@EnableAutoConfiguration
public class TodoServiceMain {

  public static void main(String[] args) {
    SpringApplication.run(TodoServiceMain.class, args);
  }

}