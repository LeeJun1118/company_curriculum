package com.example.searchjava2.service.search.functions;

import com.example.searchjava2.model.SearchWord;
import org.w3c.dom.Attr;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.traversal.NodeIterator;

import java.util.Objects;

public class SearchAttribute {
    /*public String search(NodeIterator it, SearchWord word) {
        int count = 0;
        for (Node node = it.nextNode(); node != null; node = it.nextNode()) {
            NamedNodeMap allAtt = node.getAttributes();
            for (int i = 0; i < allAtt.getLength(); i++) {
                String nodes = ((Attr) allAtt.item(i)).getName();
                String att = ((Attr) allAtt.item(i)).getValue();
                String attlist[] = att.split(" ");

                for (int j = 0; j < attlist.length; j++) {
                    if (Objects.equals(nodes, word.getAtName()) && Objects.equals(attlist[j], word.getAtValue())) {
                        count++;
                    }
                }
            }
        }
        System.out.println("Attribute : "+count);

        return ""+count;
    }*/

    public String search(NodeIterator it, SearchWord word, Node node, int count) {
        if (node == null) {
            return "" + count;
        }
        else {
            NamedNodeMap allAtt = node.getAttributes();
            for (int i = 0; i < allAtt.getLength(); i++) {
                String nodes = ((Attr) allAtt.item(i)).getName();
                String att = ((Attr) allAtt.item(i)).getValue();
                String attlist[] = att.split(" ");

                for (int j = 0; j < attlist.length; j++) {
                    if (Objects.equals(nodes, word.getAtName()) && Objects.equals(attlist[j], word.getAtValue())) {
                        count++;
                    }
                }
            }
            return search(it, word, it.nextNode(), count);
        }
    }
}
