package com.search.javasearch.controller;

import com.search.javasearch.model.searchWord;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class searchController {

//    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    @RequestMapping(value = "/")
    public String index(Model model){
        model.addAttribute("msg","input your id");
        return "index";
    }
    @RequestMapping(value = "/", method = RequestMethod.POST)
//    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
//    @PostMapping(value = "/")
    public String send(@RequestParam("id1") String id, Model model){
        model.addAttribute("msg", "Hi,  " + id + "!!");
        model.addAttribute("id2",id);
        return "index";
    }

//    @RequestMapping(value="/java", method = RequestMethod.GET)
   /* @RequestMapping(value = "/java", method = RequestMethod.POST)
    public String send(@RequestParam("searchId") String nodeId,
                       *//*@RequestParam("searchNode") String nodeName,
                       @RequestParam("attName") String attributeName,
                       @RequestParam("attValue") String attributeValue,*//*
                       Model model){
        model.addAttribute("msg",
                "nodeId : " + nodeId + "!!!!!"
        );

       *//* searchWord word = new searchWord();
        word.setSearchId(nodeId);
        word.setSearchNode(nodeName);
        word.setAttName(attributeName);
        word.setAttValue(attributeValue);

        System.out.println(word.getSearchId());
        System.out.println(word.getSearchNode());
        System.out.println(word.getAttName());
        System.out.println(word.getAttValue());
*//*
        model.addAttribute("nodeId",nodeId);
        *//*model.addAttribute("nodeName",nodeName);
        model.addAttribute("attributeName",attributeName);
        model.addAttribute("attributeValue",attributeValue);*//*

        System.out.println(nodeId);
        return "index";
    }*/



}
