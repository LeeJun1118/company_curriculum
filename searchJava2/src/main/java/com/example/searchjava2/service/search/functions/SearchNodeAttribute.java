package com.example.searchjava2.service.search.functions;

import com.example.searchjava2.model.SearchWord;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.traversal.NodeIterator;

import java.util.Objects;

public class SearchNodeAttribute {
    /*public String search(NodeIterator it, SearchWord word) {
        int count = 0;
        for (Node node = it.nextNode(); node != null; node = it.nextNode()) {
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) node;
                //String id = e.getAttribute("id");
                String nodeName = e.getNodeName();
                String attName[] = e.getAttribute(word.getAtName()).split(" ");
                for (int i = 0; i < attName.length; i++) {
                    if (Objects.equals(word.getNName(), nodeName) && Objects.equals(word.getAtValue(), attName[i])) {
                        count++;
                    }
                }
            }
        }
        System.out.println("Node Name & Attribute : " + count);

        return "" + count;
    }*/

    public String search(NodeIterator it, SearchWord word, Node node, int count) {
        if (node == null){
            return ""+count;
        }
        else{
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) node;
                //String id = e.getAttribute("id");
                String nodeName = e.getNodeName();
                String attName[] = e.getAttribute(word.getAtName()).split(" ");
                for (int i = 0; i < attName.length; i++) {
                    if (Objects.equals(word.getNName(), nodeName) && Objects.equals(word.getAtValue(), attName[i])) {
                        count++;
                    }
                }
            }
            return search(it,word,it.nextNode(),count);
        }
    }
}
