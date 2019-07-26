package br.com.sistemap.times.listaTimes.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "markets" , namespace = "http://www.eoddsmaker.net/schemas/markets/2.0")
public class EventDTO {
    @JsonProperty("I")
    private int id;

    @JsonProperty("DT")
    private int dt;

    @JsonProperty("ISH")
    private int ish;

    @JsonProperty("BKS")
    private int bks;

    @JsonProperty("T1")
    private int t1;

    @JsonProperty("T2")
    private int t2;

    @JsonProperty("T1I")
    private int t1i;

    @JsonProperty("T2I")
    private int t2i;

    @JsonProperty("PR")
    private int pr;

    @JsonProperty("MN")
    private int mn;

    @JsonProperty("A")
    private int a;

    @JsonProperty("sc")
    private int sc;

    @JsonProperty("sce")
    private int sce;
}
