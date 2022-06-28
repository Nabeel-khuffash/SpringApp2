package com.example.demo2;

import com.example.demo2.entity.Comment;
import com.example.demo2.entity.Link;
import com.example.demo2.repository.CommentRepository;
import com.example.demo2.repository.LinkRepository;
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
	CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository){
		return args -> {
			Link link=new Link("link1","www.link1.com");
			linkRepository.save(link);
			Comment comment=new Comment("this link(1) is awesome(1)",link);
			commentRepository.save(comment);
			link.addComment(comment);

			Comment comment3=new Comment("this link(1) is awesome(2)",link);
			commentRepository.save(comment3);
			link.addComment(comment3);


			Link link2=new Link("link2","www.link2.com");
			linkRepository.save(link2);
			Comment comment2=new Comment("this link(2) is awesome(1)",link);
			commentRepository.save(comment2);
			link2.addComment(comment2);

			System.out.println(link.toString2());
			System.out.println(link2.toString2());
			System.out.println(comment3.toString2());

/*
			System.out.println(linkRepository.findByTitle("link2").toString2());
*/
		};
	}

}
