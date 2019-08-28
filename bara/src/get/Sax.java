package get;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Sax {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        Sax s = new Sax();
        List<ModelOfInstance> user=  s.man("tas.xml");
        user.get(0).getPassword();
    }

    private static List<ModelOfInstance> user = new ArrayList<>();

    public List man(String url) throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        XMLHandler handler = new XMLHandler();
        parser.parse(new File(url), handler);

        return user;
    }

    private static class XMLHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equals("user")) {
                String userName = attributes.getValue("userName");
                String password = attributes.getValue("password");
                String url = attributes.getValue("url");
                user.add(new ModelOfInstance(userName, password, url));
            }
        }
    }
}