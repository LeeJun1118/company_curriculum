package com.example.searchjava2.service.search;

import com.example.searchjava2.model.SearchWord;
import com.example.searchjava2.service.search.functions.SearchId;
import com.example.searchjava2.service.search.functions.SearchNodeName;
import org.w3c.dom.Document;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.NodeIterator;

public class NodeSearch {
    public String search(Document document, SearchWord word) {
        DocumentTraversal trav = (DocumentTraversal) document;
        NodeIterator it = trav.createNodeIterator(document.getDocumentElement(), NodeFilter.SHOW_ELEMENT, null, true);

        //===================id 로 찾기===================
        if (word.getNId() != "" && word.getNName() == "" && word.getAtName() == "" && word.getAtValue() == "") {
            SearchId searchId = new SearchId();

//            return searchId.search(it,word);
            return "id";
        }
        //===================노드명으로 찾기===================
        if (word.getNId() == "" && word.getNName() != "" && word.getAtName() == "" && word.getAtValue() == "") {
            SearchNodeName nodeName = new SearchNodeName();
            return nodeName.search(it,word);
//            result = nodeName.search(it,word);
//            return result;
        }

        //===================id + 노드명으로 찾기===================
        if (word.getNId() != "" && word.getNName() != "" && word.getAtName() == "" && word.getAtValue() == "") {

            return "id + node name";
        }

        //=================== 속성명 + 속성값으로 찾기 ===================
        // 속성명, 속성값 같이 입력하게
        // 속성명 빠졌을 때 속성명을 입력해주세요
        // 속성값 빠졌을 때도 동일
        if (word.getAtName() != "" && word.getAtValue() == "") {
            return "속성값을 입력해주세요";
        }
        else if (word.getAtName() == "" && word.getAtValue() != "") {
            return "속성명을 입력해주세요";
        }
        else if (word.getAtName() != "" && word.getAtValue() != "" && word.getNId() == "" && word.getNName() == "") {

            return "속성명 + 속성값";
        }

        //========================id + 속성명 + 속성값 으로 찾기========================
        if (word.getNId() != "" && word.getNName() == "" && word.getAtName() != "" && word.getAtValue() != "") {

            return "id + 속성명 + 속성값";
        }

        //========================노드명 + 속성명 + 속성값 으로 찾기=====================
        if (word.getNId() == "" && word.getNName() != "" && word.getAtName() != "" && word.getAtValue() != "") {

            return "노드명 + 속성명 + 속성값";
        }

        //===================id + 노드명 + 속성명 + 속성값 으로 찾기===================
        if (word.getNId() != "" && word.getNName() != "" && word.getAtName() != "" && word.getAtValue() != "") {

            return "id + 노드명 + 속성명 + 속성값";
        }


        return "해당 없음 : 오류";
    }
}
