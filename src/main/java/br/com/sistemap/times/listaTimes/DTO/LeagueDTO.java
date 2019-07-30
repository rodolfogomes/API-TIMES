package br.com.sistemap.times.listaTimes.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "markets" , namespace = "http://www.eoddsmaker.net/schemas/markets/2.0")
public class LeagueDTO  implements Serializable {
    @JsonProperty("I")
    private int id;

    @JsonProperty("N")
    private String name;

    @JsonProperty("E")
    private EventDTO eventDTO;


    LeagueDTO(){}

    public LeagueDTO(int id, String name, EventDTO eventDTO) {
        this.id = id;
        this.name = name;
        this.eventDTO = eventDTO;
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

    public EventDTO getEventDTO() {
        return eventDTO;
    }

    public void setEventDTO(EventDTO eventDTO) {
        this.eventDTO = eventDTO;
    }
}
