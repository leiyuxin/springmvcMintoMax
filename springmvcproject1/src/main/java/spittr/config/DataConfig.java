package spittr.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class DataConfig {

	@Bean
	public String dataSource() {
		return "beanObject";
	}

	@Bean
	public Integer jdbcTemplate() {
		return 10;
	}

}
