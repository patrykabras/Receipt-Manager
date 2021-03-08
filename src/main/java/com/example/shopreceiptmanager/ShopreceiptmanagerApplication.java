package com.example.shopreceiptmanager;

import com.example.shopreceiptmanager.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import java.util.List;

@SpringBootApplication
public class ShopreceiptmanagerApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final Logger logger = LoggerFactory.getLogger(ShopreceiptmanagerApplication.class);

	public static void main(String[] args) {
		logger.debug("App Start");
		SpringApplication.run(ShopreceiptmanagerApplication.class, args);

	}

	@Override
	public void run(String... args) {
		String sql = "SELECT * FROM USERS";

		List<User> userstableList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class));

		userstableList.forEach(System.out :: println);
	}
}
