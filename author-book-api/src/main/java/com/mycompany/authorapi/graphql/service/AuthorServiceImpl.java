package com.mycompany.authorapi.graphql.service;

import com.mycompany.authorapi.graphql.exception.AuthorNotFoundException;
import com.mycompany.authorapi.model.Author;
import com.mycompany.authorapi.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service("GrapgQLAuthorServiceImpl")
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author validateAndGetAuthor(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException("Author not found", id));
    }

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Author author) {
        authorRepository.delete(author);
    }
}
