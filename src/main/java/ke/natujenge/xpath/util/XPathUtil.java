package ke.natujenge.xpath.util;

import javax.xml.namespace.QName;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;

public class XPathUtil {



    public static Object queryXML(final XPath instance,
                                  final String expression,
                                  final byte[] xml,
                                  final QName returnType) throws Exception {
        return instance.compile(expression).evaluate(new org.xml.sax.InputSource(new ByteArrayInputStream(xml)), returnType);
    }

    public static XPath getXPath() {
        return XPathFactory.newInstance().newXPath();
    }

}
