package com.search.javasearch;

import org.w3c.dom.*;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.NodeIterator;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class javaDom {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        //DOM문서 인스턴스를 가져옴
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        //파일을 가져옴
        Document document = builder.parse(new File("javaSearch/src/main/resources/templates/index.html"));
        //문서를 정규화하여 올바른 결과 생성
        document.getDocumentElement().normalize();

        //문서의 루트 요소를 얻음
        System.out.println("루트 요소 : " + document.getDocumentElement().getNodeName());

        // Node Name List : html head meta tittle link div 등등
        DocumentTraversal trav = (DocumentTraversal) document;
        NodeIterator it = trav.createNodeIterator(document.getDocumentElement(), NodeFilter.SHOW_ELEMENT, null, true);
        int c = 1;
        int nodeNameCount = 0;
        int idCount =0 ;
        for (Node node = it.nextNode(); node != null; node = it.nextNode()) {
            String nodeName = node.getNodeName();
            NamedNodeMap all = node.getAttributes();
            // div ul li 등등
            System.out.println("node name : " + nodeName);
//            if (nodeName == "th") {
                nodeNameCount++;
                for (int i = 0; i < all.getLength(); i++) {
                    String nodes = ((Attr) all.item(i)).getName();
                    String nodes2 = ((Attr) all.item(i)).getValue();
//                    System.out.println("div nodes GetName = "+nodes);
                    System.out.println("div nodes GetValue = " + nodes2);
                    if (Objects.equals(nodes2, "text_center")&& nodeName.equals("th")) {
                        idCount++;
                    }
                }
//            }
            System.out.println("text_center" + idCount);

//            System.out.println(nodeNameCount);
            /*
            for (int i = 0; i < all.getLength(); i++) {
                *//*System.out.println("     " +
                        //class 이름                              그 안의 다른 요소들 :name=attName type=text 등등
                        ((Attr) all.item(i)).getName() + "=" + ((Attr) all.item(i)).getValue());*//*

                // class id name type 등등이 나옴
                *//*String nodes = ((Attr) all.item(i)).getName();
                System.out.println(nodes);*//*

             *//* //class id name type 등의 값 : text yellow 등
                String nodes2 = ((Attr) all.item(i)).getValue();
                System.out.println(nodes2);*//*

            }*/
            c++;
        }

        /*NodeList nodeList = document.getElementsByTagName("div");
        int count = 0;
        String uid = null;
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            //System.out.println("\n현재 요소 : " + node.getNodeName());

            if (node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) node;
                uid = element.getAttribute("class");

                if (uid != null) {
                    count++;
                }
                System.out.println("uid : " + uid);
            }
        }
        System.out.println("count : " + count);
        */


    }
}
