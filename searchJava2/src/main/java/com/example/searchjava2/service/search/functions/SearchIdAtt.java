package com.example.searchjava2.service.search.functions;

import com.example.searchjava2.model.SearchWord;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.traversal.NodeIterator;

import java.util.Objects;

public class SearchIdAtt {
    public String search(NodeIterator it, SearchWord word) {
        int count = 0;
        for (Node node = it.nextNode(); node != null; node = it.nextNode()) {
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) node;
                String id = e.getAttribute("id");
                String nodeName = e.getAttribute(word.getAtName());
                if (Objects.equals(word.getNId(), id) && Objects.equals(word.getAtValue(), nodeName)) {
                    count++;
                }
            }
        }
        System.out.println("Id & Attribute : " + count);

        return "" + count;
    }
}