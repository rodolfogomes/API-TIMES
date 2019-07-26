package br.com.sistemap.times.listaTimes.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "markets" , namespace = "http://www.eoddsmaker.net/schemas/markets/2.0")
public class MarketDTO {

    @JsonProperty("CNT")
    private int cnt;
    @JsonProperty("S")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<SportsDTO> sportsDTO;

    public int getCnt() {
        return this.cnt;
    }





}