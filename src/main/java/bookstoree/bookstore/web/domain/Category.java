package bookstoree.bookstore.web.domain;

import jakarta.persistence.GenerationType;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity 
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonIgnore 
    private List<Book> books;
    public Category(){
    
    }

    public Category(String name){
        this.name=name;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Book> getbooks(){
        return books;
    }
    public void setBooks(List <Book> books){
        this.books=books;
    }
}
