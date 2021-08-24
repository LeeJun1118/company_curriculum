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
        int idCount = 0;
        int attCount = 0;
        int count = 0;
        NamedNodeMap all2 = null;




        /*MyFilter filter = new MyFilter();
        NodeIterator it2 = trav.createNodeIterator(document.getDocumentElement(), NodeFilter.SHOW_ELEMENT, filter, true);
        for (Node node = it2.nextNode(); node != null;
             node = it2.nextNode()) {

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element e = (Element) node;
//                String nodeName = e.getNodeName();
                String nodeid = e.getAttribute("id");
                String nodeClass = e.getAttribute("class");

                if ("text_center".equals(nodeid) && "even".equals(nodeClass)) {
                    return NodeFilter.FILTER_ACCEPT;
                }
            }


            System.out.println(node.getAttributes().item(0));
            System.out.println(node.getAttributes().item(0).getNodeName());
            System.out.println(node.getAttributes().item(0).getNodeValue());
            System.out.println("--------------------------------------------");
            *//*System.out.println(node.getAttributes().item(1));
            System.out.println(node.getAttributes().item(1).getNodeName());
            System.out.println(node.getAttributes().item(1).getNodeValue());*//*

            *//*
            System.out.println(node.getAttributes().item(2).getNodeValue());
            System.out.println(node.getAttributes().item(2));
            System.out.println(node.getAttributes().item(4));
            System.out.println(node.getNodeName());
            System.out.println(node.getNodeType());
            System.out.println(node.getNodeValue());
            System.out.println(node.getTextContent());
            System.out.println(node.getPrefix());*//*
//            System.out.printf("%s: %s%n", name, text);

        }*/

        for (Node node = it.nextNode(); node != null; node = it.nextNode()) {
//            String nodeName = node.getNodeName();
//            NamedNodeMap all = node.getAttributes();

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) node;
//                String nodeName = e.getNodeName();
                String nodeid = e.getAttribute("id");
                String nodeClass = e.getAttribute("class");

                if ("text_center".equals(nodeid) && "even".equals(nodeClass)) {
                    count++;
                }
            }


/*            // div ul li 등등
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
            System.out.println("text_center" + idCount);*/

//            System.out.println(nodeNameCount);
            /*for (int i = 0; i < all.getLength(); i++) {
                System.out.println("     " +
                        //class 이름                              그 안의 다른 요소들 :name=attName type=text 등등
                        ((Attr) all.item(i)).getName() + "=" + ((Attr) all.item(i)).getValue());
*/
                // class id name type 등등이 나옴
//                String nodes = ((Attr) all.item(i)).getName();
//                System.out.println("[" + nodes + "]");

                //class id name type 등의 값 : text yellow 등
//                String nodes2 = ((Attr) all.item(i)).getValue();
//                String list[] = nodes2.split(" ");
//                System.out.println(nodes2);


                /*if (Objects.equals(nodes, "btn1")) {
                    System.out.println("[" + nodes + "]");
                    for (int j = 0; j < list.length; j++) {
                        if (Objects.equals(nodes, "class") && Objects.equals(list[j], "horizontal_left")) {
                            System.out.println("[" + nodes + "]");
                            System.out.println(nodes2);
                            attCount++;
                        }
                    }
                }*/


             /* //class id name type 등의 값 : text yellow 등
                String nodes2 = ((Attr) all.item(i)).getValue();
                System.out.println(nodes2);
*/

                /*//div li input 등
                String nodeName = node.getNodeName();

                // id class placeholder 등등
                String attName = ((Attr) all.item(i)).getName();

                // id의 값 + class의 값들 + placeholder의 값들
                String att = ((Attr) all.item(i)).getValue();
                String attlist[] = att.split(" ");


                System.out.println("nodeName : " + nodeName);
                System.out.println("att Name : " + attName);

                for (int k = 0; k < attlist.length; k++) {
                    if (Objects.equals(attlist[k], "btn1")) {

                        for (int j = 0; j < attlist.length; j++) {
                            if (Objects.equals(attlist[j], "horizontal_left")) {
                                    count++;
                            }
                        }
                    }
                    System.out.println("=========att Value : " + attlist[k]);
                }*/
                    /*if (Objects.equals(att, "btn1")) {
                        attCount++;
                    }*/


                /*if(node.getAttributes().item(i).getNodeValue().equals("btn1")){

                }*/
            }
//            c++;
        System.out.println(count);
        }
        /*for (int i = 0; i < all2.getLength(); i++) {
            System.out.println("     " +
                    //class 이름                              그 안의 다른 요소들 :name=attName type=text 등등
                    ((Attr) all2.item(i)).getName() + "=" + ((Attr) all2.item(i)).getValue());

        }*/

//        System.out.println("attCount : " + attCount);

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

//        System.out.println(count);
//    }
    /*static class MyFilter implements NodeFilter {

        @Override
        public short acceptNode(Node thisNode) {
            if (thisNode.getNodeType() == Node.ELEMENT_NODE) {

                Element e = (Element) thisNode;
//                String nodeName = e.getNodeName();
                String nodeid = e.getAttribute("id");
                String nodeClass = e.getAttribute("class");

                if ("text_center".equals(nodeid) && "even".equals(nodeClass)) {
                    return NodeFilter.FILTER_ACCEPT;
                }
            }

            return NodeFilter.FILTER_REJECT;
        }
    }*/
}
