package com.mycompany.authorapi.graphql.service;

import com.mycompany.authorapi.model.Author;

public interface AuthorService {

    Iterable<Author> getAuthors();

    Author validateAndGetAuthor(Long id);

    Author saveAuthor(Author author);

    void deleteAuthor(Author author);

}
