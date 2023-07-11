package com.example.springintro1.service;

import com.example.springintro1.model.entity.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
       Author getRandomAuthor();


    void seedAuthors() throws IOException;

    List<String> getAllAuthorsOrderByCountOfBooks();
}
