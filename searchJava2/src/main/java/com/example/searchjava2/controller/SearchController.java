package com.example.searchjava2.controller;

import com.example.searchjava2.model.SearchWord;
import com.example.searchjava2.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@Controller
public class SearchController {
    @RequestMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("msg", "[Java Count]");
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String send(@RequestParam("searchId") String nodeId,
                       @RequestParam("searchNode") String nodeName,
                       @RequestParam("attName") String attributeName,
                       @RequestParam("attValue") String attributeValue,
                       Model model) throws ParserConfigurationException, IOException, SAXException {

        SearchWord word = new SearchWord();
        word.setNId(nodeId);
        word.setNName(nodeName);
        word.setAtName(attributeName);
        word.setAtValue(attributeValue);

        SearchService searchService = new SearchService();
        String result = searchService.search(word);

        model.addAttribute("msg",result);
        return "index";
    }
}
