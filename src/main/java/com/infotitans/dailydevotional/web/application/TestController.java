package com.infotitans.dailydevotional.web.application;

import com.infotitans.dailydevotional.data.entity.Author;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @RequestMapping("/hello")
    public String hello(){
        return "test";
    }

//    @RequestMapping("/send-data")
//    public ModelAndView sendData(){
//        ModelAndView mav = new ModelAndView("test");
//        mav.addObject("word", "Stop Learning Start dying!!");
//        return mav;
//    }

    @RequestMapping("/test-message")
    public ModelAndView getAuthor(){
        ModelAndView modelAndView = new ModelAndView("test");
        Author author = new Author();
        author.setName("Rev Ron");
        modelAndView.addObject("author", author);
        return modelAndView;
    }
}
