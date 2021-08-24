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
        /*
        model.addAttribute("msg",
                "nodeId : " + nodeId + "   node name  : " + nodeName +
                        "   attributeName  : " + attributeName +
                        "   attributeValue  : " + attributeValue);
*/
       /* System.out.println(nodeId);
        System.out.println(nodeName);
        System.out.println(attributeName);
        System.out.println(attributeValue);*/

        SearchWord word = new SearchWord();
        word.setNId(nodeId);
        word.setNName(nodeName);
        word.setAtName(attributeName);
        word.setAtValue(attributeValue);

        SearchService searchService = new SearchService();
        String result = searchService.search(word);

        System.out.println("id" + word.getNId());
        System.out.println("node name : " + word.getNName());
        System.out.println("Att Name : " + word.getAtName());
        System.out.println("Att Value : " + word.getAtValue());
/*

        *//*if (word.getNId()=="")
            System.out.println("data type");*//*

        System.out.println("Controller Result : "+result);*/
        model.addAttribute("msg",result);
        return "index";
    }
}
