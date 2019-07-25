package br.com.sistemap.times.listaTimes.service;


import com.apple.eawt.Application;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URLDecoder;

public class XMLService {

    private static final Logger log = LoggerFactory.getLogger(Application.class);


    private final long SEGUNDO = 40;

    @Scheduled(fixedDelay = SEGUNDO)
    public void parseXmlToJson() throws IOException, ParserConfigurationException, SAXException {

       /*
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://services.eoddsmaker.net/demo/feeds/V2.0/markets.ashx?l=1&u=sandro&p=sandro&frm=xml&sid=50";
        String response = restTemplate.getForObject(url,String.class);

        XmlMapper xmlMapper = new XmlMapper();
        String responsJson = xmlMapper.readValue(this.replacer(response), String.class);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(responsJson);

        log.info(json);

        */

        String url = "http://services.eoddsmaker.net/demo/feeds/V2.0/markets.ashx?l=1&u=sandro&p=sandro&frm=xml&sid=50";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(url);
        doc.getDocumentElement().normalize();
        System.out.println(this.replacer(doc.toString()));


    }

    private  String replacer(String response) {
        String data = response.toString();
        try {
            data = data.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
            data = data.replaceAll("\\+", "%2B");
            data = URLDecoder.decode(data, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
