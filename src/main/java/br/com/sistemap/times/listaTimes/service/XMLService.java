package br.com.sistemap.times.listaTimes.service;


import br.com.sistemap.times.listaTimes.DTO.MarketDTO;
import com.apple.eawt.Application;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import jdk.internal.org.xml.sax.InputSource;
import jdk.internal.org.xml.sax.SAXException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;

public class XMLService {

    private static final Logger log = LoggerFactory.getLogger(Application.class);


    //40 segundos.
    private final long SEGUNDO = 30000;

    @Scheduled(fixedRate = SEGUNDO)
    public void printMarketDTOFromApi() throws IOException {
        MarketDTO marketDTO = parseMarketFromString(receiveResults().toString());
        log.info(receiveResults().toString());
        marketDTO.getSportsDTO().forEach(sport ->{
            log.info(sport.getCountryDTO().getLeagueDTO().getEventDTO().getT1()
            +" X "+ sport.getCountryDTO().getLeagueDTO().getEventDTO().getT2());

        });
    }

    private ResponseEntity receiveResults(){
        try {
            String xml = "http://services.eoddsmaker.net/demo/feeds/V2.0/markets.ashx?l=1&u=sandro&p=sandro&frm=xml&sid=50";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
            restTemplate.getMessageConverters()
                    .add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
            ResponseEntity<String> response  = restTemplate.getForEntity(xml, String.class);
            log.info(response.toString());
            restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());

            return response;

        } catch (HttpClientErrorException ex) {
            log.error(ex.getResponseBodyAsString());
            throw  ex;
        }

    }

    private MarketDTO parseMarketFromString(String xmlString) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(xmlString, MarketDTO.class);
    }


}
