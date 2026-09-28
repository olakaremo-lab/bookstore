package bookstoree.bookstore.web;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bookstoree.bookstore.web.domain.Book;
import bookstoree.bookstore.web.domain.BookRepository;
import bookstoree.bookstore.web.domain.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class BookController {
    private BookRepository bookRepository;
    private CategoryRepository categoryRepository;
    public BookController(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository= categoryRepository;
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
        model.addAttribute("categories", categoryRepository.findAll());
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
    @ResponseBody
    @GetMapping("/books")
    public Iterable<Book> allbooks() {
        return bookRepository.findAll();
    }
    @ResponseBody
    @GetMapping("/books/{id}")
    public Optional<Book> findbook(@PathVariable("id") long id){
        return bookRepository.findById(id);
    }
}
    



