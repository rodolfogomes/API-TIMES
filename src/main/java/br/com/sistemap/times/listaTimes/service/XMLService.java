package br.com.sistemap.times.listaTimes.service;


import com.apple.eawt.Application;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.print.DocFlavor;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class XMLService {

    private static final Logger log = LoggerFactory.getLogger(Application.class);


    private final long SEGUNDO = 40;

    @Scheduled(fixedDelay = SEGUNDO)
    public void parseXmlToJson() throws IOException, ParserConfigurationException, SAXException {


        RestTemplate restTemplate = new RestTemplate();
        String url = "http://services.eoddsmaker.net/demo/feeds/V2.0/markets.ashx?l=1&u=sandro&p=sandro&frm=xml&sid=50";
        String response = restTemplate.getForObject(url,String.class);
       // URLDecoder.decode(response, "utf-8");

        XmlMapper xmlMapper = new XmlMapper();
        String responsJson = xmlMapper.readValue(response, String.class);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(responsJson);

        log.info(json);

    }

}
