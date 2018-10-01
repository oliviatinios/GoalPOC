package poc.eventstore.examples.todolist.queryside;

import io.eventuate.javaclient.driver.EventuateDriverConfiguration;
import poc.eventstore.examples.todolist.commonswagger.CommonSwaggerConfiguration;
import poc.eventstore.examples.todolist.queryside.web.TodoViewWebConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({TodoViewWebConfiguration.class,
        EventuateDriverConfiguration.class,
        CommonSwaggerConfiguration.class})
@EnableAutoConfiguration
public class TodoViewServiceMain {

  public static void main(String[] args) {
    SpringApplication.run(TodoViewServiceMain.class, args);
  }

}