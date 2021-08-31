package ke.natujenge.xpath.usecases.configs;

import ke.natujenge.xpath.util.XPathUtil;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPathConstants;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

public class UserTest {


    static Map<String, User> allActiveUsers = new HashMap<>();

    public static void main(String[] args) throws Exception {


        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "  <users>\n" +
                "      <user active = \"false\">\n" +
                "          <username>john</username>\n" +
                "          <password>wafula</password>\n" +
                "          <fullNames>John Wafula</fullNames>\n" +
                "      </user>\n" +
                "      <user active = \"true\">\n" +
                "          <username>mary</username>\n" +
                "          <password>wanjiku</password>\n" +
                "          <fullNames>Mary Wanjiku</fullNames>\n" +
                "      </user>\n" +
                "  </users>";

        String usersExpr = "/users/child::*";

        NodeList childrenNodes = (NodeList) XPathUtil.getXPath().compile(usersExpr).evaluate(
                new org.xml.sax.InputSource(new ByteArrayInputStream(xml.getBytes())),
                XPathConstants.NODESET);

        for (int i = 0; i < childrenNodes.getLength(); i++) {

            Node node = childrenNodes.item(i);

            System.out.println("node: " + node.getNodeName());

            Node activeAttribute = node.getAttributes().getNamedItem("active");

            //only tags with active attribute
            if (activeAttribute != null) {

                //only active
                if ("true".equalsIgnoreCase(activeAttribute.getNodeValue())) {

                    User user = new User();

                    //load the data

                    NodeList userParametersNodes = node.getChildNodes();

                    for (int j = 0; j < userParametersNodes.getLength(); j++) {

                        Node innerNode = userParametersNodes.item(j);

                        switch (innerNode.getNodeName()) {
                            case "username":
                                user.setUsername(innerNode.getTextContent());
                                break;

                            case "password":
                                user.setPassword(innerNode.getTextContent());
                                break;

                            case "fullNames":
                                user.setFullNames(innerNode.getTextContent());
                                break;

                            default:

                        }

                    }

                    allActiveUsers.put(user.getUsername(), user);


                } else {
                    System.out.println("a nod found but not active");
                }

            }

        }


        System.out.println("allActiveUsers: " + allActiveUsers);


        System.out.println("auth: " + authenticate("john", "wafula"));

        System.out.println("auth: " + authenticate("mary", "wanjiku"));

    }

    public static boolean authenticate(String username, String password) {

        User user = allActiveUsers.get(username);

        if (user == null || user.getPassword() == null) {
            return false;
        }

        return user.getPassword().equals(password);
    }
}
