package br.com.sistemap.times.listaTimes.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "markets" , namespace = "http://www.eoddsmaker.net/schemas/markets/2.0")
public class MarketDTO  implements Serializable {

    @JsonProperty("CNT")
    private int cnt;
    @JsonProperty("S")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<SportsDTO> sportsDTO;

    public int getCnt() {
        return this.cnt;
    }

    public  MarketDTO(){}

    public MarketDTO(int cnt, List<SportsDTO> sportsDTO) {
        this.cnt = cnt;
        this.sportsDTO = sportsDTO;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public List<SportsDTO> getSportsDTO() {
        return sportsDTO;
    }

    public void setSportsDTO(List<SportsDTO> sportsDTO) {
        this.sportsDTO = sportsDTO;
    }
}