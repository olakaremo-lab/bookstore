package bookstoree.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstoree.bookstore.web.domain.BookRepository;
import bookstoree.bookstore.web.domain.Book;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean 
	public CommandLineRunner alustaTietokanta(BookRepository bookRepository) {
		return (parametrit) -> {
			Book book1 = new Book();
            book1.setTitle("Book eka");
            book1.setAuthor("Author joku");
            book1.setPublicationYear(2026);
            book1.setIsbn("123456789");
            book1.setPrice(10.0);
            bookRepository.save(book1);
		};
		}
}
