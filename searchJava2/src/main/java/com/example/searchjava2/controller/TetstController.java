package com.example.searchjava2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TetstController {
    @RequestMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("msg", "input your id");
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String send(@RequestParam("searchId") String nodeId,
                       @RequestParam("searchNode") String nodeName,
                       @RequestParam("attName") String attributeName,
                       @RequestParam("attValue") String attributeValue,
                       Model model) {
        model.addAttribute("nodeId", nodeId);
        model.addAttribute("msg",
                "nodeId : " + nodeId + "   node name  : " + nodeName +
                        "   attributeName  : " + attributeName +
                        "   attributeValue  : " + attributeValue);

        System.out.println(nodeId);
        System.out.println(nodeName);
        System.out.println(attributeName);
        System.out.println(attributeValue);
        return "index";
    }

}
