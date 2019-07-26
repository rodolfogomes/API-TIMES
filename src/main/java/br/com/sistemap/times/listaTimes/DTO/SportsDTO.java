package br.com.sistemap.times.listaTimes.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "markets" , namespace = "http://www.eoddsmaker.net/schemas/markets/2.0")
public class SportsDTO {

    @JsonProperty("I")
    private int id;

    @JsonProperty("N")
    private String name;

    @JsonProperty("C")
    private CountryDTO countryDTO;



}
