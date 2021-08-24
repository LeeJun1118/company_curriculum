package com.example.searchjava2.service;

import com.example.searchjava2.model.SearchWord;
import com.example.searchjava2.service.search.NodeSearch;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class SearchService {
    public String search(SearchWord word) throws ParserConfigurationException, IOException, SAXException {
        //DOM 문서 인스턴스를 가져옴
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        //파일을 가져옴
        Document document = builder.parse(new File("searchJava2/src/main/resources/templates/index.html"));

        //문서를 정규화하여 올바른 결과 생성
        document.normalize();

        //NodeSearch 객체 생성
        NodeSearch nodeSearch = new NodeSearch();

        // html에서 뽑아온 list 와 SearchController에서 받아온 word 값 NodeSearch 에 넘겨줌
        String result = nodeSearch.search(document, word);

        return "" + result;
    }
}
