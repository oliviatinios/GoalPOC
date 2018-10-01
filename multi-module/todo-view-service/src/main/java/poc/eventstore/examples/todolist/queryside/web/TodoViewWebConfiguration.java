package poc.eventstore.examples.todolist.queryside.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import poc.eventstore.examples.todolist.queryside.backend.TodoViewBackendConfiguration;

@Configuration
@Import({TodoViewBackendConfiguration.class})
@ComponentScan({"poc.eventstore.examples.todolist.common",
        "poc.eventstore.examples.todolist.hateoas",
        "poc.eventstore.examples.todolist.queryside.web"})
public class TodoViewWebConfiguration extends WebMvcConfigurerAdapter {
}
