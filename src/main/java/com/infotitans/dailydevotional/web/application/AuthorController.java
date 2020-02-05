package com.infotitans.dailydevotional.web.application;

import com.infotitans.dailydevotional.business.service.AuthorService;
import com.infotitans.dailydevotional.data.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @GetMapping
    public String getAuthors(Model model){
        model.addAttribute("authors", authorService.getAllAuthors());
        return "authors";
    }

    @GetMapping("/new")
    public ModelAndView getCreateAuthor(){
        ModelAndView modelAndView = new ModelAndView("create-author");
        var author = new Author();
        modelAndView.addObject("author", author);

        return modelAndView;
    }

    @PostMapping("/new")
    public ModelAndView postCreateAuthor(@ModelAttribute Author newAuthor){
        authorService.addNewAuthor(newAuthor);
        return new ModelAndView("redirect:/authors");
    }
}
