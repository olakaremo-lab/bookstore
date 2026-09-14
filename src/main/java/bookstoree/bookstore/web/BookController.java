        package bookstoree.bookstore.web;

        import java.util.ArrayList;
        import java.util.List;

        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RequestParam;

        import bookstoree.bookstore.web.domain.Book;
        import bookstoree.bookstore.web.domain.BookRepository;


        @Controller
        public class BookController {
            private BookRepository bookRepository;
            public BookController(BookRepository bookRepository) {
               this.bookRepository = bookRepository;
            }
            @RequestMapping("/index")
            public String showIndex() {
                List<Book> bookList = (ArrayList<Book>) bookRepository.findAll();
                return "index";
            }
            @RequestMapping ("/booklist")
            public String booklist(Model model) {
                model.addAttribute("books", bookRepository.findAll());
                return "booklist";
            }
            @RequestMapping ("/addbook")
            public String addBook(Model model){
                model.addAttribute("book", new Book());
                return "addbook";
            }
            @RequestMapping ("/savebook")
            public String saveBook(Book book){
                bookRepository.save(book);
                return "redirect:/booklist";
            }
            @RequestMapping ("/delete/{id}")
            public String deleteBook(@PathVariable("id")long bookId){
                bookRepository.deleteById(bookId);
                return "redirect:/booklist";
            }
        }
    



