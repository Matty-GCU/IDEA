package design.pattern;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XMLUtil2 {
    
    public static Object getBean(String tagName) {
        return getBean(null, tagName);
    }
    
    public static Object getBean(String pathFromSrc, String tagName) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            if(pathFromSrc == null || "".equals(pathFromSrc)) {
                pathFromSrc = "C:\\Users\\Matty's PC\\IdeaProjects\\21-22SecondSemester\\src\\design\\pattern\\config.xml";
            }
            else {
                pathFromSrc = "C:\\Users\\Matty's PC\\IdeaProjects\\21-22SecondSemester\\src\\" + pathFromSrc;
            }
            Document document = documentBuilder.parse(pathFromSrc);
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
