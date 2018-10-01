package poc.eventstore.examples.todolist.e2etests;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import poc.eventstore.examples.todolist.testutil.BasicWebTestConfiguration;

/**
 * Created by popikyardo on 18.03.16.
 */
@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class E2ETestConfiguration extends BasicWebTestConfiguration {
}
