package poc.eventstore.examples.todolist.todoservice.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import poc.eventstore.examples.todolist.todoservice.backend.TodoBackendConfiguration;

@Configuration
@Import({TodoBackendConfiguration.class})
@ComponentScan({ "poc.eventstore.examples.todolist.common",
        "poc.eventstore.examples.todolist.todoservice.web",
        "poc.eventstore.examples.todolist.hateoas"})
public class TodoWebConfiguration extends WebMvcConfigurerAdapter {
}
