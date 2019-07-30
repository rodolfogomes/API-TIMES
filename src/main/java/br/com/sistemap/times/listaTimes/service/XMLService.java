package br.com.sistemap.times.listaTimes.service;


import br.com.sistemap.times.listaTimes.DTO.MarketDTO;
import com.apple.eawt.Application;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class XMLService {

    private static final Logger log = LoggerFactory.getLogger(Application.class);


    //40 segundos.
    private final long SEGUNDO = 40000;

    @Scheduled(fixedDelay = SEGUNDO)
    public void printMarketDTOFromApi() throws IOException {
        MarketDTO marketDTO = this.parseMarketFromString(this.receiveResults());
        marketDTO.getSportsDTO().forEach(sport ->{
            log.info(sport.getCountryDTO().getLeagueDTO().getEventDTO().getT1()
            +" X "+ sport.getCountryDTO().getLeagueDTO().getEventDTO().getT2());

        });
        //log.info(marketDTO.toString());
    }

    private String receiveResults(){
        try {
            String xml = "http://services.eoddsmaker.net/demo/feeds/V2.0/markets.ashx?l=1&u=sandro&p=sandro&frm=xml&sid=50";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
            return restTemplate.getForObject(xml,String.class);

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
