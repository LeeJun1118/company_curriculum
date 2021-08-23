package com.search.javasearch.controller;

import com.search.javasearch.model.Message;
import com.search.javasearch.model.searchWord;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class searchController {

//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    @RequestMapping(value="/", method = RequestMethod.GET)
//    @RequestMapping(name="/", method = RequestMethod.GET)
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("msg","input your id");
        return "index";
    }

//    @RequestMapping(value="/", method = RequestMethod.GET)
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String send(@RequestParam("searchId") String nodeId,
                       @RequestParam("searchNode") String nodeName,
                       @RequestParam("attName") String attributeName,
                       @RequestParam("attValue") String attributeValue,
                       Model model){
        model.addAttribute("msg",
                "nodeId : " + nodeId + "!!!!!"
        );

        model.addAttribute("nodeId",nodeId);
        model.addAttribute("nodeName",nodeName);
        model.addAttribute("attributeName",attributeName);
        model.addAttribute("attributeValue",attributeValue);

        System.out.println(nodeId);
        return "index";
    }
}
