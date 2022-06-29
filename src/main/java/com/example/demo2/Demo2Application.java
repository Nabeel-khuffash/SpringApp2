package com.example.demo2;

import com.example.demo2.entity.Comment;
import com.example.demo2.entity.Link;
import com.example.demo2.repository.CommentRepository;
import com.example.demo2.repository.LinkRepository;
import org.ocpsoft.prettytime.PrettyTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Demo2Application {

	private static final Logger log = LoggerFactory.getLogger(SpringApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);
		System.out.println("Server is up");
	}

	@Bean
	PrettyTime prettyTime()
	{
		return new PrettyTime();
	}

}
