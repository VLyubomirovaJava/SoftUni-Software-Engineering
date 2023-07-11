package com.example.springintro1.service;

import com.example.springintro1.model.entity.Book;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;
    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseBefore1990(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByRelease(String firstName, String lastName);
}
