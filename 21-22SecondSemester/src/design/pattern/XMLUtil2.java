package design.pattern;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XMLUtil2 {
    
    public static Object getBean(String tagName) {
        String defaultAbsolutePath = "C:\\Users\\Matty's PC\\IdeaProjects\\21-22SecondSemester\\src\\design\\pattern\\config.xml";
        return getBean(defaultAbsolutePath, tagName);
    }
    
    public static Object getBean(String absolutePath, String tagName) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(absolutePath);
            NodeList nodeList = document.getElementsByTagName(tagName);
            String className = nodeList.item(0).getTextContent();
            Class<Object> c = (Class<Object>) Class.forName(className);
            return c.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
