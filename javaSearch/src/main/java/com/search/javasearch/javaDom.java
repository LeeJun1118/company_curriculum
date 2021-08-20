package com.search.javasearch;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class javaDom {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        //DOM문서 인스턴스를 가져옴
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        //파일을 가져옴
        Document document = builder.parse(new File("searchJava/src/resources/index.html"));
        //문서를 정규화하여 올바른 결과 생성
        document.getDocumentElement().normalize();

        //문서의 루트 요소를 얻음
        System.out.println("루트 요소 : " + document.getDocumentElement().getNodeName());

        NodeList nodeList = document.getElementsByTagName("div");
        int count = 0;
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            System.out.println("\n현재 요소 : " + node.getNodeName());

            if (node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) node;
                String uid = element.getAttribute("class");

                if (uid != null) {
                    count++;
                }
//                System.out.println("id : " + uid);
            }
        }
        System.out.println("class 수 : " + count);
        /*DocumentTraversal trav = (DocumentTraversal) document;


        NodeIterator it = trav.createNodeIterator(document.getDocumentElement(), NodeFilter.SHOW_ELEMENT, null, true);
        int c = 1;
        for (Node node = it.nextNode(); node !=  null; node = it.nextNode()){
            String name = node.getNodeName();
            NamedNodeMap all = node.getAttributes();
            System.out.printf("%d %s%n", c , name);
            c++;
        }*/
    }
}
