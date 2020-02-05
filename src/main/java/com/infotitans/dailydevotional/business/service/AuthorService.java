package com.infotitans.dailydevotional.business.service;

import com.infotitans.dailydevotional.data.entity.Author;
import com.infotitans.dailydevotional.data.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        List<Author> authors = new ArrayList<>();
        this.authorRepository.findAll().forEach(authors::add);
        return authors;
    }

    public Author addNewAuthor(Author author){
        return authorRepository.save(author);
    }

    public Optional<Author> findAuthorById(Long authorId){
        return authorRepository.findById(authorId);
    }

    public Author updateAuthor(Author author){
        return authorRepository.save(author);
    }

    public void deleteAuthorById(Long authorId){
        authorRepository.deleteById(authorId);
    }
}
