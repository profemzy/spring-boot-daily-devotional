package com.infotitans.dailydevotional.web.service;

import com.infotitans.dailydevotional.data.entity.Author;
import com.infotitans.dailydevotional.data.entity.Message;
import com.infotitans.dailydevotional.business.service.AuthorService;
import com.infotitans.dailydevotional.business.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DevotionServiceController {

    private AuthorService authorService;
    private MessageService messageService;

    @Autowired
    public DevotionServiceController(AuthorService authorService, MessageService messageService) {
        this.authorService = authorService;
        this.messageService = messageService;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(DevotionServiceController.class);

    // AUTHORS API

    @GetMapping("/authors")
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/authors/{id}")
    public Optional<Author> getAuthor(@PathVariable("id") Long id){
        LOGGER.info("Finding author by ID:"+id);
        return authorService.findAuthorById(id);
    }

    @PostMapping("/authors")
    public Author createAuthor(@RequestBody Author author){
        return authorService.addNewAuthor(author);
    }

    // MESSAGE API

    @GetMapping("/messages")
    public Iterable<Message> getAllMessages(){
        return messageService.getAllMessages();
    }

    @GetMapping("/messages/{id}")
    public Optional<Message> getMessage(@PathVariable("id") Long id){
        LOGGER.info("Finding message by ID:"+id);
        return messageService.findMessageById(id);
    }
}
