package mia.lahtinen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mia.lahtinen.domain.BookRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import mia.lahtinen.domain.Book;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository){
		return (args) -> {
			log.info("save a couple of books");
			repository.save(new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "123123123-312" , 20));
			repository.save(new Book("Animal Farm", "George Orwell", 1945, "1585357-545" , 15));
		
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
			
		};
	}
}
