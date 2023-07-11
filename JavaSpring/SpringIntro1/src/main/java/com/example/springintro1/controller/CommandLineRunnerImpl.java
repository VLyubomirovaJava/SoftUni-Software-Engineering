package com.example.springintro1.controller;

import com.example.springintro1.model.entity.Book;
import com.example.springintro1.service.AuthorService;
import com.example.springintro1.service.BookService;
import com.example.springintro1.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final CategoryService categoryService;
    private final AuthorService authorService;
private  final BookService bookService;
    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
    seedData();
   // printAllBooksAfter2000(2000);
   // printAllAuthorsNamesWithBooksWithReleaseBefore1990(1990);
  //  printAllAuthorsAndNumberOfTheirBooks();
     //   printAllBooksByAuthorNameOrderByReleaseDate("George", "Powell");
    }

    private void printAllBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByRelease(firstName,lastName)
                .forEach(System.out::println);
    }


    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService.getAllAuthorsOrderByCountOfBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseBefore1990(int year) {
        bookService.findAllAuthorsWithBooksWithReleaseBefore1990(year)
                .forEach(System.out::println);

    }

    private void printAllBooksAfter2000(int year) {
        bookService.findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
