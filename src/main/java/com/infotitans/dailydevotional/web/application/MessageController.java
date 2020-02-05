package com.infotitans.dailydevotional.web.application;

import com.infotitans.dailydevotional.business.service.AuthorService;
import com.infotitans.dailydevotional.business.service.MessageService;
import com.infotitans.dailydevotional.data.entity.Author;
import com.infotitans.dailydevotional.data.entity.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/messages")
public class MessageController {

    private MessageService messageService;
    private AuthorService authorService;

    public MessageController(MessageService messageService, AuthorService authorService) {
        this.messageService = messageService;
        this.authorService = authorService;
    }

    @GetMapping
    public String getMessages(Model model){
        model.addAttribute("sermons", messageService.getAllMessages());
        return "messages";
    }

    @GetMapping("/new")
    public ModelAndView getCreateMessage(){
        ModelAndView modelAndView = new ModelAndView("create-message");
        var message = new Message();
        modelAndView.addObject("sermon", message);

        List<Author>authorsList = authorService.getAllAuthors();
        modelAndView.addObject("authorsList", authorsList);

        return modelAndView;
    }

    @PostMapping("/new")
    public ModelAndView postCreateMessage(@ModelAttribute Message newMessage) throws ParseException {
        messageService.addNewMessage(newMessage);
        return new ModelAndView("redirect:/messages");
    }


}
