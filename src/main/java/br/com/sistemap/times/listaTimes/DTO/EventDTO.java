package br.com.sistemap.times.listaTimes.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "markets" , namespace = "http://www.eoddsmaker.net/schemas/markets/2.0")
public class EventDTO  implements Serializable {
    @JsonProperty("I")
    private int id;

    @JsonProperty("DT")
    private Date dt;

    @JsonProperty("ISH")
    private int ish;

    @JsonProperty("BKS")
    private int bks;

    @JsonProperty("T1")
    private String t1;

    @JsonProperty("T2")
    private String t2;

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
    private String sc;

    @JsonProperty("sce")
    private int sce;

    EventDTO(){}

    public EventDTO(int id, Date dt, int ish, int bks, String t1, String t2, int t1i, int t2i, int pr, int mn, int a, String sc, int sce) {
        this.id = id;
        this.dt = dt;
        this.ish = ish;
        this.bks = bks;
        this.t1 = t1;
        this.t2 = t2;
        this.t1i = t1i;
        this.t2i = t2i;
        this.pr = pr;
        this.mn = mn;
        this.a = a;
        this.sc = sc;
        this.sce = sce;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public int getIsh() {
        return ish;
    }

    public void setIsh(int ish) {
        this.ish = ish;
    }

    public int getBks() {
        return bks;
    }

    public void setBks(int bks) {
        this.bks = bks;
    }

    public String getT1() {
        return t1;
    }

    public void setT1(String t1) {
        this.t1 = t1;
    }

    public String getT2() {
        return t2;
    }

    public void setT2(String t2) {
        this.t2 = t2;
    }

    public int getT1i() {
        return t1i;
    }

    public void setT1i(int t1i) {
        this.t1i = t1i;
    }

    public int getT2i() {
        return t2i;
    }

    public void setT2i(int t2i) {
        this.t2i = t2i;
    }

    public int getPr() {
        return pr;
    }

    public void setPr(int pr) {
        this.pr = pr;
    }

    public int getMn() {
        return mn;
    }

    public void setMn(int mn) {
        this.mn = mn;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getSc() {
        return sc;
    }

    public void setSc(String sc) {
        this.sc = sc;
    }

    public int getSce() {
        return sce;
    }

    public void setSce(int sce) {
        this.sce = sce;
    }
}
