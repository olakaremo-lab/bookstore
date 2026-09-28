package bookstoree.bookstore;

import bookstoree.bookstore.web.domain.Category;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstoree.bookstore.web.domain.BookRepository;
import bookstoree.bookstore.web.domain.CategoryRepository;
import bookstoree.bookstore.web.domain.Book;


@SpringBootApplication
public class BookstoreApplication {

	private final CategoryRepository categoryRepository;

    BookstoreApplication(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean 
	public CommandLineRunner alustaTietokanta(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (parametrit) -> {
			Category science = new Category("Science");
			Category romance=new Category("Romancee");
			Book book1 = new Book();
            book1.setTitle("Book eka");
            book1.setAuthor("Author joku");
            book1.setPublicationYear(2026);
            book1.setIsbn("123456789");
			book1.setCategory(romance);
            book1.setPrice(10.0);
			categoryRepository.save(romance);
			categoryRepository.save(science);
            bookRepository.save(book1);
			System.out.println(book1);	
		};

	}
	
	
}
