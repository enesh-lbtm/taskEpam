package com.task.aquarium;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String ... args) {
        Root root = new Root();
        Document doc;
        try {
            doc = builtDocument();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Parsing open Error" + e.toString());
            return;
        }
        Node rootNode = doc.getFirstChild();
        System.out.println("Its name=" + rootNode.getNodeName());
        NodeList rootChild = rootNode.getChildNodes();
        String mainName = null;
        Node residentNode = null;


        for (int i = 0; i < rootChild.getLength(); i++) {
            if (rootChild.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            System.out.println("Its roots child name= " + rootChild.item(i).getNodeName());

            switch (rootChild.item(i).getNodeName()) {
                case "name": {
                    mainName = rootChild.item(i).getTextContent();
                    System.out.println("Main name = " + mainName);
                    break;
                }
                case "resident": {
                    residentNode = rootChild.item(i);
                    break;
                }
            }
        }


        if (residentNode == null) {
            return;
        }

        List<Resident> residentList = new ArrayList<>();
        NodeList residentChild = residentNode.getChildNodes();
        for (int i = 0; i < residentChild.getLength(); i++) {
            if (residentChild.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            if (!residentChild.item(i).getNodeName().equals("element")) {
                continue;
            }

            String name = "";
            int quantity = 0;
            int cost = 0;

            NodeList elementChilds = residentChild.item(i).getChildNodes();
            for (int j = 0; j < elementChilds.getLength(); j++) {
                if (elementChilds.item(j).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }
                switch (elementChilds.item(j).getNodeName()) {
                    case "name": {
                        name = elementChilds.item(j).getTextContent();
                        break;
                    }


                    case "quantity": {
                        quantity = Integer.valueOf(elementChilds.item(j).getTextContent());
                        break;
                    }
                    case "cost": {
                        cost = Integer.valueOf(elementChilds.item(j).getTextContent());
                        break;

                    }
                }
            }
            Resident resident = new Resident(name, quantity, cost);
            residentList.add(resident);
        }
        root.setName(mainName);
        root.setResident(residentList);

        System.out.println(root.toString());
    }
    private static Document builtDocument() throws Exception{
        File file = new File("task1.xml");
        DocumentBuilderFactory dtf = DocumentBuilderFactory.newInstance();
        Document doc = null;
        return dtf.newDocumentBuilder().parse(file);

    }
}
