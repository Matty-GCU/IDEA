package design.pattern.ch03.simple.factory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        //如果更改产品，需要修改方法参数，即修改源代码，这不符合开闭原则
        Product product = SimpleFactory.getProduct("A");
        product.methodSame();
        product.methodDiff();
        
        //可以从XML文件提取参数，实现修改产品，由于没有修改代码，故符合开闭原则
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        Document document = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        try {
            document = documentBuilder.parse("src/design/pattern/ch03/simple/factory/simpleFactory-config.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        NodeList nodeList = document.getElementsByTagName("productType");
//        该结点最多可能有三个子结点（标签属性、标签内的文本、子标签）
//        String typeString = nodeList.item(0).getFirstChild().getNodeValue();
        String typeString = nodeList.item(0).getTextContent();
        product = SimpleFactory.getProduct(typeString);
        product.methodSame();
        product.methodDiff();
    }
}
