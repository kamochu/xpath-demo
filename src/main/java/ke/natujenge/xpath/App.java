package ke.natujenge.xpath;

import ke.natujenge.xpath.util.XPathUtil;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;

public class App {

    public static void main(String[] args) throws Exception {

        String xml = "<person xmlns:ns1=\"natujenge.ke/interfaces\">\n" +
                "        <name>John Wafula</name>\n" +
                "        <dob>1997-01-23</dob>\n" +
                "        <gender>M</gender>\n" +
                "        <youth>false</youth>\n" +
                "        <ns1:test key1=\"value1\" key2=\"value2\">TEST VALUE</ns1:test>\n" +
                "        <contacts>\n" +
                "            <phone>254722000000</phone>\n" +
                "            <email>jwafula@gmail.com</email>\n" +
                "            <twitter>jwafula</twitter>\n" +
                "            <facebook>jwafula</facebook>\n" +
                "            <linkedin>jwafula</linkedin>\n" +
                "            <github>jwafula</github>\n" +
                "        </contacts>\n" +
                "    </person>";


        XPath xPath = XPathUtil.getXPath();

        //part 1: using an expression to extract text
        String nameExpression = "/person/name/text()";
        String name = (String) XPathUtil.queryXML(xPath, nameExpression, xml.getBytes(), XPathConstants.STRING);
        System.out.println("name: " + name);

        String dobExpression = "/person/dob/text()";
        String dob = (String) XPathUtil.queryXML(xPath, dobExpression, xml.getBytes(), XPathConstants.STRING);
        System.out.println("dob: " + dob);

        String emailExpression = "/person/contacts/email/text()";
        String email = (String) XPathUtil.queryXML(xPath, emailExpression, xml.getBytes(), XPathConstants.STRING);
        System.out.println("email: " + email);

        System.out.println(); //divider


        //part 2: using expression to evaluate a node and get a named attribute
        String dobNodeExpression = "/person/*[local-name() = 'test']";
        Node testNode = (Node) XPathUtil.queryXML(xPath, dobNodeExpression, xml.getBytes(), XPathConstants.NODE);

        System.out.println("node-name   : " + testNode.getNodeName());
        System.out.println("node-text   : " + testNode.getTextContent());
        System.out.println("node-lname  : " + testNode.getLocalName());
        System.out.println("node-prefix : " + testNode.getPrefix());
        System.out.println("node-ns-url : " + testNode.getNamespaceURI());
        System.out.println("node-attr   : " + testNode.getAttributes().getLength());

        Node key1AttrNode = testNode.getAttributes().getNamedItem("key1");
        System.out.println("key1-name   : " + key1AttrNode.getNodeName());
        System.out.println("key1-text   : " + key1AttrNode.getTextContent());
        System.out.println("key1-value   : " + key1AttrNode.getNodeValue());
        System.out.println("key1-lname  : " + key1AttrNode.getLocalName());

        System.out.println(); //divider

        //part 3: using an expression to query children nodes
        String contactsNode = "/person/contacts/child::*";
        NodeList contactsNodeList = (NodeList) XPathUtil.queryXML(xPath, contactsNode, xml.getBytes(), XPathConstants.NODESET);

        for (int i = 0; i < contactsNodeList.getLength(); i++) {
            Node contactChildNode = contactsNodeList.item(i);
            System.out.println("\n*******************" + contactChildNode.getNodeName() + "*******************");

            System.out.println("contactChildNode-name   : " + contactChildNode.getNodeName());
            System.out.println("contactChildNode-text   : " + contactChildNode.getTextContent());
            System.out.println("contactChildNode-value   : " + contactChildNode.getNodeValue());
            System.out.println("contactChildNode-lname  : " + contactChildNode.getLocalName());

        }

    }

}
