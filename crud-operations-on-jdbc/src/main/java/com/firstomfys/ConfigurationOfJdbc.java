package com.firstomfys;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class ConfigurationOfJdbc {

	@Bean
	public DriverManagerDataSource myDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@140.238.241.183:1521:xe");
		dataSource.setUsername("test_demo");
		dataSource.setPassword("test_demo");

		return dataSource;

	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbctemp = new JdbcTemplate();
		jdbctemp.setDataSource(myDataSource());
		return jdbctemp;
	}

}
