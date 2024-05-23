package org.kirill.controller;

import jakarta.validation.Valid;
import org.kirill.entity.Book;
import org.kirill.entity.Person;
import org.kirill.service.BookService;
import org.kirill.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BooksController {

    private final BookService bookService;
    private final PersonService personService;

    @Autowired
    public BooksController(BookService bookService, PersonService personService) {
        this.bookService = bookService;
        this.personService = personService;
    }


    @GetMapping()
    public String getBooks(Model model) {
        List<Book> books = bookService.getAll();
        model.addAttribute("books", books);
        return "books/getAllBooks";
    }

    @GetMapping("/{id}")
    public String getBookById(Model model,
                              @PathVariable("id") int id) {
        Book byId = bookService.getById(id);
        List<Person> people = personService.getAll();
        model.addAttribute("people", people);
        model.addAttribute("book", byId);

        return "books/showById";
    }

    @GetMapping("/new")
    public String addNewBook(Model model) {
        model.addAttribute("book", new Book());
        return "books/newBook";
    }

    @PostMapping()
    public String addBook(@ModelAttribute("book") @Valid Book book,
                          BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "books/newBook";
        }
        bookService.save(book);
        return "redirect:/books";
    }

    @PatchMapping("/{id}/release")
    public String releaseBook(@PathVariable ("id") int id){
        Book book = bookService.getById(id);
        book.setPerson(null);
        bookService.release(book);
        return "redirect:/books";
    }

    @PatchMapping("/{id}/assign")
    public String assignBook(@PathVariable ("id") int id,
                             @RequestParam("personId") int personId){
        Person person = personService.getById(personId);
        Book book = bookService.getById(id);
        book.setPerson(person);
        bookService.release(book);
        return "redirect:/books";
    }


    @GetMapping("{id}/edit")
    public String editBook(Model model, @PathVariable ("id") int id){
        model.addAttribute("book", bookService.getById(id));
        return "books/editBook";
    }



    @PatchMapping("/{id}")
    public String editBook(@ModelAttribute("book") @Valid Book book,
                             BindingResult bindingResult,
                             @PathVariable("id") int id) {
        if(bindingResult.hasErrors()) {
            return "books/editBook";
        }
        bookService.update(book);
        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable ("id") int id) {
        bookService.delete(id);
        return "redirect:/books";
    }
}
