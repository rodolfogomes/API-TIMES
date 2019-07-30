package br.com.sistemap.times.listaTimes.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "markets" , namespace = "http://www.eoddsmaker.net/schemas/markets/2.0")
public class CountryDTO  implements Serializable {
    @JsonProperty("I")
    private int id;

    @JsonProperty("N")
    private String name;

    @JsonProperty("L")
    private LeagueDTO leagueDTO;



    CountryDTO(){}

    public CountryDTO(int id, String name, LeagueDTO leagueDTO) {
        this.id = id;
        this.name = name;
        this.leagueDTO = leagueDTO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LeagueDTO getLeagueDTO() {
        return leagueDTO;
    }

    public void setLeagueDTO(LeagueDTO leagueDTO) {
        this.leagueDTO = leagueDTO;
    }
}
