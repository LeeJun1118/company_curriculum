package com.example.searchjava2.service.search.functions;

import com.example.searchjava2.model.SearchWord;
import org.w3c.dom.Node;
import org.w3c.dom.traversal.NodeIterator;

import java.util.Objects;

public class SearchNodeName {
    public String search(NodeIterator it, SearchWord word) {
        int count = 0;
        for (Node node = it.nextNode(); node != null; node = it.nextNode()) {
            String nodeName = node.getNodeName();
            // div ul li 등등
            if (Objects.equals(nodeName, word.getNName())) {
                count++;
            }
        }
        System.out.println("SearchNodeName : "+count);
        return "" + count;
    }
}
