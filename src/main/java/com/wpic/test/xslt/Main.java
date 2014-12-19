package com.wpic.test.xslt;


import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 *
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws TransformerException {
        if (args.length != 2) {
            System.err.println("Args: xml xslt");
            return;
        }

        final String xml = args[0];
        final String xsl = args[1];

        final TransformerFactory factory = TransformerFactory.newInstance();
        final StreamSource xslStream = new StreamSource(new File(xsl));
        final Transformer transformer = factory.newTransformer(xslStream);
        final StreamSource in = new StreamSource(new File(xml));
        final StreamResult out = new StreamResult(System.out);

        System.out.println();
        transformer.transform(in, out);
        System.out.println();
    }

}
