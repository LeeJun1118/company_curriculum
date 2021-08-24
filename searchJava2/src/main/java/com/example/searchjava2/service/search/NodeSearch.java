package com.example.searchjava2.service.search;

import com.example.searchjava2.model.SearchWord;
import com.example.searchjava2.service.search.functions.*;
import org.w3c.dom.Document;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.NodeIterator;

public class NodeSearch {
    public String search(Document document, SearchWord word) {
        DocumentTraversal travel = (DocumentTraversal) document;
        NodeIterator it = travel.createNodeIterator(document.getDocumentElement(), NodeFilter.SHOW_ELEMENT, null, true);

        //===================id 로 찾기===================
        if (word.getNId() != "" && word.getNName() == "" && word.getAtName() == "" && word.getAtValue() == "") {
            SearchId searchId = new SearchId();
            return searchId.search(it,word);
        }

        //===================노드명으로 찾기===================
        if (word.getNId() == "" && word.getNName() != "" && word.getAtName() == "" && word.getAtValue() == "") {
            SearchNodeName nodeName = new SearchNodeName();
            return nodeName.search(it,word);
        }

        //===================id + 노드명으로 찾기===================
        if (word.getNId() != "" && word.getNName() != "" && word.getAtName() == "" && word.getAtValue() == "") {
            SearchIdNodeName searchIdNodeName = new SearchIdNodeName();
            return searchIdNodeName.search(it,word);
        }

        //=================== 속성명 + 속성값으로 찾기 ===================
        if (word.getAtName() != "" && word.getAtValue() == "") {
            return "속성값을 입력해주세요";
        }
        else if (word.getAtName() == "" && word.getAtValue() != "") {
            return "속성명을 입력해주세요";
        }
        else if (word.getAtName() != "" && word.getAtValue() != "" && word.getNId() == "" && word.getNName() == "") {
            SearchAttribute attribute = new SearchAttribute();
            return attribute.search(it,word);
        }

        //========================id + 속성명 + 속성값 으로 찾기========================
        if (word.getNId() != "" && word.getNName() == "" && word.getAtName() != "" && word.getAtValue() != "") {
            SearchIdAtt searchIdAtt = new SearchIdAtt();
            return searchIdAtt.search(it,word);
        }

        //========================노드명 + 속성명 + 속성값 으로 찾기=====================
        if (word.getNId() == "" && word.getNName() != "" && word.getAtName() != "" && word.getAtValue() != "") {
            SearchNodeAttribute searchNodeAttribute = new SearchNodeAttribute();
            searchNodeAttribute.search(it,word);
            return "노드명 + 속성명 + 속성값";
        }

        //===================id + 노드명 + 속성명 + 속성값 으로 찾기===================
        if (word.getNId() != "" && word.getNName() != "" && word.getAtName() != "" && word.getAtValue() != "") {

            return "id + 노드명 + 속성명 + 속성값";
        }


        return "해당 없음 : 오류";
    }
}
