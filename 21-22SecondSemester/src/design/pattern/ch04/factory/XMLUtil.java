package design.pattern.ch04.factory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XMLUtil {
    
    public static Object getObjectFromXMLByTagName(String xmlAbsolutePath, String tagName) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlAbsolutePath);
            NodeList nodeList = document.getElementsByTagName(tagName);
            String className = nodeList.item(0).getTextContent();
            Class c = Class.forName(className);
            return c.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
