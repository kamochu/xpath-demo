package ke.natujenge.xpath.usecases.soap;

import ke.natujenge.xpath.util.XPathUtil;

import javax.xml.xpath.XPathConstants;

/**
 * Sample code to help us decode (or deserialize) SOAP response
 * You can pick the data you need in the response
 *
 * <pre>
 * <?xml version="1.0" encoding="UTF-8"?>
 * <soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
 *    <soap:Body>
 *       <ns2:Response xmlns:ns2="http://API.interface/" xmlns:ns3="http://natujenge.ke/interface">
 *          <ns3:InnerResponse>
 *             <accounts>
 *                <account>
 *                   <Localcurrency>KES</Localcurrency>
 *                   <AccountId>1234</AccountId>
 *                   <AccountStatus>Open</AccountStatus>
 *                   <AccountBalance>45.56</AccountBalance>
 *                   <AccountName>SAMUEL KAMOCHU KURIAH</AccountName>
 *                </account>
 *             </accounts>
 *             <originalRefNo>XYZ00001</originalRefNo>
 *             <code>00</code>
 *             <code>Success</code>
 *          </ns3:InnerResponse>
 *       </ns2:Response>
 *    </soap:Body>
 * </soap:Envelope>
 * </pre>
 */
public class ResponseTest {

    public static void main(String[] args) throws Exception {

        String httpResponseBody = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "     <soap:Body>\n" +
                "        <ns2:Response xmlns:ns2=\"http://API.interface/\" xmlns:ns3=\"http://natujenge.ke/interface\">\n" +
                "           <ns3:InnerResponse>\n" +
                "              <accounts>\n" +
                "                 <account>\n" +
                "                    <Localcurrency>KES</Localcurrency>\n" +
                "                    <AccountId>1234</AccountId>\n" +
                "                    <AccountStatus>Open</AccountStatus>\n" +
                "                    <AccountBalance>45.56</AccountBalance>\n" +
                "                    <AccountName>SAMUEL KAMOCHU KURIAH</AccountName>\n" +
                "                 </account>\n" +
                "              </accounts>\n" +
                "              <originalRefNo>XYZ00001</originalRefNo>\n" +
                "              <code>00</code>\n" +
                "              <desc>Success</desc>\n" +
                "           </ns3:InnerResponse>\n" +
                "        </ns2:Response>\n" +
                "     </soap:Body>\n" +
                "  </soap:Envelope>";

        String codeExpr = "/*[local-name()='Envelope']/*[local-name()='Body']/*[local-name()='Response']/*[local-name()='InnerResponse']/code/text()";

        String descExpr = "/*[local-name()='Envelope']/*[local-name()='Body']/*[local-name()='Response']/*[local-name()='InnerResponse']/desc/text()";


        String code = (String) XPathUtil.queryXML(XPathUtil.getXPath(), codeExpr, httpResponseBody.getBytes(), XPathConstants.STRING);

        String desc = (String) XPathUtil.queryXML(XPathUtil.getXPath(), descExpr, httpResponseBody.getBytes(), XPathConstants.STRING);

        System.out.println("code: " + code);
        System.out.println("desc: " + desc);

    }

}
