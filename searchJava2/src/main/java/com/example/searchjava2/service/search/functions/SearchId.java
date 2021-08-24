package com.example.searchjava2.service.search.functions;

import com.example.searchjava2.model.SearchWord;
import org.w3c.dom.Attr;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.traversal.NodeIterator;

import java.util.Objects;

public class SearchId {
    public String search(NodeIterator it, SearchWord word) {
        int count = 0;
        for (Node node = it.nextNode(); node != null; node = it.nextNode()) {
            NamedNodeMap allAtt = node.getAttributes();
            for (int i = 0; i < allAtt.getLength(); i++) {
                String att = ((Attr) allAtt.item(i)).getValue();
                if (Objects.equals(att, word.getNId())) {
                    count++;
                }
            }
        }
        System.out.println("SearchId : "+count);

        return ""+count;
    }
}