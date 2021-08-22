package com.search.javasearch.controller;

import com.search.javasearch.model.Message;
import com.search.javasearch.model.searchWord;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class searchController {

    @GetMapping("/")
    ModelAndView search(searchWord search, ModelAndView modelAndView){

        modelAndView.addObject("data", new Message("총 : "+" 개", "/"));
        modelAndView.setViewName("index");

        return modelAndView;
    }
}
